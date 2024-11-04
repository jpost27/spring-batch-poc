package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.playerprofile.SrNflV7PlayerProfileResponse;
import com.jp.springbatchpoc.model.dto.CompetitorIdentifier;
import com.jp.springbatchpoc.model.entity.Competitor;
import com.jp.springbatchpoc.model.entity.CompetitorProviderId;
import com.jp.springbatchpoc.model.entity.CompetitorSportsbookSelectionId;
import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.repository.CompetitorProviderIdRepository;
import com.jp.springbatchpoc.repository.TeamProviderIdRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
@RequiredArgsConstructor
public class NflPlayerIdentifierProcessor implements ItemProcessor<CompetitorIdentifier, Competitor> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private final TeamProviderIdRepository teamProviderIdRepository;
    private final CompetitorProviderIdRepository competitorProviderIdRepository;
    private static final DateTimeFormatter dateOfBirthFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.US);

    @Override
    public Competitor process(CompetitorIdentifier playerIdentifier) throws Exception {
        if (playerIdentifier.getSportRadarId() == null) {
            log.warn("No SportRadarId found for NFL Competitor {}", playerIdentifier);
            return null;
        }

        if (competitorProviderIdRepository.existsByFanduelCompetitorId(playerIdentifier.getFanDuelId())) {
            log.warn(
                    "NFL Competitor already exists. Discarding to avoid duplicates {}:{}",
                    playerIdentifier.getName(),
                    playerIdentifier.getSportRadarId());
            return null;
        }

        TeamProviderId teamProviderId = teamProviderIdRepository
                .findByFanduelTeamId(playerIdentifier.getTeamFanDuelId())
                .orElse(null);
        if (teamProviderId == null) {
            log.warn("No teamProviderId found for fanduelID: {}", playerIdentifier);
            return null;
        }
        Team team = teamProviderId.getTeam();
        League league = team.getLeague();

        Optional<CompetitorProviderId> existingCompetitorProviderId =
                competitorProviderIdRepository.findBySportradarCompetitorId(playerIdentifier.getSportRadarId());
        Competitor competitor = existingCompetitorProviderId
                .map(CompetitorProviderId::getCompetitor)
                .orElse(new Competitor());
        competitor.setLeague(league);

        SrNflV7PlayerProfileResponse srPlayerProfile;
        try {
            srPlayerProfile = sportRadarNflV7Client
                    .getPlayerProfile(playerIdentifier.getSportRadarId())
                    .block();
        } catch (Exception e) {
            log.warn("Sportradar player profile not found for NFL Competitor {}", playerIdentifier);
            e.printStackTrace();
            return null;
        }

        srPlayerProfile.getFirstName().ifPresent(competitor::setFirstName);
        srPlayerProfile.getLastName().ifPresent(competitor::setLastName);
        srPlayerProfile.getJersey().ifPresent(competitor::setUniformIdentifier);
        srPlayerProfile
                .getBirthDate()
                .map(date -> {
                    try {
                        return LocalDate.parse(date, dateOfBirthFormatter);
                    } catch (DateTimeParseException e) {
                        log.warn("Parsing error for Competitor Date of birth: {}, {}", date, playerIdentifier);
                        return null;
                    }
                })
                .ifPresent(competitor::setDateOfBirth);
        srPlayerProfile.getHeight().ifPresent(competitor::setHeightInInches);
        srPlayerProfile.getWeight().map(Double::intValue).ifPresent(competitor::setWeightInPounds);
        srPlayerProfile.getCollege().ifPresent(competitor::setCollege);
        srPlayerProfile.getHighSchool().ifPresent(competitor::setHighSchool);
        competitor.setTeam(team);

        // Provider IDs
        CompetitorProviderId competitorProviderIds = new CompetitorProviderId();
        competitorProviderIds.setFanduelCompetitorId(playerIdentifier.getFanDuelId());
        competitorProviderIds.setSportradarCompetitorId(playerIdentifier.getSportRadarId());
        competitorProviderIds.setNumberfireCompetitorId(playerIdentifier.getNumberFireId());
        competitorProviderIds.setSportsbookSelectionIds(
                Optional.ofNullable(playerIdentifier.getSportsbookIds()).orElse(List.of()).stream()
                        .map(id -> {
                            CompetitorSportsbookSelectionId selectionId = new CompetitorSportsbookSelectionId();
                            selectionId.setSelectionId(id);
                            selectionId.setCompetitorProviderIds(competitorProviderIds);
                            return selectionId;
                        })
                        .collect(Collectors.toList()));
        competitorProviderIds.setCompetitor(competitor);
        competitor.setCompetitorProviderIds(competitorProviderIds);

        //        private InjuryStatus injuryStatus;
        //        private CompetitorStatus competitorStatus;

        return competitor;
    }
}

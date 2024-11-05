package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.playerprofile.SrNflV7PlayerProfileResponse;
import com.jp.springbatchpoc.model.dto.CompetitorIdentifier;
import com.jp.springbatchpoc.model.entity.Competitor;
import com.jp.springbatchpoc.model.entity.CompetitorProviderId;
import com.jp.springbatchpoc.model.entity.CompetitorSportsbookSelectionId;
import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Sport;
import com.jp.springbatchpoc.model.entity.SportPosition;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.model.enums.Sports;
import com.jp.springbatchpoc.repository.CompetitorProviderIdRepository;
import com.jp.springbatchpoc.repository.SportPositionRepository;
import com.jp.springbatchpoc.repository.TeamProviderIdRepository;
import com.jp.springbatchpoc.service.SportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class NflPlayerIdentifierProcessor implements ItemProcessor<CompetitorIdentifier, Competitor> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private final TeamProviderIdRepository teamProviderIdRepository;
    private final CompetitorProviderIdRepository competitorProviderIdRepository;
    private final SportService sportService;
    private final SportPositionRepository sportPositionRepository;
    private static final DateTimeFormatter dateOfBirthFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.US);
    private final Set<Integer> processedFanDuelIds = new HashSet<>();

    @Override
    public Competitor process(CompetitorIdentifier playerIdentifier) throws Exception {
        if (processedFanDuelIds.contains(playerIdentifier.getFanDuelId())) {
            log.warn("Duplicate CompetitorIdentifier found for NFL Competitor {}", playerIdentifier);
            return null;
        }
        processedFanDuelIds.add(playerIdentifier.getFanDuelId());

        if (playerIdentifier.getSportRadarId() == null) {
            log.warn("No SportRadarId found for NFL Competitor {}", playerIdentifier);
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
                competitorProviderIdRepository.findByFanduelCompetitorId(playerIdentifier.getFanDuelId());
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
        CompetitorProviderId competitorProviderIds = existingCompetitorProviderId.orElse(new CompetitorProviderId());
        competitorProviderIds.setFanduelCompetitorId(playerIdentifier.getFanDuelId());
        competitorProviderIds.setSportradarCompetitorId(playerIdentifier.getSportRadarId());
        competitorProviderIds.setNumberfireCompetitorId(playerIdentifier.getNumberFireId());
        // NOTE: Not currently updating sportsbookSelectionIds
        competitorProviderIds.setSportsbookSelectionIds(
                competitorProviderIds.getSportsbookSelectionIds() != null
                                && !competitorProviderIds
                                        .getSportsbookSelectionIds()
                                        .isEmpty()
                        ? competitorProviderIds.getSportsbookSelectionIds()
                        : Optional.ofNullable(playerIdentifier.getSportsbookIds()).orElse(List.of()).stream()
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
        //        private CompetitorStatus competitorStatus

        srPlayerProfile.getPosition().ifPresent(position -> {
            List<SportPosition> positions =
                    Optional.ofNullable(competitor.getPositions()).orElse(new ArrayList<>());
            if (positions.stream().noneMatch(p -> p.getSportPositionCode().equals(position))) {
                Sport sport = sportService.findAll().stream()
                        .filter(s -> s.getName().equals(Sports.AMERICAN_FOOTBALL.getSportName()))
                        .findFirst()
                        .orElseThrow();
                List<SportPosition> existingSportPositions = sportPositionRepository.findAll();
                SportPosition sportPosition = existingSportPositions.stream()
                        .filter(p -> p.getSportPositionCode().equals(position))
                        .findFirst()
                        .orElse(null);
                if (sportPosition == null) {
                    sportPosition = new SportPosition();
                    sportPosition.setSportPositionCode(position);
                    sportPosition.setSportId(sport.getSportId());
                    sportPosition.setSport(sport);
                    sportPosition = sportPositionRepository.save(sportPosition);
                }
                positions.add(sportPosition);
            }
            competitor.setPositions(positions);
        });

        return competitor;
    }
}

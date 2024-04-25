package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile.SrNflV7TeamProfileConference;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile.SrNflV7TeamProfileDivision;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile.SrNflV7TeamProfileLocation;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile.SrNflV7TeamProfileResponse;
import com.jp.springbatchpoc.model.dto.TeamIdentifier;
import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.model.entity.TeamAssociation;
import com.jp.springbatchpoc.model.entity.TeamAssociationType;
import com.jp.springbatchpoc.model.entity.TeamColor;
import com.jp.springbatchpoc.model.entity.TeamColorType;
import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.model.entity.TeamSportsbookSelectionId;
import com.jp.springbatchpoc.model.entity.Venue;
import com.jp.springbatchpoc.model.enums.Leagues;
import com.jp.springbatchpoc.model.enums.TeamAssociationTypes;
import com.jp.springbatchpoc.model.enums.TeamColorTypes;
import com.jp.springbatchpoc.repository.TeamAssociationRepository;
import com.jp.springbatchpoc.repository.VenueRepository;
import com.jp.springbatchpoc.service.LeagueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class NflTeamIdentifierProcessor implements ItemProcessor<TeamIdentifier, Team> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private final LeagueService leagueService;
    private final TeamAssociationRepository teamAssociationRepository;
    private final VenueRepository venueRepository;

    @Override
    public Team process(TeamIdentifier teamIdentifier) throws Exception {
        League league = leagueService.getLeagueFromLeagueCd(Leagues.NFL)
                .orElseThrow();

        if (teamIdentifier.getSportRadarId() == null) {
            log.warn("No sportradar team ID for NFL Team {}", teamIdentifier);
            return null;
        }
        Team team = new Team();
        SrNflV7TeamProfileResponse srTeamProfile =
                sportRadarNflV7Client.getTeamProfile(teamIdentifier.getSportRadarId()).block();

        if (srTeamProfile == null) {
            log.warn("Sportradar team profile not found for NFL Team {}", teamIdentifier);
            return null;
        }

        srTeamProfile.getAlias().ifPresent(team::setAbbreviation);
        srTeamProfile.getName().ifPresent(team::setName);
        srTeamProfile.getMarket().ifPresent(team::setMarket);
        srTeamProfile.getFounded().ifPresent(team::setYearFounded);
        srTeamProfile.getOwner().ifPresent(team::setOwner);
        team.setLeague(league);

        // Provider IDs
        TeamProviderId teamProviderIds = new TeamProviderId();
        teamProviderIds.setFanduelTeamId(teamIdentifier.getFanDuelId());
        teamProviderIds.setSportradarTeamId(teamIdentifier.getSportRadarId());
        teamProviderIds.setNumberfireTeamId(teamIdentifier.getNumberFireId());
        teamProviderIds.setSportsbookSelectionIds(
                Optional.ofNullable(teamIdentifier.getSportsbookIds())
                        .orElse(List.of())
                        .stream()
                        .map(id -> {
                            TeamSportsbookSelectionId selectionId = new TeamSportsbookSelectionId();
                            selectionId.setSelectionId(id);
                            selectionId.setTeamProviderIds(teamProviderIds);
                            return selectionId;
                        })
                        .collect(Collectors.toList()));
        teamProviderIds.setTeam(team);
        team.setTeamProviderIds(teamProviderIds);

        // TeamAssociations (Conference + Division)
        srTeamProfile.getConference()
                .flatMap(SrNflV7TeamProfileConference::getName)
                .ifPresent(conferenceName -> {
                    TeamAssociation teamAssociation =
                            teamAssociationRepository.findByName(conferenceName)
                                    .orElse(null);
                    if (teamAssociation == null) {
                        teamAssociation = new TeamAssociation();
                        teamAssociation.setTeamAssociationType(
                                new TeamAssociationType().setTeamAssociationTypeCode(
                                        TeamAssociationTypes.CONFERENCE.getAssociationName())
                        );
                        teamAssociation.setName(conferenceName);
                        teamAssociation.setShortName(conferenceName);
                        teamAssociation = teamAssociationRepository.save(teamAssociation);
                    }
                    if (team.getTeamAssociations() == null) {
                        team.setTeamAssociations(new ArrayList<>());
                    }
                    team.getTeamAssociations().add(teamAssociation);
                });

        srTeamProfile.getDivision()
                .flatMap(SrNflV7TeamProfileDivision::getName)
                .ifPresent(divisionName -> {
                    TeamAssociation teamAssociation =
                            teamAssociationRepository.findByName(divisionName)
                                    .orElse(null);
                    if (teamAssociation == null) {
                        teamAssociation = new TeamAssociation();
                        teamAssociation.setTeamAssociationType(
                                new TeamAssociationType().setTeamAssociationTypeCode(
                                        TeamAssociationTypes.DIVISION.getAssociationName())
                        );
                        teamAssociation.setName(divisionName);
                        teamAssociation.setShortName(divisionName);
                        teamAssociation = teamAssociationRepository.save(teamAssociation);
                    }
                    if (team.getTeamAssociations() == null) {
                        team.setTeamAssociations(new ArrayList<>());
                    }
                    team.getTeamAssociations().add(teamAssociation);
                });

        // Team Colors
        srTeamProfile.getTeamColors()
                .forEach(srColor -> {
                    TeamColor teamColor = new TeamColor();
                    TeamColorTypes teamColorType = srColor.getType().flatMap(srColorType -> Arrays.stream(TeamColorTypes.values())
                                    .filter(typeEnum -> typeEnum.getTypeName().equalsIgnoreCase(srColorType))
                                    .findFirst())
                            .orElseThrow(() -> new RuntimeException("Bad SR color type found: " + srColor.getType().orElse(null)));
                    teamColor.setTeamColorType(new TeamColorType().setTeamColorTypeCode(teamColorType.getTypeName()));
                    srColor.getHexColor().ifPresent(teamColor::setHexColor);
                    srColor.getAlpha().map(Double::intValue).ifPresent(teamColor::setAlpha);
                    srColor.getRgbColor().ifPresent(srRgb -> {
                        srRgb.getRed().ifPresent(teamColor::setRgbRed);
                        srRgb.getGreen().ifPresent(teamColor::setRgbGreen);
                        srRgb.getBlue().ifPresent(teamColor::setRgbBlue);
                    });
                    teamColor.setTeam(team);
                    if (team.getTeamColors() == null) {
                        team.setTeamColors(new ArrayList<>());
                    }
                    team.getTeamColors().add(teamColor);
                });

        // Venue
        srTeamProfile.getVenue()
                .filter(srVenue -> srVenue.getLocation().flatMap(SrNflV7TeamProfileLocation::getLat).isPresent())
                .filter(srVenue -> srVenue.getLocation().flatMap(SrNflV7TeamProfileLocation::getLng).isPresent())
                .ifPresent(srVenue -> {
                    BigDecimal lat = srVenue.getLocation().flatMap(SrNflV7TeamProfileLocation::getLat).map(BigDecimal::new).orElseThrow();
                    BigDecimal lng = srVenue.getLocation().flatMap(SrNflV7TeamProfileLocation::getLng).map(BigDecimal::new).orElseThrow();
                    Venue venue =
                            venueRepository.findByLatitudeAndLongitude(lat, lng);
                    if (venue == null) {
                        venue = new Venue();
                        srVenue.getName().ifPresent(venue::setName);
                        srVenue.getCity().ifPresent(venue::setCity);
                        srVenue.getState().ifPresent(venue::setState);
                        srVenue.getCountry().ifPresent(venue::setCountry);
                        srVenue.getZip().ifPresent(venue::setZip);
                        srVenue.getAddress().ifPresent(venue::setAddress);
                        srVenue.getCapacity().ifPresent(venue::setCapacity);
                        srVenue.getSurface().ifPresent(venue::setSurface);
                        srVenue.getRoofType().ifPresent(venue::setRoofType);
                        venue.setLatitude(lat);
                        venue.setLongitude(lng);
                        venue = venueRepository.save(venue);
                    }
                    team.setPrimaryVenue(venue);
                });

        return team;
    }
}

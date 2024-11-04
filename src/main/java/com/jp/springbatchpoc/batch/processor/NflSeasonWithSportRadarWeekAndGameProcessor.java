package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.batch.reader.SportRadarScheduleReader;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleAway;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleGame;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleHome;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleLocation;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleScoring;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleWeek;
import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.model.entity.EventAssociation;
import com.jp.springbatchpoc.model.entity.EventAssociationType;
import com.jp.springbatchpoc.model.entity.EventProviderId;
import com.jp.springbatchpoc.model.entity.EventStatus;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.model.entity.Venue;
import com.jp.springbatchpoc.model.enums.EventAssociationTypes;
import com.jp.springbatchpoc.repository.EventAssociationRepository;
import com.jp.springbatchpoc.repository.EventProviderIdRepository;
import com.jp.springbatchpoc.repository.TeamProviderIdRepository;
import com.jp.springbatchpoc.repository.VenueRepository;
import com.jp.springbatchpoc.service.EventAssociationTypeService;
import com.jp.springbatchpoc.service.EventStatusService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.Nullable;

@Slf4j
@RequiredArgsConstructor
public class NflSeasonWithSportRadarWeekAndGameProcessor
        implements ItemProcessor<SportRadarScheduleReader.SportRadarWeekAndGameWithNflSeason, Event> {

    private final EventProviderIdRepository eventProviderIdRepository;
    private final EventStatusService eventStatusService;
    private final EventAssociationRepository eventAssociationRepository;
    private final EventAssociationTypeService eventAssociationTypeService;
    private final TeamProviderIdRepository teamProviderIdRepository;
    private final VenueRepository venueRepository;

    @Override
    public Event process(SportRadarScheduleReader.SportRadarWeekAndGameWithNflSeason item) throws Exception {

        SrNflV7SeasonScheduleGame srGame = item.game();
        SrNflV7SeasonScheduleWeek srWeek = item.seasonType();

        if (eventProviderIdRepository.existsBySportradarEventId(srGame.getId().orElse(null))) {
            // Game exists already
            return null;
        }

        Map<String, EventStatus> eventStatusMap = eventStatusService.findAll().stream()
                .collect(Collectors.toMap(EventStatus::getEventStatusCode, Function.identity()));
        Event event = null;
        try {
            event = Event.builder()
                    .scheduledTime(srGame.getScheduled()
                            .map(date -> LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                            .orElseThrow())
                    .season(item.season())
                    .eventStatus(getEventStatus(srGame, eventStatusMap))
                    .awayTeamScore(srGame.getScoring()
                            .flatMap(SrNflV7SeasonScheduleScoring::getHomePoints)
                            .orElse(null))
                    .homeTeamScore(srGame.getScoring()
                            .flatMap(SrNflV7SeasonScheduleScoring::getAwayPoints)
                            .orElse(null))
                    .eventProviderId(getEventProviderId(srGame))
                    .eventAssociations(getEventAssociations(srGame, srWeek))
                    .sequence(srWeek.getSequence().orElse(null))
                    .eventTitle(srGame.getTitle().orElse(null))
                    .awayTeam(getTeam(srGame.getAway()
                            .flatMap(SrNflV7SeasonScheduleAway::getId)
                            .orElse(null)))
                    .homeTeam(getTeam(srGame.getHome()
                            .flatMap(SrNflV7SeasonScheduleHome::getId)
                            .orElse(null)))
                    .venue(getVenue(srGame))
                    .build();
            event.getEventProviderId().setEvent(event);
        } catch (IllegalArgumentException e) {
            // Invalid event status code
            log.error("Error processing event: " + srGame, e);
        }

        return event;
    }

    private EventStatus getEventStatus(SrNflV7SeasonScheduleGame srGame, Map<String, EventStatus> eventStatusMap) {
        return srGame.getStatus()
                .map(srStatus -> {
                    if (Set.of("flex-schedule", "if necessary", "unnecessary", "time-tbd")
                            .contains(srStatus)) {
                        throw new IllegalArgumentException("Invalid event status code: " + srStatus);
                    }
                    EventStatus eventStatus = eventStatusMap.get(
                            switch (srStatus) {
                                case "created", "scheduled" -> "SCHEDULED";
                                case "halftime", "inprogress" -> "IN_PROGRESS";
                                case "delayed" -> "DELAYED";
                                case "postponed" -> "POSTPONED";
                                case "suspended" -> "SUSPENDED";
                                case "canceled", "cancelled" -> "CANCELLED";
                                case "closed", "complete" -> "FINAL";
                                default -> null;
                            });
                    if (eventStatus == null) {
                        throw new IllegalArgumentException("Invalid event status code: " + srStatus);
                    }
                    return eventStatus;
                })
                .orElseThrow();
    }

    private Venue getVenue(SrNflV7SeasonScheduleGame srGame) {
        // TODO: not working correctly
        return srGame.getVenue()
                .map(srVenue -> venueRepository.findByLatitudeAndLongitude(
                        srVenue.getLocation()
                                .flatMap(SrNflV7SeasonScheduleLocation::getLat)
                                .map(BigDecimal::new)
                                .orElse(null),
                        srVenue.getLocation()
                                .flatMap(SrNflV7SeasonScheduleLocation::getLng)
                                .map(BigDecimal::new)
                                .orElse(null)))
                .orElse(null);
    }

    private Team getTeam(@Nullable String sportRadarTeamId) {
        return Optional.ofNullable(sportRadarTeamId)
                .flatMap(teamProviderIdRepository::findBySportradarTeamId)
                .map(TeamProviderId::getTeam)
                .orElse(null);
    }

    private List<EventAssociation> getEventAssociations(
            SrNflV7SeasonScheduleGame srGame, SrNflV7SeasonScheduleWeek srWeek) {
        if (!srGame.getTitle().orElse("").toLowerCase().contains("super bowl")) {
            return List.of();
        }
        EventAssociationType eventAssociationType =
                eventAssociationTypeService.findByType(EventAssociationTypes.CHAMPIONSHIP);
        String description = "Super Bowl";
        EventAssociation existingEventAssociation =
                eventAssociationRepository.findByEventAssociationTypeAndDescription(eventAssociationType, description);
        if (existingEventAssociation != null) {
            return List.of(existingEventAssociation);
        }
        return List.of(eventAssociationRepository.save(EventAssociation.builder()
                .eventAssociationType(eventAssociationType)
                .description(description)
                .build()));
    }

    private EventProviderId getEventProviderId(SrNflV7SeasonScheduleGame srGame) {
        return srGame.getId()
                .map(srEventId ->
                        EventProviderId.builder().sportradarEventId(srEventId).build())
                .orElseThrow();
    }
}

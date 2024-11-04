package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsAway;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsHome_1;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsPassing;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsReceiving;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsRushing;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsStatistics;
import com.jp.springbatchpoc.model.entity.Competitor;
import com.jp.springbatchpoc.model.entity.CompetitorEventStatistics;
import com.jp.springbatchpoc.model.entity.CompetitorProviderId;
import com.jp.springbatchpoc.model.entity.CompetitorsEvents;
import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.repository.CompetitorProviderIdRepository;
import jakarta.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

@RequiredArgsConstructor
public class EventProcessor implements ItemProcessor<Event, Event> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private final CompetitorProviderIdRepository competitorProviderIdRepository;
    private final Map<String, Competitor> competitorBySrIdCache = new HashMap<>();

    @Override
    public Event process(@Nonnull Event event) throws Exception {

        List<CompetitorsEvents> competitorsEvents = event.getCompetitorsEvents();

        // Don't populate filled out events
        if (competitorsEvents == null || competitorsEvents.isEmpty()) {
            SrNflV7GameStatisticsResponse gameStatistics = sportRadarNflV7Client
                    .getGameStatistics(event.getEventProviderId().getSportradarEventId())
                    .block();

            if (gameStatistics == null) {
                return null;
            }

            if (event.getCompetitorsEvents() == null) {
                event.setCompetitorsEvents(new LinkedList<>());
            }

            Team homeTeam = event.getHomeTeam();
            Team awayTeam = event.getAwayTeam();

            Set<String> homeTeamSportRadarPlayerIds = new HashSet<>();
            // Populate CompetitorsEvents
            Optional<SrNflV7GameStatisticsReceiving> homeReceivingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                    .flatMap(SrNflV7GameStatisticsHome_1::getReceiving);
            homeReceivingOpt
                    .map(SrNflV7GameStatisticsReceiving::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(homeTeamSportRadarPlayerIds::add)));

            Optional<SrNflV7GameStatisticsRushing> homeRushingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                    .flatMap(SrNflV7GameStatisticsHome_1::getRushing);
            homeRushingOpt
                    .map(SrNflV7GameStatisticsRushing::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(homeTeamSportRadarPlayerIds::add)));

            Optional<SrNflV7GameStatisticsPassing> homePassingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                    .flatMap(SrNflV7GameStatisticsHome_1::getPassing);
            homePassingOpt
                    .map(SrNflV7GameStatisticsPassing::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(homeTeamSportRadarPlayerIds::add)));

            Map<String, Competitor> homeTeamCompetitorMap = homeTeamSportRadarPlayerIds.stream()
                    .flatMap(srId -> getCompetitorBySrId(srId).stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry<String, Competitor> entry : homeTeamCompetitorMap.entrySet()) {
                CompetitorsEvents homeCompetitorsEvents = CompetitorsEvents.builder()
                        .competitor(entry.getValue())
                        .team(homeTeam)
                        .event(event)
                        .build();
                //                homeCompetitorsEvents.setCompetitorEventStatistics(getEventStatistics(
                //                        homeCompetitorsEvents,
                //                        entry.getKey(),
                //                        homeReceivingOpt.orElse(null),
                //                        homeRushingOpt.orElse(null),
                //                        homePassingOpt.orElse(null)));
                event.getCompetitorsEvents().add(homeCompetitorsEvents);
            }

            // Process Away team
            Set<String> awayTeamSportRadarPlayerIds = new HashSet<>();
            // Populate CompetitorsEvents
            Optional<SrNflV7GameStatisticsReceiving> awayReceivingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                    .flatMap(SrNflV7GameStatisticsAway::getReceiving);
            awayReceivingOpt
                    .map(SrNflV7GameStatisticsReceiving::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(awayTeamSportRadarPlayerIds::add)));

            Optional<SrNflV7GameStatisticsRushing> awayRushingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                    .flatMap(SrNflV7GameStatisticsAway::getRushing);
            awayRushingOpt
                    .map(SrNflV7GameStatisticsRushing::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(awayTeamSportRadarPlayerIds::add)));

            Optional<SrNflV7GameStatisticsPassing> awayPassingOpt = gameStatistics
                    .getStatistics()
                    .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                    .flatMap(SrNflV7GameStatisticsAway::getPassing);
            awayPassingOpt
                    .map(SrNflV7GameStatisticsPassing::getPlayers)
                    .ifPresent(playerList ->
                            playerList.forEach(player -> player.getId().ifPresent(awayTeamSportRadarPlayerIds::add)));

            Map<String, Competitor> awayTeamCompetitorMap = awayTeamSportRadarPlayerIds.stream()
                    .flatMap(srId -> getCompetitorBySrId(srId).stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            for (Map.Entry<String, Competitor> entry : awayTeamCompetitorMap.entrySet()) {
                CompetitorsEvents awayCompetitorsEvents = CompetitorsEvents.builder()
                        .competitor(entry.getValue())
                        .team(awayTeam)
                        .event(event)
                        .build();
                //                awayCompetitorsEvents.setCompetitorEventStatistics(getEventStatistics(
                //                        awayCompetitorsEvents,
                //                        entry.getKey(),
                //                        awayReceivingOpt.orElse(null),
                //                        awayRushingOpt.orElse(null),
                //                        awayPassingOpt.orElse(null)));
                event.getCompetitorsEvents().add(awayCompetitorsEvents);
            }

        } else {
            return null;
        }

        int x = 0;
        x++;
        return event;
    }

    private Optional<Map.Entry<String, Competitor>> getCompetitorBySrId(String srId) {
        if (competitorBySrIdCache.containsKey(srId)) {
            return Optional.of(Map.entry(srId, competitorBySrIdCache.get(srId)));
        }
        Optional<Competitor> competitorOptional = competitorProviderIdRepository
                .findBySportradarCompetitorId(srId)
                .map(CompetitorProviderId::getCompetitor);
        competitorOptional.ifPresent(competitor -> competitorBySrIdCache.put(srId, competitor));
        return competitorOptional.map(competitor -> Map.entry(srId, competitor));
    }

    private List<CompetitorEventStatistics> getEventStatistics(
            CompetitorsEvents competitorsEvents,
            String playerId,
            SrNflV7GameStatisticsReceiving receiving,
            SrNflV7GameStatisticsRushing rushing,
            SrNflV7GameStatisticsPassing passing) {

        List<CompetitorEventStatistics> competitorEventStatistics = new LinkedList<>();

        Map<String, BigDecimal> stats = new HashMap<>();
        if (receiving != null) {
            receiving.getPlayers().stream()
                    .filter(player -> player.getId().orElse("").equals(playerId))
                    .findFirst()
                    .ifPresent(player -> {
                        player.getYards().ifPresent(value -> stats.put("RECEIVING_YARDS", BigDecimal.valueOf(value)));
                        player.getReceptions()
                                .ifPresent(value -> stats.put("RECEIVING_RECEPTIONS", BigDecimal.valueOf(value)));
                        player.getTouchdowns()
                                .ifPresent(value -> stats.put("RECEIVING_TOUCHDOWNS", BigDecimal.valueOf(value)));
                        player.getAvgYards()
                                .ifPresent(value -> stats.put("RECEIVING_AVG_YARDS", BigDecimal.valueOf(value)));
                        player.getDroppedPasses()
                                .ifPresent(value -> stats.put("RECEIVING_DROPPED_PASSES", BigDecimal.valueOf(value)));
                        player.getTargets()
                                .ifPresent(value -> stats.put("RECEIVING_TARGETS", BigDecimal.valueOf(value)));
                        player.getYardsAfterCatch()
                                .ifPresent(
                                        value -> stats.put("RECEIVING_YARDS_AFTER_CATCH", BigDecimal.valueOf(value)));
                        player.getYardsAfterContact()
                                .ifPresent(
                                        value -> stats.put("RECEIVING_YARDS_AFTER_CONTACT", BigDecimal.valueOf(value)));
                        player.getRedzoneTargets()
                                .ifPresent(value -> stats.put("RECEIVING_REDZONE_TARGETS", BigDecimal.valueOf(value)));
                    });
        }

        if (rushing != null) {
            rushing.getPlayers().stream()
                    .filter(player -> player.getId().orElse("").equals(playerId))
                    .findFirst()
                    .ifPresent(player -> {
                        player.getYards().ifPresent(value -> stats.put("RUSHING_YARDS", BigDecimal.valueOf(value)));
                        player.getAttempts()
                                .ifPresent(value -> stats.put("RUSHING_ATTEMPTS", BigDecimal.valueOf(value)));
                        player.getTouchdowns()
                                .ifPresent(value -> stats.put("RUSHING_TOUCHDOWNS", BigDecimal.valueOf(value)));
                        player.getAvgYards()
                                .ifPresent(value -> stats.put("RUSHING_AVERAGE_YARDS", BigDecimal.valueOf(value)));
                        player.getYardsAfterContact()
                                .ifPresent(
                                        value -> stats.put("RUSHING_YARDS_AFTER_CONTACT", BigDecimal.valueOf(value)));
                    });
        }

        if (passing != null) {
            passing.getPlayers().stream()
                    .filter(player -> player.getId().orElse("").equals(playerId))
                    .findFirst()
                    .ifPresent(player -> {
                        player.getYards().ifPresent(value -> stats.put("PASSING_YARDS", BigDecimal.valueOf(value)));
                        player.getAttempts()
                                .ifPresent(value -> stats.put("PASSING_ATTEMPTS", BigDecimal.valueOf(value)));
                        player.getTouchdowns()
                                .ifPresent(value -> stats.put("PASSING_TOUCHDOWNS", BigDecimal.valueOf(value)));
                        player.getInterceptions()
                                .ifPresent(value -> stats.put("PASSING_INTERCEPTIONS", BigDecimal.valueOf(value)));
                        player.getAvgYards()
                                .ifPresent(value -> stats.put("PASSING_AVG_YARDS", BigDecimal.valueOf(value)));
                        player.getCompletions()
                                .ifPresent(value -> stats.put("PASSING_COMPLETIONS", BigDecimal.valueOf(value)));
                        player.getCmpPct().ifPresent(value -> stats.put("PASSING_CMP_PCT", BigDecimal.valueOf(value)));
                        player.getRating().ifPresent(value -> stats.put("PASSING_RATING", BigDecimal.valueOf(value)));
                    });
        }

        stats.forEach((name, value) -> {
            CompetitorEventStatistics.CompetitorEventStatisticsBuilder builder = CompetitorEventStatistics.builder()
                    .competitorsEvents(competitorsEvents)
                    .statisticTypeCode(name)
                    .statisticValue(value);
            competitorEventStatistics.add(builder.build());
        });

        return competitorEventStatistics;
    }
}

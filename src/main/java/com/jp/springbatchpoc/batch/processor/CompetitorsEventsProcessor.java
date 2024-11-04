package com.jp.springbatchpoc.batch.processor;

import com.jp.springbatchpoc.client.sportradar.nflv7.SportRadarNflV7Client;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsAway;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsHome_1;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsPassing;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsReceiving;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsRushing;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsStatistics;
import com.jp.springbatchpoc.model.entity.CompetitorEventStatistics;
import com.jp.springbatchpoc.model.entity.CompetitorsEvents;
import jakarta.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

@RequiredArgsConstructor
public class CompetitorsEventsProcessor implements ItemProcessor<CompetitorsEvents, CompetitorsEvents> {

    private final SportRadarNflV7Client sportRadarNflV7Client;
    private SrNflV7GameStatisticsResponse previousGameStatistics;

    @Override
    public CompetitorsEvents process(@Nonnull CompetitorsEvents competitorsEvents) throws Exception {
        String srEventId = competitorsEvents.getEvent().getEventProviderId().getSportradarEventId();
        SrNflV7GameStatisticsResponse gameStatistics;
        if (previousGameStatistics != null
                && previousGameStatistics
                        .getId()
                        .filter(id -> id.equals(srEventId))
                        .isPresent()) {
            gameStatistics = previousGameStatistics;
        } else {
            gameStatistics = sportRadarNflV7Client.getGameStatistics(srEventId).block();
            previousGameStatistics = gameStatistics;
        }

        if (gameStatistics == null) {
            return null;
        }

        String competitorSportRadarId =
                competitorsEvents.getCompetitor().getCompetitorProviderIds().getSportradarCompetitorId();

        // Populate CompetitorsEvents
        Optional<SrNflV7GameStatisticsReceiving> homeReceivingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                .flatMap(SrNflV7GameStatisticsHome_1::getReceiving);
        Optional<SrNflV7GameStatisticsRushing> homeRushingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                .flatMap(SrNflV7GameStatisticsHome_1::getRushing);
        Optional<SrNflV7GameStatisticsPassing> homePassingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getHome)
                .flatMap(SrNflV7GameStatisticsHome_1::getPassing);

        List<CompetitorEventStatistics> homeCompetitorStats = getEventStatistics(
                competitorsEvents,
                competitorSportRadarId,
                homeReceivingOpt.orElse(null),
                homeRushingOpt.orElse(null),
                homePassingOpt.orElse(null));

        competitorsEvents.getCompetitorEventStatistics().addAll(homeCompetitorStats);

        // Populate CompetitorsEvents
        Optional<SrNflV7GameStatisticsReceiving> awayReceivingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                .flatMap(SrNflV7GameStatisticsAway::getReceiving);

        Optional<SrNflV7GameStatisticsRushing> awayRushingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                .flatMap(SrNflV7GameStatisticsAway::getRushing);

        Optional<SrNflV7GameStatisticsPassing> awayPassingOpt = gameStatistics
                .getStatistics()
                .flatMap(SrNflV7GameStatisticsStatistics::getAway)
                .flatMap(SrNflV7GameStatisticsAway::getPassing);

        List<CompetitorEventStatistics> awayCompetitorStats = getEventStatistics(
                competitorsEvents,
                competitorSportRadarId,
                awayReceivingOpt.orElse(null),
                awayRushingOpt.orElse(null),
                awayPassingOpt.orElse(null));

        competitorsEvents.getCompetitorEventStatistics().addAll(awayCompetitorStats);

        return competitorsEvents;
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
                    .competitorsEventsId(competitorsEvents.getCompetitorsEventsId())
                    .statisticTypeCode(name)
                    .statisticValue(value);
            competitorEventStatistics.add(builder.build());
        });

        return competitorEventStatistics;
    }
}

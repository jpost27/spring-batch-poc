package com.jp.springbatchpoc.client.sportradar.nflv7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jp.springbatchpoc.cache.Cache;
import com.jp.springbatchpoc.cache.CacheLoader;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.currentseasonschedule.SrNflV7CurrentSeasonScheduleResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.currentweekschedule.SrNflV7CurrentWeekScheduleResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.dailychangelog.SrNflV7DailyChangeLogResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.dailytransactions.SrNflV7DailyTransactionsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.draftsummary.SrNflV7DraftSummaryResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore.SrNflV7GameBoxscoreResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gameroster.SrNflV7GameRosterResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics.SrNflV7GameStatisticsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.leaguehierarchy.SrNflV7LeagueHierarchyResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay.SrNflV7PlayByPlayResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.playerprofile.SrNflV7PlayerProfileResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings.SrNflV7PostgameStandingsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.prospects.SrNflV7ProspectsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics.SrNflV7SeasonalStatisticsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons.SrNflV7SeasonsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule.SrNflV7SeasonScheduleResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamdraftsummary.SrNflV7TeamDraftSummaryResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile.SrNflV7TeamProfileResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.teamroster.SrNflV7TeamRosterResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.topprospects.SrNflV7TopProspectsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.trades.SrNflV7TradesResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklydepthcharts.SrNflV7WeeklyDepthChartsResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklyinjuries.SrNflV7WeeklyInjuriesResponse;
import com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklyschedule.SrNflV7WeeklyScheduleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.annotation.processing.Generated;
import java.lang.reflect.Type;
import java.net.URI;
import java.time.Instant;

@Generated("fanduel-model-generator")
@Component
public class SportRadarNflV7ClientImpl implements SportRadarNflV7Client {
    private final WebClient webClient;

    private static final String API_BASE_PATH = "https://api.sportradar.us/";

    private final String API_KEY;

    private final String ACCESS_LEVEL;

    private static final String LANGUAGE_CODE = "en";

    private static final String VERSION = "v7";

    public SportRadarNflV7ClientImpl(final WebClient webClient,
                                     @Value("${sportradar.nfl.v7.key}") String key,
                                     @Value("${sportradar.nfl.v7.accessLevel}") String accessLevel) {
        this.ACCESS_LEVEL = accessLevel;
        this.API_KEY = key;
        this.webClient = webClient;
    }

    public Mono<SrNflV7CurrentSeasonScheduleResponse> getCurrentSeasonSchedule() {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", "current_season", "schedule.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7CurrentSeasonScheduleResponse.class);
    }

    public Mono<SrNflV7CurrentWeekScheduleResponse> getCurrentWeekSchedule() {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", "current_week", "schedule.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7CurrentWeekScheduleResponse.class);
    }

    public Mono<SrNflV7DailyChangeLogResponse> getDailyChangeLog(
            @NonNull Integer year, @NonNull Integer month, @NonNull Integer day) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "league", year.toString(), month.toString(), day.toString(), "changes.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7DailyChangeLogResponse.class);
    }

    public Mono<SrNflV7DailyTransactionsResponse> getDailyTransactions(
            @NonNull Integer year, @NonNull Integer month, @NonNull Integer day) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "league", year.toString(), month.toString(), day.toString(), "transactions.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7DailyTransactionsResponse.class);
    }

    public Mono<SrNflV7DraftSummaryResponse> getDraftSummary(@NonNull Integer year) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("draft", "nfl", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, year.toString(), "draft.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7DraftSummaryResponse.class);
    }

    public Mono<SrNflV7GameBoxscoreResponse> getGameBoxscore(
            @NonNull String gameId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", gameId, "boxscore.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7GameBoxscoreResponse.class);
    }

    public Mono<SrNflV7GameRosterResponse> getGameRoster(@NonNull String gameId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", gameId, "roster.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7GameRosterResponse.class);
    }

    public Mono<SrNflV7GameStatisticsResponse> getGameStatistics(
            @NonNull String gameId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", gameId, "statistics.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7GameStatisticsResponse.class);
    }

    public Mono<SrNflV7LeagueHierarchyResponse> getLeagueHierarchy() {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "league", "hierarchy.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7LeagueHierarchyResponse.class);
    }

    public Mono<SrNflV7PlayByPlayResponse> getPlayByPlay(@NonNull String gameId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", gameId, "pbp.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7PlayByPlayResponse.class);
    }

    public Mono<SrNflV7PlayerProfileResponse> getPlayerProfile(
            @NonNull String playerId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "players", playerId, "profile.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7PlayerProfileResponse.class);
    }

    public Mono<SrNflV7PostgameStandingsResponse> getPostgameStandings(
            @NonNull Integer year, @NonNull String nflSeason) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "seasons", year.toString(), nflSeason, "standings", "season.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7PostgameStandingsResponse.class);
    }

    public Mono<SrNflV7ProspectsResponse> getProspects(@NonNull Integer year) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("draft", "nfl", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, year.toString(), "prospects.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7ProspectsResponse.class);
    }

    public Mono<SrNflV7SeasonScheduleResponse> getSeasonSchedule(
            @NonNull Integer year, @NonNull String nflSeason) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", year.toString(), nflSeason, "schedule.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7SeasonScheduleResponse.class);
    }

    public Mono<SrNflV7SeasonalStatisticsResponse> getSeasonalStatistics(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String teamId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "seasons", year.toString(), nflSeason, "teams", teamId, "statistics.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7SeasonalStatisticsResponse.class);
    }

    public Mono<SrNflV7SeasonsResponse> getSeasons() {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "league", "seasons.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7SeasonsResponse.class);
    }

    public Mono<SrNflV7TeamDraftSummaryResponse> getTeamDraftSummary(
            @NonNull Integer year, @NonNull String teamId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("draft", "nfl", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, year.toString(), "teams", teamId, "draft.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7TeamDraftSummaryResponse.class);
    }

    public Mono<SrNflV7TeamProfileResponse> getTeamProfile(@NonNull String teamId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "teams", teamId, "profile.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7TeamProfileResponse.class);
    }

    public Mono<SrNflV7TeamRosterResponse> getTeamRoster(@NonNull String teamId) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "teams", teamId, "full_roster.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7TeamRosterResponse.class);
    }

    public Mono<SrNflV7TopProspectsResponse> getTopProspects(@NonNull Integer year) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("draft", "nfl", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, year.toString(), "top_prospects.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7TopProspectsResponse.class);
    }

    public Mono<SrNflV7TradesResponse> getTrades(@NonNull Integer year) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("draft", "nfl", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, year.toString(), "trades.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7TradesResponse.class);
    }

    public Mono<SrNflV7WeeklyDepthChartsResponse> getWeeklyDepthCharts(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String nflSeasonWeek) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "seasons", year.toString(), nflSeason, nflSeasonWeek, "depth_charts.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7WeeklyDepthChartsResponse.class);
    }

    public Mono<SrNflV7WeeklyInjuriesResponse> getWeeklyInjuries(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String nflSeasonWeek) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "seasons", year.toString(), nflSeason, nflSeasonWeek, "injuries.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7WeeklyInjuriesResponse.class);
    }

    public Mono<SrNflV7WeeklyScheduleResponse> getWeeklySchedule(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String nflSeasonWeek) {
        UriComponents uri = UriComponentsBuilder.fromUriString(API_BASE_PATH)
        .pathSegment("nfl", "official", ACCESS_LEVEL, VERSION, LANGUAGE_CODE, "games", year.toString(), nflSeason, nflSeasonWeek, "schedule.json")
        .queryParam("api_key", API_KEY)
        .build();
        return fetch(uri.toUri(), SrNflV7WeeklyScheduleResponse.class);
    }

    <T> Mono<T> fetch(URI uri, Class<T> returnType) {
        return CacheLoader.loadOrFetchMono(Cache.SR_NFL_RESPONSES, uri.toString(), new TypeReference<>() {
            public Type getType() { return returnType; }
        }, (uriString) -> webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(returnType)
                .mapNotNull(res -> {
                    if (ACCESS_LEVEL.equalsIgnoreCase("trial")) {
                        // TODO: Hack delay for trial keys. need to come up with a better solution
                        Instant start = Instant.now();
                        while (Instant.now().toEpochMilli() - start.toEpochMilli() < 1500) {
                        }
                    }
                    return res;
                }));
    }
}

package com.jp.springbatchpoc.client.sportradar.nflv7;

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
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

import javax.annotation.processing.Generated;

@Generated("fanduel-model-generator")
public interface SportRadarNflV7Client {
    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/current_season/schedule.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/current_season/schedule.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7CurrentSeasonScheduleResponse> getCurrentSeasonSchedule();

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/current_week/schedule.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/current_week/schedule.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7CurrentWeekScheduleResponse> getCurrentWeekSchedule();

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/league/2021/08/31/changes.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/league/{year}/{month}/{day}/changes.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7DailyChangeLogResponse> getDailyChangeLog(@NonNull Integer year,
                                                                         @NonNull Integer month, @NonNull Integer day);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/league/2022/07/14/transactions.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/league/{year}/{month}/{day}/transactions.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7DailyTransactionsResponse> getDailyTransactions(
            @NonNull Integer year, @NonNull Integer month, @NonNull Integer day);

    /**
     * Documentation sample: https://api.sportradar.us/draft/nfl/trial/v1/en/2021/draft.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/draft/nfl/{access_level}/{version}/{language_code}/{year}/draft.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7DraftSummaryResponse> getDraftSummary(@NonNull Integer year);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/7d06369a-382a-448a-b295-6da9eab53245/boxscore.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{game_id}/boxscore.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7GameBoxscoreResponse> getGameBoxscore(@NonNull String gameId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/7d06369a-382a-448a-b295-6da9eab53245/roster.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{game_id}/roster.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7GameRosterResponse> getGameRoster(@NonNull String gameId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/7d06369a-382a-448a-b295-6da9eab53245/statistics.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{game_id}/statistics.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7GameStatisticsResponse> getGameStatistics(@NonNull String gameId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/league/hierarchy.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/league/hierarchy.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7LeagueHierarchyResponse> getLeagueHierarchy();

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/7d06369a-382a-448a-b295-6da9eab53245/pbp.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{game_id}/pbp.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7PlayByPlayResponse> getPlayByPlay(@NonNull String gameId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/players/0acdcd3b-5442-4311-a139-ae7c506faf88/profile.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/players/{player_id}/profile.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7PlayerProfileResponse> getPlayerProfile(@NonNull String playerId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/seasons/2021/REG/standings/season.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/seasons/{year}/{nfl_season}/standings/season.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7PostgameStandingsResponse> getPostgameStandings(
            @NonNull Integer year, @NonNull String nflSeason);

    /**
     * Documentation sample: https://api.sportradar.us/draft/nfl/trial/v1/en/2021/prospects.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/draft/nfl/{access_level}/{version}/{language_code}/{year}/prospects.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7ProspectsResponse> getProspects(@NonNull Integer year);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/2021/reg/schedule.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{year}/{nfl_season}/schedule.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7SeasonScheduleResponse> getSeasonSchedule(@NonNull Integer year,
                                                                         @NonNull String nflSeason);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/seasons/2021/REG/teams/0d855753-ea21-4953-89f9-0e20aff9eb73/statistics.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/seasons/{year}/{nfl_season}/teams/{team_id}/statistics.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7SeasonalStatisticsResponse> getSeasonalStatistics(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String teamId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/league/seasons.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/league/seasons.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7SeasonsResponse> getSeasons();

    /**
     * Documentation sample: https://api.sportradar.us/draft/nfl/trial/v1/en/2021/teams/d5a2eb42-8065-4174-ab79-0a6fa820e35e/draft.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/draft/nfl/{access_level}/{version}/{language_code}/{year}/teams/{team_id}/draft.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7TeamDraftSummaryResponse> getTeamDraftSummary(@NonNull Integer year,
                                                                             @NonNull String teamId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/teams/0d855753-ea21-4953-89f9-0e20aff9eb73/profile.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/teams/{team_id}/profile.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7TeamProfileResponse> getTeamProfile(@NonNull String teamId);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/teams/0d855753-ea21-4953-89f9-0e20aff9eb73/full_roster.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/teams/{team_id}/full_roster.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7TeamRosterResponse> getTeamRoster(@NonNull String teamId);

    /**
     * Documentation sample: https://api.sportradar.us/draft/nfl/trial/v1/en/2021/top_prospects.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/draft/nfl/{access_level}/{version}/{language_code}/{year}/top_prospects.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7TopProspectsResponse> getTopProspects(@NonNull Integer year);

    /**
     * Documentation sample: https://api.sportradar.us/draft/nfl/trial/v1/en/2021/trades.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/draft/nfl/{access_level}/{version}/{language_code}/{year}/trades.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7TradesResponse> getTrades(@NonNull Integer year);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/seasons/2021/REG/01/depth_charts.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/seasons/{year}/{nfl_season}/{nfl_season_week}/depth_charts.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7WeeklyDepthChartsResponse> getWeeklyDepthCharts(
            @NonNull Integer year, @NonNull String nflSeason, @NonNull String nflSeasonWeek);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/seasons/2021/REG/01/injuries.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/seasons/{year}/{nfl_season}/{nfl_season_week}/injuries.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7WeeklyInjuriesResponse> getWeeklyInjuries(@NonNull Integer year,
                                                                         @NonNull String nflSeason, @NonNull String nflSeasonWeek);

    /**
     * Documentation sample: https://api.sportradar.us/nfl/official/trial/v7/en/games/2021/REG/01/schedule.json?api_key={your_api_key}
     * Variable URL: https://api.sportradar.us/nfl/official/{access_level}/{version}/{language_code}/games/{year}/{nfl_season}/{nfl_season_week}/schedule.{format}?api_key={your_api_key}
     */
    Mono<SrNflV7WeeklyScheduleResponse> getWeeklySchedule(@NonNull Integer year,
                                                                         @NonNull String nflSeason, @NonNull String nflSeasonWeek);
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.util.Optional;
import javax.annotation.processing.Generated;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Accessors(
        chain = true
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
@ToString
@Generated("fanduel-model-generator")
public class SrNflV7SeasonalStatisticsRecord {
    @JsonProperty("defense")
    private SrNflV7SeasonalStatisticsDefense defense;

    @JsonProperty("efficiency")
    private SrNflV7SeasonalStatisticsEfficiency efficiency;

    @JsonProperty("extra_points")
    private SrNflV7SeasonalStatisticsExtraPoints_1 extraPoints;

    @JsonProperty("field_goals")
    private SrNflV7SeasonalStatisticsFieldGoals fieldGoals;

    @JsonProperty("first_downs")
    private SrNflV7SeasonalStatisticsFirstDowns firstDowns;

    @JsonProperty("fumbles")
    private SrNflV7SeasonalStatisticsFumbles fumbles;

    @JsonProperty("games_played")
    private Integer gamesPlayed;

    @JsonProperty("int_returns")
    private SrNflV7SeasonalStatisticsIntReturns intReturns;

    @JsonProperty("interceptions")
    private SrNflV7SeasonalStatisticsInterceptions interceptions;

    @JsonProperty("kick_returns")
    private SrNflV7SeasonalStatisticsKickReturns kickReturns;

    @JsonProperty("kickoffs")
    private SrNflV7SeasonalStatisticsKickoffs kickoffs;

    @JsonProperty("misc_returns")
    private SrNflV7SeasonalStatisticsMiscReturns miscReturns;

    @JsonProperty("passing")
    private SrNflV7SeasonalStatisticsPassing passing;

    @JsonProperty("penalties")
    private SrNflV7SeasonalStatisticsPenalties penalties;

    @JsonProperty("punt_returns")
    private SrNflV7SeasonalStatisticsPuntReturns puntReturns;

    @JsonProperty("punts")
    private SrNflV7SeasonalStatisticsPunts punts;

    @JsonProperty("receiving")
    private SrNflV7SeasonalStatisticsReceiving receiving;

    @JsonProperty("rushing")
    private SrNflV7SeasonalStatisticsRushing rushing;

    @JsonProperty("touchdowns")
    private SrNflV7SeasonalStatisticsTouchdowns touchdowns;

    public Optional<SrNflV7SeasonalStatisticsDefense> getDefense() {
        return Optional.ofNullable(defense);
    }

    public Optional<SrNflV7SeasonalStatisticsEfficiency> getEfficiency() {
        return Optional.ofNullable(efficiency);
    }

    public Optional<SrNflV7SeasonalStatisticsExtraPoints_1> getExtraPoints() {
        return Optional.ofNullable(extraPoints);
    }

    public Optional<SrNflV7SeasonalStatisticsFieldGoals> getFieldGoals() {
        return Optional.ofNullable(fieldGoals);
    }

    public Optional<SrNflV7SeasonalStatisticsFirstDowns> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<SrNflV7SeasonalStatisticsFumbles> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<Integer> getGamesPlayed() {
        return Optional.ofNullable(gamesPlayed);
    }

    public Optional<SrNflV7SeasonalStatisticsIntReturns> getIntReturns() {
        return Optional.ofNullable(intReturns);
    }

    public Optional<SrNflV7SeasonalStatisticsInterceptions> getInterceptions() {
        return Optional.ofNullable(interceptions);
    }

    public Optional<SrNflV7SeasonalStatisticsKickReturns> getKickReturns() {
        return Optional.ofNullable(kickReturns);
    }

    public Optional<SrNflV7SeasonalStatisticsKickoffs> getKickoffs() {
        return Optional.ofNullable(kickoffs);
    }

    public Optional<SrNflV7SeasonalStatisticsMiscReturns> getMiscReturns() {
        return Optional.ofNullable(miscReturns);
    }

    public Optional<SrNflV7SeasonalStatisticsPassing> getPassing() {
        return Optional.ofNullable(passing);
    }

    public Optional<SrNflV7SeasonalStatisticsPenalties> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<SrNflV7SeasonalStatisticsPuntReturns> getPuntReturns() {
        return Optional.ofNullable(puntReturns);
    }

    public Optional<SrNflV7SeasonalStatisticsPunts> getPunts() {
        return Optional.ofNullable(punts);
    }

    public Optional<SrNflV7SeasonalStatisticsReceiving> getReceiving() {
        return Optional.ofNullable(receiving);
    }

    public Optional<SrNflV7SeasonalStatisticsRushing> getRushing() {
        return Optional.ofNullable(rushing);
    }

    public Optional<SrNflV7SeasonalStatisticsTouchdowns> getTouchdowns() {
        return Optional.ofNullable(touchdowns);
    }
}

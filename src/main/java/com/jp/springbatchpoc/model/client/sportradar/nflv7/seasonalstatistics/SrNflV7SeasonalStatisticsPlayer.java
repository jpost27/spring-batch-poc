package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
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
public class SrNflV7SeasonalStatisticsPlayer {
    @JsonProperty("conversions")
    private SrNflV7SeasonalStatisticsConversions conversions;

    @JsonProperty("defense")
    private SrNflV7SeasonalStatisticsDefense defense;

    @JsonProperty("extra_points")
    private SrNflV7SeasonalStatisticsExtraPoints extraPoints;

    @JsonProperty("field_goals")
    private SrNflV7SeasonalStatisticsFieldGoals fieldGoals;

    @JsonProperty("fumbles")
    private SrNflV7SeasonalStatisticsFumbles fumbles;

    @JsonProperty("games_played")
    private Integer gamesPlayed;

    @JsonProperty("games_started")
    private Integer gamesStarted;

    @JsonProperty("id")
    private String id;

    @JsonProperty("int_returns")
    private SrNflV7SeasonalStatisticsIntReturns intReturns;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("kick_returns")
    private SrNflV7SeasonalStatisticsKickReturns kickReturns;

    @JsonProperty("kickoffs")
    private SrNflV7SeasonalStatisticsKickoffs kickoffs;

    @JsonProperty("misc_returns")
    private SrNflV7SeasonalStatisticsMiscReturns miscReturns;

    @JsonProperty("name")
    private String name;

    @JsonProperty("passing")
    private SrNflV7SeasonalStatisticsPassing passing;

    @JsonProperty("penalties")
    private SrNflV7SeasonalStatisticsPenalties penalties;

    @JsonProperty("position")
    private String position;

    @JsonProperty("punt_returns")
    private SrNflV7SeasonalStatisticsPuntReturns puntReturns;

    @JsonProperty("punts")
    private SrNflV7SeasonalStatisticsPunts punts;

    @JsonProperty("receiving")
    private SrNflV7SeasonalStatisticsReceiving receiving;

    @JsonProperty("rushing")
    private SrNflV7SeasonalStatisticsRushing rushing;

    @JsonProperty("sr_id")
    private String srId;

    public Optional<SrNflV7SeasonalStatisticsConversions> getConversions() {
        return Optional.ofNullable(conversions);
    }

    public Optional<SrNflV7SeasonalStatisticsDefense> getDefense() {
        return Optional.ofNullable(defense);
    }

    public Optional<SrNflV7SeasonalStatisticsExtraPoints> getExtraPoints() {
        return Optional.ofNullable(extraPoints);
    }

    public Optional<SrNflV7SeasonalStatisticsFieldGoals> getFieldGoals() {
        return Optional.ofNullable(fieldGoals);
    }

    public Optional<SrNflV7SeasonalStatisticsFumbles> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<Integer> getGamesPlayed() {
        return Optional.ofNullable(gamesPlayed);
    }

    public Optional<Integer> getGamesStarted() {
        return Optional.ofNullable(gamesStarted);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7SeasonalStatisticsIntReturns> getIntReturns() {
        return Optional.ofNullable(intReturns);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
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

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<SrNflV7SeasonalStatisticsPassing> getPassing() {
        return Optional.ofNullable(passing);
    }

    public Optional<SrNflV7SeasonalStatisticsPenalties> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
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

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }
}

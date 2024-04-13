package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7GameStatisticsHome_1 {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("defense")
    private SrNflV7GameStatisticsDefense defense;

    @JsonProperty("efficiency")
    private SrNflV7GameStatisticsEfficiency efficiency;

    @JsonProperty("extra_points")
    private SrNflV7GameStatisticsExtraPoints extraPoints;

    @JsonProperty("field_goals")
    private SrNflV7GameStatisticsFieldGoals fieldGoals;

    @JsonProperty("first_downs")
    private SrNflV7GameStatisticsFirstDowns firstDowns;

    @JsonProperty("fumbles")
    private SrNflV7GameStatisticsFumbles fumbles;

    @JsonProperty("id")
    private String id;

    @JsonProperty("int_returns")
    private SrNflV7GameStatisticsIntReturns intReturns;

    @JsonProperty("interceptions")
    private SrNflV7GameStatisticsInterceptions interceptions;

    @JsonProperty("kick_returns")
    private SrNflV7GameStatisticsKickReturns kickReturns;

    @JsonProperty("kickoffs")
    private SrNflV7GameStatisticsKickoffs kickoffs;

    @JsonProperty("market")
    private String market;

    @JsonProperty("misc_returns")
    private SrNflV7GameStatisticsMiscReturns miscReturns;

    @JsonProperty("name")
    private String name;

    @JsonProperty("passing")
    private SrNflV7GameStatisticsPassing passing;

    @JsonProperty("penalties")
    private SrNflV7GameStatisticsPenalties penalties;

    @JsonProperty("punt_returns")
    private SrNflV7GameStatisticsPuntReturns puntReturns;

    @JsonProperty("punts")
    private SrNflV7GameStatisticsPunts punts;

    @JsonProperty("receiving")
    private SrNflV7GameStatisticsReceiving receiving;

    @JsonProperty("rushing")
    private SrNflV7GameStatisticsRushing rushing;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("summary")
    private SrNflV7GameStatisticsSummary summary;

    @JsonProperty("touchdowns")
    private SrNflV7GameStatisticsTouchdowns touchdowns;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public Optional<SrNflV7GameStatisticsDefense> getDefense() {
        return Optional.ofNullable(defense);
    }

    public Optional<SrNflV7GameStatisticsEfficiency> getEfficiency() {
        return Optional.ofNullable(efficiency);
    }

    public Optional<SrNflV7GameStatisticsExtraPoints> getExtraPoints() {
        return Optional.ofNullable(extraPoints);
    }

    public Optional<SrNflV7GameStatisticsFieldGoals> getFieldGoals() {
        return Optional.ofNullable(fieldGoals);
    }

    public Optional<SrNflV7GameStatisticsFirstDowns> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<SrNflV7GameStatisticsFumbles> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7GameStatisticsIntReturns> getIntReturns() {
        return Optional.ofNullable(intReturns);
    }

    public Optional<SrNflV7GameStatisticsInterceptions> getInterceptions() {
        return Optional.ofNullable(interceptions);
    }

    public Optional<SrNflV7GameStatisticsKickReturns> getKickReturns() {
        return Optional.ofNullable(kickReturns);
    }

    public Optional<SrNflV7GameStatisticsKickoffs> getKickoffs() {
        return Optional.ofNullable(kickoffs);
    }

    public Optional<String> getMarket() {
        return Optional.ofNullable(market);
    }

    public Optional<SrNflV7GameStatisticsMiscReturns> getMiscReturns() {
        return Optional.ofNullable(miscReturns);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<SrNflV7GameStatisticsPassing> getPassing() {
        return Optional.ofNullable(passing);
    }

    public Optional<SrNflV7GameStatisticsPenalties> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<SrNflV7GameStatisticsPuntReturns> getPuntReturns() {
        return Optional.ofNullable(puntReturns);
    }

    public Optional<SrNflV7GameStatisticsPunts> getPunts() {
        return Optional.ofNullable(punts);
    }

    public Optional<SrNflV7GameStatisticsReceiving> getReceiving() {
        return Optional.ofNullable(receiving);
    }

    public Optional<SrNflV7GameStatisticsRushing> getRushing() {
        return Optional.ofNullable(rushing);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<SrNflV7GameStatisticsSummary> getSummary() {
        return Optional.ofNullable(summary);
    }

    public Optional<SrNflV7GameStatisticsTouchdowns> getTouchdowns() {
        return Optional.ofNullable(touchdowns);
    }
}

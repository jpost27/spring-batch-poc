package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7GameStatisticsPlayer_10 {
    @JsonProperty("air_yards")
    private Integer airYards;

    @JsonProperty("attempts")
    private Integer attempts;

    @JsonProperty("avg_pocket_time")
    private Double avgPocketTime;

    @JsonProperty("avg_yards")
    private Double avgYards;

    @JsonProperty("batted_passes")
    private Integer battedPasses;

    @JsonProperty("blitzes")
    private Integer blitzes;

    @JsonProperty("cmp_pct")
    private Double cmpPct;

    @JsonProperty("completions")
    private Integer completions;

    @JsonProperty("defended_passes")
    private Integer defendedPasses;

    @JsonProperty("dropped_passes")
    private Integer droppedPasses;

    @JsonProperty("first_downs")
    private Integer firstDowns;

    @JsonProperty("hurries")
    private Integer hurries;

    @JsonProperty("id")
    private String id;

    @JsonProperty("interceptions")
    private Integer interceptions;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("knockdowns")
    private Integer knockdowns;

    @JsonProperty("longest")
    private Integer longest;

    @JsonProperty("longest_touchdown")
    private Integer longestTouchdown;

    @JsonProperty("name")
    private String name;

    @JsonProperty("on_target_throws")
    private Integer onTargetThrows;

    @JsonProperty("pocket_time")
    private Double pocketTime;

    @JsonProperty("poor_throws")
    private Integer poorThrows;

    @JsonProperty("position")
    private String position;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("redzone_attempts")
    private Integer redzoneAttempts;

    @JsonProperty("sack_yards")
    private Integer sackYards;

    @JsonProperty("sacks")
    private Integer sacks;

    @JsonProperty("spikes")
    private Integer spikes;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("throw_aways")
    private Integer throwAways;

    @JsonProperty("touchdowns")
    private Integer touchdowns;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getAirYards() {
        return Optional.ofNullable(airYards);
    }

    public Optional<Integer> getAttempts() {
        return Optional.ofNullable(attempts);
    }

    public Optional<Double> getAvgPocketTime() {
        return Optional.ofNullable(avgPocketTime);
    }

    public Optional<Double> getAvgYards() {
        return Optional.ofNullable(avgYards);
    }

    public Optional<Integer> getBattedPasses() {
        return Optional.ofNullable(battedPasses);
    }

    public Optional<Integer> getBlitzes() {
        return Optional.ofNullable(blitzes);
    }

    public Optional<Double> getCmpPct() {
        return Optional.ofNullable(cmpPct);
    }

    public Optional<Integer> getCompletions() {
        return Optional.ofNullable(completions);
    }

    public Optional<Integer> getDefendedPasses() {
        return Optional.ofNullable(defendedPasses);
    }

    public Optional<Integer> getDroppedPasses() {
        return Optional.ofNullable(droppedPasses);
    }

    public Optional<Integer> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<Integer> getHurries() {
        return Optional.ofNullable(hurries);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getInterceptions() {
        return Optional.ofNullable(interceptions);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<Integer> getKnockdowns() {
        return Optional.ofNullable(knockdowns);
    }

    public Optional<Integer> getLongest() {
        return Optional.ofNullable(longest);
    }

    public Optional<Integer> getLongestTouchdown() {
        return Optional.ofNullable(longestTouchdown);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getOnTargetThrows() {
        return Optional.ofNullable(onTargetThrows);
    }

    public Optional<Double> getPocketTime() {
        return Optional.ofNullable(pocketTime);
    }

    public Optional<Integer> getPoorThrows() {
        return Optional.ofNullable(poorThrows);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Double> getRating() {
        return Optional.ofNullable(rating);
    }

    public Optional<Integer> getRedzoneAttempts() {
        return Optional.ofNullable(redzoneAttempts);
    }

    public Optional<Integer> getSackYards() {
        return Optional.ofNullable(sackYards);
    }

    public Optional<Integer> getSacks() {
        return Optional.ofNullable(sacks);
    }

    public Optional<Integer> getSpikes() {
        return Optional.ofNullable(spikes);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<Integer> getThrowAways() {
        return Optional.ofNullable(throwAways);
    }

    public Optional<Integer> getTouchdowns() {
        return Optional.ofNullable(touchdowns);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

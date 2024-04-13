package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7GameStatisticsTotals_6 {
    @JsonProperty("air_yards")
    private Integer airYards;

    @JsonProperty("avg_yards")
    private Double avgYards;

    @JsonProperty("broken_tackles")
    private Integer brokenTackles;

    @JsonProperty("catchable_passes")
    private Integer catchablePasses;

    @JsonProperty("dropped_passes")
    private Integer droppedPasses;

    @JsonProperty("first_downs")
    private Integer firstDowns;

    @JsonProperty("longest")
    private Integer longest;

    @JsonProperty("longest_touchdown")
    private Integer longestTouchdown;

    @JsonProperty("receptions")
    private Integer receptions;

    @JsonProperty("redzone_targets")
    private Integer redzoneTargets;

    @JsonProperty("targets")
    private Integer targets;

    @JsonProperty("touchdowns")
    private Integer touchdowns;

    @JsonProperty("yards")
    private Integer yards;

    @JsonProperty("yards_after_catch")
    private Integer yardsAfterCatch;

    @JsonProperty("yards_after_contact")
    private Integer yardsAfterContact;

    public Optional<Integer> getAirYards() {
        return Optional.ofNullable(airYards);
    }

    public Optional<Double> getAvgYards() {
        return Optional.ofNullable(avgYards);
    }

    public Optional<Integer> getBrokenTackles() {
        return Optional.ofNullable(brokenTackles);
    }

    public Optional<Integer> getCatchablePasses() {
        return Optional.ofNullable(catchablePasses);
    }

    public Optional<Integer> getDroppedPasses() {
        return Optional.ofNullable(droppedPasses);
    }

    public Optional<Integer> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<Integer> getLongest() {
        return Optional.ofNullable(longest);
    }

    public Optional<Integer> getLongestTouchdown() {
        return Optional.ofNullable(longestTouchdown);
    }

    public Optional<Integer> getReceptions() {
        return Optional.ofNullable(receptions);
    }

    public Optional<Integer> getRedzoneTargets() {
        return Optional.ofNullable(redzoneTargets);
    }

    public Optional<Integer> getTargets() {
        return Optional.ofNullable(targets);
    }

    public Optional<Integer> getTouchdowns() {
        return Optional.ofNullable(touchdowns);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }

    public Optional<Integer> getYardsAfterCatch() {
        return Optional.ofNullable(yardsAfterCatch);
    }

    public Optional<Integer> getYardsAfterContact() {
        return Optional.ofNullable(yardsAfterContact);
    }
}

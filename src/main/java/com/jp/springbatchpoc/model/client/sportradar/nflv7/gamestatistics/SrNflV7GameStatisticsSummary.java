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
public class SrNflV7GameStatisticsSummary {
    @JsonProperty("avg_gain")
    private Double avgGain;

    @JsonProperty("fumbles")
    private Integer fumbles;

    @JsonProperty("lost_fumbles")
    private Integer lostFumbles;

    @JsonProperty("penalties")
    private Integer penalties;

    @JsonProperty("penalty_yards")
    private Integer penaltyYards;

    @JsonProperty("play_count")
    private Integer playCount;

    @JsonProperty("possession_time")
    private String possessionTime;

    @JsonProperty("return_yards")
    private Integer returnYards;

    @JsonProperty("rush_plays")
    private Integer rushPlays;

    @JsonProperty("safeties")
    private Integer safeties;

    @JsonProperty("total_yards")
    private Integer totalYards;

    @JsonProperty("turnovers")
    private Integer turnovers;

    public Optional<Double> getAvgGain() {
        return Optional.ofNullable(avgGain);
    }

    public Optional<Integer> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<Integer> getLostFumbles() {
        return Optional.ofNullable(lostFumbles);
    }

    public Optional<Integer> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<Integer> getPenaltyYards() {
        return Optional.ofNullable(penaltyYards);
    }

    public Optional<Integer> getPlayCount() {
        return Optional.ofNullable(playCount);
    }

    public Optional<String> getPossessionTime() {
        return Optional.ofNullable(possessionTime);
    }

    public Optional<Integer> getReturnYards() {
        return Optional.ofNullable(returnYards);
    }

    public Optional<Integer> getRushPlays() {
        return Optional.ofNullable(rushPlays);
    }

    public Optional<Integer> getSafeties() {
        return Optional.ofNullable(safeties);
    }

    public Optional<Integer> getTotalYards() {
        return Optional.ofNullable(totalYards);
    }

    public Optional<Integer> getTurnovers() {
        return Optional.ofNullable(turnovers);
    }
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
import java.util.Collections;
import java.util.List;
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
public class SrNflV7PlayByPlayDetail {
    @JsonProperty("category")
    private String category;

    @JsonProperty("description")
    private String description;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("end_location")
    private SrNflV7PlayByPlayEndLocation endLocation;

    @JsonProperty("penalty")
    private SrNflV7PlayByPlayPenalty penalty;

    @JsonProperty("players")
    private List<SrNflV7PlayByPlayPlayer> players;

    @JsonProperty("recovery")
    private SrNflV7PlayByPlayRecovery recovery;

    @JsonProperty("result")
    private String result;

    @JsonProperty("review")
    private SrNflV7PlayByPlayReview review;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("start_location")
    private SrNflV7PlayByPlayStartLocation startLocation;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<String> getCategory() {
        return Optional.ofNullable(category);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<String> getDirection() {
        return Optional.ofNullable(direction);
    }

    public Optional<SrNflV7PlayByPlayEndLocation> getEndLocation() {
        return Optional.ofNullable(endLocation);
    }

    public Optional<SrNflV7PlayByPlayPenalty> getPenalty() {
        return Optional.ofNullable(penalty);
    }

    public List<SrNflV7PlayByPlayPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7PlayByPlayRecovery> getRecovery() {
        return Optional.ofNullable(recovery);
    }

    public Optional<String> getResult() {
        return Optional.ofNullable(result);
    }

    public Optional<SrNflV7PlayByPlayReview> getReview() {
        return Optional.ofNullable(review);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<SrNflV7PlayByPlayStartLocation> getStartLocation() {
        return Optional.ofNullable(startLocation);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

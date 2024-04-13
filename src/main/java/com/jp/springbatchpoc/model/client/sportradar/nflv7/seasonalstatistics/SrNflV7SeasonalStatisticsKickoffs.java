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
public class SrNflV7SeasonalStatisticsKickoffs {
    @JsonProperty("endzone")
    private Integer endzone;

    @JsonProperty("inside_20")
    private Integer inside20;

    @JsonProperty("kickoffs")
    private Integer kickoffs;

    @JsonProperty("onside_attempts")
    private Integer onsideAttempts;

    @JsonProperty("onside_successes")
    private Integer onsideSuccesses;

    @JsonProperty("out_of_bounds")
    private Integer outOfBounds;

    @JsonProperty("return_yards")
    private Integer returnYards;

    @JsonProperty("returned")
    private Integer returned;

    @JsonProperty("squib_kicks")
    private Integer squibKicks;

    @JsonProperty("touchbacks")
    private Integer touchbacks;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getEndzone() {
        return Optional.ofNullable(endzone);
    }

    public Optional<Integer> getInside20() {
        return Optional.ofNullable(inside20);
    }

    public Optional<Integer> getKickoffs() {
        return Optional.ofNullable(kickoffs);
    }

    public Optional<Integer> getOnsideAttempts() {
        return Optional.ofNullable(onsideAttempts);
    }

    public Optional<Integer> getOnsideSuccesses() {
        return Optional.ofNullable(onsideSuccesses);
    }

    public Optional<Integer> getOutOfBounds() {
        return Optional.ofNullable(outOfBounds);
    }

    public Optional<Integer> getReturnYards() {
        return Optional.ofNullable(returnYards);
    }

    public Optional<Integer> getReturned() {
        return Optional.ofNullable(returned);
    }

    public Optional<Integer> getSquibKicks() {
        return Optional.ofNullable(squibKicks);
    }

    public Optional<Integer> getTouchbacks() {
        return Optional.ofNullable(touchbacks);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

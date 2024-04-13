package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
public class SrNflV7GameStatisticsPlayer_2 {
    @JsonProperty("endzone")
    private Integer endzone;

    @JsonProperty("id")
    private String id;

    @JsonProperty("inside_20")
    private Integer inside20;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("name")
    private String name;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("onside_attempts")
    private Integer onsideAttempts;

    @JsonProperty("onside_successes")
    private Integer onsideSuccesses;

    @JsonProperty("out_of_bounds")
    private Integer outOfBounds;

    @JsonProperty("position")
    private String position;

    @JsonProperty("return_yards")
    private Integer returnYards;

    @JsonProperty("squib_kicks")
    private Integer squibKicks;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("total_endzone")
    private Integer totalEndzone;

    @JsonProperty("touchbacks")
    private Integer touchbacks;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getEndzone() {
        return Optional.ofNullable(endzone);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getInside20() {
        return Optional.ofNullable(inside20);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getNumber() {
        return Optional.ofNullable(number);
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

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Integer> getReturnYards() {
        return Optional.ofNullable(returnYards);
    }

    public Optional<Integer> getSquibKicks() {
        return Optional.ofNullable(squibKicks);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<Integer> getTotalEndzone() {
        return Optional.ofNullable(totalEndzone);
    }

    public Optional<Integer> getTouchbacks() {
        return Optional.ofNullable(touchbacks);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

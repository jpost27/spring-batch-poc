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
public class SrNflV7GameStatisticsPlayer_3 {
    @JsonProperty("attempts")
    private Integer attempts;

    @JsonProperty("avg_hang_time")
    private Double avgHangTime;

    @JsonProperty("avg_net_yards")
    private Double avgNetYards;

    @JsonProperty("avg_yards")
    private Double avgYards;

    @JsonProperty("blocked")
    private Integer blocked;

    @JsonProperty("hang_time")
    private Double hangTime;

    @JsonProperty("id")
    private String id;

    @JsonProperty("inside_20")
    private Integer inside20;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("longest")
    private Integer longest;

    @JsonProperty("name")
    private String name;

    @JsonProperty("net_yards")
    private Integer netYards;

    @JsonProperty("position")
    private String position;

    @JsonProperty("return_yards")
    private Integer returnYards;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("touchbacks")
    private Integer touchbacks;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getAttempts() {
        return Optional.ofNullable(attempts);
    }

    public Optional<Double> getAvgHangTime() {
        return Optional.ofNullable(avgHangTime);
    }

    public Optional<Double> getAvgNetYards() {
        return Optional.ofNullable(avgNetYards);
    }

    public Optional<Double> getAvgYards() {
        return Optional.ofNullable(avgYards);
    }

    public Optional<Integer> getBlocked() {
        return Optional.ofNullable(blocked);
    }

    public Optional<Double> getHangTime() {
        return Optional.ofNullable(hangTime);
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

    public Optional<Integer> getLongest() {
        return Optional.ofNullable(longest);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getNetYards() {
        return Optional.ofNullable(netYards);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Integer> getReturnYards() {
        return Optional.ofNullable(returnYards);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<Integer> getTouchbacks() {
        return Optional.ofNullable(touchbacks);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
public class SrNflV7GameStatisticsTotals_12 {
    @JsonProperty("defense_attempts")
    private Integer defenseAttempts;

    @JsonProperty("defense_successes")
    private Integer defenseSuccesses;

    @JsonProperty("pass_attempts")
    private Integer passAttempts;

    @JsonProperty("pass_successes")
    private Integer passSuccesses;

    @JsonProperty("rush_attempts")
    private Integer rushAttempts;

    @JsonProperty("rush_successes")
    private Integer rushSuccesses;

    public Optional<Integer> getDefenseAttempts() {
        return Optional.ofNullable(defenseAttempts);
    }

    public Optional<Integer> getDefenseSuccesses() {
        return Optional.ofNullable(defenseSuccesses);
    }

    public Optional<Integer> getPassAttempts() {
        return Optional.ofNullable(passAttempts);
    }

    public Optional<Integer> getPassSuccesses() {
        return Optional.ofNullable(passSuccesses);
    }

    public Optional<Integer> getRushAttempts() {
        return Optional.ofNullable(rushAttempts);
    }

    public Optional<Integer> getRushSuccesses() {
        return Optional.ofNullable(rushSuccesses);
    }
}

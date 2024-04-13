package com.jp.springbatchpoc.model.client.sportradar.nflv7.playerprofile;

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
public class SrNflV7PlayerProfileConversions {
    @JsonProperty("defense_attempts")
    private Integer defenseAttempts;

    @JsonProperty("defense_successes")
    private Integer defenseSuccesses;

    @JsonProperty("pass_attempts")
    private Integer passAttempts;

    @JsonProperty("pass_successes")
    private Integer passSuccesses;

    @JsonProperty("receive_attempts")
    private Integer receiveAttempts;

    @JsonProperty("receive_successes")
    private Integer receiveSuccesses;

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

    public Optional<Integer> getReceiveAttempts() {
        return Optional.ofNullable(receiveAttempts);
    }

    public Optional<Integer> getReceiveSuccesses() {
        return Optional.ofNullable(receiveSuccesses);
    }

    public Optional<Integer> getRushAttempts() {
        return Optional.ofNullable(rushAttempts);
    }

    public Optional<Integer> getRushSuccesses() {
        return Optional.ofNullable(rushSuccesses);
    }
}

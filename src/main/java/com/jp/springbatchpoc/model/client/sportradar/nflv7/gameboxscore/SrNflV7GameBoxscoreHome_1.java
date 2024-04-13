package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

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
public class SrNflV7GameBoxscoreHome_1 {
    @JsonProperty("decision")
    private String decision;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("outcome")
    private String outcome;

    public Optional<String> getDecision() {
        return Optional.ofNullable(decision);
    }

    public Optional<String> getDirection() {
        return Optional.ofNullable(direction);
    }

    public Optional<String> getOutcome() {
        return Optional.ofNullable(outcome);
    }
}

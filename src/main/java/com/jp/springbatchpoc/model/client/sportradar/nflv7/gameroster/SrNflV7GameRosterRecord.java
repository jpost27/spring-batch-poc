package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameroster;

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
public class SrNflV7GameRosterRecord {
    @JsonProperty("losses")
    private Integer losses;

    @JsonProperty("ties")
    private Integer ties;

    @JsonProperty("wins")
    private Integer wins;

    public Optional<Integer> getLosses() {
        return Optional.ofNullable(losses);
    }

    public Optional<Integer> getTies() {
        return Optional.ofNullable(ties);
    }

    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }
}

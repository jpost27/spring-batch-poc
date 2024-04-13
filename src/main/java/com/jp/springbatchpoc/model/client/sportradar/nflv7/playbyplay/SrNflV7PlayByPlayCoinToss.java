package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7PlayByPlayCoinToss {
    @JsonProperty("away")
    private SrNflV7PlayByPlayAway_2 away;

    @JsonProperty("home")
    private SrNflV7PlayByPlayHome home;

    public Optional<SrNflV7PlayByPlayAway_2> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7PlayByPlayHome> getHome() {
        return Optional.ofNullable(home);
    }
}

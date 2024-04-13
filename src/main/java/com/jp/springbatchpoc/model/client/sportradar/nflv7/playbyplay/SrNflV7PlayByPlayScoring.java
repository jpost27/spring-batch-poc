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
public class SrNflV7PlayByPlayScoring {
    @JsonProperty("away")
    private SrNflV7PlayByPlayAway_1 away;

    @JsonProperty("home")
    private SrNflV7PlayByPlayHome_2 home;

    public Optional<SrNflV7PlayByPlayAway_1> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7PlayByPlayHome_2> getHome() {
        return Optional.ofNullable(home);
    }
}

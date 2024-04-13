package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

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
public class SrNflV7GameBoxscoreCoinTos {
    @JsonProperty("away")
    private SrNflV7GameBoxscoreAway_1 away;

    @JsonProperty("home")
    private SrNflV7GameBoxscoreHome_1 home;

    @JsonProperty("quarter")
    private Integer quarter;

    public Optional<SrNflV7GameBoxscoreAway_1> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7GameBoxscoreHome_1> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<Integer> getQuarter() {
        return Optional.ofNullable(quarter);
    }
}

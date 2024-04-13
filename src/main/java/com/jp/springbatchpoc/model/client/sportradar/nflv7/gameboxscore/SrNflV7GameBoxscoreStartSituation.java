package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

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
public class SrNflV7GameBoxscoreStartSituation {
    @JsonProperty("clock")
    private String clock;

    @JsonProperty("down")
    private Integer down;

    @JsonProperty("location")
    private SrNflV7GameBoxscoreLocation_1 location;

    @JsonProperty("possession")
    private SrNflV7GameBoxscorePossession possession;

    @JsonProperty("yfd")
    private Integer yfd;

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public Optional<Integer> getDown() {
        return Optional.ofNullable(down);
    }

    public Optional<SrNflV7GameBoxscoreLocation_1> getLocation() {
        return Optional.ofNullable(location);
    }

    public Optional<SrNflV7GameBoxscorePossession> getPossession() {
        return Optional.ofNullable(possession);
    }

    public Optional<Integer> getYfd() {
        return Optional.ofNullable(yfd);
    }
}

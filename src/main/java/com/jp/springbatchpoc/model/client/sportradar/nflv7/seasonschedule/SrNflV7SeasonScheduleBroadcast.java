package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule;

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
public class SrNflV7SeasonScheduleBroadcast {
    @JsonProperty("internet")
    private String internet;

    @JsonProperty("network")
    private String network;

    @JsonProperty("satellite")
    private String satellite;

    public Optional<String> getInternet() {
        return Optional.ofNullable(internet);
    }

    public Optional<String> getNetwork() {
        return Optional.ofNullable(network);
    }

    public Optional<String> getSatellite() {
        return Optional.ofNullable(satellite);
    }
}

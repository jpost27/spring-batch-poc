package com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile;

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
public class SrNflV7TeamProfileLocation {
    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

    public Optional<String> getLat() {
        return Optional.ofNullable(lat);
    }

    public Optional<String> getLng() {
        return Optional.ofNullable(lng);
    }
}

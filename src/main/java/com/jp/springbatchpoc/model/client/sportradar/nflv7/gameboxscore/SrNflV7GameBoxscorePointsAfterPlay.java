package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7GameBoxscorePointsAfterPlay {
    @JsonProperty("id")
    private String id;

    @JsonProperty("sequence")
    private Double sequence;

    @JsonProperty("type")
    private String type;

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Double> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }
}

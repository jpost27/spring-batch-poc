package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

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
public class SrNflV7PlayByPlayPenalty {
    @JsonProperty("description")
    private String description;

    @JsonProperty("result")
    private String result;

    @JsonProperty("team")
    private SrNflV7PlayByPlayTeam team;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<String> getResult() {
        return Optional.ofNullable(result);
    }

    public Optional<SrNflV7PlayByPlayTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

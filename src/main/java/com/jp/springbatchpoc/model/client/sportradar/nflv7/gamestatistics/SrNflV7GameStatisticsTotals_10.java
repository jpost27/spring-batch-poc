package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
public class SrNflV7GameStatisticsTotals_10 {
    @JsonProperty("first_downs")
    private Integer firstDowns;

    @JsonProperty("penalties")
    private Integer penalties;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<Integer> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

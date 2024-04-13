package com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7PostgameStandingsStrengthOfSchedule {
    @JsonProperty("sos")
    private Double sos;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("wins")
    private Integer wins;

    public Optional<Double> getSos() {
        return Optional.ofNullable(sos);
    }

    public Optional<Integer> getTotal() {
        return Optional.ofNullable(total);
    }

    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }
}

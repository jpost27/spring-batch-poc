package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
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
public class SrNflV7GameStatisticsReceiving {
    @JsonProperty("players")
    private List<SrNflV7GameStatisticsPlayer_1> players;

    @JsonProperty("totals")
    private SrNflV7GameStatisticsTotals_6 totals;

    public List<SrNflV7GameStatisticsPlayer_1> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7GameStatisticsTotals_6> getTotals() {
        return Optional.ofNullable(totals);
    }
}

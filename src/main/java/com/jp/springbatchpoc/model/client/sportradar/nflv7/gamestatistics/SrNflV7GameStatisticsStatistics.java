package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
public class SrNflV7GameStatisticsStatistics {
    @JsonProperty("away")
    private SrNflV7GameStatisticsAway away;

    @JsonProperty("home")
    private SrNflV7GameStatisticsHome_1 home;

    public Optional<SrNflV7GameStatisticsAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7GameStatisticsHome_1> getHome() {
        return Optional.ofNullable(home);
    }
}

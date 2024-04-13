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
public class SrNflV7GameStatisticsEfficiency {
    @JsonProperty("fourthdown")
    private SrNflV7GameStatisticsFourthdown fourthdown;

    @JsonProperty("goaltogo")
    private SrNflV7GameStatisticsGoaltogo goaltogo;

    @JsonProperty("redzone")
    private SrNflV7GameStatisticsRedzone redzone;

    @JsonProperty("thirddown")
    private SrNflV7GameStatisticsThirddown thirddown;

    public Optional<SrNflV7GameStatisticsFourthdown> getFourthdown() {
        return Optional.ofNullable(fourthdown);
    }

    public Optional<SrNflV7GameStatisticsGoaltogo> getGoaltogo() {
        return Optional.ofNullable(goaltogo);
    }

    public Optional<SrNflV7GameStatisticsRedzone> getRedzone() {
        return Optional.ofNullable(redzone);
    }

    public Optional<SrNflV7GameStatisticsThirddown> getThirddown() {
        return Optional.ofNullable(thirddown);
    }
}

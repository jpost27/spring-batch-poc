package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

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
public class SrNflV7SeasonalStatisticsEfficiency {
    @JsonProperty("fourthdown")
    private SrNflV7SeasonalStatisticsFourthdown fourthdown;

    @JsonProperty("goaltogo")
    private SrNflV7SeasonalStatisticsGoaltogo goaltogo;

    @JsonProperty("redzone")
    private SrNflV7SeasonalStatisticsRedzone redzone;

    @JsonProperty("thirddown")
    private SrNflV7SeasonalStatisticsThirddown thirddown;

    public Optional<SrNflV7SeasonalStatisticsFourthdown> getFourthdown() {
        return Optional.ofNullable(fourthdown);
    }

    public Optional<SrNflV7SeasonalStatisticsGoaltogo> getGoaltogo() {
        return Optional.ofNullable(goaltogo);
    }

    public Optional<SrNflV7SeasonalStatisticsRedzone> getRedzone() {
        return Optional.ofNullable(redzone);
    }

    public Optional<SrNflV7SeasonalStatisticsThirddown> getThirddown() {
        return Optional.ofNullable(thirddown);
    }
}

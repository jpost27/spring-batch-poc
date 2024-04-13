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
public class SrNflV7SeasonalStatisticsExtraPoints_1 {
    @JsonProperty("conversions")
    private SrNflV7SeasonalStatisticsConversions conversions;

    @JsonProperty("kicks")
    private SrNflV7SeasonalStatisticsKicks kicks;

    public Optional<SrNflV7SeasonalStatisticsConversions> getConversions() {
        return Optional.ofNullable(conversions);
    }

    public Optional<SrNflV7SeasonalStatisticsKicks> getKicks() {
        return Optional.ofNullable(kicks);
    }
}

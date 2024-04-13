package com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklydepthcharts;

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
public class SrNflV7WeeklyDepthChartsDefense {
    @JsonProperty("position")
    private SrNflV7WeeklyDepthChartsPosition position;

    public Optional<SrNflV7WeeklyDepthChartsPosition> getPosition() {
        return Optional.ofNullable(position);
    }
}

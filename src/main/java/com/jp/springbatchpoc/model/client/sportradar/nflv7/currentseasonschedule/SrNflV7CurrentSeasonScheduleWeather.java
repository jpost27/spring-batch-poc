package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentseasonschedule;

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
public class SrNflV7CurrentSeasonScheduleWeather {
    @JsonProperty("condition")
    private String condition;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("temp")
    private Integer temp;

    @JsonProperty("wind")
    private SrNflV7CurrentSeasonScheduleWind wind;

    public Optional<String> getCondition() {
        return Optional.ofNullable(condition);
    }

    public Optional<Integer> getHumidity() {
        return Optional.ofNullable(humidity);
    }

    public Optional<Integer> getTemp() {
        return Optional.ofNullable(temp);
    }

    public Optional<SrNflV7CurrentSeasonScheduleWind> getWind() {
        return Optional.ofNullable(wind);
    }
}
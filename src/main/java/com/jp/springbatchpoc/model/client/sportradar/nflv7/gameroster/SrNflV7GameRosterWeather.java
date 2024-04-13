package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameroster;

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
public class SrNflV7GameRosterWeather {
    @JsonProperty("condition")
    private String condition;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("temp")
    private Integer temp;

    @JsonProperty("wind")
    private SrNflV7GameRosterWind wind;

    public Optional<String> getCondition() {
        return Optional.ofNullable(condition);
    }

    public Optional<Integer> getHumidity() {
        return Optional.ofNullable(humidity);
    }

    public Optional<Integer> getTemp() {
        return Optional.ofNullable(temp);
    }

    public Optional<SrNflV7GameRosterWind> getWind() {
        return Optional.ofNullable(wind);
    }
}

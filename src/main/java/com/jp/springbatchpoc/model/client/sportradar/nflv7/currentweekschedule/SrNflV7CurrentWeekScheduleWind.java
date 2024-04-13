package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentweekschedule;

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
public class SrNflV7CurrentWeekScheduleWind {
    @JsonProperty("direction")
    private String direction;

    @JsonProperty("speed")
    private Integer speed;

    public Optional<String> getDirection() {
        return Optional.ofNullable(direction);
    }

    public Optional<Integer> getSpeed() {
        return Optional.ofNullable(speed);
    }
}

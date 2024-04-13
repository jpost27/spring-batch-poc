package com.jp.springbatchpoc.model.client.sportradar.nflv7.leaguehierarchy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7LeagueHierarchyRgbColor {
    @JsonProperty("blue")
    private Integer blue;

    @JsonProperty("green")
    private Integer green;

    @JsonProperty("red")
    private Integer red;

    public Optional<Integer> getBlue() {
        return Optional.ofNullable(blue);
    }

    public Optional<Integer> getGreen() {
        return Optional.ofNullable(green);
    }

    public Optional<Integer> getRed() {
        return Optional.ofNullable(red);
    }
}

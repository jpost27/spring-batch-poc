package com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklydepthcharts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
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
public class SrNflV7WeeklyDepthChartsPosition {
    @JsonProperty("name")
    private String name;

    @JsonProperty("players")
    private List<SrNflV7WeeklyDepthChartsPlayer> players;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public List<SrNflV7WeeklyDepthChartsPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }
}

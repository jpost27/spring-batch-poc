package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

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
public class SrNflV7PlayByPlayStatistic_1 {
    @JsonProperty("penalty")
    private Integer penalty;

    @JsonProperty("player")
    private SrNflV7PlayByPlayPlayer player;

    @JsonProperty("stat_type")
    private String statType;

    @JsonProperty("team")
    private SrNflV7PlayByPlayTeam team;

    @JsonProperty("yards")
    private Integer yards;

    public Optional<Integer> getPenalty() {
        return Optional.ofNullable(penalty);
    }

    public Optional<SrNflV7PlayByPlayPlayer> getPlayer() {
        return Optional.ofNullable(player);
    }

    public Optional<String> getStatType() {
        return Optional.ofNullable(statType);
    }

    public Optional<SrNflV7PlayByPlayTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }
}

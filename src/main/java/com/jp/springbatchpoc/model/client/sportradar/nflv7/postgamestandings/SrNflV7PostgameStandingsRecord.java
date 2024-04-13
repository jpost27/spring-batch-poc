package com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7PostgameStandingsRecord {
    @JsonProperty("category")
    private String category;

    @JsonProperty("losses")
    private Integer losses;

    @JsonProperty("points_against")
    private Integer pointsAgainst;

    @JsonProperty("points_for")
    private Integer pointsFor;

    @JsonProperty("ties")
    private Integer ties;

    @JsonProperty("win_pct")
    private Double winPct;

    @JsonProperty("wins")
    private Integer wins;

    public Optional<String> getCategory() {
        return Optional.ofNullable(category);
    }

    public Optional<Integer> getLosses() {
        return Optional.ofNullable(losses);
    }

    public Optional<Integer> getPointsAgainst() {
        return Optional.ofNullable(pointsAgainst);
    }

    public Optional<Integer> getPointsFor() {
        return Optional.ofNullable(pointsFor);
    }

    public Optional<Integer> getTies() {
        return Optional.ofNullable(ties);
    }

    public Optional<Double> getWinPct() {
        return Optional.ofNullable(winPct);
    }

    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }
}

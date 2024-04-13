package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

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
public class SrNflV7GameBoxscoreScore {
    @JsonProperty("away_points")
    private Integer awayPoints;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("home_points")
    private Integer homePoints;

    @JsonProperty("points")
    private Integer points;

    @JsonProperty("points-after-play")
    private SrNflV7GameBoxscorePointsAfterPlay pointsAfterPlay;

    @JsonProperty("sequence")
    private Integer sequence;

    public Optional<Integer> getAwayPoints() {
        return Optional.ofNullable(awayPoints);
    }

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public Optional<Integer> getHomePoints() {
        return Optional.ofNullable(homePoints);
    }

    public Optional<Integer> getPoints() {
        return Optional.ofNullable(points);
    }

    public Optional<SrNflV7GameBoxscorePointsAfterPlay> getPointsAfterPlay() {
        return Optional.ofNullable(pointsAfterPlay);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Integer;
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
public class SrNflV7GameBoxscoreScoringDrife {
    @JsonProperty("duration")
    private String duration;

    @JsonProperty("end_reason")
    private String endReason;

    @JsonProperty("first_downs")
    private Integer firstDowns;

    @JsonProperty("gain")
    private Integer gain;

    @JsonProperty("id")
    private String id;

    @JsonProperty("inside_20")
    private Boolean inside20;

    @JsonProperty("penalty_yards")
    private Integer penaltyYards;

    @JsonProperty("play_count")
    private Integer playCount;

    @JsonProperty("plays")
    private List<SrNflV7GameBoxscorePlay> plays;

    @JsonProperty("quarter")
    private SrNflV7GameBoxscoreQuarter quarter;

    @JsonProperty("scoring_drive")
    private Boolean scoringDrive;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("start_reason")
    private String startReason;

    @JsonProperty("team")
    private SrNflV7GameBoxscoreTeam team;

    public Optional<String> getDuration() {
        return Optional.ofNullable(duration);
    }

    public Optional<String> getEndReason() {
        return Optional.ofNullable(endReason);
    }

    public Optional<Integer> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<Integer> getGain() {
        return Optional.ofNullable(gain);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Boolean> getInside20() {
        return Optional.ofNullable(inside20);
    }

    public Optional<Integer> getPenaltyYards() {
        return Optional.ofNullable(penaltyYards);
    }

    public Optional<Integer> getPlayCount() {
        return Optional.ofNullable(playCount);
    }

    public List<SrNflV7GameBoxscorePlay> getPlays() {
        return Optional.ofNullable(plays).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7GameBoxscoreQuarter> getQuarter() {
        return Optional.ofNullable(quarter);
    }

    public Optional<Boolean> getScoringDrive() {
        return Optional.ofNullable(scoringDrive);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<String> getStartReason() {
        return Optional.ofNullable(startReason);
    }

    public Optional<SrNflV7GameBoxscoreTeam> getTeam() {
        return Optional.ofNullable(team);
    }
}

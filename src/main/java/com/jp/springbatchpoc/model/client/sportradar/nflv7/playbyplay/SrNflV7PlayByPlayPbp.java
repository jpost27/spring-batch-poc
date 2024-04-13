package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

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
public class SrNflV7PlayByPlayPbp {
    @JsonProperty("away_points")
    private Integer awayPoints;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("defensive_team")
    private SrNflV7PlayByPlayDefensiveTeam defensiveTeam;

    @JsonProperty("description")
    private String description;

    @JsonProperty("details")
    private List<SrNflV7PlayByPlayDetail_1> details;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("end_clock")
    private String endClock;

    @JsonProperty("end_reason")
    private String endReason;

    @JsonProperty("end_situation")
    private SrNflV7PlayByPlayEndSituation endSituation;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("events")
    private List<SrNflV7PlayByPlayEvent> events;

    @JsonProperty("fake_field_goal")
    private Boolean fakeFieldGoal;

    @JsonProperty("fake_punt")
    private Boolean fakePunt;

    @JsonProperty("first_downs")
    private Integer firstDowns;

    @JsonProperty("first_drive_yardline")
    private Integer firstDriveYardline;

    @JsonProperty("gain")
    private Integer gain;

    @JsonProperty("home_points")
    private Integer homePoints;

    @JsonProperty("id")
    private String id;

    @JsonProperty("inside_20")
    private Boolean inside20;

    @JsonProperty("last_drive_yardline")
    private Integer lastDriveYardline;

    @JsonProperty("net_yards")
    private Integer netYards;

    @JsonProperty("offensive_team")
    private SrNflV7PlayByPlayOffensiveTeam offensiveTeam;

    @JsonProperty("pat_points_attempted")
    private Integer patPointsAttempted;

    @JsonProperty("pat_successful")
    private Boolean patSuccessful;

    @JsonProperty("penalty_yards")
    private Integer penaltyYards;

    @JsonProperty("play_action")
    private Boolean playAction;

    @JsonProperty("play_count")
    private Integer playCount;

    @JsonProperty("play_type")
    private String playType;

    @JsonProperty("run_pass_option")
    private Boolean runPassOption;

    @JsonProperty("scoring_drive")
    private Boolean scoringDrive;

    @JsonProperty("screen_pass")
    private Boolean screenPass;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("start_clock")
    private String startClock;

    @JsonProperty("start_reason")
    private String startReason;

    @JsonProperty("start_situation")
    private SrNflV7PlayByPlayStartSituation startSituation;

    @JsonProperty("statistics")
    private List<SrNflV7PlayByPlayStatistic_1> statistics;

    @JsonProperty("team_sequence")
    private Integer teamSequence;

    @JsonProperty("type")
    private String type;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("wall_clock")
    private String wallClock;

    public Optional<Integer> getAwayPoints() {
        return Optional.ofNullable(awayPoints);
    }

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public Optional<String> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public Optional<SrNflV7PlayByPlayDefensiveTeam> getDefensiveTeam() {
        return Optional.ofNullable(defensiveTeam);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public List<SrNflV7PlayByPlayDetail_1> getDetails() {
        return Optional.ofNullable(details).orElse(Collections.emptyList());
    }

    public Optional<String> getDuration() {
        return Optional.ofNullable(duration);
    }

    public Optional<String> getEndClock() {
        return Optional.ofNullable(endClock);
    }

    public Optional<String> getEndReason() {
        return Optional.ofNullable(endReason);
    }

    public Optional<SrNflV7PlayByPlayEndSituation> getEndSituation() {
        return Optional.ofNullable(endSituation);
    }

    public Optional<String> getEventType() {
        return Optional.ofNullable(eventType);
    }

    public List<SrNflV7PlayByPlayEvent> getEvents() {
        return Optional.ofNullable(events).orElse(Collections.emptyList());
    }

    public Optional<Boolean> getFakeFieldGoal() {
        return Optional.ofNullable(fakeFieldGoal);
    }

    public Optional<Boolean> getFakePunt() {
        return Optional.ofNullable(fakePunt);
    }

    public Optional<Integer> getFirstDowns() {
        return Optional.ofNullable(firstDowns);
    }

    public Optional<Integer> getFirstDriveYardline() {
        return Optional.ofNullable(firstDriveYardline);
    }

    public Optional<Integer> getGain() {
        return Optional.ofNullable(gain);
    }

    public Optional<Integer> getHomePoints() {
        return Optional.ofNullable(homePoints);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Boolean> getInside20() {
        return Optional.ofNullable(inside20);
    }

    public Optional<Integer> getLastDriveYardline() {
        return Optional.ofNullable(lastDriveYardline);
    }

    public Optional<Integer> getNetYards() {
        return Optional.ofNullable(netYards);
    }

    public Optional<SrNflV7PlayByPlayOffensiveTeam> getOffensiveTeam() {
        return Optional.ofNullable(offensiveTeam);
    }

    public Optional<Integer> getPatPointsAttempted() {
        return Optional.ofNullable(patPointsAttempted);
    }

    public Optional<Boolean> getPatSuccessful() {
        return Optional.ofNullable(patSuccessful);
    }

    public Optional<Integer> getPenaltyYards() {
        return Optional.ofNullable(penaltyYards);
    }

    public Optional<Boolean> getPlayAction() {
        return Optional.ofNullable(playAction);
    }

    public Optional<Integer> getPlayCount() {
        return Optional.ofNullable(playCount);
    }

    public Optional<String> getPlayType() {
        return Optional.ofNullable(playType);
    }

    public Optional<Boolean> getRunPassOption() {
        return Optional.ofNullable(runPassOption);
    }

    public Optional<Boolean> getScoringDrive() {
        return Optional.ofNullable(scoringDrive);
    }

    public Optional<Boolean> getScreenPass() {
        return Optional.ofNullable(screenPass);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<String> getStartClock() {
        return Optional.ofNullable(startClock);
    }

    public Optional<String> getStartReason() {
        return Optional.ofNullable(startReason);
    }

    public Optional<SrNflV7PlayByPlayStartSituation> getStartSituation() {
        return Optional.ofNullable(startSituation);
    }

    public List<SrNflV7PlayByPlayStatistic_1> getStatistics() {
        return Optional.ofNullable(statistics).orElse(Collections.emptyList());
    }

    public Optional<Integer> getTeamSequence() {
        return Optional.ofNullable(teamSequence);
    }

    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }

    public Optional<String> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public Optional<String> getWallClock() {
        return Optional.ofNullable(wallClock);
    }
}

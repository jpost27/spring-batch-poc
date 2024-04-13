package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Double;
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
public class SrNflV7GameBoxscoreScoringPlay {
    @JsonProperty("away_points")
    private Integer awayPoints;

    @JsonProperty("blitz")
    private Boolean blitz;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("description")
    private String description;

    @JsonProperty("details")
    private List<SrNflV7GameBoxscoreDetail> details;

    @JsonProperty("end_situation")
    private SrNflV7GameBoxscoreEndSituation endSituation;

    @JsonProperty("fake_field_goal")
    private Boolean fakeFieldGoal;

    @JsonProperty("fake_punt")
    private Boolean fakePunt;

    @JsonProperty("goaltogo")
    private Boolean goaltogo;

    @JsonProperty("hash_mark")
    private String hashMark;

    @JsonProperty("home_points")
    private Integer homePoints;

    @JsonProperty("huddle")
    private String huddle;

    @JsonProperty("id")
    private String id;

    @JsonProperty("left_tightends")
    private Integer leftTightends;

    @JsonProperty("men_in_box")
    private Integer menInBox;

    @JsonProperty("pass_route")
    private String passRoute;

    @JsonProperty("play_action")
    private Boolean playAction;

    @JsonProperty("play_direction")
    private String playDirection;

    @JsonProperty("play_type")
    private String playType;

    @JsonProperty("players_rushed")
    private Integer playersRushed;

    @JsonProperty("pocket_location")
    private String pocketLocation;

    @JsonProperty("qb_at_snap")
    private String qbAtSnap;

    @JsonProperty("quarter")
    private SrNflV7GameBoxscoreQuarter quarter;

    @JsonProperty("right_tightends")
    private Integer rightTightends;

    @JsonProperty("run_pass_option")
    private Boolean runPassOption;

    @JsonProperty("running_lane")
    private Integer runningLane;

    @JsonProperty("score")
    private SrNflV7GameBoxscoreScore score;

    @JsonProperty("scoring_description")
    private String scoringDescription;

    @JsonProperty("scoring_play")
    private Boolean scoringPlay;

    @JsonProperty("screen_pass")
    private Boolean screenPass;

    @JsonProperty("sequence")
    private Double sequence;

    @JsonProperty("start_situation")
    private SrNflV7GameBoxscoreStartSituation startSituation;

    @JsonProperty("statistics")
    private List<SrNflV7GameBoxscoreStatistic_1> statistics;

    @JsonProperty("type")
    private String type;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("wall_clock")
    private String wallClock;

    public Optional<Integer> getAwayPoints() {
        return Optional.ofNullable(awayPoints);
    }

    public Optional<Boolean> getBlitz() {
        return Optional.ofNullable(blitz);
    }

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public Optional<String> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public List<SrNflV7GameBoxscoreDetail> getDetails() {
        return Optional.ofNullable(details).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7GameBoxscoreEndSituation> getEndSituation() {
        return Optional.ofNullable(endSituation);
    }

    public Optional<Boolean> getFakeFieldGoal() {
        return Optional.ofNullable(fakeFieldGoal);
    }

    public Optional<Boolean> getFakePunt() {
        return Optional.ofNullable(fakePunt);
    }

    public Optional<Boolean> getGoaltogo() {
        return Optional.ofNullable(goaltogo);
    }

    public Optional<String> getHashMark() {
        return Optional.ofNullable(hashMark);
    }

    public Optional<Integer> getHomePoints() {
        return Optional.ofNullable(homePoints);
    }

    public Optional<String> getHuddle() {
        return Optional.ofNullable(huddle);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getLeftTightends() {
        return Optional.ofNullable(leftTightends);
    }

    public Optional<Integer> getMenInBox() {
        return Optional.ofNullable(menInBox);
    }

    public Optional<String> getPassRoute() {
        return Optional.ofNullable(passRoute);
    }

    public Optional<Boolean> getPlayAction() {
        return Optional.ofNullable(playAction);
    }

    public Optional<String> getPlayDirection() {
        return Optional.ofNullable(playDirection);
    }

    public Optional<String> getPlayType() {
        return Optional.ofNullable(playType);
    }

    public Optional<Integer> getPlayersRushed() {
        return Optional.ofNullable(playersRushed);
    }

    public Optional<String> getPocketLocation() {
        return Optional.ofNullable(pocketLocation);
    }

    public Optional<String> getQbAtSnap() {
        return Optional.ofNullable(qbAtSnap);
    }

    public Optional<SrNflV7GameBoxscoreQuarter> getQuarter() {
        return Optional.ofNullable(quarter);
    }

    public Optional<Integer> getRightTightends() {
        return Optional.ofNullable(rightTightends);
    }

    public Optional<Boolean> getRunPassOption() {
        return Optional.ofNullable(runPassOption);
    }

    public Optional<Integer> getRunningLane() {
        return Optional.ofNullable(runningLane);
    }

    public Optional<SrNflV7GameBoxscoreScore> getScore() {
        return Optional.ofNullable(score);
    }

    public Optional<String> getScoringDescription() {
        return Optional.ofNullable(scoringDescription);
    }

    public Optional<Boolean> getScoringPlay() {
        return Optional.ofNullable(scoringPlay);
    }

    public Optional<Boolean> getScreenPass() {
        return Optional.ofNullable(screenPass);
    }

    public Optional<Double> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<SrNflV7GameBoxscoreStartSituation> getStartSituation() {
        return Optional.ofNullable(startSituation);
    }

    public List<SrNflV7GameBoxscoreStatistic_1> getStatistics() {
        return Optional.ofNullable(statistics).orElse(Collections.emptyList());
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

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
public class SrNflV7GameBoxscoreResponse {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("clock")
    private String clock;

    @JsonProperty("coin_toss")
    private List<SrNflV7GameBoxscoreCoinTos> coinToss;

    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("conference_game")
    private Boolean conferenceGame;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("id")
    private String id;

    @JsonProperty("last_event")
    private SrNflV7GameBoxscoreLastEvent lastEvent;

    @JsonProperty("quarter")
    private Integer quarter;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("scoring")
    private List<SrNflV7GameBoxscoreScoring> scoring;

    @JsonProperty("scoring_drives")
    private List<SrNflV7GameBoxscoreScoringDrife> scoringDrives;

    @JsonProperty("scoring_plays")
    private List<SrNflV7GameBoxscoreScoringPlay> scoringPlays;

    @JsonProperty("situation")
    private SrNflV7GameBoxscoreSituation situation;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("summary")
    private SrNflV7GameBoxscoreSummary summary;

    @JsonProperty("weather")
    private SrNflV7GameBoxscoreWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public List<SrNflV7GameBoxscoreCoinTos> getCoinToss() {
        return Optional.ofNullable(coinToss).orElse(Collections.emptyList());
    }

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<Boolean> getConferenceGame() {
        return Optional.ofNullable(conferenceGame);
    }

    public Optional<String> getDuration() {
        return Optional.ofNullable(duration);
    }

    public Optional<String> getEntryMode() {
        return Optional.ofNullable(entryMode);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7GameBoxscoreLastEvent> getLastEvent() {
        return Optional.ofNullable(lastEvent);
    }

    public Optional<Integer> getQuarter() {
        return Optional.ofNullable(quarter);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public List<SrNflV7GameBoxscoreScoring> getScoring() {
        return Optional.ofNullable(scoring).orElse(Collections.emptyList());
    }

    public List<SrNflV7GameBoxscoreScoringDrife> getScoringDrives() {
        return Optional.ofNullable(scoringDrives).orElse(Collections.emptyList());
    }

    public List<SrNflV7GameBoxscoreScoringPlay> getScoringPlays() {
        return Optional.ofNullable(scoringPlays).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7GameBoxscoreSituation> getSituation() {
        return Optional.ofNullable(situation);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7GameBoxscoreSummary> getSummary() {
        return Optional.ofNullable(summary);
    }

    public Optional<SrNflV7GameBoxscoreWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

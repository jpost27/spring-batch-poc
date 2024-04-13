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
public class SrNflV7PlayByPlayResponse {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("clock")
    private String clock;

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

    @JsonProperty("periods")
    private List<SrNflV7PlayByPlayPeriod> periods;

    @JsonProperty("quarter")
    private Integer quarter;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("summary")
    private SrNflV7PlayByPlaySummary summary;

    @JsonProperty("weather")
    private SrNflV7PlayByPlayWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
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

    public List<SrNflV7PlayByPlayPeriod> getPeriods() {
        return Optional.ofNullable(periods).orElse(Collections.emptyList());
    }

    public Optional<Integer> getQuarter() {
        return Optional.ofNullable(quarter);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7PlayByPlaySummary> getSummary() {
        return Optional.ofNullable(summary);
    }

    public Optional<SrNflV7PlayByPlayWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

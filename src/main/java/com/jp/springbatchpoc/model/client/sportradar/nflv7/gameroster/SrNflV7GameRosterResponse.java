package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameroster;

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
public class SrNflV7GameRosterResponse {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("away")
    private SrNflV7GameRosterAway_1 away;

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

    @JsonProperty("home")
    private SrNflV7GameRosterHome_1 home;

    @JsonProperty("id")
    private String id;

    @JsonProperty("officials")
    private List<SrNflV7GameRosterOfficial> officials;

    @JsonProperty("quarter")
    private Integer quarter;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("summary")
    private SrNflV7GameRosterSummary summary;

    @JsonProperty("weather")
    private SrNflV7GameRosterWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<SrNflV7GameRosterAway_1> getAway() {
        return Optional.ofNullable(away);
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

    public Optional<SrNflV7GameRosterHome_1> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public List<SrNflV7GameRosterOfficial> getOfficials() {
        return Optional.ofNullable(officials).orElse(Collections.emptyList());
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

    public Optional<SrNflV7GameRosterSummary> getSummary() {
        return Optional.ofNullable(summary);
    }

    public Optional<SrNflV7GameRosterWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

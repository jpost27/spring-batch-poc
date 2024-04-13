package com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklyschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
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
public class SrNflV7WeeklyScheduleGame {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("away")
    private SrNflV7WeeklyScheduleAway away;

    @JsonProperty("broadcast")
    private SrNflV7WeeklyScheduleBroadcast broadcast;

    @JsonProperty("conference_game")
    private Boolean conferenceGame;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("home")
    private SrNflV7WeeklyScheduleHome home;

    @JsonProperty("id")
    private String id;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("scoring")
    private SrNflV7WeeklyScheduleScoring scoring;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("venue")
    private SrNflV7WeeklyScheduleVenue venue;

    @JsonProperty("weather")
    private SrNflV7WeeklyScheduleWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<SrNflV7WeeklyScheduleAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7WeeklyScheduleBroadcast> getBroadcast() {
        return Optional.ofNullable(broadcast);
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

    public Optional<SrNflV7WeeklyScheduleHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public Optional<SrNflV7WeeklyScheduleScoring> getScoring() {
        return Optional.ofNullable(scoring);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7WeeklyScheduleVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7WeeklyScheduleWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

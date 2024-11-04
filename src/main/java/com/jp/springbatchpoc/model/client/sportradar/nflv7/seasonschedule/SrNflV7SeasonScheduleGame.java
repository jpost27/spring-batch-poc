package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Optional;
import javax.annotation.processing.Generated;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@Generated("fanduel-model-generator")
public class SrNflV7SeasonScheduleGame {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("away")
    private SrNflV7SeasonScheduleAway away;

    @JsonProperty("broadcast")
    private SrNflV7SeasonScheduleBroadcast broadcast;

    @JsonProperty("conference_game")
    private Boolean conferenceGame;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("home")
    private SrNflV7SeasonScheduleHome home;

    @JsonProperty("id")
    private String id;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("scoring")
    private SrNflV7SeasonScheduleScoring scoring;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("venue")
    private SrNflV7SeasonScheduleVenue venue;

    @JsonProperty("weather")
    private SrNflV7SeasonScheduleWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<SrNflV7SeasonScheduleAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7SeasonScheduleBroadcast> getBroadcast() {
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

    public Optional<SrNflV7SeasonScheduleHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public Optional<SrNflV7SeasonScheduleScoring> getScoring() {
        return Optional.ofNullable(scoring);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7SeasonScheduleVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7SeasonScheduleWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

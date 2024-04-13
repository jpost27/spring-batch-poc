package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentseasonschedule;

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
public class SrNflV7CurrentSeasonScheduleGame {
    @JsonProperty("attendance")
    private Integer attendance;

    @JsonProperty("away")
    private SrNflV7CurrentSeasonScheduleAway away;

    @JsonProperty("broadcast")
    private SrNflV7CurrentSeasonScheduleBroadcast broadcast;

    @JsonProperty("conference_game")
    private Boolean conferenceGame;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("entry_mode")
    private String entryMode;

    @JsonProperty("game_type")
    private String gameType;

    @JsonProperty("home")
    private SrNflV7CurrentSeasonScheduleHome home;

    @JsonProperty("id")
    private String id;

    @JsonProperty("neutral_site")
    private Boolean neutralSite;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("scoring")
    private SrNflV7CurrentSeasonScheduleScoring scoring;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("title")
    private String title;

    @JsonProperty("venue")
    private SrNflV7CurrentSeasonScheduleVenue venue;

    @JsonProperty("weather")
    private SrNflV7CurrentSeasonScheduleWeather weather;

    public Optional<Integer> getAttendance() {
        return Optional.ofNullable(attendance);
    }

    public Optional<SrNflV7CurrentSeasonScheduleAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7CurrentSeasonScheduleBroadcast> getBroadcast() {
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

    public Optional<String> getGameType() {
        return Optional.ofNullable(gameType);
    }

    public Optional<SrNflV7CurrentSeasonScheduleHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Boolean> getNeutralSite() {
        return Optional.ofNullable(neutralSite);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public Optional<SrNflV7CurrentSeasonScheduleScoring> getScoring() {
        return Optional.ofNullable(scoring);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }

    public Optional<SrNflV7CurrentSeasonScheduleVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7CurrentSeasonScheduleWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

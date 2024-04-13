package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
public class SrNflV7GameStatisticsResponse {
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

    @JsonProperty("quarter")
    private Integer quarter;

    @JsonProperty("scheduled")
    private String scheduled;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("statistics")
    private SrNflV7GameStatisticsStatistics statistics;

    @JsonProperty("status")
    private String status;

    @JsonProperty("summary")
    private SrNflV7GameStatisticsSummary_1 summary;

    @JsonProperty("weather")
    private SrNflV7GameStatisticsWeather weather;

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

    public Optional<Integer> getQuarter() {
        return Optional.ofNullable(quarter);
    }

    public Optional<String> getScheduled() {
        return Optional.ofNullable(scheduled);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<SrNflV7GameStatisticsStatistics> getStatistics() {
        return Optional.ofNullable(statistics);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7GameStatisticsSummary_1> getSummary() {
        return Optional.ofNullable(summary);
    }

    public Optional<SrNflV7GameStatisticsWeather> getWeather() {
        return Optional.ofNullable(weather);
    }
}

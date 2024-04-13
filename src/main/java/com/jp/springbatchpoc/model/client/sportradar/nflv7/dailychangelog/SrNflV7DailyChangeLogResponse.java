package com.jp.springbatchpoc.model.client.sportradar.nflv7.dailychangelog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7DailyChangeLogResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("league")
    private SrNflV7DailyChangeLogLeague league;

    @JsonProperty("players")
    private List<SrNflV7DailyChangeLogPlayer> players;

    @JsonProperty("results")
    private List<SrNflV7DailyChangeLogResult> results;

    @JsonProperty("schedule")
    private List<SrNflV7DailyChangeLogSchedule> schedule;

    @JsonProperty("start_time")
    private String startTime;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<String> getEndTime() {
        return Optional.ofNullable(endTime);
    }

    public Optional<SrNflV7DailyChangeLogLeague> getLeague() {
        return Optional.ofNullable(league);
    }

    public List<SrNflV7DailyChangeLogPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public List<SrNflV7DailyChangeLogResult> getResults() {
        return Optional.ofNullable(results).orElse(Collections.emptyList());
    }

    public List<SrNflV7DailyChangeLogSchedule> getSchedule() {
        return Optional.ofNullable(schedule).orElse(Collections.emptyList());
    }

    public Optional<String> getStartTime() {
        return Optional.ofNullable(startTime);
    }
}

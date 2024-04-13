package com.jp.springbatchpoc.model.client.sportradar.nflv7.dailytransactions;

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
public class SrNflV7DailyTransactionsResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("league")
    private SrNflV7DailyTransactionsLeague league;

    @JsonProperty("players")
    private List<SrNflV7DailyTransactionsPlayer> players;

    @JsonProperty("start_time")
    private String startTime;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<String> getEndTime() {
        return Optional.ofNullable(endTime);
    }

    public Optional<SrNflV7DailyTransactionsLeague> getLeague() {
        return Optional.ofNullable(league);
    }

    public List<SrNflV7DailyTransactionsPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public Optional<String> getStartTime() {
        return Optional.ofNullable(startTime);
    }
}

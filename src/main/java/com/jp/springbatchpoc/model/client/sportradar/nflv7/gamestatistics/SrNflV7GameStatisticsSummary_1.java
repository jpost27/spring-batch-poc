package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

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
@Accessors(
        chain = true
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
@ToString
@Generated("fanduel-model-generator")
public class SrNflV7GameStatisticsSummary_1 {
    @JsonProperty("away")
    private SrNflV7GameStatisticsAway_1 away;

    @JsonProperty("home")
    private SrNflV7GameStatisticsHome home;

    @JsonProperty("season")
    private SrNflV7GameStatisticsSeason season;

    @JsonProperty("venue")
    private SrNflV7GameStatisticsVenue venue;

    @JsonProperty("week")
    private SrNflV7GameStatisticsWeek week;

    public Optional<SrNflV7GameStatisticsAway_1> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7GameStatisticsHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<SrNflV7GameStatisticsSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public Optional<SrNflV7GameStatisticsVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7GameStatisticsWeek> getWeek() {
        return Optional.ofNullable(week);
    }
}

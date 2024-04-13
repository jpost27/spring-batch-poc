package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

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
public class SrNflV7GameBoxscoreSummary {
    @JsonProperty("away")
    private SrNflV7GameBoxscoreAway away;

    @JsonProperty("home")
    private SrNflV7GameBoxscoreHome home;

    @JsonProperty("season")
    private SrNflV7GameBoxscoreSeason season;

    @JsonProperty("venue")
    private SrNflV7GameBoxscoreVenue venue;

    @JsonProperty("week")
    private SrNflV7GameBoxscoreWeek week;

    public Optional<SrNflV7GameBoxscoreAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7GameBoxscoreHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<SrNflV7GameBoxscoreSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public Optional<SrNflV7GameBoxscoreVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7GameBoxscoreWeek> getWeek() {
        return Optional.ofNullable(week);
    }
}

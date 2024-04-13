package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameroster;

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
public class SrNflV7GameRosterSummary {
    @JsonProperty("away")
    private SrNflV7GameRosterAway away;

    @JsonProperty("home")
    private SrNflV7GameRosterHome home;

    @JsonProperty("season")
    private SrNflV7GameRosterSeason season;

    @JsonProperty("venue")
    private SrNflV7GameRosterVenue venue;

    @JsonProperty("week")
    private SrNflV7GameRosterWeek week;

    public Optional<SrNflV7GameRosterAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7GameRosterHome> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<SrNflV7GameRosterSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public Optional<SrNflV7GameRosterVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7GameRosterWeek> getWeek() {
        return Optional.ofNullable(week);
    }
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

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
public class SrNflV7PlayByPlaySummary {
    @JsonProperty("away")
    private SrNflV7PlayByPlayAway away;

    @JsonProperty("home")
    private SrNflV7PlayByPlayHome_1 home;

    @JsonProperty("season")
    private SrNflV7PlayByPlaySeason season;

    @JsonProperty("venue")
    private SrNflV7PlayByPlayVenue venue;

    @JsonProperty("week")
    private SrNflV7PlayByPlayWeek week;

    public Optional<SrNflV7PlayByPlayAway> getAway() {
        return Optional.ofNullable(away);
    }

    public Optional<SrNflV7PlayByPlayHome_1> getHome() {
        return Optional.ofNullable(home);
    }

    public Optional<SrNflV7PlayByPlaySeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public Optional<SrNflV7PlayByPlayVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<SrNflV7PlayByPlayWeek> getWeek() {
        return Optional.ofNullable(week);
    }
}

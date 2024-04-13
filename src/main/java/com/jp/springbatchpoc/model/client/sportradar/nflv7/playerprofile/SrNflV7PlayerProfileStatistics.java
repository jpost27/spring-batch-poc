package com.jp.springbatchpoc.model.client.sportradar.nflv7.playerprofile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
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
public class SrNflV7PlayerProfileStatistics {
    @JsonProperty("conversions")
    private SrNflV7PlayerProfileConversions conversions;

    @JsonProperty("defense")
    private SrNflV7PlayerProfileDefense defense;

    @JsonProperty("fumbles")
    private SrNflV7PlayerProfileFumbles fumbles;

    @JsonProperty("games_played")
    private Integer gamesPlayed;

    @JsonProperty("games_started")
    private Integer gamesStarted;

    @JsonProperty("kick_returns")
    private SrNflV7PlayerProfileKickReturns kickReturns;

    @JsonProperty("passing")
    private SrNflV7PlayerProfilePassing passing;

    @JsonProperty("penalties")
    private SrNflV7PlayerProfilePenalties penalties;

    @JsonProperty("punt_returns")
    private SrNflV7PlayerProfilePuntReturns puntReturns;

    @JsonProperty("receiving")
    private SrNflV7PlayerProfileReceiving receiving;

    @JsonProperty("rushing")
    private SrNflV7PlayerProfileRushing rushing;

    public Optional<SrNflV7PlayerProfileConversions> getConversions() {
        return Optional.ofNullable(conversions);
    }

    public Optional<SrNflV7PlayerProfileDefense> getDefense() {
        return Optional.ofNullable(defense);
    }

    public Optional<SrNflV7PlayerProfileFumbles> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<Integer> getGamesPlayed() {
        return Optional.ofNullable(gamesPlayed);
    }

    public Optional<Integer> getGamesStarted() {
        return Optional.ofNullable(gamesStarted);
    }

    public Optional<SrNflV7PlayerProfileKickReturns> getKickReturns() {
        return Optional.ofNullable(kickReturns);
    }

    public Optional<SrNflV7PlayerProfilePassing> getPassing() {
        return Optional.ofNullable(passing);
    }

    public Optional<SrNflV7PlayerProfilePenalties> getPenalties() {
        return Optional.ofNullable(penalties);
    }

    public Optional<SrNflV7PlayerProfilePuntReturns> getPuntReturns() {
        return Optional.ofNullable(puntReturns);
    }

    public Optional<SrNflV7PlayerProfileReceiving> getReceiving() {
        return Optional.ofNullable(receiving);
    }

    public Optional<SrNflV7PlayerProfileRushing> getRushing() {
        return Optional.ofNullable(rushing);
    }
}

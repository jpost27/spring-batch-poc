package com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
import java.lang.Integer;
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
public class SrNflV7PostgameStandingsTeam {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("id")
    private String id;

    @JsonProperty("losses")
    private Integer losses;

    @JsonProperty("market")
    private String market;

    @JsonProperty("name")
    private String name;

    @JsonProperty("points_against")
    private Integer pointsAgainst;

    @JsonProperty("points_for")
    private Integer pointsFor;

    @JsonProperty("rank")
    private SrNflV7PostgameStandingsRank rank;

    @JsonProperty("records")
    private List<SrNflV7PostgameStandingsRecord> records;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("streak")
    private SrNflV7PostgameStandingsStreak streak;

    @JsonProperty("strength_of_schedule")
    private SrNflV7PostgameStandingsStrengthOfSchedule strengthOfSchedule;

    @JsonProperty("strength_of_victory")
    private SrNflV7PostgameStandingsStrengthOfVictory strengthOfVictory;

    @JsonProperty("ties")
    private Integer ties;

    @JsonProperty("win_pct")
    private Double winPct;

    @JsonProperty("wins")
    private Integer wins;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getLosses() {
        return Optional.ofNullable(losses);
    }

    public Optional<String> getMarket() {
        return Optional.ofNullable(market);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getPointsAgainst() {
        return Optional.ofNullable(pointsAgainst);
    }

    public Optional<Integer> getPointsFor() {
        return Optional.ofNullable(pointsFor);
    }

    public Optional<SrNflV7PostgameStandingsRank> getRank() {
        return Optional.ofNullable(rank);
    }

    public List<SrNflV7PostgameStandingsRecord> getRecords() {
        return Optional.ofNullable(records).orElse(Collections.emptyList());
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<SrNflV7PostgameStandingsStreak> getStreak() {
        return Optional.ofNullable(streak);
    }

    public Optional<SrNflV7PostgameStandingsStrengthOfSchedule> getStrengthOfSchedule() {
        return Optional.ofNullable(strengthOfSchedule);
    }

    public Optional<SrNflV7PostgameStandingsStrengthOfVictory> getStrengthOfVictory() {
        return Optional.ofNullable(strengthOfVictory);
    }

    public Optional<Integer> getTies() {
        return Optional.ofNullable(ties);
    }

    public Optional<Double> getWinPct() {
        return Optional.ofNullable(winPct);
    }

    public Optional<Integer> getWins() {
        return Optional.ofNullable(wins);
    }
}

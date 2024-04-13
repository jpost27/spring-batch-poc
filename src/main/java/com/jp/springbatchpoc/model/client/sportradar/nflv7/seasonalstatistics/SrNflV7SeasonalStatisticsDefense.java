package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7SeasonalStatisticsDefense {
    @JsonProperty("assists")
    private Integer assists;

    @JsonProperty("batted_passes")
    private Integer battedPasses;

    @JsonProperty("blitzes")
    private Integer blitzes;

    @JsonProperty("combined")
    private Integer combined;

    @JsonProperty("def_comps")
    private Integer defComps;

    @JsonProperty("def_targets")
    private Integer defTargets;

    @JsonProperty("forced_fumbles")
    private Integer forcedFumbles;

    @JsonProperty("fourth_down_stops")
    private Integer fourthDownStops;

    @JsonProperty("fumble_recoveries")
    private Integer fumbleRecoveries;

    @JsonProperty("hurries")
    private Integer hurries;

    @JsonProperty("interceptions")
    private Integer interceptions;

    @JsonProperty("knockdowns")
    private Integer knockdowns;

    @JsonProperty("misc_assists")
    private Integer miscAssists;

    @JsonProperty("misc_forced_fumbles")
    private Integer miscForcedFumbles;

    @JsonProperty("misc_fumble_recoveries")
    private Integer miscFumbleRecoveries;

    @JsonProperty("misc_tackles")
    private Integer miscTackles;

    @JsonProperty("missed_tackles")
    private Integer missedTackles;

    @JsonProperty("passes_defended")
    private Integer passesDefended;

    @JsonProperty("qb_hits")
    private Integer qbHits;

    @JsonProperty("sack_yards")
    private Double sackYards;

    @JsonProperty("sacks")
    private Double sacks;

    @JsonProperty("safeties")
    private Integer safeties;

    @JsonProperty("sp_assists")
    private Integer spAssists;

    @JsonProperty("sp_blocks")
    private Integer spBlocks;

    @JsonProperty("sp_forced_fumbles")
    private Integer spForcedFumbles;

    @JsonProperty("sp_fumble_recoveries")
    private Integer spFumbleRecoveries;

    @JsonProperty("sp_tackles")
    private Integer spTackles;

    @JsonProperty("tackles")
    private Integer tackles;

    @JsonProperty("three_and_outs_forced")
    private Integer threeAndOutsForced;

    @JsonProperty("tloss")
    private Double tloss;

    @JsonProperty("tloss_yards")
    private Double tlossYards;

    public Optional<Integer> getAssists() {
        return Optional.ofNullable(assists);
    }

    public Optional<Integer> getBattedPasses() {
        return Optional.ofNullable(battedPasses);
    }

    public Optional<Integer> getBlitzes() {
        return Optional.ofNullable(blitzes);
    }

    public Optional<Integer> getCombined() {
        return Optional.ofNullable(combined);
    }

    public Optional<Integer> getDefComps() {
        return Optional.ofNullable(defComps);
    }

    public Optional<Integer> getDefTargets() {
        return Optional.ofNullable(defTargets);
    }

    public Optional<Integer> getForcedFumbles() {
        return Optional.ofNullable(forcedFumbles);
    }

    public Optional<Integer> getFourthDownStops() {
        return Optional.ofNullable(fourthDownStops);
    }

    public Optional<Integer> getFumbleRecoveries() {
        return Optional.ofNullable(fumbleRecoveries);
    }

    public Optional<Integer> getHurries() {
        return Optional.ofNullable(hurries);
    }

    public Optional<Integer> getInterceptions() {
        return Optional.ofNullable(interceptions);
    }

    public Optional<Integer> getKnockdowns() {
        return Optional.ofNullable(knockdowns);
    }

    public Optional<Integer> getMiscAssists() {
        return Optional.ofNullable(miscAssists);
    }

    public Optional<Integer> getMiscForcedFumbles() {
        return Optional.ofNullable(miscForcedFumbles);
    }

    public Optional<Integer> getMiscFumbleRecoveries() {
        return Optional.ofNullable(miscFumbleRecoveries);
    }

    public Optional<Integer> getMiscTackles() {
        return Optional.ofNullable(miscTackles);
    }

    public Optional<Integer> getMissedTackles() {
        return Optional.ofNullable(missedTackles);
    }

    public Optional<Integer> getPassesDefended() {
        return Optional.ofNullable(passesDefended);
    }

    public Optional<Integer> getQbHits() {
        return Optional.ofNullable(qbHits);
    }

    public Optional<Double> getSackYards() {
        return Optional.ofNullable(sackYards);
    }

    public Optional<Double> getSacks() {
        return Optional.ofNullable(sacks);
    }

    public Optional<Integer> getSafeties() {
        return Optional.ofNullable(safeties);
    }

    public Optional<Integer> getSpAssists() {
        return Optional.ofNullable(spAssists);
    }

    public Optional<Integer> getSpBlocks() {
        return Optional.ofNullable(spBlocks);
    }

    public Optional<Integer> getSpForcedFumbles() {
        return Optional.ofNullable(spForcedFumbles);
    }

    public Optional<Integer> getSpFumbleRecoveries() {
        return Optional.ofNullable(spFumbleRecoveries);
    }

    public Optional<Integer> getSpTackles() {
        return Optional.ofNullable(spTackles);
    }

    public Optional<Integer> getTackles() {
        return Optional.ofNullable(tackles);
    }

    public Optional<Integer> getThreeAndOutsForced() {
        return Optional.ofNullable(threeAndOutsForced);
    }

    public Optional<Double> getTloss() {
        return Optional.ofNullable(tloss);
    }

    public Optional<Double> getTlossYards() {
        return Optional.ofNullable(tlossYards);
    }
}

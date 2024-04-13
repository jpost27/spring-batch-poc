package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7GameBoxscoreStatistic_1 {
    @JsonProperty("att_yards")
    private Integer attYards;

    @JsonProperty("attempt")
    private Integer attempt;

    @JsonProperty("batted_pass")
    private Integer battedPass;

    @JsonProperty("blitz")
    private Integer blitz;

    @JsonProperty("broken_tackles")
    private Integer brokenTackles;

    @JsonProperty("catchable")
    private Integer catchable;

    @JsonProperty("category")
    private String category;

    @JsonProperty("complete")
    private Integer complete;

    @JsonProperty("def_comp")
    private Integer defComp;

    @JsonProperty("def_target")
    private Integer defTarget;

    @JsonProperty("down")
    private Integer down;

    @JsonProperty("dropped")
    private Integer dropped;

    @JsonProperty("firstdown")
    private Integer firstdown;

    @JsonProperty("goaltogo")
    private Integer goaltogo;

    @JsonProperty("hurry")
    private Integer hurry;

    @JsonProperty("inside_20")
    private Integer inside20;

    @JsonProperty("kneel_down")
    private Integer kneelDown;

    @JsonProperty("knockdown")
    private Integer knockdown;

    @JsonProperty("made")
    private Integer made;

    @JsonProperty("missed")
    private Integer missed;

    @JsonProperty("missed_tackles")
    private Integer missedTackles;

    @JsonProperty("on_target_throw")
    private Integer onTargetThrow;

    @JsonProperty("player")
    private SrNflV7GameBoxscorePlayer player;

    @JsonProperty("pocket_time")
    private Double pocketTime;

    @JsonProperty("reception")
    private Integer reception;

    @JsonProperty("scramble")
    private Integer scramble;

    @JsonProperty("stat_type")
    private String statType;

    @JsonProperty("target")
    private Integer target;

    @JsonProperty("team")
    private SrNflV7GameBoxscoreTeam team;

    @JsonProperty("touchdown")
    private Integer touchdown;

    @JsonProperty("yards")
    private Integer yards;

    @JsonProperty("yards_after_catch")
    private Integer yardsAfterCatch;

    @JsonProperty("yards_after_contact")
    private Integer yardsAfterContact;

    public Optional<Integer> getAttYards() {
        return Optional.ofNullable(attYards);
    }

    public Optional<Integer> getAttempt() {
        return Optional.ofNullable(attempt);
    }

    public Optional<Integer> getBattedPass() {
        return Optional.ofNullable(battedPass);
    }

    public Optional<Integer> getBlitz() {
        return Optional.ofNullable(blitz);
    }

    public Optional<Integer> getBrokenTackles() {
        return Optional.ofNullable(brokenTackles);
    }

    public Optional<Integer> getCatchable() {
        return Optional.ofNullable(catchable);
    }

    public Optional<String> getCategory() {
        return Optional.ofNullable(category);
    }

    public Optional<Integer> getComplete() {
        return Optional.ofNullable(complete);
    }

    public Optional<Integer> getDefComp() {
        return Optional.ofNullable(defComp);
    }

    public Optional<Integer> getDefTarget() {
        return Optional.ofNullable(defTarget);
    }

    public Optional<Integer> getDown() {
        return Optional.ofNullable(down);
    }

    public Optional<Integer> getDropped() {
        return Optional.ofNullable(dropped);
    }

    public Optional<Integer> getFirstdown() {
        return Optional.ofNullable(firstdown);
    }

    public Optional<Integer> getGoaltogo() {
        return Optional.ofNullable(goaltogo);
    }

    public Optional<Integer> getHurry() {
        return Optional.ofNullable(hurry);
    }

    public Optional<Integer> getInside20() {
        return Optional.ofNullable(inside20);
    }

    public Optional<Integer> getKneelDown() {
        return Optional.ofNullable(kneelDown);
    }

    public Optional<Integer> getKnockdown() {
        return Optional.ofNullable(knockdown);
    }

    public Optional<Integer> getMade() {
        return Optional.ofNullable(made);
    }

    public Optional<Integer> getMissed() {
        return Optional.ofNullable(missed);
    }

    public Optional<Integer> getMissedTackles() {
        return Optional.ofNullable(missedTackles);
    }

    public Optional<Integer> getOnTargetThrow() {
        return Optional.ofNullable(onTargetThrow);
    }

    public Optional<SrNflV7GameBoxscorePlayer> getPlayer() {
        return Optional.ofNullable(player);
    }

    public Optional<Double> getPocketTime() {
        return Optional.ofNullable(pocketTime);
    }

    public Optional<Integer> getReception() {
        return Optional.ofNullable(reception);
    }

    public Optional<Integer> getScramble() {
        return Optional.ofNullable(scramble);
    }

    public Optional<String> getStatType() {
        return Optional.ofNullable(statType);
    }

    public Optional<Integer> getTarget() {
        return Optional.ofNullable(target);
    }

    public Optional<SrNflV7GameBoxscoreTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getTouchdown() {
        return Optional.ofNullable(touchdown);
    }

    public Optional<Integer> getYards() {
        return Optional.ofNullable(yards);
    }

    public Optional<Integer> getYardsAfterCatch() {
        return Optional.ofNullable(yardsAfterCatch);
    }

    public Optional<Integer> getYardsAfterContact() {
        return Optional.ofNullable(yardsAfterContact);
    }
}

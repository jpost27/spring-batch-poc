package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
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
public class SrNflV7PlayByPlayStatistic {
    @JsonProperty("return")
    private Integer _return;

    @JsonProperty("ast_sack")
    private Integer astSack;

    @JsonProperty("ast_tackle")
    private Integer astTackle;

    @JsonProperty("ast_tlost")
    private Integer astTlost;

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

    @JsonProperty("endzone")
    private Integer endzone;

    @JsonProperty("faircatch")
    private Integer faircatch;

    @JsonProperty("firstdown")
    private Integer firstdown;

    @JsonProperty("forced")
    private Integer forced;

    @JsonProperty("forced_fumble")
    private Integer forcedFumble;

    @JsonProperty("fumble")
    private Integer fumble;

    @JsonProperty("goaltogo")
    private Integer goaltogo;

    @JsonProperty("hang_time")
    private Double hangTime;

    @JsonProperty("hurry")
    private Integer hurry;

    @JsonProperty("incompletion_type")
    private String incompletionType;

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

    @JsonProperty("net_yards")
    private Integer netYards;

    @JsonProperty("nullified")
    private Boolean nullified;

    @JsonProperty("on_target_throw")
    private Integer onTargetThrow;

    @JsonProperty("onside_attempt")
    private Integer onsideAttempt;

    @JsonProperty("onside_success")
    private Integer onsideSuccess;

    @JsonProperty("out_of_bounds")
    private Integer outOfBounds;

    @JsonProperty("own_rec")
    private Integer ownRec;

    @JsonProperty("own_rec_yards")
    private Integer ownRecYards;

    @JsonProperty("pass_defended")
    private Integer passDefended;

    @JsonProperty("penalty")
    private Integer penalty;

    @JsonProperty("play_category")
    private String playCategory;

    @JsonProperty("player")
    private SrNflV7PlayByPlayPlayer player;

    @JsonProperty("pocket_time")
    private Double pocketTime;

    @JsonProperty("qb_hit")
    private Integer qbHit;

    @JsonProperty("reception")
    private Integer reception;

    @JsonProperty("sack")
    private Integer sack;

    @JsonProperty("sack_yards")
    private Double sackYards;

    @JsonProperty("scramble")
    private Integer scramble;

    @JsonProperty("squib_kick")
    private Integer squibKick;

    @JsonProperty("stat_type")
    private String statType;

    @JsonProperty("tackle")
    private Integer tackle;

    @JsonProperty("target")
    private Integer target;

    @JsonProperty("team")
    private SrNflV7PlayByPlayTeam team;

    @JsonProperty("tlost")
    private Integer tlost;

    @JsonProperty("tlost_yards")
    private Integer tlostYards;

    @JsonProperty("touchback")
    private Integer touchback;

    @JsonProperty("touchdown")
    private Integer touchdown;

    @JsonProperty("yards")
    private Integer yards;

    @JsonProperty("yards_after_catch")
    private Integer yardsAfterCatch;

    @JsonProperty("yards_after_contact")
    private Integer yardsAfterContact;

    public Optional<Integer> get_return() {
        return Optional.ofNullable(_return);
    }

    public Optional<Integer> getAstSack() {
        return Optional.ofNullable(astSack);
    }

    public Optional<Integer> getAstTackle() {
        return Optional.ofNullable(astTackle);
    }

    public Optional<Integer> getAstTlost() {
        return Optional.ofNullable(astTlost);
    }

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

    public Optional<Integer> getEndzone() {
        return Optional.ofNullable(endzone);
    }

    public Optional<Integer> getFaircatch() {
        return Optional.ofNullable(faircatch);
    }

    public Optional<Integer> getFirstdown() {
        return Optional.ofNullable(firstdown);
    }

    public Optional<Integer> getForced() {
        return Optional.ofNullable(forced);
    }

    public Optional<Integer> getForcedFumble() {
        return Optional.ofNullable(forcedFumble);
    }

    public Optional<Integer> getFumble() {
        return Optional.ofNullable(fumble);
    }

    public Optional<Integer> getGoaltogo() {
        return Optional.ofNullable(goaltogo);
    }

    public Optional<Double> getHangTime() {
        return Optional.ofNullable(hangTime);
    }

    public Optional<Integer> getHurry() {
        return Optional.ofNullable(hurry);
    }

    public Optional<String> getIncompletionType() {
        return Optional.ofNullable(incompletionType);
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

    public Optional<Integer> getNetYards() {
        return Optional.ofNullable(netYards);
    }

    public Optional<Boolean> getNullified() {
        return Optional.ofNullable(nullified);
    }

    public Optional<Integer> getOnTargetThrow() {
        return Optional.ofNullable(onTargetThrow);
    }

    public Optional<Integer> getOnsideAttempt() {
        return Optional.ofNullable(onsideAttempt);
    }

    public Optional<Integer> getOnsideSuccess() {
        return Optional.ofNullable(onsideSuccess);
    }

    public Optional<Integer> getOutOfBounds() {
        return Optional.ofNullable(outOfBounds);
    }

    public Optional<Integer> getOwnRec() {
        return Optional.ofNullable(ownRec);
    }

    public Optional<Integer> getOwnRecYards() {
        return Optional.ofNullable(ownRecYards);
    }

    public Optional<Integer> getPassDefended() {
        return Optional.ofNullable(passDefended);
    }

    public Optional<Integer> getPenalty() {
        return Optional.ofNullable(penalty);
    }

    public Optional<String> getPlayCategory() {
        return Optional.ofNullable(playCategory);
    }

    public Optional<SrNflV7PlayByPlayPlayer> getPlayer() {
        return Optional.ofNullable(player);
    }

    public Optional<Double> getPocketTime() {
        return Optional.ofNullable(pocketTime);
    }

    public Optional<Integer> getQbHit() {
        return Optional.ofNullable(qbHit);
    }

    public Optional<Integer> getReception() {
        return Optional.ofNullable(reception);
    }

    public Optional<Integer> getSack() {
        return Optional.ofNullable(sack);
    }

    public Optional<Double> getSackYards() {
        return Optional.ofNullable(sackYards);
    }

    public Optional<Integer> getScramble() {
        return Optional.ofNullable(scramble);
    }

    public Optional<Integer> getSquibKick() {
        return Optional.ofNullable(squibKick);
    }

    public Optional<String> getStatType() {
        return Optional.ofNullable(statType);
    }

    public Optional<Integer> getTackle() {
        return Optional.ofNullable(tackle);
    }

    public Optional<Integer> getTarget() {
        return Optional.ofNullable(target);
    }

    public Optional<SrNflV7PlayByPlayTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getTlost() {
        return Optional.ofNullable(tlost);
    }

    public Optional<Integer> getTlostYards() {
        return Optional.ofNullable(tlostYards);
    }

    public Optional<Integer> getTouchback() {
        return Optional.ofNullable(touchback);
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

package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7GameStatisticsPlayer_8 {
    @JsonProperty("ez_rec_tds")
    private Integer ezRecTds;

    @JsonProperty("forced_fumbles")
    private Integer forcedFumbles;

    @JsonProperty("fumbles")
    private Integer fumbles;

    @JsonProperty("id")
    private String id;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("lost_fumbles")
    private Integer lostFumbles;

    @JsonProperty("name")
    private String name;

    @JsonProperty("opp_rec")
    private Integer oppRec;

    @JsonProperty("opp_rec_tds")
    private Integer oppRecTds;

    @JsonProperty("opp_rec_yards")
    private Integer oppRecYards;

    @JsonProperty("out_of_bounds")
    private Integer outOfBounds;

    @JsonProperty("own_rec")
    private Integer ownRec;

    @JsonProperty("own_rec_tds")
    private Integer ownRecTds;

    @JsonProperty("own_rec_yards")
    private Integer ownRecYards;

    @JsonProperty("position")
    private String position;

    @JsonProperty("sr_id")
    private String srId;

    public Optional<Integer> getEzRecTds() {
        return Optional.ofNullable(ezRecTds);
    }

    public Optional<Integer> getForcedFumbles() {
        return Optional.ofNullable(forcedFumbles);
    }

    public Optional<Integer> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<Integer> getLostFumbles() {
        return Optional.ofNullable(lostFumbles);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getOppRec() {
        return Optional.ofNullable(oppRec);
    }

    public Optional<Integer> getOppRecTds() {
        return Optional.ofNullable(oppRecTds);
    }

    public Optional<Integer> getOppRecYards() {
        return Optional.ofNullable(oppRecYards);
    }

    public Optional<Integer> getOutOfBounds() {
        return Optional.ofNullable(outOfBounds);
    }

    public Optional<Integer> getOwnRec() {
        return Optional.ofNullable(ownRec);
    }

    public Optional<Integer> getOwnRecTds() {
        return Optional.ofNullable(ownRecTds);
    }

    public Optional<Integer> getOwnRecYards() {
        return Optional.ofNullable(ownRecYards);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }
}

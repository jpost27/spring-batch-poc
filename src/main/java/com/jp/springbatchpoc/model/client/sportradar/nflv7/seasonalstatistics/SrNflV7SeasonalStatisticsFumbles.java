package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

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
public class SrNflV7SeasonalStatisticsFumbles {
    @JsonProperty("ez_rec_tds")
    private Integer ezRecTds;

    @JsonProperty("forced_fumbles")
    private Integer forcedFumbles;

    @JsonProperty("fumbles")
    private Integer fumbles;

    @JsonProperty("lost_fumbles")
    private Integer lostFumbles;

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

    public Optional<Integer> getEzRecTds() {
        return Optional.ofNullable(ezRecTds);
    }

    public Optional<Integer> getForcedFumbles() {
        return Optional.ofNullable(forcedFumbles);
    }

    public Optional<Integer> getFumbles() {
        return Optional.ofNullable(fumbles);
    }

    public Optional<Integer> getLostFumbles() {
        return Optional.ofNullable(lostFumbles);
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
}

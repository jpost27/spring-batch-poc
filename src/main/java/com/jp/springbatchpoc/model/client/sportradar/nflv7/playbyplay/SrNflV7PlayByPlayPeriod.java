package com.jp.springbatchpoc.model.client.sportradar.nflv7.playbyplay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7PlayByPlayPeriod {
    @JsonProperty("coin_toss")
    private SrNflV7PlayByPlayCoinToss coinToss;

    @JsonProperty("id")
    private String id;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("pbp")
    private List<SrNflV7PlayByPlayPbp> pbp;

    @JsonProperty("period_type")
    private String periodType;

    @JsonProperty("scoring")
    private SrNflV7PlayByPlayScoring scoring;

    @JsonProperty("sequence")
    private Integer sequence;

    public Optional<SrNflV7PlayByPlayCoinToss> getCoinToss() {
        return Optional.ofNullable(coinToss);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getNumber() {
        return Optional.ofNullable(number);
    }

    public List<SrNflV7PlayByPlayPbp> getPbp() {
        return Optional.ofNullable(pbp).orElse(Collections.emptyList());
    }

    public Optional<String> getPeriodType() {
        return Optional.ofNullable(periodType);
    }

    public Optional<SrNflV7PlayByPlayScoring> getScoring() {
        return Optional.ofNullable(scoring);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }
}

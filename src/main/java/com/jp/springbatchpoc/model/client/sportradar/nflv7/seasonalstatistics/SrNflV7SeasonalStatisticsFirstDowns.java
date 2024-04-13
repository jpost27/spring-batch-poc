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
public class SrNflV7SeasonalStatisticsFirstDowns {
    @JsonProperty("pass")
    private Integer pass;

    @JsonProperty("penalty")
    private Integer penalty;

    @JsonProperty("rush")
    private Integer rush;

    @JsonProperty("total")
    private Integer total;

    public Optional<Integer> getPass() {
        return Optional.ofNullable(pass);
    }

    public Optional<Integer> getPenalty() {
        return Optional.ofNullable(penalty);
    }

    public Optional<Integer> getRush() {
        return Optional.ofNullable(rush);
    }

    public Optional<Integer> getTotal() {
        return Optional.ofNullable(total);
    }
}

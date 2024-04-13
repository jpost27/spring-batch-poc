package com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings;

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
public class SrNflV7PostgameStandingsRank {
    @JsonProperty("clinched")
    private String clinched;

    @JsonProperty("conference")
    private Integer conference;

    @JsonProperty("division")
    private Integer division;

    public Optional<String> getClinched() {
        return Optional.ofNullable(clinched);
    }

    public Optional<Integer> getConference() {
        return Optional.ofNullable(conference);
    }

    public Optional<Integer> getDivision() {
        return Optional.ofNullable(division);
    }
}

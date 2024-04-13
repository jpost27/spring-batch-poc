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
public class SrNflV7PlayerProfileDraft {
    @JsonProperty("number")
    private Integer number;

    @JsonProperty("round")
    private Integer round;

    @JsonProperty("team")
    private SrNflV7PlayerProfileTeam team;

    @JsonProperty("year")
    private Integer year;

    public Optional<Integer> getNumber() {
        return Optional.ofNullable(number);
    }

    public Optional<Integer> getRound() {
        return Optional.ofNullable(round);
    }

    public Optional<SrNflV7PlayerProfileTeam> getTeam() {
        return Optional.ofNullable(team);
    }

    public Optional<Integer> getYear() {
        return Optional.ofNullable(year);
    }
}

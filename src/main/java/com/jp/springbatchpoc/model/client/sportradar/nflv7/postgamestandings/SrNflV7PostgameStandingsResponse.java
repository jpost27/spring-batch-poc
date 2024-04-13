package com.jp.springbatchpoc.model.client.sportradar.nflv7.postgamestandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7PostgameStandingsResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("conferences")
    private List<SrNflV7PostgameStandingsConference> conferences;

    @JsonProperty("season")
    private SrNflV7PostgameStandingsSeason season;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public List<SrNflV7PostgameStandingsConference> getConferences() {
        return Optional.ofNullable(conferences).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7PostgameStandingsSeason> getSeason() {
        return Optional.ofNullable(season);
    }
}

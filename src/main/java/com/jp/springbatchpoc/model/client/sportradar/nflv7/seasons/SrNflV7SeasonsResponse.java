package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7SeasonsResponse {
    @JsonProperty("league")
    private SrNflV7SeasonsLeague league;

    @JsonProperty("seasons")
    private List<SrNflV7SeasonsSeason> seasons;

    public Optional<SrNflV7SeasonsLeague> getLeague() {
        return Optional.ofNullable(league);
    }

    public List<SrNflV7SeasonsSeason> getSeasons() {
        return Optional.ofNullable(seasons).orElse(Collections.emptyList());
    }
}

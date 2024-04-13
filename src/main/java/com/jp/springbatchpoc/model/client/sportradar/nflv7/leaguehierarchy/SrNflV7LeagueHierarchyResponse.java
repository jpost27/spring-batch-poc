package com.jp.springbatchpoc.model.client.sportradar.nflv7.leaguehierarchy;

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
public class SrNflV7LeagueHierarchyResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("conferences")
    private List<SrNflV7LeagueHierarchyConference> conferences;

    @JsonProperty("league")
    private SrNflV7LeagueHierarchyLeague league;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public List<SrNflV7LeagueHierarchyConference> getConferences() {
        return Optional.ofNullable(conferences).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7LeagueHierarchyLeague> getLeague() {
        return Optional.ofNullable(league);
    }
}

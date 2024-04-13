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
public class SrNflV7LeagueHierarchyConference {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("divisions")
    private List<SrNflV7LeagueHierarchyDivision> divisions;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public List<SrNflV7LeagueHierarchyDivision> getDivisions() {
        return Optional.ofNullable(divisions).orElse(Collections.emptyList());
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}

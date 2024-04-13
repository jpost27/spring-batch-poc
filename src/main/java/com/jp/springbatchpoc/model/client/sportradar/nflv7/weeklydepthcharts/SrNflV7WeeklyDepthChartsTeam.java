package com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklydepthcharts;

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
public class SrNflV7WeeklyDepthChartsTeam {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("defense")
    private List<SrNflV7WeeklyDepthChartsDefense> defense;

    @JsonProperty("id")
    private String id;

    @JsonProperty("market")
    private String market;

    @JsonProperty("name")
    private String name;

    @JsonProperty("offense")
    private List<SrNflV7WeeklyDepthChartsOffense> offense;

    @JsonProperty("special_teams")
    private List<SrNflV7WeeklyDepthChartsSpecialTeam> specialTeams;

    @JsonProperty("sr_id")
    private String srId;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public List<SrNflV7WeeklyDepthChartsDefense> getDefense() {
        return Optional.ofNullable(defense).orElse(Collections.emptyList());
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getMarket() {
        return Optional.ofNullable(market);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public List<SrNflV7WeeklyDepthChartsOffense> getOffense() {
        return Optional.ofNullable(offense).orElse(Collections.emptyList());
    }

    public List<SrNflV7WeeklyDepthChartsSpecialTeam> getSpecialTeams() {
        return Optional.ofNullable(specialTeams).orElse(Collections.emptyList());
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }
}

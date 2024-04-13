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
public class SrNflV7WeeklyDepthChartsResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("season")
    private SrNflV7WeeklyDepthChartsSeason season;

    @JsonProperty("teams")
    private List<SrNflV7WeeklyDepthChartsTeam> teams;

    @JsonProperty("week")
    private SrNflV7WeeklyDepthChartsWeek week;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<SrNflV7WeeklyDepthChartsSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public List<SrNflV7WeeklyDepthChartsTeam> getTeams() {
        return Optional.ofNullable(teams).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7WeeklyDepthChartsWeek> getWeek() {
        return Optional.ofNullable(week);
    }
}

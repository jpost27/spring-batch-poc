package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentseasonschedule;

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
public class SrNflV7CurrentSeasonScheduleResponse {
    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("season")
    private SrNflV7CurrentSeasonScheduleSeason season;

    @JsonProperty("weeks")
    private List<SrNflV7CurrentSeasonScheduleWeek> weeks;

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<SrNflV7CurrentSeasonScheduleSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public List<SrNflV7CurrentSeasonScheduleWeek> getWeeks() {
        return Optional.ofNullable(weeks).orElse(Collections.emptyList());
    }
}

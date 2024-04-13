package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentweekschedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
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
public class SrNflV7CurrentWeekScheduleWeek {
    @JsonProperty("games")
    private List<SrNflV7CurrentWeekScheduleGame> games;

    @JsonProperty("id")
    private String id;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("title")
    private String title;

    public List<SrNflV7CurrentWeekScheduleGame> getGames() {
        return Optional.ofNullable(games).orElse(Collections.emptyList());
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Integer> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<String> getTitle() {
        return Optional.ofNullable(title);
    }
}

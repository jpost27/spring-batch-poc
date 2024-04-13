package com.jp.springbatchpoc.model.client.sportradar.nflv7.seasonalstatistics;

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
public class SrNflV7SeasonalStatisticsResponse {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("id")
    private String id;

    @JsonProperty("market")
    private String market;

    @JsonProperty("name")
    private String name;

    @JsonProperty("opponents")
    private SrNflV7SeasonalStatisticsOpponents opponents;

    @JsonProperty("players")
    private List<SrNflV7SeasonalStatisticsPlayer> players;

    @JsonProperty("record")
    private SrNflV7SeasonalStatisticsRecord record;

    @JsonProperty("season")
    private SrNflV7SeasonalStatisticsSeason season;

    @JsonProperty("sr_id")
    private String srId;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
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

    public Optional<SrNflV7SeasonalStatisticsOpponents> getOpponents() {
        return Optional.ofNullable(opponents);
    }

    public List<SrNflV7SeasonalStatisticsPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public Optional<SrNflV7SeasonalStatisticsRecord> getRecord() {
        return Optional.ofNullable(record);
    }

    public Optional<SrNflV7SeasonalStatisticsSeason> getSeason() {
        return Optional.ofNullable(season);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }
}

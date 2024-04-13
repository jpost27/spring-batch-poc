package com.jp.springbatchpoc.model.client.sportradar.nflv7.gamestatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Integer;
import java.lang.String;
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
public class SrNflV7GameStatisticsHome {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("id")
    private String id;

    @JsonProperty("market")
    private String market;

    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private Integer points;

    @JsonProperty("record")
    private SrNflV7GameStatisticsRecord record;

    @JsonProperty("remaining_challenges")
    private Integer remainingChallenges;

    @JsonProperty("remaining_timeouts")
    private Integer remainingTimeouts;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("used_challenges")
    private Integer usedChallenges;

    @JsonProperty("used_timeouts")
    private Integer usedTimeouts;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
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

    public Optional<Integer> getPoints() {
        return Optional.ofNullable(points);
    }

    public Optional<SrNflV7GameStatisticsRecord> getRecord() {
        return Optional.ofNullable(record);
    }

    public Optional<Integer> getRemainingChallenges() {
        return Optional.ofNullable(remainingChallenges);
    }

    public Optional<Integer> getRemainingTimeouts() {
        return Optional.ofNullable(remainingTimeouts);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<Integer> getUsedChallenges() {
        return Optional.ofNullable(usedChallenges);
    }

    public Optional<Integer> getUsedTimeouts() {
        return Optional.ofNullable(usedTimeouts);
    }
}

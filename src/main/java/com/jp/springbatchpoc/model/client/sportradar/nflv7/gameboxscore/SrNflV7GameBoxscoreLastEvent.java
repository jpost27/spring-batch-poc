package com.jp.springbatchpoc.model.client.sportradar.nflv7.gameboxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7GameBoxscoreLastEvent {
    @JsonProperty("clock")
    private String clock;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("description")
    private String description;

    @JsonProperty("event_type")
    private String eventType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("sequence")
    private Double sequence;

    @JsonProperty("type")
    private String type;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("wall_clock")
    private String wallClock;

    public Optional<String> getClock() {
        return Optional.ofNullable(clock);
    }

    public Optional<String> getCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public Optional<String> getEventType() {
        return Optional.ofNullable(eventType);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Double> getSequence() {
        return Optional.ofNullable(sequence);
    }

    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }

    public Optional<String> getUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public Optional<String> getWallClock() {
        return Optional.ofNullable(wallClock);
    }
}

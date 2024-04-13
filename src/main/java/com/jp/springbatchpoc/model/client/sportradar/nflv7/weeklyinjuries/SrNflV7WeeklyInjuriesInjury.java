package com.jp.springbatchpoc.model.client.sportradar.nflv7.weeklyinjuries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SrNflV7WeeklyInjuriesInjury {
    @JsonProperty("practice")
    private SrNflV7WeeklyInjuriesPractice practice;

    @JsonProperty("primary")
    private String primary;

    @JsonProperty("secondary")
    private String secondary;

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_date")
    private String statusDate;

    public Optional<SrNflV7WeeklyInjuriesPractice> getPractice() {
        return Optional.ofNullable(practice);
    }

    public Optional<String> getPrimary() {
        return Optional.ofNullable(primary);
    }

    public Optional<String> getSecondary() {
        return Optional.ofNullable(secondary);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<String> getStatusDate() {
        return Optional.ofNullable(statusDate);
    }
}

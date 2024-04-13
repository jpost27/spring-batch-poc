package com.jp.springbatchpoc.model.client.sportradar.nflv7.topprospects;

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
public class SrNflV7TopProspectsDraft {
    @JsonProperty("broadcast")
    private SrNflV7TopProspectsBroadcast broadcast;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("id")
    private String id;

    @JsonProperty("league")
    private SrNflV7TopProspectsLeague league;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("venue")
    private SrNflV7TopProspectsVenue venue;

    @JsonProperty("year")
    private Integer year;

    public Optional<SrNflV7TopProspectsBroadcast> getBroadcast() {
        return Optional.ofNullable(broadcast);
    }

    public Optional<String> getEndDate() {
        return Optional.ofNullable(endDate);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7TopProspectsLeague> getLeague() {
        return Optional.ofNullable(league);
    }

    public Optional<String> getStartDate() {
        return Optional.ofNullable(startDate);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<SrNflV7TopProspectsVenue> getVenue() {
        return Optional.ofNullable(venue);
    }

    public Optional<Integer> getYear() {
        return Optional.ofNullable(year);
    }
}

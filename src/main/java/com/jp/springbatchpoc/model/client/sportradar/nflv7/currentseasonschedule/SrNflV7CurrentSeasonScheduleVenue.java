package com.jp.springbatchpoc.model.client.sportradar.nflv7.currentseasonschedule;

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
public class SrNflV7CurrentSeasonScheduleVenue {
    @JsonProperty("address")
    private String address;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("id")
    private String id;

    @JsonProperty("location")
    private SrNflV7CurrentSeasonScheduleLocation location;

    @JsonProperty("name")
    private String name;

    @JsonProperty("roof_type")
    private String roofType;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("state")
    private String state;

    @JsonProperty("surface")
    private String surface;

    @JsonProperty("zip")
    private String zip;

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<Integer> getCapacity() {
        return Optional.ofNullable(capacity);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<SrNflV7CurrentSeasonScheduleLocation> getLocation() {
        return Optional.ofNullable(location);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getRoofType() {
        return Optional.ofNullable(roofType);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getState() {
        return Optional.ofNullable(state);
    }

    public Optional<String> getSurface() {
        return Optional.ofNullable(surface);
    }

    public Optional<String> getZip() {
        return Optional.ofNullable(zip);
    }
}

package com.jp.springbatchpoc.model.client.sportradar.nflv7.teamprofile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
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
public class SrNflV7TeamProfilePlayer {
    @JsonProperty("abbr_name")
    private String abbrName;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("birth_place")
    private String birthPlace;

    @JsonProperty("college")
    private String college;

    @JsonProperty("college_conf")
    private String collegeConf;

    @JsonProperty("draft")
    private SrNflV7TeamProfileDraft draft;

    @JsonProperty("experience")
    private Integer experience;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("high_school")
    private String highSchool;

    @JsonProperty("id")
    private String id;

    @JsonProperty("jersey")
    private String jersey;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("name_suffix")
    private String nameSuffix;

    @JsonProperty("position")
    private String position;

    @JsonProperty("rookie_year")
    private Integer rookieYear;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("weight")
    private Double weight;

    public Optional<String> getAbbrName() {
        return Optional.ofNullable(abbrName);
    }

    public Optional<String> getBirthDate() {
        return Optional.ofNullable(birthDate);
    }

    public Optional<String> getBirthPlace() {
        return Optional.ofNullable(birthPlace);
    }

    public Optional<String> getCollege() {
        return Optional.ofNullable(college);
    }

    public Optional<String> getCollegeConf() {
        return Optional.ofNullable(collegeConf);
    }

    public Optional<SrNflV7TeamProfileDraft> getDraft() {
        return Optional.ofNullable(draft);
    }

    public Optional<Integer> getExperience() {
        return Optional.ofNullable(experience);
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<Integer> getHeight() {
        return Optional.ofNullable(height);
    }

    public Optional<String> getHighSchool() {
        return Optional.ofNullable(highSchool);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getJersey() {
        return Optional.ofNullable(jersey);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getNameSuffix() {
        return Optional.ofNullable(nameSuffix);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Integer> getRookieYear() {
        return Optional.ofNullable(rookieYear);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<Double> getWeight() {
        return Optional.ofNullable(weight);
    }
}

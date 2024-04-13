package com.jp.springbatchpoc.model.client.sportradar.nflv7.draftsummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
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
public class SrNflV7DraftSummaryProspect {
    @JsonProperty("birth_place")
    private String birthPlace;

    @JsonProperty("experience")
    private String experience;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("id")
    private String id;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("league_id")
    private String leagueId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("source_id")
    private String sourceId;

    @JsonProperty("team_name")
    private String teamName;

    @JsonProperty("top_prospect")
    private Boolean topProspect;

    @JsonProperty("weight")
    private Integer weight;

    public Optional<String> getBirthPlace() {
        return Optional.ofNullable(birthPlace);
    }

    public Optional<String> getExperience() {
        return Optional.ofNullable(experience);
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public Optional<Integer> getHeight() {
        return Optional.ofNullable(height);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public Optional<String> getLeagueId() {
        return Optional.ofNullable(leagueId);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<String> getSourceId() {
        return Optional.ofNullable(sourceId);
    }

    public Optional<String> getTeamName() {
        return Optional.ofNullable(teamName);
    }

    public Optional<Boolean> getTopProspect() {
        return Optional.ofNullable(topProspect);
    }

    public Optional<Integer> getWeight() {
        return Optional.ofNullable(weight);
    }
}

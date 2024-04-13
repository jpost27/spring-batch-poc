package com.jp.springbatchpoc.model.client.sportradar.nflv7.teamroster;

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
public class SrNflV7TeamRosterResponse {
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("championship_seasons")
    private String championshipSeasons;

    @JsonProperty("championships_won")
    private Integer championshipsWon;

    @JsonProperty("coaches")
    private List<SrNflV7TeamRosterCoach> coaches;

    @JsonProperty("_comment")
    private String comment;

    @JsonProperty("conference")
    private SrNflV7TeamRosterConference conference;

    @JsonProperty("conference_titles")
    private Integer conferenceTitles;

    @JsonProperty("division")
    private SrNflV7TeamRosterDivision division;

    @JsonProperty("division_titles")
    private Integer divisionTitles;

    @JsonProperty("fight_song")
    private String fightSong;

    @JsonProperty("founded")
    private Integer founded;

    @JsonProperty("franchise")
    private SrNflV7TeamRosterFranchise franchise;

    @JsonProperty("general_manager")
    private String generalManager;

    @JsonProperty("id")
    private String id;

    @JsonProperty("market")
    private String market;

    @JsonProperty("mascot")
    private String mascot;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nicknames")
    private String nicknames;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("players")
    private List<SrNflV7TeamRosterPlayer> players;

    @JsonProperty("playoff_appearances")
    private Integer playoffAppearances;

    @JsonProperty("president")
    private String president;

    @JsonProperty("sr_id")
    private String srId;

    @JsonProperty("venue")
    private SrNflV7TeamRosterVenue venue;

    public Optional<String> getAlias() {
        return Optional.ofNullable(alias);
    }

    public Optional<String> getChampionshipSeasons() {
        return Optional.ofNullable(championshipSeasons);
    }

    public Optional<Integer> getChampionshipsWon() {
        return Optional.ofNullable(championshipsWon);
    }

    public List<SrNflV7TeamRosterCoach> getCoaches() {
        return Optional.ofNullable(coaches).orElse(Collections.emptyList());
    }

    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public Optional<SrNflV7TeamRosterConference> getConference() {
        return Optional.ofNullable(conference);
    }

    public Optional<Integer> getConferenceTitles() {
        return Optional.ofNullable(conferenceTitles);
    }

    public Optional<SrNflV7TeamRosterDivision> getDivision() {
        return Optional.ofNullable(division);
    }

    public Optional<Integer> getDivisionTitles() {
        return Optional.ofNullable(divisionTitles);
    }

    public Optional<String> getFightSong() {
        return Optional.ofNullable(fightSong);
    }

    public Optional<Integer> getFounded() {
        return Optional.ofNullable(founded);
    }

    public Optional<SrNflV7TeamRosterFranchise> getFranchise() {
        return Optional.ofNullable(franchise);
    }

    public Optional<String> getGeneralManager() {
        return Optional.ofNullable(generalManager);
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<String> getMarket() {
        return Optional.ofNullable(market);
    }

    public Optional<String> getMascot() {
        return Optional.ofNullable(mascot);
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<String> getNicknames() {
        return Optional.ofNullable(nicknames);
    }

    public Optional<String> getOwner() {
        return Optional.ofNullable(owner);
    }

    public List<SrNflV7TeamRosterPlayer> getPlayers() {
        return Optional.ofNullable(players).orElse(Collections.emptyList());
    }

    public Optional<Integer> getPlayoffAppearances() {
        return Optional.ofNullable(playoffAppearances);
    }

    public Optional<String> getPresident() {
        return Optional.ofNullable(president);
    }

    public Optional<String> getSrId() {
        return Optional.ofNullable(srId);
    }

    public Optional<SrNflV7TeamRosterVenue> getVenue() {
        return Optional.ofNullable(venue);
    }
}

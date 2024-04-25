package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "team_provider_ids")
public class TeamProviderId {
    @Id
    @Column(name = "team_id")
    private Integer teamId;
    @Column(name = "fanduel_team_id", unique = true)
    private Integer fanduelTeamId;
    @Column(name = "sportradar_team_id", unique = true)
    private String sportradarTeamId;
    @Column(name = "numberfire_team_id")
    private Integer numberfireTeamId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teamProviderIds", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TeamSportsbookSelectionId> sportsbookSelectionIds;
    @OneToOne
    @MapsId
    @JoinColumn(name = "team_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Team team;
}

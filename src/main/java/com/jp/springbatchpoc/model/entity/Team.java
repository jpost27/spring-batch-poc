package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "teams")
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private League league;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "market")
    private String market;

    @Column(name = "year_founded")
    private Integer yearFounded;

    @Column(name = "owner")
    private String owner;

    @OneToOne(mappedBy = "team", optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private TeamProviderId teamProviderIds;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "team_team_associations",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "team_association_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TeamAssociation> teamAssociations;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "team")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TeamColor> teamColors;

    @ManyToOne
    @JoinColumn(name = "primary_venue_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Venue primaryVenue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Competitor> competitors;
}

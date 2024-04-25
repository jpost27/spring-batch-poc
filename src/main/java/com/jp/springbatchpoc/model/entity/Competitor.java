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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "competitors")
public class Competitor {

    @Id
    @Column(name = "competitor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer competitorId;
    @ManyToOne
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team team;
    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private League league;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "uniform_identifier")
    private String uniformIdentifier;
    @ManyToOne
    @JoinColumn(name = "injury_status_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private InjuryStatus injuryStatus;
    @ManyToOne
    @JoinColumn(name = "competitor_status_code")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CompetitorStatus competitorStatus;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "height_in_inches")
    private Integer heightInInches;
    @Column(name = "weight_in_pounds")
    private Integer weightInPounds;
    @Column(name = "college")
    private String college;
    @Column(name = "high_school")
    private String highSchool;
    @OneToOne(mappedBy = "competitor", optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private CompetitorProviderId competitorProviderIds;

    @ManyToMany
    @JoinTable(
            name = "competitors_positions",
            joinColumns = @JoinColumn(name = "competitor_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "sport_position_code"),
                    @JoinColumn(name = "sport_id")
            })
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SportPosition> positions;

}

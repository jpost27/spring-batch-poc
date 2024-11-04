package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "leagues")
public class League {

    @Id
    @Column(name = "league_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer leagueId;

    @Column(name = "abbreviated_name", nullable = false)
    private String abbreviatedName;

    @Column(name = "full_name", unique = true, nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Sport sport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "league")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Season> seasons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "league")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Team> teams;
}

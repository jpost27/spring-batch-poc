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
@Entity(name = "competitor_provider_ids")
public class CompetitorProviderId {
    @Id
    @Column(name = "competitor_id")
    private Integer competitorId;
    @Column(name = "fanduel_competitor_id", unique = true)
    private Integer fanduelCompetitorId;
    @Column(name = "sportradar_competitor_id", unique = true)
    private String sportradarCompetitorId;
    @Column(name = "numberfire_competitor_id")
    private Integer numberfireCompetitorId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "competitorProviderIds", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<CompetitorSportsbookSelectionId> sportsbookSelectionIds;
    @OneToOne
    @MapsId
    @JoinColumn(name = "competitor_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Competitor competitor;
}

package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Entity(name = "competitors_events")
@Table(
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "Unique competitor event connection",
                    columnNames = {"competitor_id", "event_id", "team_id"})
        })
public class CompetitorsEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "competitors_events_id")
    private Integer competitorsEventsId;

    //    @Column(name = "competitor_id", nullable = false)
    //    private Integer competitorId;
    //
    //    @Column(name = "event_id", nullable = false)
    //    private Integer eventId;
    //
    //    @Column(name = "team_id")
    //    private Integer teamId;

    @ManyToOne
    @JoinColumn(name = "competitor_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Competitor competitor;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Event event;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team team;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "competitorsEvents", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CompetitorEventStatistics> competitorEventStatistics;
}

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
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "events")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Season season;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_status_code", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EventStatus eventStatus;

    @Column(name = "scheduled_time", nullable = false)
    private LocalDateTime scheduledTime;

    @OneToOne(mappedBy = "event", optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private EventProviderId eventProviderId;

    @Column(name = "home_team_score")
    private Integer homeTeamScore;

    @Column(name = "away_team_score")
    private Integer awayTeamScore;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "event_title")
    private String eventTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team awayTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Venue venue;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_event_associations",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "event_association_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<EventAssociation> eventAssociations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CompetitorsEvents> competitorsEvents;
}

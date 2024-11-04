package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event_provider_ids")
public class EventProviderId {
    @Id
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "fanduel_event_id")
    private Integer fanduelEventId;

    @Column(name = "sportradar_event_id")
    private String sportradarEventId;

    @Column(name = "numberfire_event_id")
    private Integer numberfireEventId;

    @Column(name = "sportsbook_event_id")
    private Integer sportsbookEventId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "event_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Event event;
}

package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import java.math.BigDecimal;
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
@IdClass(CompetitorEventStatisticsId.class)
@Entity(name = "competitor_event_statistics")
public class CompetitorEventStatistics {

    @Id
    @Column(name = "competitors_events_id", nullable = false)
    private Integer competitorsEventsId;

    @Id
    @Column(name = "statistic_type_code", nullable = false)
    private String statisticTypeCode;

    @Column(name = "statistic_value", nullable = false)
    private BigDecimal statisticValue;

    @ManyToOne
    @MapsId("competitorsEventsId")
    @JoinColumn(name = "competitors_events_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CompetitorsEvents competitorsEvents;
}

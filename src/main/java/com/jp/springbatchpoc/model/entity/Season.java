package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "seasons")
@Table(
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "Unique year, league, and season type",
                    columnNames = {"year", "league_id", "season_type_code"})
        })
public class Season {

    @Id
    @Column(name = "season_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seasonId;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private League league;

    @ManyToOne
    @JoinColumn(name = "season_type_code", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private SeasonType seasonType;
}

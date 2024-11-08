package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "sports")
public class Sport implements Serializable {
    @Id
    @Column(name = "sport_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sportId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sport")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<League> leagues;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sport")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<SportPosition> sportPositions;
}

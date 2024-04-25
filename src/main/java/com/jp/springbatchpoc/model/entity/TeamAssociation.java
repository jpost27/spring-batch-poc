package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "team_associations")
public class TeamAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_association_id")
    private Integer teamAssociationId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "team_association_type_code", nullable = false)
    private TeamAssociationType teamAssociationType;
    @Column(name = "name", unique = true)
    private String name; // National Football Conference
    @Column(name = "short_name")
    private String shortName; // NFC
    @ManyToMany(mappedBy = "teamAssociations")
    private List<Team> teams;
}

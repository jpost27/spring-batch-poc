package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity(name = "team_color_types")
public class TeamColorType {
    @Id
    @Column(name = "team_color_type_code")
    private String teamColorTypeCode; // PRIMARY, SECONDARY, etc

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamColorType")
    private List<TeamColor> teamColors;
}

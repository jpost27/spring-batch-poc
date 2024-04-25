package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "team_colors")
public class TeamColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_color_id")
    private Integer teamColorId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "team_color_type_code", nullable = false)
    private TeamColorType teamColorType;

    @Column(name = "hex_color")
    private String hexColor;

    @Column(name = "alpha")
    private Integer alpha;

    @Column(name = "rgb_red")
    private Integer rgbRed;

    @Column(name = "rgb_green")
    private Integer rgbGreen;

    @Column(name = "rgb_blue")
    private Integer rgbBlue;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team team;

}

package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Entity(name = "season_types")
public class SeasonType {

    @Id
    @Column(name = "season_type_code")
    private String seasonTypeCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seasonType")
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Season> seasons;
}

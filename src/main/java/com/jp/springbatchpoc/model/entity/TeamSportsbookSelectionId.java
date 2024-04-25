package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "team_sportsbook_selection_ids")
public class TeamSportsbookSelectionId {
    @Id
    @Column(name = "selection_id")
    private Long selectionId;
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private TeamProviderId teamProviderIds;
}

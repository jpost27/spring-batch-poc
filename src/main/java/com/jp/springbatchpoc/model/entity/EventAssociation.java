package com.jp.springbatchpoc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "event_associations")
public class EventAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_association_id")
    private Integer eventAssociationId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_association_type_code", nullable = false)
    private EventAssociationType eventAssociationType;

    @Column(name = "description", nullable = false, unique = true)
    private String description; // Super Bowl (Championship), Wimbledon (Tournament), Week 1 (Week)

    @ManyToMany(mappedBy = "eventAssociations")
    private List<Event> events;
}

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
@Entity(name = "event_association_types")
public class EventAssociationType {
    @Id
    @Column(name = "event_association_type_code")
    private String eventAssociationTypeCode; // WEEK, TOURNAMENT, CHAMPIONSHIP etc

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventAssociationType")
    private List<EventAssociation> eventAssociations;
}

package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.EventAssociation;
import com.jp.springbatchpoc.model.entity.EventAssociationType;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAssociationRepository extends JPRepository<EventAssociation, Integer> {

    EventAssociation findByEventAssociationTypeAndDescription(
            EventAssociationType eventAssociationType, String description);
}

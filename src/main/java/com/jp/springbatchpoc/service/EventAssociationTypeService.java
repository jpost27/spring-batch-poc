package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.EventAssociationType;
import com.jp.springbatchpoc.model.enums.EventAssociationTypes;
import com.jp.springbatchpoc.repository.EventAssociationTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class EventAssociationTypeService extends CachedEntityService<EventAssociationType> {

    public EventAssociationTypeService(EventAssociationTypeRepository repository) {
        super(repository);
    }

    public EventAssociationType findByType(EventAssociationTypes type) {
        return findAll().stream()
                .filter(eventAssociationType ->
                        eventAssociationType.getEventAssociationTypeCode().equals(type.name()))
                .findFirst()
                .orElse(null);
    }
}

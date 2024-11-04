package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.EventAssociationType;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAssociationTypeRepository extends JPRepository<EventAssociationType, Integer> {}

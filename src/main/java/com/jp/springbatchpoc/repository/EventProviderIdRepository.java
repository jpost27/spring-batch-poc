package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.EventProviderId;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProviderIdRepository extends JPRepository<EventProviderId, Integer> {

    EventProviderId findBySportradarEventId(String sportradarEventId);

    boolean existsBySportradarEventId(String sportradarEventId);
}

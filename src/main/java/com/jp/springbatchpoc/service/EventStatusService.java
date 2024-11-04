package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.EventStatus;
import com.jp.springbatchpoc.repository.EventStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class EventStatusService extends CachedEntityService<EventStatus> {

    public EventStatusService(EventStatusRepository repository) {
        super(repository);
    }
}

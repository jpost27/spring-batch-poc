package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Event;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JPRepository<Event, Integer> {}

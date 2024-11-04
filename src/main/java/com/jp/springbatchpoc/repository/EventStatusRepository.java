package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.EventStatus;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStatusRepository extends JPRepository<EventStatus, String> {}

package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.CompetitorsEvents;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorsEventsRepository extends JPRepository<CompetitorsEvents, Integer> {}

package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Competitor;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorRepository extends JPRepository<Competitor, Integer> {
}

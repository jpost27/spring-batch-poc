package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.League;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JPRepository<League, Integer> {
}

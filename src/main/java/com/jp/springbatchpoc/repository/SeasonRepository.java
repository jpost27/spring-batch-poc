package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Season;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JPRepository<Season, Integer> {}

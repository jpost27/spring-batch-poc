package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.SeasonType;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonTypeRepository extends JPRepository<SeasonType, String> {}

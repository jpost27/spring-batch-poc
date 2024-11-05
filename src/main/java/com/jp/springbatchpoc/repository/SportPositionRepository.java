package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.SportPosition;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportPositionRepository extends JPRepository<SportPosition, String> {}

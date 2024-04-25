package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.TeamColor;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamColorRepository extends JPRepository<TeamColor, Integer> {
}

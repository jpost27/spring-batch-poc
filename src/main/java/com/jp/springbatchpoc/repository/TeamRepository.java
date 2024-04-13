package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Team;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JPRepository<Team, Integer> {
}

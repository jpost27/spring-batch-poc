package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.Sport;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JPRepository<Sport, Integer> {
}

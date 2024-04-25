package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.CompetitorProviderId;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetitorProviderIdRepository extends JPRepository<CompetitorProviderId, Integer> {

    Optional<CompetitorProviderId> findBySportradarCompetitorId(String sportradarCompetitorId);

}

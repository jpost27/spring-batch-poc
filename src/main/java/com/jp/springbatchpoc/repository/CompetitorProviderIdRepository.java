package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.CompetitorProviderId;
import com.jp.springbatchpoc.repository.base.JPRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitorProviderIdRepository extends JPRepository<CompetitorProviderId, Integer> {

    Optional<CompetitorProviderId> findBySportradarCompetitorId(String sportradarCompetitorId);

    Optional<CompetitorProviderId> findByFanduelCompetitorId(Integer sportradarCompetitorId);

    boolean existsBySportradarCompetitorId(String sportradarCompetitorId);

    boolean existsByFanduelCompetitorId(Integer fanduelCompetitorId);
}

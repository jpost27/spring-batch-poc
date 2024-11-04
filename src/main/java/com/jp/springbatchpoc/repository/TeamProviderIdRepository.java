package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.repository.base.JPRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamProviderIdRepository extends JPRepository<TeamProviderId, Integer> {

    Optional<TeamProviderId> findByFanduelTeamId(Integer fanduelTeamId);

    Optional<TeamProviderId> findBySportradarTeamId(String teamId);
}

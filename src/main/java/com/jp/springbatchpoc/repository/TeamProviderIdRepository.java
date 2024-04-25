package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.TeamProviderId;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamProviderIdRepository extends JPRepository<TeamProviderId, Integer> {

    Optional<TeamProviderId> findByFanduelTeamId(Integer fanduelTeamId);

}

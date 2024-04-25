package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.TeamAssociation;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamAssociationRepository extends JPRepository<TeamAssociation, Integer> {

    Optional<TeamAssociation> findByName(String name);

}

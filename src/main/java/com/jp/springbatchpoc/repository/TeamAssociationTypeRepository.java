package com.jp.springbatchpoc.repository;

import com.jp.springbatchpoc.model.entity.TeamAssociationType;
import com.jp.springbatchpoc.repository.base.JPRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamAssociationTypeRepository extends JPRepository<TeamAssociationType, String> {
}

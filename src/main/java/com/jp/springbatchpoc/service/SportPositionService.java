package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.SportPosition;
import com.jp.springbatchpoc.repository.SportPositionRepository;
import org.springframework.stereotype.Service;

@Service
public class SportPositionService extends CachedEntityService<SportPosition> {

    public SportPositionService(SportPositionRepository repository) {
        super(repository);
    }
}

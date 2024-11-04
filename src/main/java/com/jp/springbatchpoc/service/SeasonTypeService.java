package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.SeasonType;
import com.jp.springbatchpoc.repository.SeasonTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonTypeService extends CachedEntityService<SeasonType> {

    public SeasonTypeService(SeasonTypeRepository repository) {
        super(repository);
    }
}

package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.Season;
import com.jp.springbatchpoc.repository.SeasonRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonService extends CachedEntityService<Season> {

    public SeasonService(SeasonRepository repository) {
        super(repository);
    }
}

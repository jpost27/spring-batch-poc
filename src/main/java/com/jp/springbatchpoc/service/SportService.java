package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.model.entity.Sport;
import com.jp.springbatchpoc.repository.SportRepository;
import org.springframework.stereotype.Service;

@Service
public class SportService extends CachedEntityService<Sport> {

    public SportService(SportRepository repository) {
        super(repository);
    }
}

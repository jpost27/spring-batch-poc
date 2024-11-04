package com.jp.springbatchpoc.service;

import com.jp.springbatchpoc.repository.base.JPRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CachedEntityService<E> {

    protected final JPRepository<E, ?> repository;

    protected List<E> cache;

    public synchronized List<E> findAll() {
        if (cache == null || cache.isEmpty()) {
            cache = repository.findAll();
        }
        return cache;
    }
}

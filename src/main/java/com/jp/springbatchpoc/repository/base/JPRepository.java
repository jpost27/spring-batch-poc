package com.jp.springbatchpoc.repository.base;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface JPRepository<T, ID> extends ListCrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}

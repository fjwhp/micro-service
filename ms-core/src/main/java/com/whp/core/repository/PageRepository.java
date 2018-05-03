package com.whp.core.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}

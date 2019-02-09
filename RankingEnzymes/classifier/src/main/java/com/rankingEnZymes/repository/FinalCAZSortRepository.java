package com.rankingEnZymes.repository;
 
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
 
public interface FinalCAZSortRepository extends PagingAndSortingRepository<FinalCAZvType, String> {
	List<FinalCAZvType> findAll(Sort sort);
	 public List<FinalCAZvType> findAll();
}
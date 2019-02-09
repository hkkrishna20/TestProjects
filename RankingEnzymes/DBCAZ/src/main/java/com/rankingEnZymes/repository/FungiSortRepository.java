package com.rankingEnZymes.repository;
 
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rankingEnZymes.model.FungiCAZymes;
 
public interface FungiSortRepository extends PagingAndSortingRepository<FungiCAZymes, String> {
 
}
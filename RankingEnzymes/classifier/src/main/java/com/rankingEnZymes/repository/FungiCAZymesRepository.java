package com.rankingEnZymes.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rankingEnZymes.model.FungiCAZymes;
@Repository
public interface FungiCAZymesRepository extends CrudRepository<FungiCAZymes, String> {

}
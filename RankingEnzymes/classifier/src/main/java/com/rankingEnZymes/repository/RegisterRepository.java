package com.rankingEnZymes.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rankingEnZymes.model.RegisterBean;
@Repository
public interface RegisterRepository extends  CrudRepository<RegisterBean, String> {

}
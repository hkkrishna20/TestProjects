package com.rankingEnZymes.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rankingEnZymes.model.UserBean;
@Repository
public interface LoginRepository extends  CrudRepository<UserBean, Long> {

}
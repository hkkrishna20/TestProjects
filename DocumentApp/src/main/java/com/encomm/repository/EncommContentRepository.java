package com.encomm.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.encomm.models.content.entity.ParaType;
@Repository
public interface EncommContentRepository extends CrudRepository<ParaType, Integer> {

}
package com.operationtool.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.BillableProject;

@Repository
public interface MemberBillDetailsRepository extends CrudRepository<BillableProject, String> {
	long count();

}
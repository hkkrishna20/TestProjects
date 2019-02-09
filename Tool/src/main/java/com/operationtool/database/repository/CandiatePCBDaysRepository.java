package com.operationtool.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.CandidateBillPCBDaysTracker;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTrackerId;

@Repository
public interface CandiatePCBDaysRepository extends CrudRepository<CandidateBillPCBDaysTracker, CandidateBillPCBDaysTrackerId> {
	
	
}
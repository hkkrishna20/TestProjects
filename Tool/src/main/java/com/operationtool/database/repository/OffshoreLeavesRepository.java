package com.operationtool.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.models.entity.ForecastLeaveTrackerId;

@Repository
public interface OffshoreLeavesRepository extends CrudRepository<ForecastLeaveTracker, ForecastLeaveTrackerId> {
	
}
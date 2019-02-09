package com.operationtool.database.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.PCBCalendar;

@Repository
public interface PCBCalendarRepository extends CrudRepository<PCBCalendar, Date> {
	
	
}
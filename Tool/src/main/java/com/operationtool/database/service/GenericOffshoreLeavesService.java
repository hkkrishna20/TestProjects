package com.operationtool.database.service;

import java.util.List;

import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.models.entity.ForecastLeaveTrackerId;

public interface GenericOffshoreLeavesService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<ForecastLeaveTracker> getAll();

	E getById(ForecastLeaveTrackerId id);

	E get(K id);

}
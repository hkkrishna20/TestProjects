package com.operationtool.database.service;

import java.util.List;

import com.operationtool.database.models.entity.CandidateBillPCBDaysTracker;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTrackerId;

public interface GenericCandidateBillPCBDaysService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<CandidateBillPCBDaysTracker> getAll();

	E getById(CandidateBillPCBDaysTrackerId id);

	E get(K id);

}
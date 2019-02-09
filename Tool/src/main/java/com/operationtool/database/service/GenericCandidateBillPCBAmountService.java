package com.operationtool.database.service;

import java.util.List;

import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;

public interface GenericCandidateBillPCBAmountService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<CandidateBillPCBAmountTracker> getAll();

	E getById(CandidateBillPCBAmountTrackerId id);

	E get(K id);

}
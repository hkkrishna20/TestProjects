package com.operationtool.database.service;

import java.util.List;

import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.models.entity.RateCardTrackerId;

public interface GenericRateCardService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<RateCardSystem> getAll();

	E getById(RateCardTrackerId id);

	E get(K id);

}
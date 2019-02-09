package com.rankingEnZymes.service;

import java.util.List;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;


public interface GenericFinalCAZvService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<FinalCAZvType> getAll();

	E getById(String id);

	E get(K id);

}
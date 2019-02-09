package com.rankingEnZymes.service;

import java.util.List;

import com.rankingEnZymes.model.FungiCAZymes;


public interface GenericFungiCAZymesService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<FungiCAZymes> getAll();

	E getById(String id);

	E get(K id);

}
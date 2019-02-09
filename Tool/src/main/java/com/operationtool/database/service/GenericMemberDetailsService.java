package com.operationtool.database.service;

import java.util.List;

import com.operationtool.database.models.entity.BillableProject;

public interface GenericMemberDetailsService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<BillableProject> getAll();

	E getById(String id);

	E get(K id);

}
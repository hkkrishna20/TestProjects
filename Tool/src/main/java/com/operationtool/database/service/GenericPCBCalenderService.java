package com.operationtool.database.service;

import java.util.Date;
import java.util.List;

import com.operationtool.database.models.entity.PCBCalendar;

public interface GenericPCBCalenderService<E, K> {
	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E find(K key);

	public List<PCBCalendar> getAll();

	E getById(Date id);

	E get(K id);

}
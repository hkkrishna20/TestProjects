package com.operationtool.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.PCBCalendar;
import com.operationtool.database.service.GenericPCBCalenderService;


@Service
public abstract class GenericPCBCalenderServiceImpl<E, K> implements GenericPCBCalenderService<E, K> {

	private GenericPCBCalenderService<E, K> genericImplDao;

	public GenericPCBCalenderServiceImpl(GenericPCBCalenderService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericPCBCalenderServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<PCBCalendar> getAll() {
		return genericImplDao.getAll();
	}

	@Override
	@Transactional
	public E get(K id) {
		return genericImplDao.find(id);
	}

	@Override
	@Transactional
	public void add(E entity) {
		genericImplDao.add(entity);
	}

	@Override
	@Transactional
	public void update(E entity) {
		genericImplDao.update(entity);
	}

	@Override
	@Transactional
	public void remove(E entity) {
		genericImplDao.remove(entity);
	}
}
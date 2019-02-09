package com.operationtool.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.service.GenericOffshoreLeavesService;


@Service
public abstract class GenericOffshoreLeavesServiceImpl<E, K> implements  GenericOffshoreLeavesService<E, K> {

	private  GenericOffshoreLeavesService<E, K> genericImplDao;

	public GenericOffshoreLeavesServiceImpl( GenericOffshoreLeavesService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericOffshoreLeavesServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<ForecastLeaveTracker> getAll() {
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
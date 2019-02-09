package com.operationtool.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.service.GenericRateCardService;



@Service
public abstract class GenericRateCardServiceImpl<E, K> implements GenericRateCardService<E, K> {

	private GenericRateCardService<E, K> genericImplDao;

	public GenericRateCardServiceImpl(GenericRateCardService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericRateCardServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<RateCardSystem> getAll() {
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
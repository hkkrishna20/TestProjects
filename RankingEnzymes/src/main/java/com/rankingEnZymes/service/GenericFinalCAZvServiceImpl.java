package com.rankingEnZymes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

@Service
public abstract class GenericFinalCAZvServiceImpl<E, K> implements GenericFinalCAZvService<E, K> {

	private GenericFinalCAZvService<E, K> genericImplDao;

	public GenericFinalCAZvServiceImpl(GenericFinalCAZvService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericFinalCAZvServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<FinalCAZvType> getAll() {
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
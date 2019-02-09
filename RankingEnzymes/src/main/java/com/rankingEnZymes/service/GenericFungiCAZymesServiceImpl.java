package com.rankingEnZymes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rankingEnZymes.model.FungiCAZymes;


@Service
public abstract class GenericFungiCAZymesServiceImpl<E, K> implements GenericFungiCAZymesService<E, K> {

	private GenericFungiCAZymesService<E, K> genericImplDao;

	public GenericFungiCAZymesServiceImpl(GenericFungiCAZymesService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericFungiCAZymesServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<FungiCAZymes> getAll() {
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
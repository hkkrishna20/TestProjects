package com.operationtool.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.BillableProject;
import com.operationtool.database.service.GenericMemberDetailsService;


@Service
public abstract class GenericMemberDetailsServiceImpl<E, K> implements GenericMemberDetailsService<E, K> {

	private GenericMemberDetailsService<E, K> genericImplDao;

	public GenericMemberDetailsServiceImpl(GenericMemberDetailsService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericMemberDetailsServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<BillableProject> getAll() {
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
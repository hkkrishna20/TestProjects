package com.operationtool.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.service.GenericCandidateService;


@Service
public abstract class GenericCandidateServiceImpl<E, K> implements GenericCandidateService<E, K> {

	private GenericCandidateService<E, K> genericImplDao;

	public GenericCandidateServiceImpl(GenericCandidateService<E, K> genericImplDao) {
		this.genericImplDao = genericImplDao;
	}

	public GenericCandidateServiceImpl() {
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericImplDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public List<Candidate> getAll() {
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
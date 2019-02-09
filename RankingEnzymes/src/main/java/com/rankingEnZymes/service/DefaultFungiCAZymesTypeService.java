package com.rankingEnZymes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.repository.FungiCAZymesRepository;


@Service
public class DefaultFungiCAZymesTypeService implements FungiCAZymesService {

	@Autowired
	FungiCAZymesRepository fungiCAZymesTypeRepository;
	
	@Override
	public FungiCAZymes find(String key) {
		return fungiCAZymesTypeRepository.findById(key).get();
	}

	@Override
	public List<FungiCAZymes> getAll() {
		return toList(fungiCAZymesTypeRepository.findAll()) ;
	}
	@Override
	public FungiCAZymes get(String id) {
		return fungiCAZymesTypeRepository.findById(id).get();
	}

	@Override
	public void add(FungiCAZymes entity) {
		fungiCAZymesTypeRepository.save(entity);

	}

	@Override
	public void saveOrUpdate(FungiCAZymes entity) {
		fungiCAZymesTypeRepository.save(entity);

	}

	@Override
	public void update(FungiCAZymes entity) {
		fungiCAZymesTypeRepository.save(entity);
		
	}

	@Override
	public void remove(FungiCAZymes entity) {
		fungiCAZymesTypeRepository.delete(entity);
		
	}

	@Override
	public FungiCAZymes getById(String id) {
		return fungiCAZymesTypeRepository.findById(id).get();
	}
	public static <E> List<E> toList(Iterable<E> iterable) {
	    if(iterable instanceof List) {
	      return (List<E>) iterable;
	    }
	    ArrayList<E> list = new ArrayList<E>();
	    if(iterable != null) {
	      for(E e: iterable) {
	        list.add(e);
	      }
	    }
	    return list;
	  }


	}

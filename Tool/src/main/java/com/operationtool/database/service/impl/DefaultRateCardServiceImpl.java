package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.models.entity.RateCardTrackerId;
import com.operationtool.database.repository.RateCardRepository;
import com.operationtool.database.service.RateCardService;

@Service
public class DefaultRateCardServiceImpl implements RateCardService {

	@Autowired
	RateCardRepository rateCardRepository;

	@Override
	public RateCardSystem find(RateCardTrackerId key) {
		// TODO Auto-generated method stub
		return rateCardRepository.findById(key).get();
	}

	@Override
	public List<RateCardSystem> getAll() {
		// TODO Auto-generated method stub
		return toList(rateCardRepository.findAll());
	}

	public static <E> List<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (List<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}

	@Override
	public RateCardSystem get(RateCardTrackerId id) {
		// TODO Auto-generated method stub
		try {
			return rateCardRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(RateCardSystem entity) {
		// TODO Auto-generated method stub
		rateCardRepository.save(entity);

	}

	@Override
	public void saveOrUpdate(RateCardSystem entity) {
		// TODO Auto-generated method stub
		rateCardRepository.save(entity);

	}

	@Override
	public void update(RateCardSystem entity) {
		// TODO Auto-generated method stub
		rateCardRepository.save(entity);

	}

	@Override
	public void remove(RateCardSystem entity) {
		// TODO Auto-generated method stub
		rateCardRepository.delete(entity);

	}

	@Override
	public RateCardSystem getById(RateCardTrackerId id) {
		// TODO Auto-generated method stub
		return rateCardRepository.findById(id).get();
	}
}

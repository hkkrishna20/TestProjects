package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.models.entity.ForecastLeaveTrackerId;
import com.operationtool.database.repository.OffshoreLeavesRepository;
import com.operationtool.database.service.OffshoreLeavesService;

@Service
public class DefaultOffshoreLeavesServiceImpl implements OffshoreLeavesService {

	@Autowired
	OffshoreLeavesRepository ForecastLeaveTracker;

	@Override
	public ForecastLeaveTracker find(ForecastLeaveTrackerId key) {
		// TODO Auto-generated method stub
		return ForecastLeaveTracker.findById(key).get();
	}

	@Override
	public List<ForecastLeaveTracker> getAll() {
		// TODO Auto-generated method stub
		return toList(ForecastLeaveTracker.findAll());
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
	public ForecastLeaveTracker get(ForecastLeaveTrackerId id) {
		// TODO Auto-generated method stub
		try {
			return ForecastLeaveTracker.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(ForecastLeaveTracker entity) {
		// TODO Auto-generated method stub
		ForecastLeaveTracker.save(entity);

	}

	@Override
	public void saveOrUpdate(ForecastLeaveTracker entity) {
		// TODO Auto-generated method stub
		ForecastLeaveTracker.save(entity);

	}

	@Override
	public void update(ForecastLeaveTracker entity) {
		// TODO Auto-generated method stub
		ForecastLeaveTracker.save(entity);

	}

	@Override
	public void remove(ForecastLeaveTracker entity) {
		// TODO Auto-generated method stub
		ForecastLeaveTracker.delete(entity);

	}

	@Override
	public ForecastLeaveTracker getById(ForecastLeaveTrackerId id) {
		// TODO Auto-generated method stub
		return ForecastLeaveTracker.findById(id).get();
	}
}

package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;
import com.operationtool.database.repository.CandiatePCBAmountRepository;
import com.operationtool.database.service.CandidateBillPCBTrackerService;

@Service
public class DefaultCandidatePCBAmountServiceImpl implements CandidateBillPCBTrackerService {

	@Autowired
	CandiatePCBAmountRepository pcbCalendar;

	@Override
	public CandidateBillPCBAmountTracker find(CandidateBillPCBAmountTrackerId key) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(key).get();
	}

	@Override
	public List<CandidateBillPCBAmountTracker> getAll() {
		// TODO Auto-generated method stub
		return toList(pcbCalendar.findAll());
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
	public CandidateBillPCBAmountTracker get(CandidateBillPCBAmountTrackerId id) {
		// TODO Auto-generated method stub
		try {
			return pcbCalendar.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(CandidateBillPCBAmountTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void saveOrUpdate(CandidateBillPCBAmountTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void update(CandidateBillPCBAmountTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void remove(CandidateBillPCBAmountTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.delete(entity);

	}

	
	@Override
	public CandidateBillPCBAmountTracker getById(CandidateBillPCBAmountTrackerId id) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(id).get();
	}
}

package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.CandidateBillPCBDaysTracker;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTrackerId;
import com.operationtool.database.repository.CandiatePCBDaysRepository;
import com.operationtool.database.service.CandidateBillPCBDaysTrackerService;

@Service
public class DefaultCandidatePCBDaysServiceImpl implements CandidateBillPCBDaysTrackerService {

	@Autowired
	CandiatePCBDaysRepository pcbCalendar;

	@Override
	public CandidateBillPCBDaysTracker find(CandidateBillPCBDaysTrackerId key) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(key).get();
	}

	@Override
	public List<CandidateBillPCBDaysTracker> getAll() {
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
	public CandidateBillPCBDaysTracker get(CandidateBillPCBDaysTrackerId id) {
		// TODO Auto-generated method stub
		try {
			return pcbCalendar.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(CandidateBillPCBDaysTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void saveOrUpdate(CandidateBillPCBDaysTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void update(CandidateBillPCBDaysTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void remove(CandidateBillPCBDaysTracker entity) {
		// TODO Auto-generated method stub
		pcbCalendar.delete(entity);

	}

	
	@Override
	public CandidateBillPCBDaysTracker getById(CandidateBillPCBDaysTrackerId id) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(id).get();
	}
}

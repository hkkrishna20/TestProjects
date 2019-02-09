package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.PCBCalendar;
import com.operationtool.database.repository.PCBCalendarRepository;
import com.operationtool.database.service.PCBCalenderService;

@Service
public class DefaultPCBCalenderServiceImpl implements PCBCalenderService {

	@Autowired
	PCBCalendarRepository pcbCalendar;

	@Override
	public PCBCalendar find(Date key) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(key).get();
	}

	@Override
	public List<PCBCalendar> getAll() {
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
	public PCBCalendar get(Date id) {
		// TODO Auto-generated method stub
		try {
			return pcbCalendar.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(PCBCalendar entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void saveOrUpdate(PCBCalendar entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void update(PCBCalendar entity) {
		// TODO Auto-generated method stub
		pcbCalendar.save(entity);

	}

	@Override
	public void remove(PCBCalendar entity) {
		// TODO Auto-generated method stub
		pcbCalendar.delete(entity);

	}

	@Override
	public PCBCalendar getById(Date id) {
		// TODO Auto-generated method stub
		return pcbCalendar.findById(id).get();
	}
}

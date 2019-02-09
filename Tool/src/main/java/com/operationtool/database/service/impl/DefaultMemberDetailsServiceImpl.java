package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.BillableProject;
import com.operationtool.database.repository.MemberBillDetailsRepository;
import com.operationtool.database.service.MemberDetailsService;

@Service
public class DefaultMemberDetailsServiceImpl implements MemberDetailsService {

	@Autowired
	MemberBillDetailsRepository memberBillRepository;

	@Override
	public BillableProject find(String key) {
		// TODO Auto-generated method stub
		return memberBillRepository.findById(key).get();
	}

	@Override
	public List<BillableProject> getAll() {
		// TODO Auto-generated method stub
		return toList(memberBillRepository.findAll());
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
	public BillableProject get(String id) {
		// TODO Auto-generated method stub
		try {
			return memberBillRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(BillableProject entity) {
		// TODO Auto-generated method stub
		memberBillRepository.save(entity);

	}

	@Override
	public void saveOrUpdate(BillableProject entity) {
		// TODO Auto-generated method stub
		memberBillRepository.save(entity);

	}

	@Override
	public void update(BillableProject entity) {
		// TODO Auto-generated method stub
		memberBillRepository.save(entity);

	}

	@Override
	public void remove(BillableProject entity) {
		// TODO Auto-generated method stub
		memberBillRepository.delete(entity);

	}

	@Override
	public BillableProject getById(String id) {
		// TODO Auto-generated method stub
		return memberBillRepository.findById(id).get();
	}
}

package com.operationtool.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.repository.CandidateSortRepository;


@Service
public class CandidateSortService {

	private final static int PAGESIZE = 100;

	@Autowired
	CandidateSortRepository repository;

	public void save(Candidate response) {
		repository.save(response);
	}

	public List<Candidate> findAllResponse() {
		return repository.findAll();
	}

	
	public List<Candidate> findAll(String orderBy, String val) {
		return repository.findAll(sortById(orderBy, val));
	}

	private Sort sortById(String orderBy, String val) {
		if (orderBy.equals("ASC")) {
			return new Sort(Sort.Direction.ASC, "_"+val);

		} else {
			return new Sort(Sort.Direction.DESC, "_"+val);
		}
	}

	public List<Candidate> getPage(int pageNumber,String orderBy, String val,int pageSize) {
		PageRequest request = null;
		if (orderBy.equals("ASC")) {
			 request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "_"+val);
		} else {
			 request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC,"_"+val);
		}
		return repository.findAll(request).getContent();
	}
	
	public List<Candidate> getPagevalue(int pageNumber,int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "totalEnzymesv");
		return repository.findAll(request).getContent();
	}
}
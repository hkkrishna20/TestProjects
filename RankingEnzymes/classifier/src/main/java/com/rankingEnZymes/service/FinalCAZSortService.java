package com.rankingEnZymes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
import com.rankingEnZymes.repository.FinalCAZSortRepository;

@Service
public class FinalCAZSortService {

	private final static int PAGESIZE = 100;

	@Autowired
	FinalCAZSortRepository repository;

	public void save(FinalCAZvType response) {
		repository.save(response);
	}

	public List<FinalCAZvType> findAllResponse() {
		return repository.findAll();
	}

	
	public List<FinalCAZvType> findAll(String orderBy, String val) {
		return repository.findAll(sortById(orderBy, val));
	}

	private Sort sortById(String orderBy, String val) {
		if (orderBy.equals("ASC")) {
			return new Sort(Sort.Direction.ASC, "_"+val);

		} else {
			return new Sort(Sort.Direction.DESC, "_"+val);
		}
	}

	public List<FinalCAZvType> getPage(int pageNumber,String orderBy, String val,int pageSize) {
		PageRequest request = null;
		if (orderBy.equals("ASC")) {
			 request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "_"+val);
		} else {
			 request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC,"_"+val);
		}
		return repository.findAll(request).getContent();
	}
	
	public List<FinalCAZvType> getPagevalue(int pageNumber,int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.DESC, "totalEnzymesv");
		return repository.findAll(request).getContent();
	}
}
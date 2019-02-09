package com.rankingEnZymes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
import com.rankingEnZymes.repository.FinalCAZSortRepository;
import com.rankingEnZymes.repository.FungiSortRepository;

@Service
public class FungiCAZSortService {
 
	private final static int PAGESIZE = 100;
	
	@Autowired
	FungiSortRepository repository;
	
	public void save(FungiCAZymes customer) {
		repository.save(customer);
	}
	
	public List<FungiCAZymes> findAllC() {
		return (List<FungiCAZymes>)repository.findAll();
	}
	
	public List<FungiCAZymes> getPagegenomeCodeASC(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "genomeCode");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPagegenomeCodeDesc(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE,  Sort.Direction.DESC, "genomeCode");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPageNameASC(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "name");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPageNameDesc(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE,  Sort.Direction.DESC, "name");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPagePublishedASC(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "published");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPagePublishedDesc(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE,  Sort.Direction.DESC, "published");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPageassemblyLengthASC(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE,  Sort.Direction.ASC, "assemblyLength");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPageassemblyLengthDesc(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.DESC, "assemblyLength");
		
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPagegenesASC(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "genes");
		return repository.findAll(request).getContent();
	}
	public List<FungiCAZymes> getPagegenesDesc(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.DESC, "genes");
		
		return repository.findAll(request).getContent();
	}

	public Iterable<FungiCAZymes> findAll(String orderCriteria, String classifer) {
		return repository.findAll(sortById(orderCriteria, classifer));
	}

	private Sort sortById(String orderBy, String val) {
		if (orderBy.equals("ASC")) {
			return new Sort(Sort.Direction.ASC, val);

		} else {
			return new Sort(Sort.Direction.DESC, val);
		}
	}

	
	
	
	
	
}
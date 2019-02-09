package com.operationtool.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.repository.CandidateRepository;
import com.operationtool.database.service.CandidateService;

@Service
public class DefaultCandidateService implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public Candidate find(String key) {
		// TODO Auto-generated method stub
		return candidateRepository.findById(key).get();
	}

	@Override
	public List<Candidate> getAll() {
		// TODO Auto-generated method stub
		return toList(candidateRepository.findAll());
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
	public Candidate get(String id) {
		// TODO Auto-generated method stub
		try {
			return candidateRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public void add(Candidate entity) {
		// TODO Auto-generated method stub
		candidateRepository.save(entity);

	}

	@Override
	public void saveOrUpdate(Candidate entity) {
		// TODO Auto-generated method stub
		candidateRepository.save(entity);

	}

	@Override
	public void update(Candidate entity) {
		// TODO Auto-generated method stub
		candidateRepository.save(entity);

	}

	@Override
	public void remove(Candidate entity) {
		// TODO Auto-generated method stub
		candidateRepository.delete(entity);

	}

	@Override
	public Candidate getById(String id) {
		// TODO Auto-generated method stub
		return candidateRepository.findById(id).get();
	}

	@Override
	public Set<Candidate> findByPyramidaccounthrbu(String string) {
		// TODO Auto-generated method stub
		return candidateRepository.findByPyramidaccounthrbu(string);
	}

	@Override
	public Set<String> findDistinctResourcename(String designation,String pyramidaccounthrbu) {
		// TODO Auto-generated method stub
		return candidateRepository.findDistinctResourcename(designation,pyramidaccounthrbu);
	}

	@Override
	public Set<String> findDistinctDirectordept10inthehrtreeAndPyramidaccounthrbu(String description) {
		// TODO Auto-generated method stub
		
		return candidateRepository.findDistinctDirectordept10inthehrtreeAndPyramidaccounthrbu(description);
	}

	@Override
	public Set<String> findDistinctReportingmanagerAndPyramidaccounthrbu(String dirName, String pyramidaccounthrbu) {
		// TODO Auto-generated method stub
		return candidateRepository.findDistinctReportingmanagerAndPyramidaccounthrbu(dirName,pyramidaccounthrbu);

	}

	@Override
	public Set<String> findDistinctProjectAndPyramidaccounthrbu(String managerNamesList, String pyramidaccounthrbu) {
		// TODO Auto-generated method stub
		return candidateRepository.findDistinctProjectAndPyramidaccounthrbu(managerNamesList, pyramidaccounthrbu);
	}

}

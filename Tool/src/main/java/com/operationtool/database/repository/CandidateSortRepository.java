package com.operationtool.database.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.operationtool.database.models.entity.Candidate;

public interface CandidateSortRepository extends PagingAndSortingRepository<Candidate, String> {
	List<Candidate> findAll(Sort sort);

	public List<Candidate> findAll();
}
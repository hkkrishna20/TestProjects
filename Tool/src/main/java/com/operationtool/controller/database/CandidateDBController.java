package com.operationtool.controller.database;



import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.service.CandidateService;


@RestController
public class CandidateDBController {


	@Autowired
	CandidateService candidateService;

	@RequestMapping(value = "candidate/getPNC", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	
	Set<Candidate> findByPyramidaccounthrbu(){
		return candidateService.findByPyramidaccounthrbu("PNC Bank");
		
	}
	
	
	@RequestMapping(value = "candidate/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Candidate> getAllPosts(Pageable pageable) {

		List<Candidate> metadata = candidateService.getAll();
		if (((List<Candidate>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "candidate/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public Candidate get(@PathVariable("id") String id) {
		Candidate inc = candidateService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "candidate/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody Candidate Candidate) {
		candidateService.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "candidate/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody Candidate Candidate) {
		Candidate inc = candidateService.find(Candidate.getResourceID());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateService.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "candidate/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		Candidate inc = candidateService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
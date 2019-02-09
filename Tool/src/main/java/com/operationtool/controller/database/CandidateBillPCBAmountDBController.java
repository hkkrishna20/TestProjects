package com.operationtool.controller.database;



import java.util.List;

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

import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;
import com.operationtool.database.service.CandidateBillPCBTrackerService;


@RestController
public class CandidateBillPCBAmountDBController {


	@Autowired
	CandidateBillPCBTrackerService candidateBillPCBAmountTracker;

	
	
	@RequestMapping(value = "pcbAmount/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CandidateBillPCBAmountTracker> getAllPosts(Pageable pageable) {

		List<CandidateBillPCBAmountTracker> metadata = candidateBillPCBAmountTracker.getAll();
		if (((List<CandidateBillPCBAmountTracker>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "pcbAmount/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public CandidateBillPCBAmountTracker get(@PathVariable("id") CandidateBillPCBAmountTrackerId id) {
		CandidateBillPCBAmountTracker inc = candidateBillPCBAmountTracker.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "pcbAmount/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody CandidateBillPCBAmountTracker Candidate) {
		candidateBillPCBAmountTracker.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "pcbAmount/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody CandidateBillPCBAmountTracker Candidate) {
		CandidateBillPCBAmountTracker inc = candidateBillPCBAmountTracker.find(Candidate.getId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateBillPCBAmountTracker.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "pcbAmount/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") CandidateBillPCBAmountTrackerId id) {
		CandidateBillPCBAmountTracker inc = candidateBillPCBAmountTracker.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			candidateBillPCBAmountTracker.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
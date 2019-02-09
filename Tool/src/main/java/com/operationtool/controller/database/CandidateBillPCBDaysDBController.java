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

import com.operationtool.database.models.entity.CandidateBillPCBDaysTracker;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTrackerId;
import com.operationtool.database.service.CandidateBillPCBDaysTrackerService;


@RestController
public class CandidateBillPCBDaysDBController {


	@Autowired
	CandidateBillPCBDaysTrackerService CandidateBillPCBDaysTracker;

	
	
	@RequestMapping(value = "pcbDays/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CandidateBillPCBDaysTracker> getAllPosts(Pageable pageable) {

		List<CandidateBillPCBDaysTracker> metadata = CandidateBillPCBDaysTracker.getAll();
		if (((List<CandidateBillPCBDaysTracker>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "pcbDays/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public CandidateBillPCBDaysTracker get(@PathVariable("id") CandidateBillPCBDaysTrackerId id) {
		CandidateBillPCBDaysTracker inc = CandidateBillPCBDaysTracker.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "pcbDays/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody CandidateBillPCBDaysTracker Candidate) {
		CandidateBillPCBDaysTracker.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "pcbDays/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody CandidateBillPCBDaysTracker Candidate) {
		CandidateBillPCBDaysTracker inc = CandidateBillPCBDaysTracker.find(Candidate.getId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			CandidateBillPCBDaysTracker.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "pcbDays/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") CandidateBillPCBDaysTrackerId id) {
		CandidateBillPCBDaysTracker inc = CandidateBillPCBDaysTracker.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			CandidateBillPCBDaysTracker.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
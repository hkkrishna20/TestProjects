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

import com.operationtool.database.models.entity.BillableProject;
import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.service.MemberDetailsService;


@RestController
public class MemberDetailsDBController {


	@Autowired
	MemberDetailsService memberDetailsService;

	
	@RequestMapping(value = "memberDetails/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<BillableProject> getAllPosts(Pageable pageable) {

		List<BillableProject> metadata = memberDetailsService.getAll();
		if (((List<BillableProject>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "memberDetails/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public BillableProject get(@PathVariable("id") String id) {
		BillableProject inc = memberDetailsService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "memberDetails/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody BillableProject Candidate) {
		memberDetailsService.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "memberDetails/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody BillableProject Candidate) {
		BillableProject inc = memberDetailsService.find(Candidate.getResourceId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			memberDetailsService.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "memberDetails/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		BillableProject inc = memberDetailsService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			memberDetailsService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
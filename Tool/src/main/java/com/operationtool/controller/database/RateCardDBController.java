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

import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.models.entity.RateCardTrackerId;
import com.operationtool.database.service.RateCardService;


@RestController
public class RateCardDBController {


	@Autowired
	RateCardService rateCardService;

	
	@RequestMapping(value = "rateCardDetails/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<RateCardSystem> getAllPosts(Pageable pageable) {

		List<RateCardSystem> metadata = rateCardService.getAll();
		if (((List<RateCardSystem>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "rateCardDetails/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public RateCardSystem get(@PathVariable("id") RateCardTrackerId id) {
		RateCardSystem inc = rateCardService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "rateCardDetails/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody RateCardSystem Candidate) {
		rateCardService.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "rateCardDetails/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody RateCardSystem Candidate) {
		RateCardSystem inc = rateCardService.find(Candidate.getId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			rateCardService.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "rateCardDetails/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") RateCardTrackerId id) {
		RateCardSystem inc = rateCardService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			rateCardService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
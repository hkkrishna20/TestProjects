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

import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.models.entity.ForecastLeaveTrackerId;
import com.operationtool.database.service.OffshoreLeavesService;


@RestController
public class OffshoreDetailsDBController {


	@Autowired
	OffshoreLeavesService offshoreLeaveDetailsService;

	
	@RequestMapping(value = "offshoreDetails/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<ForecastLeaveTracker> getAllPosts(Pageable pageable) {

		List<ForecastLeaveTracker> metadata = offshoreLeaveDetailsService.getAll();
		if (((List<ForecastLeaveTracker>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "offshoreDetails/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ForecastLeaveTracker get(@PathVariable("id") ForecastLeaveTrackerId id) {
		ForecastLeaveTracker inc = offshoreLeaveDetailsService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "offshoreDetails/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody ForecastLeaveTracker Candidate) {
		offshoreLeaveDetailsService.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "offshoreDetails/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody ForecastLeaveTracker Candidate) {
		ForecastLeaveTracker inc = offshoreLeaveDetailsService.find(Candidate.getId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			offshoreLeaveDetailsService.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "offshoreDetails/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") ForecastLeaveTrackerId id) {
		ForecastLeaveTracker inc = offshoreLeaveDetailsService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			offshoreLeaveDetailsService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
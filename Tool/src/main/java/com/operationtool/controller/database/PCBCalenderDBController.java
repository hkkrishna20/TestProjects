package com.operationtool.controller.database;



import java.util.Date;
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

import com.operationtool.database.models.entity.PCBCalendar;
import com.operationtool.database.service.PCBCalenderService;


@RestController
public class PCBCalenderDBController {


	@Autowired
	PCBCalenderService pcbCalendarService;

	
	
	@RequestMapping(value = "pcbDetails/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<PCBCalendar> getAllPosts(Pageable pageable) {

		List<PCBCalendar> metadata = pcbCalendarService.getAll();
		if (((List<PCBCalendar>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "pcbDetails/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public PCBCalendar get(@PathVariable("id") Date id) {
		PCBCalendar inc = pcbCalendarService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "pcbDetails/save", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@Valid @RequestBody PCBCalendar Candidate) {
		pcbCalendarService.add(Candidate);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "pcbDetails/update", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@Valid @RequestBody PCBCalendar Candidate) {
		PCBCalendar inc = pcbCalendarService.find(Candidate.getMonth());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			pcbCalendarService.update(Candidate);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "pcbDetails/delete/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deletePost(@PathVariable("id") Date id) {
		PCBCalendar inc = pcbCalendarService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			pcbCalendarService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
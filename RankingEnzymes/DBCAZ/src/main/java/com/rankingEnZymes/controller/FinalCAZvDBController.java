
package com.rankingEnZymes.controller;

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

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
import com.rankingEnZymes.service.FinalCAZvService;

@RestController
public class FinalCAZvDBController {


	@Autowired
	FinalCAZvService finalCAZvService;

	@RequestMapping(value = "finalCAZv/getAll", method = RequestMethod.GET)
	public List<FinalCAZvType> getAllPosts(Pageable pageable) {

		List<com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType> metadata = finalCAZvService.getAll();
		if (((List<FinalCAZvType>) metadata).isEmpty()) {
			return null;
		}
		return  metadata;
	}

	@RequestMapping(value = "finalCAZv/get/{id}", method = RequestMethod.GET)

	public FinalCAZvType get(@PathVariable("id") String id) {
		FinalCAZvType inc = finalCAZvService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "finalCAZv/save", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody FinalCAZvType FinalCAZvType) {
		finalCAZvService.add(FinalCAZvType);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "finalCAZv/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FinalCAZvType FinalCAZvType) {
		FinalCAZvType inc = finalCAZvService.find(FinalCAZvType.getGenomecode());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			finalCAZvService.update(FinalCAZvType);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "finalCAZv/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		FinalCAZvType inc = finalCAZvService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			finalCAZvService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
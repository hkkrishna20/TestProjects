
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

import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.service.FungiCAZymesService;

@RestController
public class FungiDBController {

	@Autowired
	FungiCAZymesService FungiCAZymesService;

	@RequestMapping(value = "fungiCAZymes/getAll", method = RequestMethod.GET)
	public List<FungiCAZymes> getAllPosts(Pageable pageable) {

		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		if (((List<FungiCAZymes>) metadata).isEmpty()) {
			return null;
		}
		return metadata;
	}

	@RequestMapping(value = "fungiCAZymes/get/{id}", method = RequestMethod.GET)

	public FungiCAZymes get(@PathVariable("id") String id) {
		FungiCAZymes inc = FungiCAZymesService.get(id);
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "fungiCAZymes/save", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody FungiCAZymes FungiCAZymes) {
		FungiCAZymesService.add(FungiCAZymes);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "fungiCAZymes/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FungiCAZymes FungiCAZymes) {
		FungiCAZymes inc = FungiCAZymesService.find(FungiCAZymes.getGenomecode());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			FungiCAZymesService.update(FungiCAZymes);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "fungiCAZymes/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		FungiCAZymes inc = FungiCAZymesService.find(id);
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			FungiCAZymesService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
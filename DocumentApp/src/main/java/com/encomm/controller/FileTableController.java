
package com.encomm.controller;

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

import com.encomm.models.content.entity.FileTableType;
import com.encomm.service.EncommContentService;
import com.encomm.service.EncommFileService;

@RestController
@RequestMapping("/fileTable")
public class FileTableController {

	@Autowired
	EncommFileService encommFileTableTypeService;
	@Autowired
	EncommContentService encommContentTypeService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<FileTableType> getAllPosts(Pageable pageable) {

		List<FileTableType> fileTableType = encommFileTableTypeService.getAll();
		if (((List<FileTableType>) fileTableType).isEmpty()) {
			return null;
		}
		return fileTableType;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public FileTableType get(@PathVariable("id") String id) {
		FileTableType inc = encommFileTableTypeService.get(Integer.parseInt(id));
		if (inc == null) {
			return null;
		}
		return inc;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody FileTableType FileTableType) {
		encommFileTableTypeService.saveOrUpdate(FileTableType);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FileTableType FileTableType) {
		FileTableType inc = encommFileTableTypeService.find(FileTableType.getFileId());
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			encommFileTableTypeService.update(FileTableType);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(@PathVariable("id") String id) {
		FileTableType inc = encommFileTableTypeService.find(Integer.parseInt(id));
		if (inc == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			encommFileTableTypeService.remove(inc);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}
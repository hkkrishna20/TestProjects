package com.operationtool.controller.upload;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.operationtool.controller.highchart.OldDrilldownFinanceComponent;
import com.operationtool.controller.highchart.OrganisationAnalysisComponent;
import com.operationtool.database.service.CandidateService;

@RestController
public class ExcelUploadController {
	@Autowired
	OrganisationAnalysisComponent dataComponent;

	@Autowired
	OldDrilldownFinanceComponent dataComponentFinance;
	@Autowired
	CandidateService candidateService;


	@RequestMapping(value = "uploadMultipleFile", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	public String uploadDataFile(@RequestParam("logo") MultipartFile[] file,
			@RequestParam("uploadType") String uploadType)
			throws IOException, InvalidFormatException {
		
		System.out.println("Entry  uploadDataFile");
		System.out.println("Files size" + file.length);
		for (int i = 0; i < file.length; i++) {
			System.out.println("Rest call----" + file[i].getOriginalFilename() + uploadType);
			dataComponent.readExcel(file[i], uploadType);
		}
		System.out.println("Exit  uploadDataFile");
		return "Success";
	}
	
	

	@RequestMapping(value = "testUpload", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	public String testUpload(@RequestParam("logo") MultipartFile[] file,
			@RequestParam("uploadType") String uploadType)
			throws IOException, InvalidFormatException {
		System.out.println("Entry  uploadDataFile");
		System.out.println("Files size" + file.length);
		for (int i = 0; i < file.length; i++) {
			System.out.println("Rest call----" + file[i].getOriginalFilename());
			dataComponent.readTestExcel(file[i], uploadType);
		}
		System.out.println("Exit  uploadDataFile");
		return "Success";
	}

}

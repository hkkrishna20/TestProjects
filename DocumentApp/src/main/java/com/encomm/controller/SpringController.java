package com.encomm.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compare.component.CompareReport;
import com.compare.component.ContentExtract;
import com.compare.component.ContentInfo;

@RestController
public class SpringController {
	
	@Autowired
	ContentExtract contentExtract;
	
	@RequestMapping(value = "uploaddata", method = RequestMethod.POST)
	@CrossOrigin(origins = {"http://localhost:4200","http://localhost:6003"})
	public String uploadDataFile(@RequestParam MultipartFile[] file ){
		
		String res = null;
		String titleName ="";
		//ExtractReport report = new ExtractReport();
		CompareReport cr = new CompareReport();
		System.out.println("Files size"+file.length);
		for(int i=0; i< file.length; i++) {
			System.out.println("Rest call----"+file[i].getOriginalFilename());
		}
		try {
			//report.extractReport(file);
			titleName = contentExtract.landPage(file);
			res = "Excel Report generated successfully";			
		} catch (Exception e) {
			e.printStackTrace();
			res = "Exception occured while generating the report";
		}
		return titleName;
	 }
	
	@RequestMapping(value = "consolidateList", method = RequestMethod.POST)
	@CrossOrigin(origins = {"http://localhost:4200","http://localhost:6003"})
	public ContentInfo consolidateList(@RequestParam String fileName ){
		
		File file = new File("C:\\Users\\Public\\POC Files\\BaseDir\\BaselineDoc\\"+fileName+".docx");
		ContentInfo contentInfo = new ContentInfo();
		try {
			//report.extractReport(file);
			contentInfo = contentExtract.extractConsolidateList(file);
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		return contentInfo;
	 }
}

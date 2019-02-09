package com.compare.main;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.web.multipart.MultipartFile;


public class BaseParaFile {
	
	String fileName;
	List<XWPFParagraph> paraList;
	List<MultipartFile> files;
	
	
	public String getFileName() {
		return fileName;
	}
	public List<MultipartFile> getFiles() {
		if(files == null)
			return new ArrayList<MultipartFile>();
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<XWPFParagraph> getParaList() {
		return paraList;
	}
	public void setParaList(List<XWPFParagraph> paraList) {
		this.paraList = paraList;
	}
	
}

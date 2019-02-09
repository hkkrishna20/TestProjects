package com.encomm.models.content.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.encomm.models.content.response.ContentPOJO;

@XmlRootElement(name = "compareList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompareList {

	@XmlElement(name = "fileName")
	private String fileName;
	@XmlElement(name = "baseVersionParaList")
	private List<String> baseVersionParaList = new ArrayList<String>();

	@XmlElement(name = "baseVersionParaList")
	private List<ContentPOJO> compareVersionParaList = new ArrayList<ContentPOJO>();

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getBaseVersionParaList() {
		return baseVersionParaList;
	}

	public void setBaseVersionParaList(List<String> baseVersionParaList) {
		this.baseVersionParaList = baseVersionParaList;
	}

	public List<ContentPOJO> getCompareVersionParaList() {
		return compareVersionParaList;
	}

	public void setCompareVersionParaList(List<ContentPOJO> compareVersionParaList) {
		this.compareVersionParaList = compareVersionParaList;
	}

	

}

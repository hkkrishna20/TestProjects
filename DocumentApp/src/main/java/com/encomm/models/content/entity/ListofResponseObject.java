package com.encomm.models.content.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ListofResponseObject {
	
	private List<ResponseObject> responses  = null;

	public List<ResponseObject> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseObject> response) {
		this.responses = response;
	}

}

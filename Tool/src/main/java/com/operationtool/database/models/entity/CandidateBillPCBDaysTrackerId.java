package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CandidateBillPCBDaysTrackerId implements Serializable{

	@Column(length = 128, nullable = false)
	String resourceid;
	@Column(length = 128, nullable = false)
	String pcbmonth;
	
	
	public CandidateBillPCBDaysTrackerId() {
		
		
	}


	/**
	 * @param resourceid
	 * @param pcbmonth
	 */
	public CandidateBillPCBDaysTrackerId(String resourceid, String pcbmonth) {
		super();
		this.resourceid = resourceid;
		this.pcbmonth = pcbmonth;
	}


	public String getResourceid() {
		return resourceid;
	}


	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}


	public String getPcbmonth() {
		return pcbmonth;
	}


	public void setPcbmonth(String pcbmonth) {
		this.pcbmonth = pcbmonth;
	}
	
	
		
}

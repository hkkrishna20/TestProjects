package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class RateCardTrackerId implements Serializable{

	@Column(name = "member_id", length = 128, nullable = false)
	private String memberId;
	@Column(name = "billable_status", length = 128, nullable = false)
	private String billableStatus;
	
	public RateCardTrackerId() {
		
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBillableStatus() {
		return billableStatus;
	}

	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}
	
	
	
		
}

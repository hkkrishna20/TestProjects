package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class RateCardViewTrackerId implements Serializable{

	@Column(name = "member_id", length = 128, nullable = false)
	private String memberId;
	
	@Column(name = "vacation_date")
	private String vacationDate;

	public RateCardViewTrackerId() {
		
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getVacationDate() {
		return vacationDate;
	}

	public void setVacationDate(String vacationDate) {
		this.vacationDate = vacationDate;
	}

	
	
	
	
		
}

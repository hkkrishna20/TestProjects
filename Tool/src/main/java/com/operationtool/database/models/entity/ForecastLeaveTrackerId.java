package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ForecastLeaveTrackerId implements Serializable{

	@Column(length = 128, nullable = false)
	String resourceid;
	@Column(length = 128, nullable = false)
	String day;
	@Column(length = 128, nullable = false)
	String month;
	@Column(length = 128, nullable = false)
	String year;
	
	public ForecastLeaveTrackerId() {
		
		
	}
	
	
	
	public ForecastLeaveTrackerId(String resourceid, String day, String month, String year) {
		super();
		this.resourceid = resourceid;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String getResourceid() {
		return resourceid;
	}
	public void setResourceid(String resourceID) {
		this.resourceid = resourceID;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}

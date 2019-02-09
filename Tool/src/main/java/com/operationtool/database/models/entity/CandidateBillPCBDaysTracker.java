package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candidatebillpcbdays")
@Entity(name = "candidatebillpcbdays")
@Table(name = "candidatebillpcbdays")
@XmlAccessorType(XmlAccessType.FIELD)
public class CandidateBillPCBDaysTracker implements Serializable {

	public CandidateBillPCBDaysTracker() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	CandidateBillPCBDaysTrackerId id;

	@Column(name = "days")
	protected Integer days;

	@Column(name = "bill_Type")
	protected String billType;

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public CandidateBillPCBDaysTrackerId getId() {
		return id;
	}

	public void setId(CandidateBillPCBDaysTrackerId id) {
		this.id = id;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(int days2) {
		this.days = days2;
	}

	/**
	 * @param id
	 * @param billAmount
	 */
	public CandidateBillPCBDaysTracker(CandidateBillPCBDaysTrackerId id, Integer days) {
		super();
		this.id = id;
		this.days = days;
	}

}

package com.operationtool.database.models.entity.pmo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author xx57136
 * 
 */

@Entity
@Table(name = "Member_Sow")
public class MemberSow implements Comparable<MemberSow>{
	private Integer sowId;
	private Status status;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	private Date lastUpdatedts;
	private MemberDetails memberdetails;
	private String action = "create";

	/**
	 * @return the MemberDetails
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PSA_ID")
	public MemberDetails getMemberdetails() {
		return memberdetails;
	}

	/**
	 * @param memberdetails
	 *            the MemberDetails to set
	 */

	public void setMemberdetails(MemberDetails memberdetails) {
		this.memberdetails = memberdetails;
	}

	/**
	 * @return the sowId
	 */
	@Id
	@Column(name = "Sow_ID")
	public Integer getSowId() {
		return sowId;
	}

	/**
	 * @param sowId
	 *            the sowId to set
	 */
	public void setSowId(Integer sowId) {
		this.sowId = sowId;
	}

	/**
	 * @return the statusId
	 */
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "STATUS_ID")
	public Status getStatus() {
		return status;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the startDate
	 */
	@Column(name = "Start_Date")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Column(name = "End_Date")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the lastUpdatedts
	 */
	@Column(name = "Last_Updated_TS")
	public Date getLastUpdatedts() {
		return lastUpdatedts;
	}

	/**
	 * @param lastUpdatedts
	 *            the lastUpdatedts to set
	 */
	public void setLastUpdatedts(Date lastUpdatedts) {
		this.lastUpdatedts = lastUpdatedts;
	}

	@Transient
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int compareTo(MemberSow Obj1) {
		// TODO Auto-generated method stub
		return this.sowId-Obj1.sowId;
	}

	
}

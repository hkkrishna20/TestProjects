/**
 * 
 */
package com.operationtool.database.models.entity.pmo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author xx57136
 * 
 */
@Entity
@Table(name = "Status")
public class Status {
	private Integer statusId;
	private String statusName;
	private String statusDescription;
	private Date lastUpdatedts;
	private MemberSow memberSow;
	private BGVDetails bgvDetails;
	//private MemberProjectDetails memberProjectDetails;

	/**
	 * @return the statusId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Status_ID")
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusName
	 */
	@Column(name = "Status_Name")
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName
	 *            the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return the statusDescription
	 */
	@Column(name = "Status_Description")
	public String getStatusDescription() {
		return statusDescription;
	}

	/**
	 * @param statusDescription
	 *            the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
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

	
	/**
	 * @return the memberProjectDetails
	 */
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	@JoinColumn(name = "Status_ID")
	public MemberProjectDetails getMemberProjectDetails() {
		return memberProjectDetails;
	}

	*//**
	 * @param memberProjectDetails the memberProjectDetails to set
	 *//*
	public void setMemberProjectDetails(MemberProjectDetails memberProjectDetails) {
		this.memberProjectDetails = memberProjectDetails;
	}*/

}

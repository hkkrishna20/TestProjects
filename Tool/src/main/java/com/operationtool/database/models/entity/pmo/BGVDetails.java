/**
 * 
 */
package com.operationtool.database.models.entity.pmo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author xx57136
 *
 */
@Entity
@Table(name = "BGV_DETAILS")
public class BGVDetails 
{
	private Integer bgvId;
	private Integer statusId;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date bgvInitiationDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date bgvCompletionDate;
	private Date lastUpdatedts;
	private MemberDetails memberdetails;
	private String action;
	//private List<Status> statusList;
	
	/**
	 * @return the member details
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PSA_ID")
	public MemberDetails getMemberdetails() {
		return memberdetails;
	}
	/**
	 * @param memberdetails the memberdetails to set
	 */
	public void setMemberdetails(MemberDetails memberdetails) {
		this.memberdetails = memberdetails;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="BGV_ID")
	public Integer getBgvId() {
		return bgvId;
	}
	public void setBgvId(Integer bgvId) {
		this.bgvId = bgvId;
	}
	/**
	 * @return the statusId
	 */
	@Column(name = "STATUS_ID")
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * @return the bgvInitiationDate
	 */
	@Column(name="BGV_INITIATED_DATE")
	public Date getBgvInitiationDate() {
		return bgvInitiationDate;
	}
	/**
	 * @param bgvInitiationDate the bgvInitiationDate to set
	 */
	public void setBgvInitiationDate(Date bgvInitiationDate) {
		this.bgvInitiationDate = bgvInitiationDate;
	}
	/**
	 * @return the bgvCompletionDate
	 */
	@Column(name="BGV_COMPLETION_DATE ")
	public Date getBgvCompletionDate() {
		return bgvCompletionDate;
	}
	/**
	 * @param bgvCompletionDate the bgvCompletionDate to set
	 */
	public void setBgvCompletionDate(Date bgvCompletionDate) {
		this.bgvCompletionDate = bgvCompletionDate;
	}
	/**
	 * @return the lastUpdatedts
	 */
	@Column(name="LAST_UPDATED_TS ")
	public Date getLastUpdatedts() {
		return lastUpdatedts;
	}
	/**
	 * @param lastUpdatedts the lastUpdatedts to set
	 */
	public void setLastUpdatedts(Date lastUpdatedts) {
		this.lastUpdatedts = lastUpdatedts;
	}
	/**
	 * @return the statusList
	 *//*
	public List<Status> getStatusList() {
		return statusList;
	}
	*//**
	 * @param statusList the statusList to set
	 *//*
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}*/
	@Transient
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString(){
		return "bgvId-->"+bgvId+"statusId-->"+statusId+"bgvInitiationDate-->"+bgvInitiationDate+"bgvCompletionDate-->"+bgvCompletionDate+"action-->"+action;
	}
	

}

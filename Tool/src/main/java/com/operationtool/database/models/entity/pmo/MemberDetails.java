/**
 * 
 */
package com.operationtool.database.models.entity.pmo;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author xx55372
 * 
 */

@Entity
@Table(name = "MEMBER_DETAILS")
public class MemberDetails {
	
	private Integer psaId;

	private String cgiEMailId;

	private String workStationId;

	private String firstName;

	private String lastName;

	private Character gender;

	private Integer titleId;

	private Integer experienceInYears;
	
	private Integer experienceInMonths;

	private Character isActive;

	private Date memberJoiningDate;

	private String mobileNumber;

	private Date lastUpdatedTS;

	private byte[] cgiResume;
	
	private Set<MemberSow> memberSowList;
	
	private BGVDetails memberBGVDetails;
	
	private String action;
	
	private MemberPNCDetails memberPNCDetails;
	
	private Set<MemberProjectDetails> memberProjectDetailsList;
	
	/**
	 * @return the psaId
	 */
	@Id
	@Column(name = "PSA_ID")
	public Integer getPsaId() {
		return psaId;
	}

	public void setPsaId(Integer psaId) {
		this.psaId = psaId;
	}

	/**
	 * @return the cgiEMailID
	 */
	@Column(name = "CGI_MAIL_ID")
	public String getCgiEMailId() {
		return cgiEMailId;
	}

	public void setCgiEMailId(String cgiEMailId) {
		this.cgiEMailId = cgiEMailId;
	}

	/**
	 * @return the gender
	 */
	@Column(name = "GENDER")
	public Character getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Character gender) {
		this.gender = gender;
	}

	/**
	 * @return the designation
	 */
	@Column(name = "TITLE_ID")
	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}


	@Column(name = "EXPERIENCE_YEARS")
	public Integer getExperienceInYears() {
		return experienceInYears;
	}


	public void setExperienceInYears(Integer experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	@Column(name = "EXPERIENCE_MONTHS")
	public Integer getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(Integer experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}
	/**
	 * @return the isActive
	 */
	@Column(name = "ISACTIVE")
	public Character getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the memberJoiningDate
	 */
	@Column(name = "MEMBER_JOINING_DATE")
	public Date getMemberJoiningDate() {
		return memberJoiningDate;
	}

	/**
	 * @param memberJoiningDate
	 *            the memberJoiningDate to set
	 */
	public void setMemberJoiningDate(Date memberJoiningDate) {
		this.memberJoiningDate = memberJoiningDate;
	}

	/**
	 * @return the mobileNumber
	 */
	@Column(name = "MOBILE_NUMBER")
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the workStationID
	 */
	@Column(name = "WORKSTATION_ID")
	public String getWorkStationId() {
		return workStationId;
	}

	public void setWorkStationId(String workStationId) {
		this.workStationId = workStationId;
	}

	/**
	 * @return the lastUpdatedTS
	 */
	@Column(name = "LAST_UPDATED_TS")
	public Date getLastUpdatedTS() {
		return lastUpdatedTS;
	}


	/**
	 * @param lastUpdatedTS
	 *            the lastUpdatedTS to set
	 */
	public void setLastUpdatedTS(Date lastUpdatedTS) {
		this.lastUpdatedTS = lastUpdatedTS;
	}

	/**
	 * @return the cgiResume
	 */
	@Column(name = "CGI_RESUME")
	public byte[] getCgiResume() {
		return cgiResume;
	}

	/**
	 * @param cgiResume
	 *            the cgiResume to set
	 */
	public void setCgiResume(byte[] cgiResume) {
		this.cgiResume = cgiResume;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="memberdetails")
	public Set<MemberSow> getMemberSowList() {
		return memberSowList;
	}

	public void setMemberSowList(Set<MemberSow> memberSowList) {
		this.memberSowList = memberSowList;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="memberdetails")
	@JoinColumn(name="PSA_ID")
	public BGVDetails getMemberBGVDetails() {
		return memberBGVDetails;
	}

	public void setMemberBGVDetails(BGVDetails memberBGVDetails) {
		this.memberBGVDetails = memberBGVDetails;
	}

	/**
	 * @return the memberProjectDetailsList
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="PSA_ID",updatable=false,insertable=false)
	public Set<MemberProjectDetails> getMemberProjectDetailsList() {
		return memberProjectDetailsList;
	}

	/**
	 * @param memberProjectDetailsList the memberProjectDetailsList to set
	 */
	public void setMemberProjectDetailsList(
			Set<MemberProjectDetails> memberProjectDetailsList) {
		this.memberProjectDetailsList = memberProjectDetailsList;
	}

	@Transient
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="memberdetails")
	@JoinColumn(name="PSA_ID")
	public MemberPNCDetails getMemberPNCDetails() {
		return memberPNCDetails;
	}

	public void setMemberPNCDetails(MemberPNCDetails memberPNCDetails) {
		this.memberPNCDetails = memberPNCDetails;
	}

	 
	
	
}
/**
 * 
 */
package com.operationtool.database.models.entity.pmo;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xx55372
 * 
 */
public class MemberDetailsWeb {

	private Integer psaId;

	private String firstName;

	private String lastName;

	private String cgiEMailId;

	private Character gender;

	private Integer titleId;
	
	private List<Title> titleList;

	private Integer experienceInYears;
	
	private Integer experienceInMonths;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date memberJoiningDate;

	private String mobileNumber;

	private String workStationId;

	private Date lastUpdatedTS;

	private Blob cgiResume;

	private MultipartFile file;
	
	private MemberDetails memberDetailsWeb;
	
	private String action;

	

	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the psaId
	 */
	public Integer getPsaId() {
		return psaId;
	}

	/**
	 * @param psaId the psaId to set
	 */
	public void setPsaId(Integer psaId) {
		this.psaId = psaId;
	}

	/**
	 * @return the cgiEMailId
	 */
	public String getCgiEMailId() {
		return cgiEMailId;
	}

	/**
	 * @param cgiEMailId the cgiEMailId to set
	 */
	public void setCgiEMailId(String cgiEMailId) {
		this.cgiEMailId = cgiEMailId;
	}

	/**
	 * @return the workStationId
	 */
	public String getWorkStationId() {
		return workStationId;
	}

	/**
	 * @param workStationId the workStationId to set
	 */
	public void setWorkStationId(String workStationId) {
		this.workStationId = workStationId;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}

	/**
	 * @return the gender
	 */
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

	
	public Integer getExperienceInYears() {
		return experienceInYears;
	}

	public void setExperienceInYears(Integer experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	public Integer getExperienceInMonths() {
		return experienceInMonths;
	}

	public void setExperienceInMonths(Integer experienceInMonths) {
		this.experienceInMonths = experienceInMonths;
	}

	/**
	 * @return the memberJoiningDate
	 */
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
	 * @return the lastUpdatedTS
	 */
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
	public Blob getCgiResume() {
		return cgiResume;
	}

	/**
	 * @param cgiResume
	 *            the cgiResume to set
	 */
	public void setCgiResume(Blob cgiResume) {
		this.cgiResume = cgiResume;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the firstName
	 */
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

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public MemberDetails getMemberDetailsWeb() {
		return memberDetailsWeb;
	}

	public void setMemberDetailsWeb(MemberDetails memberDetailsWeb) {
		this.memberDetailsWeb = memberDetailsWeb;
	}

	 
	
	
	
	
}
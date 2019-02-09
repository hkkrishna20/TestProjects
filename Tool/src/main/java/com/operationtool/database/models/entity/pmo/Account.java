package com.operationtool.database.models.entity.pmo;
/**
 * @author xx57136
 *
 */

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	private Integer accountId;
	private String accountName; 
	private String description; 
	private Date lastUpdatedts;
	//private List<ProjectDetails> projectDetailsList;
	
	
	/**
	 * @return the accountId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	public Integer getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the accountName
	 */
	
	@Column(name = "ACCOUNT_NAME")
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountname) {
		accountName = accountname;
	}
	/**
	 * @return the description
	 */
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the lastUpdatedts
	 */
	@Column(name = "LAST_UPDATED_TS")
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
	 * @return the projectDetailsList
	 *//*
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_ID")
	public List<ProjectDetails> getProjectDetailsList() {
		return projectDetailsList;
	}
	*//**k
	 * @param projectDetailsList the projectDetailsList to set
	 *//*
	public void setProjectDetailsList(List<ProjectDetails> projectDetailsList) {
		this.projectDetailsList = projectDetailsList;
	}*/

	}



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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author xx57136
 * 
 */
@Entity
@Table(name = "PROJECT_DETAILS")
public class ProjectDetails {
	private Integer projectId;
	private String projectName;
	private String cgiProjectCode;
	private String projectManager;
	private Date lastUpdatedts;
	private Account account;
	private ProjectType projectType;
	private String status;
	
	/**
	 * @return the account
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_ID")
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the project type
	 */

	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="PROJECT_TYPE_ID")
	public ProjectType getProjectType() {
		return projectType;
	}

	/**
	 * @param project
	 *            type the project type to set
	 */
	public void setProjectType(ProjectType projecttype) {
		this.projectType = projecttype;
	}

	/**
	 * @return the projectId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	@Column(name = "PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	

	/**
	 * @return the projectManager
	 */
	@Column(name = "PROJECT_MANAGER")
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager
	 *            the projectManager to set
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the lastUpdatedts
	 */
	@Column(name = "LAST_UPDATED_TS")
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
	 * @return the cgiProjectCode
	 */
	@Column(name="CGI_PROJECT_CODE")
	public String getCgiProjectCode() {
		return cgiProjectCode;
	}

	/**
	 * @param cgiProjectCode the cgiProjectCode to set
	 */
	public void setCgiProjectCode(String cgiProjectCode) {
		this.cgiProjectCode = cgiProjectCode;
	}

	/**
	 * @return the status
	 */
	@Transient
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

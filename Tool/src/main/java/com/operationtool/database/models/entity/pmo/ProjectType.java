/**
 * 
 */
package com.operationtool.database.models.entity.pmo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "PROJECT_TYPE")
public class ProjectType 
{
	private Integer projectTypeId ; 
	private String projectType; 
    private String projectDescription; 
    private Date lastUpdatedts;
	
	/**
	 * @return the projectTypeId
	 */
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROJECT_TYPE_ID")
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	/**
	 * @param projectTypeId the projectTypeId to set
	 */
	public void setProjectTypeId(Integer projectTypeId) {
	this.projectTypeId = projectTypeId;
	}
	/**
	 * @return the projectType
	 */
	
	@Column(name = "Project_Type")
	public String getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the projectDescription
	 */
	@Column(name = "Project_Description")
	public String getProjectDescription() {
		return projectDescription;
	}
	/**
	 * @param projectDescription the projectDescription to set
	 */
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	/**
	 * @return the lastUpdatedts
	 */
	@Column(name = "Last_Updated_TS")
	public Date getLastUpdatedts() {
		return lastUpdatedts;
	}
	/**
	 * @param lastUpdatedts the lastUpdatedts to set
	 */
	public void setLastUpdatedts(Date lastUpdatedts) {
		this.lastUpdatedts = lastUpdatedts;
	}
	

	
}

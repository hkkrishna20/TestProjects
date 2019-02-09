package com.operationtool.database.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecastleavetracker")
@Entity(name = "forecastleavetracker")
@Table(name = "forecastleavetracker")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastLeaveTracker implements Serializable {

	public ForecastLeaveTracker(ForecastLeaveTrackerId id, String resourceName, String project,
			String cgiOnsiteEngManager, String offshoreManager, Date vacationDate, String vacationType) {
		super();
		this.id = id;
		this.resourceName = resourceName;
		this.project = project;
		this.cgiOnsiteEngManager = cgiOnsiteEngManager;
		this.offshoreManager = offshoreManager;
		this.vacationDate = vacationDate;
		this.vacationType = vacationType;
	}

	public ForecastLeaveTracker() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	ForecastLeaveTrackerId id;
	/*
	 * @Column(name = "resourceID", nullable = true, insertable = true, updatable =
	 * true, unique = true)
	 * 
	 * @Id
	 * 
	 * protected String resourceID;
	 */

	@Column(name = "resource_name")
	protected String resourceName;

	@Column(name = "project")
	protected String project;

	@Column(name = "cgi_onsite_eng_manager")
	protected String cgiOnsiteEngManager;

	@Column(name = "offshore_manager")
	protected String offshoreManager;

	@Column(name = "vacation_date")
	@Temporal(TemporalType.DATE)
	protected Date vacationDate;

	@Column(name = "vacation_type")
	protected String vacationType;

	public ForecastLeaveTrackerId getId() {
		return id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getProject() {
		return project;
	}

	public String getCgiOnsiteEngManager() {
		return cgiOnsiteEngManager;
	}

	public String getOffshoreManager() {
		return offshoreManager;
	}

	public Date getVacationDate() {
		return vacationDate;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public void setOffshoreManager(String offshoreManager) {
		this.offshoreManager = offshoreManager;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setId(ForecastLeaveTrackerId id) {
		this.id = id;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setCgiOnsiteEngManager(String cgiOnsiteEngManager) {
		this.cgiOnsiteEngManager = cgiOnsiteEngManager;
	}

	public void setVacationDate(Date vacationDate) {
		this.vacationDate = vacationDate;
	}

}

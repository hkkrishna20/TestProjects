package com.operationtool.database.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "billable")
@Entity(name = "billable")
@Table(name = "billable")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillableProject {
	@Id
	@Column(name = "resource_id")
	@NotNull
	protected String resourceId;

	@Column(name = "resource_name")
	protected String resourceName;

	@Column(name = "billing_start_date")
	@Temporal(TemporalType.DATE)
	protected Date billingStartDate;

	@Column(name = "billing_end_date")
	@Temporal(TemporalType.DATE)
	protected Date billingEndDate;

	public String getResourceId() {
		return resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public Date getBillingStartDate() {
		return billingStartDate;
	}

	public Date getBillingEndDate() {
		return billingEndDate;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	public void setBillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}

}

package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "candidatebillpcb")
@Entity(name = "candidatebillpcb")
@Table(name = "candidatebillpcb")
@XmlAccessorType(XmlAccessType.FIELD)
public class CandidateBillPCBAmountTracker implements Serializable {

	public CandidateBillPCBAmountTracker() {
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	CandidateBillPCBAmountTrackerId id;

	@Column(name = "bill_amount")
	protected Integer billAmount;

	@Column(name = "bill_Type")
	protected String billType;

	@Column(name = "engagement_director")
	protected String engagementDirector;

	@Column(name = "project_manger")
	protected String projectManger;

	@Column(name = "project")
	protected String project;

	@Column(name = "hrbu")
	protected String hrbu;
	
	@Column(name = "account_group")
	protected String accountGroup;

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getEngagementDirector() {
		return engagementDirector;
	}

	public void setEngagementDirector(String engagementDirector) {
		this.engagementDirector = engagementDirector;
	}

	public String getProjectManger() {
		return projectManger;
	}

	public void setProjectManger(String projectManger) {
		this.projectManger = projectManger;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getHrbu() {
		return hrbu;
	}

	public void setHrbu(String hrbu) {
		this.hrbu = hrbu;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public CandidateBillPCBAmountTrackerId getId() {
		return id;
	}

	public void setId(CandidateBillPCBAmountTrackerId id) {
		this.id = id;
	}

	public Integer getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Integer amount) {
		this.billAmount = amount;
	}

	/**
	 * @param id
	 * @param billAmount
	 */
	public CandidateBillPCBAmountTracker(CandidateBillPCBAmountTrackerId id, Integer billAmount) {
		super();
		this.id = id;
		this.billAmount = billAmount;
	}

}

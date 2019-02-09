package com.operationtool.database.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "views")
@Entity(name = "views")
@Table(name = "views")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateCardView implements Serializable {
	public RateCardView() {

	}

	@EmbeddedId
	RateCardViewTrackerId id;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "billable_status")
	private String billableStatus;

	@Column(name = "hrbu_status")
	private String hrbuStatus;

	@Column(name = "base_currency")
	private String baseCurrency;

	@Column(name = "standard_rate_modified")
	private String standardRateModified;

	@Column(name = "engagement_director")
	private String engagementDirector;

	@Column(name = "project_manager")
	private String projectManager;

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "account_group")
	private String accountGroup;

	@Column(name = "billing_end_date")
	private String billingEndDate;

	@Column(name = "billing_start_date")
	private String billingStartDate;

	@Column(name = "cgi_onsite_eng_manager")
	private String cgiOnsiteEngManager;

	@Column(name = "vacation_type")
	private String vacationType;

	@Column(name = "month")
	private String month;

	@Column(name = "pcb_days")
	private String pcbDays;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	public RateCardView(@NotNull String memberId, String memberName, String billableStatus, String hrbuStatus,
			String baseCurrency, String standardRateModified, String engagementDirector, String projectManager,
			String deptId, String projectName, String accountGroup, String billingEndDate, String billingStartDate,
			String cgiOnsiteEngManager, String vacationDate, String vacationType, String month, String pcbDays,
			String startDate, String endDate) {
		super();
		this.memberName = memberName;
		this.billableStatus = billableStatus;
		this.hrbuStatus = hrbuStatus;
		this.baseCurrency = baseCurrency;
		this.standardRateModified = standardRateModified;
		this.engagementDirector = engagementDirector;
		this.projectManager = projectManager;
		this.deptId = deptId;
		this.projectName = projectName;
		this.accountGroup = accountGroup;
		this.billingEndDate = billingEndDate;
		this.billingStartDate = billingStartDate;
		this.cgiOnsiteEngManager = cgiOnsiteEngManager;
		this.vacationType = vacationType;
		this.month = month;
		this.pcbDays = pcbDays;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBillableStatus() {
		return billableStatus;
	}

	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}

	public String getHrbuStatus() {
		return hrbuStatus;
	}

	public void setHrbuStatus(String hrbuStatus) {
		this.hrbuStatus = hrbuStatus;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getStandardRateModified() {
		return standardRateModified;
	}

	public void setStandardRateModified(String standardRateModified) {
		this.standardRateModified = standardRateModified;
	}

	public String getEngagementDirector() {
		return engagementDirector;
	}

	public void setEngagementDirector(String engagementDirector) {
		this.engagementDirector = engagementDirector;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getBillingEndDate() {
		return billingEndDate;
	}

	public void setBillingEndDate(String billingEndDate) {
		this.billingEndDate = billingEndDate;
	}

	public String getBillingStartDate() {
		return billingStartDate;
	}

	public void setBillingStartDate(String billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	public String getCgiOnsiteEngManager() {
		return cgiOnsiteEngManager;
	}

	public void setCgiOnsiteEngManager(String cgiOnsiteEngManager) {
		this.cgiOnsiteEngManager = cgiOnsiteEngManager;
	}

	public RateCardViewTrackerId getId() {
		return id;
	}

	public RateCardView(RateCardViewTrackerId id, String memberName, String billableStatus, String hrbuStatus,
			String baseCurrency, String standardRateModified, String engagementDirector, String projectManager,
			String deptId, String projectName, String accountGroup, String billingEndDate, String billingStartDate,
			String cgiOnsiteEngManager, String vacationType, String month, String pcbDays, String startDate,
			String endDate) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.billableStatus = billableStatus;
		this.hrbuStatus = hrbuStatus;
		this.baseCurrency = baseCurrency;
		this.standardRateModified = standardRateModified;
		this.engagementDirector = engagementDirector;
		this.projectManager = projectManager;
		this.deptId = deptId;
		this.projectName = projectName;
		this.accountGroup = accountGroup;
		this.billingEndDate = billingEndDate;
		this.billingStartDate = billingStartDate;
		this.cgiOnsiteEngManager = cgiOnsiteEngManager;
		this.vacationType = vacationType;
		this.month = month;
		this.pcbDays = pcbDays;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "RateCardView [id=" + id + ", memberName=" + memberName + ", billableStatus=" + billableStatus
				+ ", hrbuStatus=" + hrbuStatus + ", baseCurrency=" + baseCurrency + ", standardRateModified="
				+ standardRateModified + ", engagementDirector=" + engagementDirector + ", projectManager="
				+ projectManager + ", deptId=" + deptId + ", projectName=" + projectName + ", accountGroup="
				+ accountGroup + ", billingEndDate=" + billingEndDate + ", billingStartDate=" + billingStartDate
				+ ", cgiOnsiteEngManager=" + cgiOnsiteEngManager + ", vacationType=" + vacationType + ", month=" + month
				+ ", pcbDays=" + pcbDays + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public void setId(RateCardViewTrackerId id) {
		this.id = id;
	}

	public String getVacationType() {
		return vacationType;
	}

	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPcbDays() {
		return pcbDays;
	}

	public void setPcbDays(String pcbDays) {
		this.pcbDays = pcbDays;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}

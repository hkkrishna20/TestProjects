package com.operationtool.database.models.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rateCard")
@Entity(name = "rateCard")
@Table(name = "rateCard")
public class RateCardSystem {

	
	@EmbeddedId
	RateCardTrackerId id;
	
	@Column(name = "member_name")
	private String memberName;

	@Column(name = "active_status")
	private String activeStatus;



	public RateCardSystem(RateCardTrackerId id, String memberName, String activeStatus, String trxOU,
			String hrbuStatus, String baseCurrency, String ensembleRate, String standardRateAsPerRateCard,
			String standardRateModified, String shiftRateAsPerRateCard, String shiftRateModified,
			String onCallRateAsPerRateCard, String onCallRateModified, String onCallHolidayRateAsPerRateCard,
			String onCallHolidayRateModified, String targetCurrency, String ensembleRateInr,
			String standardRateAsPerRateCardColumn2, String standardRateModifiedColumn2,
			String shiftRateAsPerRateCardColumn2, String shiftRateModifiedColumn2,
			String onCallRateAsPerRateCardColumn2, String onCallRateModifiedColumn2,
			String onCallHolidayRateAsPerRateCardColumn2, String onCallHolidayRateModifiedColumn2, String comments,
			String financeRate, String technologyGroup, String actualRolePlayed, String rateType,
			String maxBillableHoursPerYear, String shiftType, String deptId, String projectName,
			String fixedRateProject, String offeringType, String actualPercentageCharged, String projectManager,
			String seniorProjectManager, String engagementDirector, String groupHead, String groupLead,
			String accountGroup, String createdBy, String createdDate, String modifiedBy, String modifiedDate) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.activeStatus = activeStatus;
		this.trxOU = trxOU;
		this.hrbuStatus = hrbuStatus;
		this.baseCurrency = baseCurrency;
		this.ensembleRate = ensembleRate;
		this.standardRateAsPerRateCard = standardRateAsPerRateCard;
		this.standardRateModified = standardRateModified;
		this.shiftRateAsPerRateCard = shiftRateAsPerRateCard;
		this.shiftRateModified = shiftRateModified;
		this.onCallRateAsPerRateCard = onCallRateAsPerRateCard;
		this.onCallRateModified = onCallRateModified;
		this.onCallHolidayRateAsPerRateCard = onCallHolidayRateAsPerRateCard;
		this.onCallHolidayRateModified = onCallHolidayRateModified;
		this.targetCurrency = targetCurrency;
		this.ensembleRateInr = ensembleRateInr;
		this.standardRateAsPerRateCardColumn2 = standardRateAsPerRateCardColumn2;
		this.standardRateModifiedColumn2 = standardRateModifiedColumn2;
		this.shiftRateAsPerRateCardColumn2 = shiftRateAsPerRateCardColumn2;
		this.shiftRateModifiedColumn2 = shiftRateModifiedColumn2;
		this.onCallRateAsPerRateCardColumn2 = onCallRateAsPerRateCardColumn2;
		this.onCallRateModifiedColumn2 = onCallRateModifiedColumn2;
		this.onCallHolidayRateAsPerRateCardColumn2 = onCallHolidayRateAsPerRateCardColumn2;
		this.onCallHolidayRateModifiedColumn2 = onCallHolidayRateModifiedColumn2;
		this.comments = comments;
		this.financeRate = financeRate;
		this.technologyGroup = technologyGroup;
		this.actualRolePlayed = actualRolePlayed;
		this.rateType = rateType;
		this.maxBillableHoursPerYear = maxBillableHoursPerYear;
		this.shiftType = shiftType;
		this.deptId = deptId;
		this.projectName = projectName;
		this.fixedRateProject = fixedRateProject;
		this.offeringType = offeringType;
		this.actualPercentageCharged = actualPercentageCharged;
		this.projectManager = projectManager;
		this.seniorProjectManager = seniorProjectManager;
		this.engagementDirector = engagementDirector;
		this.groupHead = groupHead;
		this.groupLead = groupLead;
		this.accountGroup = accountGroup;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public RateCardSystem() {
		// TODO Auto-generated constructor stub
	}

	public RateCardTrackerId getId() {
		return id;
	}

	public void setId(RateCardTrackerId id) {
		this.id = id;
	}

	@Column(name = "trx_ou")
	private String trxOU;

	@Column(name = "hrbu_status")
	private String hrbuStatus;

	@Column(name = "base_currency")
	private String baseCurrency;

	@Column(name = "ensemble_rate")
	private String ensembleRate;

	@Column(name = "standard_rate_as_per_ratecard")
	private String standardRateAsPerRateCard;

	@Column(name = "standard_rate_modified")
	private String standardRateModified;

	@Column(name = "shift_rate_as_per_ratecard")
	private String shiftRateAsPerRateCard;

	@Column(name = "shift_rate_modified")
	private String shiftRateModified;

	@Column(name = "oncall_rate_as_per_ratecard")
	private String onCallRateAsPerRateCard;

	@Column(name = "oncall_rate_modified")
	private String onCallRateModified;

	@Column(name = "oncall_holiday_rate_as_per_ratecard")
	private String onCallHolidayRateAsPerRateCard;

	@Column(name = "oncall_holiday_rate_modified")
	private String onCallHolidayRateModified;

	@Column(name = "target_currency")
	private String targetCurrency;

	@Column(name = "Ensemble_rate_inr")
	private String ensembleRateInr;
	
	@Column(name = "standard_rate_as_per_ratecard_column2")
	private String standardRateAsPerRateCardColumn2;
	
	@Column(name = "standard_rate_modified_column2")
	private String standardRateModifiedColumn2;

	@Column(name = "shift_rate_as_per_ratecard_column2")
	private String shiftRateAsPerRateCardColumn2;

	@Column(name = "shift_rate_modified_column2")
	private String shiftRateModifiedColumn2;

	@Column(name = "oncall_rate_as_per_ratecard_column2")
	private String onCallRateAsPerRateCardColumn2;

	@Column(name = "oncall_rate_modified_column2")
	private String onCallRateModifiedColumn2;

	@Column(name = "oncall_holiday_rate_as_per_ratecard_column2")
	private String onCallHolidayRateAsPerRateCardColumn2;

	@Column(name = "oncall_holiday_rate_modified_column2")
	private String onCallHolidayRateModifiedColumn2;

	@Column(name = "comments")
	private String comments;

	@Column(name = "finance_rate")
	private String financeRate;

	@Column(name = "technology_group")
	private String technologyGroup;

	@Column(name = "actual_role_played")
	private String actualRolePlayed;

	@Column(name = "rate_type")
	private String rateType;

	@Column(name = "max_billable_hours_per_year")
	private String maxBillableHoursPerYear;

	@Column(name = "shift_type")
	private String shiftType;

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "fixed_rate_project")
	private String fixedRateProject;

	@Column(name = "offering_type")
	private String offeringType;

	@Column(name = "actual_percentage_charged")
	private String actualPercentageCharged;

	@Column(name = "project_manager")
	private String projectManager;

	@Column(name = "senior_project_manager")
	private String seniorProjectManager;

	@Column(name = "engagement_director")
	private String engagementDirector;

	@Column(name = "group_head")
	private String groupHead;

	@Column(name = "group_lead")
	private String groupLead;

	@Column(name = "account_group")
	private String accountGroup;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private String modifiedDate;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}



	public String getTrxOU() {
		return trxOU;
	}

	public void setTrxOU(String trxOU) {
		this.trxOU = trxOU;
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

	public String getEnsembleRate() {
		return ensembleRate;
	}

	public void setEnsembleRate(String ensembleRate) {
		this.ensembleRate = ensembleRate;
	}

	public String getStandardRateAsPerRateCard() {
		return standardRateAsPerRateCard;
	}

	public void setStandardRateAsPerRateCard(String standardRateAsPerRateCard) {
		this.standardRateAsPerRateCard = standardRateAsPerRateCard;
	}

	public String getStandardRateModified() {
		return standardRateModified;
	}

	public void setStandardRateModified(String standardRateModified) {
		this.standardRateModified = standardRateModified;
	}

	public String getShiftRateAsPerRateCard() {
		return shiftRateAsPerRateCard;
	}

	public void setShiftRateAsPerRateCard(String shiftRateAsPerRateCard) {
		this.shiftRateAsPerRateCard = shiftRateAsPerRateCard;
	}

	public String getShiftRateModified() {
		return shiftRateModified;
	}

	public void setShiftRateModified(String shiftRateModified) {
		this.shiftRateModified = shiftRateModified;
	}

	public String getOnCallRateAsPerRateCard() {
		return onCallRateAsPerRateCard;
	}

	public void setOnCallRateAsPerRateCard(String onCallRateAsPerRateCard) {
		this.onCallRateAsPerRateCard = onCallRateAsPerRateCard;
	}

	public String getOnCallRateModified() {
		return onCallRateModified;
	}

	public void setOnCallRateModified(String onCallRateModified) {
		this.onCallRateModified = onCallRateModified;
	}

	public String getOnCallHolidayRateAsPerRateCard() {
		return onCallHolidayRateAsPerRateCard;
	}

	public void setOnCallHolidayRateAsPerRateCard(String onCallHolidayRateAsPerRateCard) {
		this.onCallHolidayRateAsPerRateCard = onCallHolidayRateAsPerRateCard;
	}

	public String getOnCallHolidayRateModified() {
		return onCallHolidayRateModified;
	}

	public void setOnCallHolidayRateModified(String onCallHolidayRateModified) {
		this.onCallHolidayRateModified = onCallHolidayRateModified;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public String getEnsembleRateInr() {
		return ensembleRateInr;
	}

	public void setEnsembleRateInr(String ensembleRateInr) {
		this.ensembleRateInr = ensembleRateInr;
	}

	public String getStandardRateAsPerRateCardColumn2() {
		return standardRateAsPerRateCardColumn2;
	}

	public void setStandardRateAsPerRateCardColumn2(String standardRateAsPerRateCardColumn2) {
		this.standardRateAsPerRateCardColumn2 = standardRateAsPerRateCardColumn2;
	}

	public String getStandardRateModifiedColumn2() {
		return standardRateModifiedColumn2;
	}

	public void setStandardRateModifiedColumn2(String standardRateModifiedColumn2) {
		this.standardRateModifiedColumn2 = standardRateModifiedColumn2;
	}

	public String getShiftRateAsPerRateCardColumn2() {
		return shiftRateAsPerRateCardColumn2;
	}

	public void setShiftRateAsPerRateCardColumn2(String shiftRateAsPerRateCardColumn2) {
		this.shiftRateAsPerRateCardColumn2 = shiftRateAsPerRateCardColumn2;
	}

	public String getShiftRateModifiedColumn2() {
		return shiftRateModifiedColumn2;
	}

	public void setShiftRateModifiedColumn2(String shiftRateModifiedColumn2) {
		this.shiftRateModifiedColumn2 = shiftRateModifiedColumn2;
	}

	public String getOnCallRateAsPerRateCardColumn2() {
		return onCallRateAsPerRateCardColumn2;
	}

	public void setOnCallRateAsPerRateCardColumn2(String onCallRateAsPerRateCardColumn2) {
		this.onCallRateAsPerRateCardColumn2 = onCallRateAsPerRateCardColumn2;
	}

	public String getOnCallRateModifiedColumn2() {
		return onCallRateModifiedColumn2;
	}

	public void setOnCallRateModifiedColumn2(String onCallRateModifiedColumn2) {
		this.onCallRateModifiedColumn2 = onCallRateModifiedColumn2;
	}

	public String getOnCallHolidayRateAsPerRateCardColumn2() {
		return onCallHolidayRateAsPerRateCardColumn2;
	}

	public void setOnCallHolidayRateAsPerRateCardColumn2(String onCallHolidayRateAsPerRateCardColumn2) {
		this.onCallHolidayRateAsPerRateCardColumn2 = onCallHolidayRateAsPerRateCardColumn2;
	}

	public String getOnCallHolidayRateModifiedColumn2() {
		return onCallHolidayRateModifiedColumn2;
	}

	public void setOnCallHolidayRateModifiedColumn2(String onCallHolidayRateModifiedColumn2) {
		this.onCallHolidayRateModifiedColumn2 = onCallHolidayRateModifiedColumn2;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFinanceRate() {
		return financeRate;
	}

	public void setFinanceRate(String financeRate) {
		this.financeRate = financeRate;
	}

	public String getTechnologyGroup() {
		return technologyGroup;
	}

	public void setTechnologyGroup(String technologyGroup) {
		this.technologyGroup = technologyGroup;
	}

	public String getActualRolePlayed() {
		return actualRolePlayed;
	}

	public void setActualRolePlayed(String actualRolePlayed) {
		this.actualRolePlayed = actualRolePlayed;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getMaxBillableHoursPerYear() {
		return maxBillableHoursPerYear;
	}

	public void setMaxBillableHoursPerYear(String maxBillableHoursPerYear) {
		this.maxBillableHoursPerYear = maxBillableHoursPerYear;
	}

	public String getShiftType() {
		return shiftType;
	}

	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
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

	public String getFixedRateProject() {
		return fixedRateProject;
	}

	public void setFixedRateProject(String fixedRateProject) {
		this.fixedRateProject = fixedRateProject;
	}

	public String getOfferingType() {
		return offeringType;
	}

	public void setOfferingType(String offeringType) {
		this.offeringType = offeringType;
	}

	public String getActualPercentageCharged() {
		return actualPercentageCharged;
	}

	public void setActualPercentageCharged(String actualPercentageCharged) {
		this.actualPercentageCharged = actualPercentageCharged;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getSeniorProjectManager() {
		return seniorProjectManager;
	}

	public void setSeniorProjectManager(String seniorProjectManager) {
		this.seniorProjectManager = seniorProjectManager;
	}

	public String getEngagementDirector() {
		return engagementDirector;
	}

	public void setEngagementDirector(String engagementDirector) {
		this.engagementDirector = engagementDirector;
	}

	public String getGroupHead() {
		return groupHead;
	}

	public void setGroupHead(String groupHead) {
		this.groupHead = groupHead;
	}

	public String getGroupLead() {
		return groupLead;
	}

	public void setGroupLead(String groupLead) {
		this.groupLead = groupLead;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}

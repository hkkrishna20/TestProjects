package com.operationtool.controller.ratecard;

public class IDepartmentData {

	private String projectId;
	private String projectDescription;
	private String totalTalRevenue;
	private String[] revenuePerMonthList;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getTotalTalRevenue() {
		return totalTalRevenue;
	}

	public void setTotalTalRevenue(String totalTalRevenue) {
		this.totalTalRevenue = totalTalRevenue;
	}

	public String[] getRevenuePerMonthList() {
		return revenuePerMonthList;
	}

	public void setRevenuePerMonthList(String[] revenuePerMonthList) {
		this.revenuePerMonthList = revenuePerMonthList;
	}

}

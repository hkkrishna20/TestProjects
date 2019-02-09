package com.operationtool.controller.ratecard;

import java.util.List;

public class IDepartmentListData {

	private List<IDepartmentData> departmentData;
	private String[] monthsList;

	public List<IDepartmentData> getDepartmentData() {
		return departmentData;
	}

	public void setDepartmentData(List<IDepartmentData> departmentData) {
		this.departmentData = departmentData;
	}

	public String[] getMonthsList() {
		return monthsList;
	}

	public void setMonthsList(String[] monthsList) {
		this.monthsList = monthsList;
	}

}

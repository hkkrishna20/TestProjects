package com.operationtool.controller.ratecard;

import java.util.List;

public class FinanceSeries {

	private String name;

	private List<Double> data;
	private String[] months;

	public String[] getMonths() {
		return months;
	}

	public void setMonths(String[] months) {
		this.months = months;
	}

	private String prevLevel;

	private String nextLevel;

	public String getPrevLevel() {
		return prevLevel;
	}

	public void setPrevLevel(String prevLevel) {
		this.prevLevel = prevLevel;
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

}

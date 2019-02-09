/**
 * 
 */
package com.operationtool.controller.ratecard;

/**
 * @author test
 *
 */
public class FinanceRequest {

	private String designation;
	private String name;
	private String nextLevel;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public String getPreLevel() {
		return preLevel;
	}

	public void setPreLevel(String preLevel) {
		this.preLevel = preLevel;
	}

	public String getBussinessUnit() {
		return bussinessUnit;
	}

	public void setBussinessUnit(String bussinessUnit) {
		this.bussinessUnit = bussinessUnit;
	}

	private String preLevel;
	private String bussinessUnit;

}

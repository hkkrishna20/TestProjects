package com.operationtool.database.models.ratecard;

import java.util.Date;
import java.util.List;

public class RateCardDomain {

	// MemberID
	String resourceId;

	Date billingStartDate;
	Date billingEndDate;
	Date pcbStartDate;
	Date pcbEndDate;
	int pcbDays;
	int rate;
	// TODO: Need to pass the list of vacationDate
	List<String> vacationDate;
	String month;
	String year;

	public List<String> getVacationDate() {
		return vacationDate;
	}

	public void setVacationDate(List<String> vacationDate) {
		this.vacationDate = vacationDate;
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId
	 *            the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the billingStartDate
	 */
	public Date getBillingStartDate() {
		return billingStartDate;
	}

	/**
	 * @param billingStartDate
	 *            the billingStartDate to set
	 */
	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	/**
	 * @return the billingEndDate
	 */
	public Date getBillingEndDate() {
		return billingEndDate;
	}

	/**
	 * @param billingEndDate
	 *            the billingEndDate to set
	 */
	public void setBillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @return the pcbStartDate
	 */
	public Date getPcbStartDate() {
		return pcbStartDate;
	}

	/**
	 * @param pcbStartDate
	 *            the pcbStartDate to set
	 */
	public void setPcbStartDate(Date pcbStartDate) {
		this.pcbStartDate = pcbStartDate;
	}

	/**
	 * @return the pcbEndDate
	 */
	public Date getPcbEndDate() {
		return pcbEndDate;
	}

	/**
	 * @param pcbEndDate
	 *            the pcbEndDate to set
	 */
	public void setPcbEndDate(Date pcbEndDate) {
		this.pcbEndDate = pcbEndDate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the pcbDays
	 */
	public int getPcbDays() {
		return pcbDays;
	}

	/**
	 * @param pcbDays
	 *            the pcbDays to set
	 */
	public void setPcbDays(int pcbDays) {
		this.pcbDays = pcbDays;
	}

}

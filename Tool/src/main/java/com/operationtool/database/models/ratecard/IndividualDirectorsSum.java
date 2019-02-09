package com.operationtool.database.models.ratecard;

public class IndividualDirectorsSum {

	private String pcbmonth;
	private String bill;
	private String director;

	public String getPcbmonth() {
		return pcbmonth;
	}

	public void setPcbmonth(String pcbmonth) {
		this.pcbmonth = pcbmonth;
	}

	@Override
	public String toString() {
		return "IndividualDirectorsSum [pcbmonth=" + pcbmonth + ", bill=" + bill + ", director=" + director + "]";
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public IndividualDirectorsSum(String pcbmonth, String bill, String director) {
		super();
		this.pcbmonth = pcbmonth;
		this.bill = bill;
		this.director = director;
	}

	public IndividualDirectorsSum() {

	}
}

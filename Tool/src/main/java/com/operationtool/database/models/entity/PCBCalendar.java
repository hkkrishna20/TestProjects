
package com.operationtool.database.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pcbcalendar")
@Entity(name = "pcbcalendar")
@Table(name = "pcbcalendar")
@XmlAccessorType(XmlAccessType.FIELD)
public class PCBCalendar {
	@Id
	@Column(name = "month")
	@Temporal(TemporalType.DATE)
	protected Date month;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	protected Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	protected Date endDate;

	@Column(name = "pcb_days")
	protected String pcbDays;

	public void setMonth(Date month) {
		this.month = month;
	}

	public void setPcbDays(String pcbDays) {
		this.pcbDays = pcbDays;
	}

	public void setStartDate(Date start_date) {
		this.startDate = start_date;
	}

	public void setEndDate(Date end_date) {
		this.endDate = end_date;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getMonth() {
		return month;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getPcbDays() {
		return pcbDays;
	}

}

package com.operationtool.controller.ratecard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.operationtool.database.models.ratecard.RateCardDomain;

@Component
public class CalculateRateService {

	Map<String, Set<String>> vacationDates = new HashMap<String, Set<String>>();

	public void add(String x, String y) {
		Set<String> set = vacationDates.get(x);
		if (set == null) {
			vacationDates.put(x, set = new HashSet<String>());
		}
		vacationDates.get(x).add(y);
	}

	// Pcb dates value that is set is after removing the vacation dates.
	public int calculateRate(RateCardDomain rateCardDomain) {
		int rate = rateCardDomain.getRate();
		int billableDays = getNumberOfBillableDaysBasedOnBillableDays(rateCardDomain.getPcbDays(),
				rateCardDomain.getBillingStartDate(), rateCardDomain.getBillingEndDate(),
				rateCardDomain.getPcbStartDate(), rateCardDomain.getPcbEndDate());
		// TODO: Need to take this billable hours 9 from table or property.
		return rate * billableDays * 9;
	}

	public int getNumberOfBillableDaysBasedOnBillableDays(int pcbDays, Date billingStartDate, Date billingEndDate,
			Date pcbStartDate, Date pcbEndDate) {
		// Checking billing start and end date are valid for given pcb dates.
		if (compareBeforeOrEqual(billingStartDate, pcbStartDate) && compareAfterOrEqual(billingEndDate, pcbEndDate)) {
			// dont remove any days
			return pcbDays;
		}

		// Return zero if billing start date is more then pcb end date
		if (billingStartDate.after(pcbEndDate)) {
			return 0;
		}

		// Removing the days if billing start date is after the pcb start date
		if (compareAfterOrEqual(billingStartDate, pcbStartDate)) {
			pcbDays = pcbDays - getDaysDifference(pcbStartDate, billingStartDate);
		}

		// Removing the days if billing end date is before the pcb end date
		if (compareBeforeOrEqual(billingEndDate, pcbEndDate)) {
			pcbDays = pcbDays - getDaysDifference(billingEndDate, pcbEndDate);
		}

		return pcbDays;
	}

	public boolean compareBeforeOrEqual(Date acutalDate, Date compareDate) {
		boolean isDateIsbeforeOrEqual = false;
		if (acutalDate.before(compareDate) || acutalDate.equals(compareDate)) {
			isDateIsbeforeOrEqual = true;
		}
		return isDateIsbeforeOrEqual;
	}

	public boolean compareAfterOrEqual(Date acutalDate, Date compareDate) {
		boolean isDateIsbeforeOrEqual = false;
		if (acutalDate.after(compareDate) || acutalDate.equals(compareDate)) {
			isDateIsbeforeOrEqual = true;
		}
		return isDateIsbeforeOrEqual;
	}

	public int getDaysDifference(Date dateFirstComing, Date dateAfterComing) {
		LocalDate dateBefore = LocalDate.of(dateFirstComing.getYear(), dateFirstComing.getMonth() + 1,
				dateFirstComing.getDate());
		// 29-July-2017, change this to your desired End Date
		LocalDate dateAfter = LocalDate.of(dateAfterComing.getYear(), dateAfterComing.getMonth() + 1,
				dateAfterComing.getDate());
		Long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		return noOfDaysBetween.intValue();
	}

}

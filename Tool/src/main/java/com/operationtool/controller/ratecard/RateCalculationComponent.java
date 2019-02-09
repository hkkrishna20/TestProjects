package com.operationtool.controller.ratecard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTracker;
import com.operationtool.database.models.entity.CandidateBillPCBDaysTrackerId;
import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.models.entity.RateCardView;
import com.operationtool.database.models.ratecard.IndividualDirectorsSum;
import com.operationtool.database.models.ratecard.RateCardDomain;
import com.operationtool.database.repository.CandiatePCBAmountRepository;
import com.operationtool.database.repository.RateCardRepository;
import com.operationtool.database.repository.RateCardViewRepository;
import com.operationtool.database.service.CandidateBillPCBDaysTrackerService;
import com.operationtool.database.service.CandidateBillPCBTrackerService;
import com.operationtool.database.service.CandidateService;
import com.operationtool.database.service.MemberDetailsService;
import com.operationtool.database.service.OffshoreLeavesService;
import com.operationtool.database.service.PCBCalenderService;
import com.operationtool.database.service.RateCardService;

@Component
public class RateCalculationComponent {
	Map<String, RateCardView> rateViewObjects = new HashMap<String, RateCardView>();
	Map<String, Map<String, List<String>>> dates = new HashMap<String, Map<String, List<String>>>();

	@Autowired
	RateCardRepository rateRepo;

	@Autowired
	CalculateRateService calculateService;

	@Autowired
	CandidateBillPCBDaysTrackerService pcbdaysservice;

	@Autowired
	CandidateBillPCBTrackerService amountSaveService;

	@Autowired
	CandidateService candidateService;

	@Autowired
	MemberDetailsService memberDetailsService;

	@Autowired
	OffshoreLeavesService offshoreLeavesService;

	@Autowired
	PCBCalenderService pcbCalendarService;

	@Autowired
	RateCardService rateCardService;

	@Autowired
	RateCardViewRepository rateCardViewRepository;

	void calculateRates() throws ParseException {
		// TODO Auto-generated method stub
		Set<RateCardDomain> rateCardObjects = new HashSet<RateCardDomain>();
		Map<String, RateCardDomain> rateObjects = new HashMap<String, RateCardDomain>();
		Set<RateCardView> obj = rateCardViewRepository.retrieveRateCardView();
		for (RateCardView ob : obj) {
			calculateService.add(ob.getId().getMemberId(), ob.getId().getVacationDate());
			System.out
					.println("calculateRates() + " + ob.getId().getMemberId() + "----" + ob.getId().getVacationDate());
			RateCardDomain ratecardDomain = callRateCardDomain(ob);
			rateCardObjects.add(ratecardDomain);
			rateObjects.put(ob.getId().getMemberId(), ratecardDomain);
		}
		Map<String, Set<String>> vacationDates = calculateService.vacationDates;
		for (String key : rateObjects.keySet()) {
			Set<String> vacations = vacationDates.get(key);
			RateCardDomain ratecardDomain = rateObjects.get(key);
			List<String> mainList = new ArrayList<String>();
			mainList.addAll(vacations);
			ratecardDomain.setVacationDate(mainList);
			rateCardObjects.add(ratecardDomain);
		}
		for (RateCardDomain rateMember : rateCardObjects) {
			int days = rateMember.getPcbDays()
					- dates.get(rateMember.getResourceId()).get(rateMember.getMonth()).size();
			rateMember.setPcbDays(days);
			int amount = calculateService.calculateRate(rateMember);
			/// saving pcb days to database
			saveToBillPcbdays(days, amount, rateMember);
			// saving pcb month amount of candidate to database
			saveToBillPcbAmount(rateMember, amount);
		}

	}

	private void saveToBillPcbAmount(RateCardDomain rateMember, int amount) {
		// TODO Auto-generated method stub

		CandidateBillPCBAmountTracker entity1 = new CandidateBillPCBAmountTracker();
		CandidateBillPCBAmountTrackerId id1 = new CandidateBillPCBAmountTrackerId();
		id1.setPcbmonth(rateMember.getMonth());
		id1.setResourceid(rateMember.getResourceId());
		entity1.setId(id1);
		RateCardView rate = rateViewObjects.get(rateMember.getResourceId());
		entity1.setBillAmount(amount);
		entity1.setBillType("Billable");
		entity1.setEngagementDirector(rate.getEngagementDirector());
		entity1.setHrbu(rate.getHrbuStatus());
		entity1.setProject(rate.getProjectName());
		entity1.setProjectManger(rate.getProjectManager());
		entity1.setAccountGroup(rate.getAccountGroup());
		amountSaveService.saveOrUpdate(entity1);
	}

	private void saveToBillPcbdays(int days, int amount, RateCardDomain rateMember) {
		// TODO Auto-generated method stub
		CandidateBillPCBDaysTracker entity = new CandidateBillPCBDaysTracker();
		entity.setBillType("Billable");
		entity.setDays(days);
		CandidateBillPCBDaysTrackerId id = new CandidateBillPCBDaysTrackerId();
		id.setPcbmonth(rateMember.getMonth());
		id.setResourceid(rateMember.getResourceId());
		entity.setId(id);
		pcbdaysservice.add(entity);
	}

	private RateCardDomain callRateCardDomain(RateCardView ob) throws ParseException {
		RateCardDomain ratecardDomain = new RateCardDomain();
		ratecardDomain.setResourceId(ob.getId().getMemberId());
		ratecardDomain.setBillingStartDate(calculateFindDate(ob.getBillingStartDate()));
		ratecardDomain.setBillingEndDate(calculateFindDate(ob.getBillingEndDate()));
		ratecardDomain.setPcbStartDate(calculateFindDate(ob.getStartDate()));
		ratecardDomain.setPcbEndDate(calculateFindDate(ob.getEndDate()));
		ratecardDomain.setPcbDays(Integer.valueOf(ob.getPcbDays()));
		ratecardDomain.setRate(Integer.valueOf(ob.getStandardRateModified()));
		String date = calculateDate(ob.getMonth());
		String[] array;
		// split the string and store it in the array
		array = date.split("[,]");
		ratecardDomain.setMonth(date);
		ratecardDomain.setYear(array[1].trim());

		rateViewObjects.put(ob.getId().getMemberId(), ob);
		if (null == dates.get(ob.getId().getMemberId())) {
			Map<String, List<String>> value = new HashMap<String, List<String>>();
			dates.put(ob.getId().getMemberId(), value);

		}
		if (null == dates.get(ob.getId().getMemberId()).get(date)) {
			List<String> val = new ArrayList<String>();
			dates.get(ob.getId().getMemberId()).put(date, val);
		}

		dates.get(ob.getId().getMemberId()).get(date).add(ob.getId().getVacationDate());
		// TODO Auto-generated method stub
		return ratecardDomain;
	}

	private Date calculateFindDate(String string) throws ParseException {
		Calendar mydate = new GregorianCalendar();
		Date thedate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(string);
		mydate.setTime(thedate);
		return thedate;
	}

	private String calculateDate(String string) throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM, yyyy", Locale.ENGLISH);
		LocalDate ld = LocalDate.parse(string, dtf);
		String month_name = dtf2.format(ld);

		return month_name;

	}

	public static boolean test(Date pcbMonthStartDate, Date pcbMonthEndDate, Date vacationDayofPCBMonth)
			throws ParseException {
		boolean test = between(vacationDayofPCBMonth, pcbMonthStartDate, pcbMonthEndDate);
		return test;

	}
	/*
	 * public Boolean checkDate(Date startDate, Date endDate, Date checkDate) {
	 * Interval interval = new Interval(new DateTime(startDate), new
	 * DateTime(endDate)); return interval.contains(new DateTime(checkDate)); }
	 */

	public static boolean between(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			if ((date.after(dateStart) && date.before(dateEnd)) || date.equals(dateStart) || date.equals(dateEnd)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private Date convert(Object object) throws ParseException {

		String[] possibleDateFormats = { "yyyy-MM-dd", "dd/MM/yyyy", "dd/MM/yy", "yyyy.MM.dd G 'at' HH:mm:ss z",
				"EEE, MMM d, ''yy", "h:mm a", "hh 'o''clock' a, zzzz", "K:mm a, z", "yyyyy.MMMMM.dd GGG hh:mm aaa",
				"EEE, d MMM yyyy HH:mm:ss Z", "yyMMddHHmmssZ", "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
				"yyyy-MM-dd'T'HH:mm:ss.SSSXXX", "YYYY-'W'ww-u", "EEE, dd MMM yyyy HH:mm:ss z",
				"EEE, dd MMM yyyy HH:mm zzzz", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz",
				"yyyy-MM-dd'T'HH:mm:sszzzz", "yyyy-MM-dd'T'HH:mm:ss z", "yyyy-MM-dd'T'HH:mm:ssz",
				"yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HHmmss.SSSz", "yyyyMMdd" };
		Date outputDate = null;

		try {

			outputDate = DateUtils.parseDate(String.valueOf(object), possibleDateFormats);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(String.valueOf(object), formatter);
			int year = localDate.getYear();
			int month = localDate.getMonthValue();
			int dayOfMonth = localDate.getDayOfMonth();

			Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
			Date myDate = myCalendar.getTime();

			SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
			return myDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

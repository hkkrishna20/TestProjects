package com.operationtool.util.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
	public static void main(String[] args) throws ParseException {
		/*
		 * IntStream.range(1, 1).parallel().forEach( nbr -> { try { Thread.sleep(1000);
		 * } catch (InterruptedException ex) {} System.out.println(nbr); } );
		 */
		
		
		/*LocalDateTime.from(referenceDate.toInstant()).minusMonths(6);*/

/*		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		Date parse = sdf.parse("18/01/2012");  
		Calendar c = Calendar.getInstance();  
		c.setTime(parse);  
		System.out.println(c.get(Calendar.MONTH) +"" + c.get(Calendar.DATE) +""+ c.get(Calendar.YEAR));
	
		
		//test2();
		//testt();
		 sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = "31-08-1982";
		Date a = sdf.parse(dateInString);
		System.out.println(a);

		String dateInString2 = "30-09-1982";
		Date b = sdf.parse(dateInString2);
		System.out.println(b);

		String dateIn = "30-09-1982";
		Date d = sdf.parse(dateIn);
		System.out.println(b);

		test(a,b,d);

		JSONObject jo = new JSONObject();
		jo.put("firstName", "John");
		jo.put("lastName", "Doe");

		JSONArray ja = new JSONArray();
		ja.put(jo);

		jo = new JSONObject();
		jo.put("firstName", "Joh1n");
		jo.put("lastName", "Doe1");

		ja.put(jo);
		JSONObject mainObj = new JSONObject();
		mainObj.put("employees", ja);
*/
//		System.out.println(mainObj);
	}

	private static void test2() {
		
	}

	/*
	 * public Boolean checkDate(Date startDate, Date endDate, Date checkDate) {
	 * Interval interval = new Interval(new DateTime(startDate), new
	 * DateTime(endDate)); return interval.contains(new DateTime(checkDate)); }
	 */

	public static boolean between(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			if ((date.after(dateStart) && date.before(dateEnd))
					|| date.equals(dateStart) 
					|| date.equals(dateEnd)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean test(Date pcbMonthStartDate, Date pcbMonthEndDate,Date vacationDayofPCBMonth) throws ParseException {
		boolean test = between(vacationDayofPCBMonth, pcbMonthStartDate, pcbMonthEndDate);
		System.out.println(test);
		return test;

	}
	
	
	
	
	public static void testt() throws ParseException {
		
		TreeMap<Integer, List<Date>> dateHashMap = new TreeMap<>();

	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    List<Date> dates = new ArrayList<>();


	    dates.add(sdf.parse("10/03/2017"));
	    dates.add(sdf.parse("9/03/2017"));
	    dates.add(sdf.parse("8/03/2017"));
	    dates.add(sdf.parse("7/03/2017"));
	    dates.add(sdf.parse("6/03/2017"));

	    dates.add(sdf.parse("23/02/2017"));
	    dates.add(sdf.parse("3/02/2017"));

	    dates.add(sdf.parse("2/02/2017"));
	    dates.add(sdf.parse("1/02/2017"));


	    for (int i = 0; i < dates.size(); i++) {
	        List<Date> datesList = new ArrayList<>();
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(dates.get(i));

	        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

	        for (Date date : dates) {
	            Calendar c = Calendar.getInstance();
	            c.setTime(date);
	            if (weekOfMonth == c.get(Calendar.WEEK_OF_MONTH)) {
	                datesList.add(date);
	            }
	        }

	        dateHashMap.put(weekOfMonth, datesList);


	    }

	    System.out.println(dateHashMap.toString());
	}
		
	public List<String> getListOfWeeksFromListOfDates(List<Date> listOfDates) {
	    List<String> listOfWeeks = new ArrayList<>();

	    for (Date date : listOfDates) {
	        listOfWeeks.add(new SimpleDateFormat("w").format(date));
	    }

	    return listOfWeeks;
	}	
}

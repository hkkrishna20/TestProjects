package com.operationtool.controller.highchart;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitorjbl.xlsx.StreamingReader;
import com.operationtool.database.models.entity.BillableProject;
import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;
import com.operationtool.database.models.entity.ForecastLeaveTracker;
import com.operationtool.database.models.entity.ForecastLeaveTrackerId;
import com.operationtool.database.models.entity.PCBCalendar;
import com.operationtool.database.models.entity.RateCardSystem;
import com.operationtool.database.models.entity.RateCardTrackerId;
import com.operationtool.database.service.CandidateBillPCBTrackerService;
import com.operationtool.database.service.CandidateService;
import com.operationtool.database.service.MemberDetailsService;
import com.operationtool.database.service.OffshoreLeavesService;
import com.operationtool.database.service.PCBCalenderService;
import com.operationtool.database.service.RateCardService;
import com.operationtool.highchart.models.drilldown.Credits;
import com.operationtool.highchart.models.drilldown.Datum;
import com.operationtool.highchart.models.drilldown.HighChart;
import com.operationtool.highchart.models.drilldown.Series_;
import com.operationtool.highchart.models.drilldown.Series_2;

@Component
public class OrganisationAnalysisComponent {
	@Autowired
	CandidateService candidateService;

	@Autowired
	MemberDetailsService memberDetailsService;

	@Autowired
	OffshoreLeavesService offshoreLeavesService;

	@Autowired
	PCBCalenderService pcbCalenderService;

	@Autowired
	RateCardService rateCardService;

	@Autowired
	CandidateBillPCBTrackerService candidatePcbCalendarAmountTest;

	public String getDataOrg(Set<Candidate> mergeSetsList)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("getDirectPNC   getDataOrg");
		Map<String, Set<String>> directToManagers = new HashMap<String, Set<String>>();
		Map<String, String> resourceIdtoResourceName = new HashMap<String, String>();
		Map<String, String> resourceIdtoEmail = new HashMap<String, String>();
		Map<String, String> projectIdToDescription = new HashMap<String, String>();
		List<String> resourceIds = new ArrayList<String>();
		List<String> resourceNames = new ArrayList<String>();
		List<String> resourceEmails = new ArrayList<String>();
		List<Candidate> templist = mergeSetsList.stream().collect(Collectors.toList());

		Map<String, Candidate> resourceCandidateMap = new HashMap<String, Candidate>();
		Set<String> set = new TreeSet<>();
		Map<String, String> resourceToLocation = new HashMap<String, String>();
		Map<String, String> resourceToSubLocation = new HashMap<String, String>();
		Map<String, String> resourceGender = new HashMap<String, String>();
		for (Candidate candidate : templist) {
			resourceCandidateMap.put(candidate.getResourceID(), candidate);
			set.add(candidate.getDirectordept10inthehrtree());
			projectIdToDescription.put(candidate.getDepartmentid(), candidate.getDepartmentdescription());
			resourceIds.add(candidate.getResourceID());
			resourceNames.add(candidate.getResourcename());
			resourceEmails.add(candidate.getResourceemailid());
			resourceToLocation.put(candidate.getResourceID(), candidate.getLocation());
			resourceToSubLocation.put(candidate.getResourceID(), candidate.getSublocation());
			resourceGender.put(candidate.getResourceID(), candidate.getGender());

			/*
			 * resourceIdtoResourceName.put(candidate.getResourceID().trim().toString(), ""
			 * + candidate.getResourcename().trim().toString());
			 */
		}
		int count = 0;
		for (String resourceid : resourceIds) {
			if (!resourceid.isEmpty()) {
				resourceIdtoResourceName.put(resourceid, resourceNames.get(count));
				resourceIdtoEmail.put(resourceid, resourceEmails.get(count));
			}
			count++;

		}
		List<String> directorNames = set.stream().collect(Collectors.toList());
		Map<String, Map<String, Map<String, Set<String>>>> org = new HashMap<String, Map<String, Map<String, Set<String>>>>();
		for (String dirName : directorNames) {
			if (!(dirName.isEmpty() || dirName.length() < 1)) {
				Set<String> ManagersList = new TreeSet<>();
				for (Candidate candidate : templist) {
					if (candidate.getDirectordept10inthehrtree().equals(dirName)) {
						ManagersList.add(candidate.getReportingmanager());
					}
				}
				directToManagers.put(dirName, ManagersList);
			}
		}

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
		Map<String, Set<String>> directorsToReportMangersresult = templist.stream()
				.collect(Collectors.groupingBy(Candidate::getDirectordept10inthehrtree,
						Collectors.mapping(Candidate::getReportingmanager, Collectors.toSet())));
		List<String> directorlist = new ArrayList<String>(directorsToReportMangersresult.keySet());
		Collections.sort(directorlist);

		for (String dir : directorlist) {

			if (!dir.isEmpty()) {

				for (String dir2 : directorlist) {

					if (!dir.isEmpty()) {

						directorsToReportMangersresult.get(dir).remove(dir2);
						// removeReportManagers(projectManagerss, directorlist);

					}
				}
			}

		}

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
		Map<String, Set<String>> managersProjectsresult = templist.stream()
				.collect(Collectors.groupingBy(Candidate::getReportingmanager,
						Collectors.mapping(Candidate::getDepartmentdescription, Collectors.toSet())));

		Map<String, Set<String>> projectsMembersresult = templist.stream().collect(Collectors.groupingBy(
				Candidate::getDepartmentid, Collectors.mapping(Candidate::getResourceID, Collectors.toSet())));
		Map<String, Set<String>> projectsMembersNamesresult = new HashMap<String, Set<String>>();

		for (String key : projectsMembersresult.keySet()) {
			Set<String> sets = projectsMembersresult.get(key);
			Set<String> names = new TreeSet<>();
			for (String t : sets) {
				names.add(resourceIdtoResourceName.get(t));
			}

			projectsMembersNamesresult.put(key, names);
		}

		Map<String, Set<String>> projectsDescriptgMembersresult = templist.stream().collect(Collectors.groupingBy(
				Candidate::getDepartmentdescription, Collectors.mapping(Candidate::getResourceID, Collectors.toSet())));
		
		HighChart responseS = new HighChart();
		responseS.getChart().setType("pie");
		responseS.getTitle().setText("Organisation Analytics");
		responseS.getSubtitle().setText("");
		responseS.getPlotOptions().getSeries().getDataLabels().setEnabled(true);
		responseS.getPlotOptions().getSeries().getDataLabels().setFormat("{point.name}: {point.y}");
		responseS.getTooltip().setHeaderFormat("<span style=\"font-size:9px\">{series.name}</span><br>");
		responseS.getTooltip()
				.setPointFormat("<span style=\"color:{point.color}\">{point.name}</span>: <b>{point.y}</b><br/>");

		Series_2 directorsseries2 = new Series_2();
		directorsseries2.setColorByPoint(true);
		directorsseries2.setName("Directors");

		/*
		 * Datum dirSeries = new Datum(); dirSeries.setName("Directors"); int
		 * countofDirectors = 0; for (String dir : directorlist) { if (!(dir.isEmpty()
		 * || dir.trim().length() < 1)) { countofDirectors++;
		 * 
		 * }
		 * 
		 * } dirSeries.setY(Double.valueOf(countofDirectors));
		 * dirSeries.setDrilldown("directors");
		 * directorsseries2.getData().add(dirSeries);
		 */

		ObjectMapper dirmapper = new ObjectMapper();

		String datalabels = "{ \r\n" + "				        \"enabled\": true, \r\n"
				+ "				      \"rotation\": 0,\r\n" + "				        \"color\": \"#FFFFFF\", \r\n"
				+ "				        \"align\": \"right\",  \r\n"
				+ "				        \"format\": \"{point.y}\", \r\n" + "				        \"style\": { \r\n"
				+ "				            \"fontSize\": \"8px\", \r\n"
				+ "				            \"fontFamily\": \"Verdana, sans-serif\" \r\n"
				+ "				        } \r\n" + "				  }";

		// DataLabels datalabel = dirmapper.readValue(datalabels, DataLabels.class);

		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				Datum dataN = new Datum();
				String name = director;// "John Paul Jones"; // read this from the user
				name = name.replaceAll("(?<=\\w)\\w+(?=\\s)", ".");
				/*
				 * String [] phraseChanger = phraseToChange.split(" "); StringBuilder sb = new
				 * StringBuilder(); for (int i=0; i < phraseChanger.length ; i++) {
				 * sb.append(phraseChanger[i].charAt(0)); }
				 * 
				 * System.out.println(sb.toString());
				 */

				String string = name;
				String[] parts = string.split(",");
				dataN.setName(parts[0].charAt(0) + "." + parts[1]);
				dataN.setDrilldown(director.toLowerCase());
				dataN.setY(Double.valueOf(directorsToReportMangersresult.get(director).size()));
				directorsseries2.getData().add(dataN);
			}

		}
		// directorsseries2.setDataLabels(datalabel);
		responseS.getSeries().add(directorsseries2);
		List<Datum> data = null;
		Series_ directorsseries0 = new Series_();
		directorsseries0.setId("directors");
		directorsseries0.setName("directors");

		// responseS.getDrilldown().getDrilldown().add(directorsseries0);
		directorsseries0 = new Series_();
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				directorsseries0 = new Series_();
				directorsseries0.setId(director.toLowerCase());
				directorsseries0.setName(director.toLowerCase());
				data = new ArrayList<Datum>();
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						Datum dataN = new Datum();
						/*
						 * String [] phraseChanger = phraseToChange.split(" "); StringBuilder sb = new
						 * StringBuilder(); for (int i=0; i < phraseChanger.length ; i++) {
						 * sb.append(phraseChanger[i].charAt(0)); }
						 * 
						 * System.out.println(sb.toString());
						 */
						String string = managers;
						String[] parts = string.split(",");
						dataN.setName(parts[1]);
						dataN.setDrilldown(managers.toLowerCase());
						dataN.setY(Double.valueOf(managersProjectsresult.get(managers).size()));
						data.add(dataN);
					}
				}
				Set<Datum> setss = data.stream()
						.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
				List<Datum> mainList = new ArrayList<Datum>();
				mainList.addAll(setss);
				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
				directorsseries0.setData(mainList);
				// directorsseries0.setDataLabels(datalabel);
				responseS.getDrilldown().getDrilldown().add(directorsseries0);
			}
		}
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				List<Series_> dir = new ArrayList<Series_>();
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						Set<String> projects = managersProjectsresult.get(managers);
						directorsseries0 = new Series_();
						directorsseries0.setId(managers.toLowerCase());
						String[] parts = managers.toLowerCase().split(",");
						directorsseries0.setName(parts[0].charAt(0) + "," + parts[1]);
						data = new ArrayList<Datum>();
						for (int j = 0; j < managersProjectsresult.get(managers).size(); j++) {
							for (String proj : projects) {
								Set<String> projeId = getKeysByValue(projectIdToDescription, proj);
								List<String> mainList = new ArrayList<String>();
								mainList.addAll(projeId);
								Datum dataN = new Datum();
								String string = proj;
								parts = string.split(" ");
								String projectNameFinal = "";
								for (int k = 1; k < parts.length; k++) {
									projectNameFinal = projectNameFinal + "-" + parts[k];
								}
								projectNameFinal = projectNameFinal.substring(1);
								String part1 = parts[0]; // 004
								String part2 = parts[1]; // 034556
								dataN.setName(projectNameFinal);
								dataN.setDrilldown(mainList.get(0));
								if (projectsMembersresult.get(mainList.get(0)) != null) {
									dataN.setY(Double.valueOf(projectsMembersresult.get(mainList.get(0)).size()));
								} else {
									dataN.setY(Double.valueOf(0));
								}
								data.add(dataN);
							}

						}
						Set<Datum> setss = data.stream().collect(
								Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
						List<Datum> mainList = new ArrayList<Datum>();
						mainList.addAll(setss);
						directorsseries0.setData(mainList);
						// directorsseries0.setDataLabels(datalabel);
						dir.add(directorsseries0);
					}
				}
				Set<Series_> setss = dir.stream()
						.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Series_::getName))));
				List<Series_> mainList = new ArrayList<Series_>();
				mainList.addAll(setss);
				responseS.getDrilldown().getDrilldown().addAll(mainList);
				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
			}
		}
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				List<Series_> dir = new ArrayList<Series_>();
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						Set<String> projects = managersProjectsresult.get(managers);
						for (int j = 0; j < managersProjectsresult.get(managers).size(); j++) {
							for (String proj : projects) {
								Set<String> projeId = getKeysByValue(projectIdToDescription, proj);

								List<String> mainList = new ArrayList<String>();
								mainList.addAll(projeId);
								directorsseries0 = new Series_();
								directorsseries0.setId(mainList.get(0));
								directorsseries0.setType("column");
								String string = proj;
								String[] parts = string.split(" ");
								String projectNameFinal = "";
								for (int k = 1; k < parts.length; k++) {
									projectNameFinal = projectNameFinal + parts[k];
								}
								String part1 = parts[0]; // 004
								String part2 = parts[1]; // 034556
								directorsseries0.setName(projectNameFinal);
								data = new ArrayList<Datum>();

								// dataN.setDrilldown(mainList.get(0));
								if (projectsMembersresult.get(mainList.get(0)) != null) {
									Set<String> mem = projectsMembersresult.get(mainList.get(0));
									for (String memb : mem) {
										Datum dataN = new Datum();

										Set<String> memberName = getKeysByValue(projectIdToDescription, memb);
										List<String> mainNameList = new ArrayList<String>();
										mainNameList.addAll(memberName);
										/*
										 * String emailid = resourceIdtoEmail.get(memb); String firstName =
										 * emailid.split(".")[0]; String lastName = emailid.split(".")[1];
										 */
										dataN.setName(resourceIdtoResourceName.get(memb).split(" ")[1]);
										// dataN.setDrilldown(memb);
										Candidate name = resourceCandidateMap.get(memb);
										dataN.setY(Double.valueOf(name.getTotalexp()));
										data.add(dataN);
									}
								}
								Set<Datum> setss = data.stream().collect(Collectors
										.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
								List<Datum> mainlList = new ArrayList<Datum>();
								mainlList.addAll(setss);
								directorsseries0.setData(mainlList);
								// directorsseries0.setDataLabels(datalabel);
								directorsseries0.getDataLabels();
								dir.add(directorsseries0);
							}

						}

					}
				}
				Set<Series_> setss = dir.stream()
						.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Series_::getName))));
				List<Series_> mainList = new ArrayList<Series_>();
				mainList.addAll(setss);
				responseS.getDrilldown().getDrilldown().addAll(mainList);
				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
			}
		}

		ObjectMapper mapper = new ObjectMapper();

		String jsonInString = "{\r\n" + "				\"enabled\":false,\r\n" + "				\"href\":\"\",\r\n"
				+ "				\"position\":{\r\n" + "				\"align\":\"right\",\r\n"
				+ "				\"verticalAlign\":\"bottom\",\r\n" + "				\"x\":-10,\r\n"
				+ "				\"y\":-5\r\n" + "				},\r\n"
				+ "				\"style\":{\"cursor\": \"pointer\", \"color\": \"#FFFFFF\", \"fontSize\": \"4px\"},\r\n"
				+ "				\"text\":\"\"\r\n" + "				}";

		Credits credits = mapper.readValue(jsonInString, Credits.class);
		// System.out.println(credits);

		responseS.setCredits(credits);

		mapper = new ObjectMapper();

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseS);
		return json;
	}

	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
		return map.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}

	// Generic function to merge two sets in Java
	public static <T> Set<T> mergeSets(Set<T> a, Set<T> b) {
		return Stream.of(a, b).flatMap(x -> x.stream()).collect(Collectors.toSet());
	}

	public static void removeReportManagers(Set<String> list, List<String> directors) {
		for (String s : list) {
			for (String dir : directors) {
				if (dir.contains(s)) {
					list.remove(s);
				}
			}

		}
	}

	public Set<Candidate> doSomething() {
		Set<Candidate> pNCpersons = candidateService.findByPyramidaccounthrbu("PNC");
		Set<Candidate> pncBank = candidateService.findByPyramidaccounthrbu("PNC Bank");
		Set<Candidate> newSet = new HashSet<Candidate>(pNCpersons);
		newSet.addAll(pncBank);
		List<Candidate> newList = new ArrayList<Candidate>(newSet);
		Set<Candidate> myset = newList.stream().collect(Collectors.toSet());
		return myset;
	}

	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

	public File multipartToFiles(MultipartFile multipart) throws IllegalStateException, IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + timeStamp
				+ multipart.getOriginalFilename());
		multipart.transferTo(tmpFile);
		return tmpFile;
	}

	void readBatchExcel(MultipartFile files, String uploadCategory, int min, int max)
			throws IOException, InvalidFormatException {
		InputStream inputStream = new BufferedInputStream(files.getInputStream());
		OPCPackage opcPackage = OPCPackage.open(inputStream);
		XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
		inputStream.close();
	}

	public void readExcel(MultipartFile files, String uploadCategory) throws IOException, InvalidFormatException {
		System.out.println("Entry  readExcel");
		if (files.getBytes().length > 0) {
			InputStream inputStream = files.getInputStream();
			try (Workbook wb = StreamingReader.builder().open(inputStream)) {
				List<List<Cell>> obj = new ArrayList<>();
				for (Row r : wb.getSheetAt(0)) {
					List<Cell> o = new ArrayList<>();
					if (r != null) {
						for (int k = 0; k < r.getLastCellNum(); k++) {
							o.add(r.getCell(k));
						}

					}
					obj.add(o);
				}
				System.out.println("Size" + obj.size());
				for (int j = 1; j < obj.size(); j++) {
					List<Cell> rown = obj.get(j);
					if (uploadCategory.equalsIgnoreCase("Organisation")) {
						if (rown.get(0) != null) {

							Candidate resource = addResource(rown);
							candidateService.saveOrUpdate(resource);
						}
					} else if (uploadCategory.equalsIgnoreCase("pcbcalendar")) {
						if (rown.get(0) != null) {

							PCBCalendar resource = addpcbcalendarResource(rown);
							pcbCalenderService.saveOrUpdate(resource);
						}
					} else if (uploadCategory.equalsIgnoreCase("memberdetails")) {
						if (rown.get(0) != null) {
							BillableProject resource = addBillableProjectResource(rown);
							memberDetailsService.saveOrUpdate(resource);

						}
					} else if (uploadCategory.equalsIgnoreCase("ratecard")) {
						if (rown.get(0) != null) {
							System.out.println("RateCard");
							RateCardSystem resource = addRateCardResource(rown);
							rateCardService.saveOrUpdate(resource);
						}
					} else if (uploadCategory.equalsIgnoreCase("offshoreleavetracker")) {
						if (rown.get(0) != null) {
							ForecastLeaveTracker resource = addOffshoreLeaveResource(rown);
							offshoreLeavesService.saveOrUpdate(resource);
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Exit  readExcel");
	}

	private ForecastLeaveTracker addOffshoreLeaveResource(List<Cell> row) throws ParseException {
		// TODO Auto-generated method stub
		DataFormatter df = new DataFormatter();
		ForecastLeaveTracker resource = new ForecastLeaveTracker();
		ForecastLeaveTrackerId id = new ForecastLeaveTrackerId();
		id.setResourceid(df.formatCellValue(row.get(0)));
		System.out.println("ResourceId : " + df.formatCellValue(row.get(0)));
		String date = df.formatCellValue(row.get(5));
		String dateparts[] = date.split("-");
		System.out.println(dateparts[0] + "  " + dateparts[1] + "  " + dateparts[2]);
		id.setDay(dateparts[0]);
		id.setMonth(dateparts[1]);
		id.setYear(dateparts[2]);
		resource.setResourceName(df.formatCellValue(row.get(1)));
		resource.setId(id);
		resource.setProject(df.formatCellValue(row.get(2)));
		resource.setVacationType(df.formatCellValue(row.get(6)));
		resource.setOffshoreManager(df.formatCellValue(row.get(4)));
		resource.setCgiOnsiteEngManager(df.formatCellValue(row.get(3)));
		Date date1 = new SimpleDateFormat("dd-MMM-yy").parse(df.formatCellValue(row.get(5)));

		resource.setVacationDate(date1);
		System.out.println("Over");
		return resource;
	}

	private BillableProject addBillableProjectResource(List<Cell> row) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("-------------------->");
		BillableProject resource = new BillableProject();
		DataFormatter df = new DataFormatter();
		System.out.println(df.formatCellValue(row.get(0)));
		resource.setResourceId(df.formatCellValue(row.get(0)));
		System.out.println(df.formatCellValue(row.get(1)));
		resource.setResourceName(df.formatCellValue(row.get(1)));
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(df.formatCellValue(row.get(2)));
		System.out.println(df.formatCellValue(row.get(2)));
		resource.setBillingStartDate(date1);
		System.out.println(df.formatCellValue(row.get(3)));
		date1 = new SimpleDateFormat("dd-MM-yyyy").parse(df.formatCellValue(row.get(3)));
		resource.setBillingEndDate(date1);
		return resource;
	}

	private PCBCalendar addpcbcalendarResource(List<Cell> row) throws ParseException {
		// TODO Auto-generated method stub
		DataFormatter df = new DataFormatter();
		PCBCalendar resource = new PCBCalendar();
		Date date1 = new SimpleDateFormat("y-MMM").parse(df.formatCellValue(row.get(0)));
		resource.setMonth(date1);
		resource.setPcbDays(df.formatCellValue(row.get(3)));
		date1 = new SimpleDateFormat("dd-MMM-yy").parse(df.formatCellValue(row.get(1)));
		resource.setStartDate(date1);
		date1 = new SimpleDateFormat("dd-MMM-yy").parse(df.formatCellValue(row.get(2)));

		resource.setEndDate(date1);
		return resource;
	}

	public static Candidate addResource(List<Cell> row) {
		System.out.println("Entry  addResource");
		Candidate newResource = new Candidate();
		DataFormatter df = new DataFormatter();
		newResource.setResourceID(df.formatCellValue(row.get(0)));
		newResource.setResourcename(df.formatCellValue(row.get(1)));
		newResource.setResourceemailid(df.formatCellValue(row.get(2)));
		newResource.setDoj(df.formatCellValue(row.get(3)));
		newResource.setDesignation(df.formatCellValue(row.get(4)));
		newResource.setGender(df.formatCellValue(row.get(5)));
		newResource.setShortdesignation(df.formatCellValue(row.get(6)));
		newResource.setCgiexp(df.formatCellValue(row.get(7)));
		newResource.setPrevexp(df.formatCellValue(row.get(8)));
		newResource.setTotalexp(df.formatCellValue(row.get(9)));
		newResource.setMembertype(df.formatCellValue(row.get(10)));
		newResource.setLocation(df.formatCellValue(row.get(11)));
		newResource.setSublocation(df.formatCellValue(row.get(12)));
		newResource.setSkillsfamily(df.formatCellValue(row.get(13)));
		newResource.setCompetency(df.formatCellValue(row.get(14)));
		newResource.setSubcompetency(df.formatCellValue(row.get(15)));
		newResource.setSkillcategory(df.formatCellValue(row.get(16)));
		newResource.setDepartmentid(df.formatCellValue(row.get(17)));
		newResource.setDepartmentdescription(df.formatCellValue(row.get(18)));
		newResource.setAssignmentstartdate(df.formatCellValue(row.get(19)));
		newResource.setAssignmentenddate(df.formatCellValue(row.get(20)));
		newResource.setEmployeestatus(df.formatCellValue(row.get(21)));
		newResource.setReleasemonth(df.formatCellValue(row.get(22)));
		newResource.setReportingmanager(df.formatCellValue(row.get(23)));
		newResource.setReportingmanageremailid(df.formatCellValue(row.get(24)));
		newResource.setProjectmanagerdept11inthehrtree(df.formatCellValue(row.get(25)));
		newResource.setDirectordept10inthehrtree(df.formatCellValue(row.get(26)));
		newResource.setGroupleaddept9inthehrtree(df.formatCellValue(row.get(27)));
		newResource.setBuleaddept8inthehrtree(df.formatCellValue(row.get(28)));
		newResource.setPyramidaccounthrbu(df.formatCellValue(row.get(29)));
		newResource.setHrbu(df.formatCellValue(row.get(30)));
		System.out.println("Exit  addResource");
		return newResource;
	}

	private RateCardSystem addRateCardResource(List<Cell> row) {
		System.out.println("RateCard");
		List<String> strings = new ArrayList<String>();
		int count = 0;
		for (Cell cell : row) {
			DataFormatter df = new DataFormatter();
			if (cell == null) {
				strings.add("");
				System.out.println(count);
			} else {
				strings.add(df.formatCellValue(row.get(count)));
				System.out.println("" + df.formatCellValue(row.get(count)));
			}
			count++;
		}

		try {
			RateCardSystem resource = new RateCardSystem();
			RateCardTrackerId od = new RateCardTrackerId();
			od.setMemberId("" + strings.get(0));
			od.setBillableStatus(strings.get(3));
			resource.setId(od);
			resource.setMemberName(strings.get(1));
			resource.setActiveStatus(strings.get(2));
			resource.setTrxOU(strings.get(4));
			resource.setHrbuStatus(strings.get(5));
			resource.setBaseCurrency(strings.get(6));
			resource.setEnsembleRate(strings.get(7));
			resource.setStandardRateAsPerRateCard(strings.get(8));
			resource.setStandardRateModified(strings.get(9));
			resource.setShiftRateAsPerRateCard(strings.get(10));
			resource.setShiftRateModified(strings.get(11));
			resource.setOnCallRateAsPerRateCard(strings.get(12));
			resource.setOnCallRateModified(strings.get(13));
			resource.setOnCallHolidayRateAsPerRateCard(strings.get(14));
			resource.setOnCallHolidayRateModified(strings.get(15));
			resource.setTargetCurrency(strings.get(16));
			resource.setEnsembleRateInr(strings.get(17));
			resource.setStandardRateAsPerRateCardColumn2(strings.get(18));
			resource.setStandardRateModifiedColumn2(strings.get(19));
			resource.setShiftRateAsPerRateCardColumn2(strings.get(20));
			resource.setShiftRateModifiedColumn2(strings.get(21));
			resource.setOnCallRateAsPerRateCardColumn2(strings.get(22));
			resource.setOnCallRateModifiedColumn2(strings.get(23));
			resource.setOnCallHolidayRateAsPerRateCardColumn2(strings.get(24));
			resource.setOnCallHolidayRateModifiedColumn2(strings.get(25));
			resource.setComments(strings.get(26));
			resource.setFinanceRate(strings.get(27));
			resource.setTechnologyGroup(strings.get(28));
			resource.setActualRolePlayed(strings.get(29));
			resource.setRateType(strings.get(30));
			resource.setMaxBillableHoursPerYear(strings.get(31));
			resource.setShiftType(strings.get(32));
			resource.setDeptId(strings.get(33));
			resource.setProjectName(strings.get(34));
			resource.setFixedRateProject(strings.get(35));
			resource.setOfferingType(strings.get(36));
			resource.setActualPercentageCharged(strings.get(37));
			resource.setProjectManager(strings.get(38));
			resource.setSeniorProjectManager(strings.get(39));
			resource.setEngagementDirector(strings.get(40));
			resource.setGroupHead(strings.get(41));
			resource.setGroupLead(strings.get(42));
			System.out.println("setAccountGroup" + strings.get(43));
			resource.setAccountGroup(strings.get(43));
			System.out.println(strings.get(45));
			resource.setCreatedDate(strings.get(45));
			resource.setModifiedBy(strings.get(46));
			resource.setModifiedDate(strings.get(47));

			System.out.println("CreatedBy");
			resource.setCreatedBy(strings.get(44));

			System.out.println("Exit RateCard");
			return resource;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void readTestExcel(MultipartFile files, String uploadCategory) throws IOException, InvalidFormatException {
		System.out.println("Entry  readExcel");
		if (files.getBytes().length > 0) {
			InputStream inputStream = files.getInputStream();
			try (Workbook wb = StreamingReader.builder().open(inputStream)) {
				List<List<Cell>> obj = new ArrayList<>();
				for (Row r : wb.getSheetAt(0)) {
					List<Cell> o = new ArrayList<>();
					if (r != null) {
						for (int k = 0; k < r.getLastCellNum(); k++) {
							o.add(r.getCell(k));
						}
						System.out.println("--->" + o.size());
					}
					obj.add(o);
				}

				for (int j = 1; j < obj.size(); j++) {
					List<Cell> rown = obj.get(j);
					Candidate resource = addResource(rown);
					List<PCBCalendar> calendar = pcbCalenderService.getAll();
					for (PCBCalendar cal : calendar) {
						CandidateBillPCBAmountTracker entity = new CandidateBillPCBAmountTracker();
						CandidateBillPCBAmountTrackerId id = new CandidateBillPCBAmountTrackerId();
						id.setResourceid(resource.getResourceID());

						entity.setId(id);
						entity.setBillAmount(0);
						// entity.setBillType(resource.g);
						entity.setBillType("Billable");
						candidatePcbCalendarAmountTest.saveOrUpdate(entity);

					}

					candidateService.saveOrUpdate(resource);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Exit  readExcel");
	}

}

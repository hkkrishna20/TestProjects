package com.operationtool.controller.highchart;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.service.CandidateService;
import com.operationtool.database.service.GenericCandidateService;
import com.operationtool.highchart.models.AxesChart.Labels;
import com.operationtool.highchart.models.drilldown.Credits;
import com.operationtool.highchart.models.drilldown.DataLablesFinanceSeriesData;
import com.operationtool.highchart.models.drilldown.Datum;
import com.operationtool.highchart.models.drilldown.DrilldownFinance;
import com.operationtool.highchart.models.drilldown.FinanceChart;
import com.operationtool.highchart.models.drilldown.Series_Finance;
import com.operationtool.highchart.models.drilldown.Series_Finance2;
import com.operationtool.highchart.models.drilldown.XAxis;

@Component
public class OldDrilldownFinanceComponent {
	@Autowired
	CandidateService candidateService;

	public String getDataFinance(Set<Candidate> mergeSetsList)
			throws JsonParseException, JsonMappingException, IOException {

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

		FinanceChart responseS = new FinanceChart();
		responseS.getChart().setType("column");
		responseS.getTitle().setText("Financial Analytics");
		responseS.getSubtitle().setText("");
		ObjectMapper mapper = new ObjectMapper();

		String datalabels = "{\r\n" + "\"align\":\"null\",\r\n" + "\"allowOverlap\":true,\r\n"
				+ "\"backgroundColor\":\"undefined\",\r\n" + "\"borderColor\":\"undefined\",\r\n"
				+ "\"borderRadius\":0,\r\n" + "\"borderWidth\":0,\r\n" + "\"className\":\"undefined\",\r\n"
				+ "\"color\":\"undefined\",\r\n" + "\"crop\":true,\r\n" + "\"defer\":true,\r\n"
				+ "\"enabled\":true,\r\n" + "\"filter\":{\r\n" + "\"operator\":\"undefined\",\r\n"
				+ "\"property\":\"undefined\",\r\n" + "\"value\":\"undefined\"\r\n" + "},\r\n"
				+ "\"format\":\"undefined\",\r\n" + "\"formatter\":\"undefined\",\r\n" + "\"inside\":\"undefined\",\r\n"
				+ "\"overflow\":\"justify\",\r\n" + "\"padding\":5,\r\n" + "\"rotation\":90,\r\n"
				+ "\"shadow\":false,\r\n" + "\"shape\":\"square\",\r\n" + "\"style\":{\r\n"
				+ "\"color\":\"contrast\",\r\n" + "\"fontSize\":\"11px\",\r\n" + "\"fontWeight\":\"bold\",\r\n"
				+ "\"textOutline\":\"1px contrast\"\r\n" + "},\r\n" + "\"useHTML\":false,\r\n"
				+ "\"verticalAlign\":null,\r\n" + "\"x\":\"0\",\r\n" + "\"y\":\"10\",\r\n" + "\"zIndex\":\"6\"\r\n"
				+ "}";
		DataLablesFinanceSeriesData dataLabelsSeries = mapper.readValue(datalabels, DataLablesFinanceSeriesData.class);

		String jsonInString = "{\r\n" + "				\"enabled\":false,\r\n" + "				\"href\":\"\",\r\n"
				+ "				\"position\":{\r\n" + "				\"align\":\"left\",\r\n"
				+ "				\"verticalAlign\":\"top\",\r\n" + "				\"x\":-20,\r\n"
				+ "				\"y\":-5\r\n" + "				},\r\n"
				+ "				\"style\":{\"cursor\": \"pointer\", \"color\": \"#CCCCCC\", \"fontSize\": \"2px\"},\r\n"
				+ "				\"text\":\"\"\r\n" + "				}";

		Credits credits = mapper.readValue(jsonInString, Credits.class);
		jsonInString = " {\r\n" + "   		\"type\": null,\r\n" + "        \"title\": {\r\n" + "\"text\": null\r\n"
				+ "        },\r\n" + "        \"min\": 0,\r\n" +

				"        \"scrollbar\": {\r\n" + "\"enabled\": true\r\n" + "        },\r\n"
				+ "        \"tickLength\": 0\r\n" + "    }";
		XAxis xaxis = mapper.readValue(jsonInString, XAxis.class);
		jsonInString = " {\r\n" + "   		\"type\": null,\r\n" + "        \"title\": {\r\n" + "  \"text\": null,\r\n"
				+ "\"align\": \"high\"\r\n" + "        },\r\n" + "        \"min\": 100,\r\n" +

				"        \"scrollbar\": {\r\n" + "\"enabled\": true\r\n" + "        },\r\n"
				+ "        \"tickLength\": 0\r\n" + "    }";

		XAxis yaxis = mapper.readValue(jsonInString, XAxis.class);
		String[] months = new DateFormatSymbols().getShortMonths();
		List<String> monthsList = new ArrayList<String>(Arrays.asList(months));

		boolean nullCheck = StringUtils.isEmpty(monthsList.get(monthsList.size() - 1));
		boolean emptyCheck = StringUtils.isEmpty(monthsList.get(monthsList.size() - 1));
		if (nullCheck || emptyCheck) {
			monthsList.remove(monthsList.size() - 1);
		}
		monthsList.removeAll(Collections.singleton(null));
		monthsList.removeAll(Collections.singleton(""));
		monthsList.removeIf(item -> item == null || "".equals(item));

		Labels labels = new Labels();
		labels.setRotation(-45);

		labels.getStyle().setFontFamily("Verdana, sans-serif");
		labels.getStyle().setFontSize("13px");
		xaxis.setLabels(labels);
		// System.out.println(credits);
		xaxis.setCategories(monthsList);
		xaxis.setCrosshair(true);
		yaxis.setCrosshair(true);
		responseS.setCredits(credits);
		responseS.setxAxis(xaxis);
		responseS.setyAxis(yaxis);

		responseS.getPlotOptions().getColumn().getDataLabels().getStyle().setFontSize("9px");
		responseS.getPlotOptions().getSeries().getDataLabels().setRotation(90);
		responseS.getPlotOptions().getSeries().getDataLabels().setY(-12);
		responseS.getPlotOptions().getSeries().getDataLabels().setEnabled(true);
		responseS.getPlotOptions().getSeries().getDataLabels().setFormat("{point.name}: {point.y}");
		responseS.getPlotOptions().getSeries().getDataLabels().getStyle().setFontSize("9px");
		responseS.getTooltip().setHeaderFormat("<span style=\"font-size:11px\">{series.name}</span><br>");
		responseS.getTooltip().setPointFormat(
				"<span style=\"color:{point.color}; outline: solid red 1px;\">{point.name}</span>: <b>{point.y}</b><br/>");
		String obj = "{\r\n" + "\"allowPointDrilldown\":true,\r\n" + "\"activeAxisLabelStyle\":{\r\n"
				+ "\"color\":\"#003399\",\r\n" + "\"cursor\":\"pointer\",\r\n" + "\"fontWeight\":\"bold\",\r\n"
				+ "  \"textDecoration\":\"underline\"},\r\n" + "\"animation\":{\r\n" + "\"duration\":500\r\n" + "},\r\n"
				+ "\"drillUpButton\":{\r\n" + "\"position\":{\r\n" + "\"align\":\"right\",\r\n"
				+ "\"verticalAlign\":\"bottom\",\r\n" + "\"x\":-2,\r\n" + "\"y\":10\r\n" + "},\r\n"
				+ "\"relativeTo\":\"plotBox\",\r\n" + "\"theme\":\"undefined\"\r\n" + "}\r\n" + "\r\n" + "}\r\n" + "";

		DrilldownFinance financeDrill = null;
		try {
			financeDrill = mapper.readValue(obj, DrilldownFinance.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// responseS.setDrilldown(financeDrill);
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

		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				Series_Finance2 directorsseries2 = new Series_Finance2();
				directorsseries2.setColorByPoint(true);
				directorsseries2.setName(director);
				for (int i = 0; i < 12; i++) {
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
					// dataN.setName(parts[0].charAt(0) + "." + parts[1]);
					dataN.setName(director.toLowerCase() + monthsList.get(i));
					dataN.setDrilldown(director.toLowerCase());
					dataN.setY(Double.valueOf(directorsToReportMangersresult.get(director).size() * 100));
					directorsseries2.getData().add(dataN);
				}
				// directorsseries2.setDataLabels(dataLabelsSeries);
				directorsseries2.getDataLabels().setEnabled(true);
				directorsseries2.getDataLabels().setAlign("left");
				directorsseries2.getDataLabels().setX(2);
				directorsseries2.getDataLabels().setRotation(90);
				directorsseries2.getDataLabels().setY(-12);
				responseS.getSeries().add(directorsseries2);

			}

		}

		List<Datum> data = null;
		Series_Finance directorsseries0 = new Series_Finance();
		directorsseries0.setId("directors");
		directorsseries0.setName("directors");

		// responseS.getDrilldown().getDrilldown().add(directorsseries0);
		directorsseries0 = new Series_Finance();
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				List<List<Datum>> test = new ArrayList<List<Datum>>(20);
				for (int ll = 0; ll < 12; ll++) {
					List<Datum> data2 = new ArrayList<Datum>();
					test.add(data2);
				}
				directorsseries0 = new Series_Finance();
				directorsseries0.setId(director.toLowerCase());
				directorsseries0.setName(director.toLowerCase());
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						data = new ArrayList<Datum>();
						for (int ll = 0; ll < 12; ll++) {
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
							dataN.setName(managers.toLowerCase() + monthsList.get(ll));
							dataN.setDrilldown(managers.toLowerCase());
							dataN.setY(Double.valueOf(managersProjectsresult.get(managers).size() * 100));
							data.add(dataN);

							test.get(ll).add(dataN);
						}

						// test.add(data);
					}

				}
				List<List<Datum>> testnew = new ArrayList<List<Datum>>(20);
				for (int ll = 0; ll < 12; ll++) {
					List<Datum> data2 = test.get(ll);

					Set<Datum> setss = data2.stream().collect(
							Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
					List<Datum> mainList = new ArrayList<Datum>();
					mainList.addAll(setss);
					testnew.add(mainList);
				}

				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
				directorsseries0.setData(testnew);
				directorsseries0.getDataLabels().setEnabled(true);
				directorsseries0.getDataLabels().setAlign("left");
				directorsseries0.getDataLabels().setX(2);
				directorsseries0.getDataLabels().setRotation(90);
				directorsseries0.getDataLabels().setY(-12);
				responseS.getDrilldown().getDrilldown().add(directorsseries0);
			}
		}
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				List<Series_Finance> dir = new ArrayList<Series_Finance>();
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					List<List<Datum>> test1 = new ArrayList<List<Datum>>(20);
					for (int ll = 0; ll < 12; ll++) {
						List<Datum> data2 = new ArrayList<Datum>();
						test1.add(data2);
					}
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						Set<String> projects = managersProjectsresult.get(managers);

						directorsseries0 = new Series_Finance();
						directorsseries0.setId(managers.toLowerCase());
						String[] parts = managers.toLowerCase().split(",");
						directorsseries0.setName(parts[0].charAt(0) + "," + parts[1]);
						for (int j = 0; j < managersProjectsresult.get(managers).size(); j++) {
							data = new ArrayList<Datum>();
							for (int test = 0; test < 12; test++) {
								for (String proj : projects) {
									Set<String> projeId = getKeysByValue(projectIdToDescription, proj);
									List<String> mainList = new ArrayList<String>();
									mainList.addAll(projeId);
									for (int ll = 0; ll < 12; ll++) {

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
										dataN.setName(mainList.get(0) + monthsList.get(test));
										dataN.setDrilldown(mainList.get(0));
										if (projectsMembersresult.get(mainList.get(0)) != null) {
											dataN.setY(Double
													.valueOf(projectsMembersresult.get(mainList.get(0)).size() * 100));
										} else {
											dataN.setY(Double.valueOf(0));
										}

										data.add(dataN);
										test1.get(ll).add(dataN);

									}
								}

							}

							List<List<Datum>> testnew = new ArrayList<List<Datum>>(20);
							for (int ll = 0; ll < 12; ll++) {
								List<Datum> data2 = test1.get(ll);

								Set<Datum> setss = data2.stream().collect(
										Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
								List<Datum> mainList = new ArrayList<Datum>();
								mainList.addAll(setss);
								testnew.add(mainList);
							}

							// data = data.stream().distinct().collect(Collectors.toList());
							// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
							directorsseries0.setData(testnew);

							/*Set<Datum> setss = data.stream().collect(
									Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
							List<Datum> mainList = new ArrayList<Datum>();
							mainList.addAll(setss);*/
							// directorsseries0.setData(mainList);
							directorsseries0.getDataLabels().setEnabled(true);
							directorsseries0.getDataLabels().setAlign("left");
							directorsseries0.getDataLabels().setX(2);
							directorsseries0.getDataLabels().setRotation(90);
							directorsseries0.getDataLabels().setY(-12);

							dir.add(directorsseries0);
						}
					}
				}
				Set<Series_Finance> setss = dir.stream().collect(
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Series_Finance::getName))));
				List<Series_Finance> mainList = new ArrayList<Series_Finance>();
				mainList.addAll(setss);
				responseS.getDrilldown().getDrilldown().addAll(mainList);
				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
			}
		}
		for (String director : directorlist) {
			if (!director.trim().isEmpty()) {
				List<Series_Finance> dir = new ArrayList<Series_Finance>();
				for (int i = 0; i < directorsToReportMangersresult.get(director).size(); i++) {
					Set<String> man = directorsToReportMangersresult.get(director);
					for (String managers : man) {
						Set<String> projects = managersProjectsresult.get(managers);
						for (int j = 0; j < managersProjectsresult.get(managers).size(); j++) {
							for (String proj : projects) {
								Set<String> projeId = getKeysByValue(projectIdToDescription, proj);

								List<String> mainList = new ArrayList<String>();
								mainList.addAll(projeId);
								for (int test = 0; test < 12; test++) {
									directorsseries0 = new Series_Finance();
									directorsseries0.setId(mainList.get(0) + monthsList.get(test));
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
											dataN.setY(Double.valueOf(name.getTotalexp()) * 100);
											data.add(dataN);
										}
									}
									Set<Datum> setss = data.stream().collect(Collectors
											.toCollection(() -> new TreeSet<>(Comparator.comparing(Datum::getName))));
									List<Datum> mainlList = new ArrayList<Datum>();
									mainlList.addAll(setss);
									// directorsseries0.setData(mainlList);
									directorsseries0.getDataLabels().setEnabled(true);
									directorsseries0.getDataLabels().setAlign("left");
									directorsseries0.getDataLabels().setX(2);
									directorsseries0.getDataLabels().setRotation(90);
									directorsseries0.getDataLabels().setY(-12);

									dir.add(directorsseries0);
								}
							}

						}

					}
				}
				Set<Series_Finance> setss = dir.stream().collect(
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Series_Finance::getName))));
				List<Series_Finance> mainList = new ArrayList<Series_Finance>();
				mainList.addAll(setss);
				responseS.getDrilldown().getDrilldown().addAll(mainList);
				// data = data.stream().distinct().collect(Collectors.toList());
				// data = new ArrayList<Datum>(new LinkedHashSet<Datum>(data));
			}
		}

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseS);
		// System.out.println(jsonInString);
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
}

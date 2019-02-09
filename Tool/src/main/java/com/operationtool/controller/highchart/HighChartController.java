package com.operationtool.controller.highchart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.operationtool.database.models.entity.Candidate;
import com.operationtool.database.service.CandidateService;
import com.operationtool.highchart.models.drilldown.Datum;
import com.operationtool.highchart.models.drilldown.DummySeries1;

@RestController
public class HighChartController {
	@Autowired
	OrganisationAnalysisComponent dataComponent;

	@Autowired
	OldDrilldownFinanceComponent dataComponentFinance;
	@Autowired
	CandidateService candidateService;

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "getFinance", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	String findFinanceData() throws JsonGenerationException, JsonMappingException, IOException {
		String pyramidaccounthrbu = "PNC Bank";
		Set<Candidate> mergeSetsList = null;
		if (pyramidaccounthrbu.contains("PNC")) {
			Set<Candidate> resources = findByPyramidaccounthrbu("PNC Bank");
			Set<Candidate> pncresources = findByPyramidaccounthrbu("PNC");
			mergeSetsList = dataComponent.mergeSets(resources, pncresources);
		} else {
			mergeSetsList = findByPyramidaccounthrbu(pyramidaccounthrbu);
		}
		System.out.println("Exit getDataFinance");
		return dataComponentFinance.getDataFinance(mergeSetsList);

	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })

	@RequestMapping(value = "getDirectPNC", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	String findDistinctDirectordept10inthehrtree() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Entry   into  getDirectPNC ");
		String pyramidaccounthrbu = "PNC Bank";
		Set<Candidate> mergeSetsList = null;
		if (pyramidaccounthrbu.contains("PNC")) {
			Set<Candidate> resources = findByPyramidaccounthrbu("PNC Bank");
			Set<Candidate> pncresources = findByPyramidaccounthrbu("PNC");
			mergeSetsList = dataComponent.mergeSets(resources, pncresources);
		} else {
			mergeSetsList = findByPyramidaccounthrbu(pyramidaccounthrbu);
		}
		System.out.println("Exit getDirectPNC");
		return dataComponent.getDataOrg(mergeSetsList);

	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "genericResponse", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<DummySeries1> GenericResponse(@RequestParam("analytics") String analyticsByType,
			@RequestParam("bu") String pyramidaccounthrbu) throws IOException, InvalidFormatException {
		System.out.println("Entry   into   genericResponse");
		if (pyramidaccounthrbu.trim().isEmpty() || pyramidaccounthrbu.trim() == null) {
			pyramidaccounthrbu = "PNC Bank";
		}
		if (analyticsByType.trim().isEmpty() || analyticsByType.trim() == null) {
			analyticsByType = "skillsanalytics";
		}
		Map<String, List<Candidate>> candidateByskill = null;
		// List<Candidate> metadata = candidateService.getAll();
		Set<Candidate> mergeSetsList = null;
		if (pyramidaccounthrbu.contains("PNC")) {
			Set<Candidate> resources = findByPyramidaccounthrbu("PNC Bank");
			Set<Candidate> pncresources = findByPyramidaccounthrbu("PNC");
			mergeSetsList = dataComponent.mergeSets(resources, pncresources);
		} else {
			mergeSetsList = findByPyramidaccounthrbu(pyramidaccounthrbu);
		}
		if (analyticsByType.equalsIgnoreCase("malefemaleanalytics")) {
			System.out.println("malefemaleanalyticsHere");
			candidateByskill = mergeSetsList.stream().collect(Collectors.groupingBy(Candidate::getGender));
			System.out.println("Exit  PieResponse");
			return testData(candidateByskill, analyticsByType);
		} else if (analyticsByType.equals("skillsanalytics")) {
			System.out.println("skillsanalytics Here");
			candidateByskill = mergeSetsList.stream().collect(Collectors.groupingBy(Candidate::getSubcompetency));
			System.out.println("Exit  Response");
			return testData(candidateByskill, analyticsByType);
		} else if (analyticsByType.equalsIgnoreCase("designationanalytics")) {
			System.out.println("designationanalyticsHere");
			candidateByskill = new HashMap<>();
			candidateByskill = mergeSetsList.stream().collect(Collectors.groupingBy(Candidate::getDesignation));
			System.out.println("Exit  Response");
			return testData(candidateByskill, analyticsByType);
		} else if (analyticsByType.equalsIgnoreCase("locationanalytics")) {
			System.out.println("locationanalyticsHere");
			// candidateByskill =
			// mergeSetsList.stream().collect(Collectors.groupingBy(Candidate::getLocation));
			/*
			 * Map<String, List<Candidate>> listGrouped = mergeSetsList.stream().map(w ->
			 * w.getLocation() + "-" +w.getSublocation());
			 */

			Map<String, List<Candidate>> map = mergeSetsList.stream()
					.collect(Collectors.groupingBy(Candidate::getLocation));
			Map<String, List<Candidate>> finalList = new HashMap<>();
			Set<String> keyset = map.keySet();
			List<String> mainList = new ArrayList<String>();
			mainList.addAll(keyset);

			for (String key : keyset) {
				List<Candidate> tempList = map.get(key);
				Map<String, List<Candidate>> candidateBySubLocation = null;
				candidateBySubLocation = tempList.stream().collect(Collectors.groupingBy(Candidate::getSublocation));
				Set<String> sublockeyset = candidateBySubLocation.keySet();
				for (String keys : sublockeyset) {
					List<Candidate> tempListSubloc = candidateBySubLocation.get(keys);
					finalList.put(key + ", " + keys, tempListSubloc);
				}

			}
			System.out.println("Exit  Response");
			return testData(finalList, analyticsByType);
		}

		System.out.println("Exit  Response");
		return null;
	}

	private List<DummySeries1> testData(Map<String, List<Candidate>> candidateByskill, String analyticsByType) {

		Set<String> keyset = candidateByskill.keySet();
		DummySeries1 series1 = new DummySeries1();
		if (analyticsByType.equalsIgnoreCase("malefemaleanalytics")) {
			series1.setName("Male Female Analytics");
		} else if (analyticsByType.equalsIgnoreCase("locationanalytics")) {
			series1.setName("Location Analytics");
		} else if (analyticsByType.equals("skillsanalytics")) {
			series1.setName("Skills Analytics");
		} else if (analyticsByType.equalsIgnoreCase("designationanalytics")) {
			series1.setName("Designation Analytics");
			List<Datum> pieResponse = new ArrayList<Datum>();
			for (String key : keyset) {
				Datum fakeJSON = new Datum();
				String initials = Arrays.stream(key.split(" ")).map(s -> s.substring(0, 3))
						.collect(Collectors.joining("."));
				fakeJSON.setName(initials);
				fakeJSON.setY((double) candidateByskill.get(key).size());
				pieResponse.add(fakeJSON);
			}
			series1.setData(pieResponse);
			List<DummySeries1> ds = new ArrayList<DummySeries1>();
			ds.add(series1);
			return ds;
		}
		List<Datum> pieResponse = new ArrayList<Datum>();
		for (String key : keyset) {
			Datum fakeJSON = new Datum();
			fakeJSON.setName(key);
			fakeJSON.setY((double) candidateByskill.get(key).size());
			pieResponse.add(fakeJSON);
		}
		series1.setData(pieResponse);
		List<DummySeries1> ds = new ArrayList<DummySeries1>();
		ds.add(series1);
		return ds;
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "getPNC", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	Set<Candidate> findByPyramidaccounthrbu(String bu) {
		return candidateService.findByPyramidaccounthrbu(bu);
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "getDirectAndPNC", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	Set<String> findDistinctDirectordept10inthehrtreeAndPNC() {
		String description = "PNC Bank";
		return candidateService.findDistinctDirectordept10inthehrtreeAndPyramidaccounthrbu(description);
	}

	public Set<Candidate> doSomeSomething(String bu) {
		return candidateService.findByPyramidaccounthrbu(bu);
	}

}

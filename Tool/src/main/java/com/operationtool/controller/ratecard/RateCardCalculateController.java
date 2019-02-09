package com.operationtool.controller.ratecard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.operationtool.database.models.ratecard.IndividualDirectorsSum;
import com.operationtool.database.repository.CandiatePCBAmountRepository;

@RestController

public class RateCardCalculateController {

	@Autowired
	RateCalculationComponent rateComponent;

	@Autowired
	CandiatePCBAmountRepository rates;

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })

	@RequestMapping(value = "rateCalculationService", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public void rateCalculationService() throws ParseException {
		rateComponent.calculateRates();
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })

	@RequestMapping(value = "testIt", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })

	public void testIt() throws ParseException {
		List<IndividualDirectorsSum> individualDirectorsSum = new ArrayList<IndividualDirectorsSum>();
		List<Object[]> retrieveIndividualDirectorSum = rates.retrieveIndividualDirectorSum("PNC Bank",
				"Srinivasan Rajesh");
		for (Object[] ob : retrieveIndividualDirectorSum) {
			individualDirectorsSum.add(
					new IndividualDirectorsSum(String.valueOf(ob[0]), String.valueOf(ob[1]), String.valueOf(ob[2])));

		}
		System.out.println(individualDirectorsSum);

	}

}

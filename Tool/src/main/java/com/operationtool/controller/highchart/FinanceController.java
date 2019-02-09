package com.operationtool.controller.highchart;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.operationtool.controller.ratecard.FinanceRequest;
import com.operationtool.controller.ratecard.FinanceSeries;
import com.operationtool.controller.ratecard.IDepartmentListData;

@RestController
public class FinanceController {
	@Autowired
	FinanceComponent rates;

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "projectRevenue", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public IDepartmentListData projectRevenue(@RequestBody FinanceRequest projectRevenueRequest) {
		return rates.projectRevenue(projectRevenueRequest);
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "projectRevenue", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public IDepartmentListData projectRevenuea() {
		return rates.projectRevenue();
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:6003" })
	@RequestMapping(value = "getFinanceData", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public List<FinanceSeries> getFinanceData(@RequestBody FinanceRequest financeRequest)
			throws JsonParseException, JsonMappingException, IOException {

		if (financeRequest.getDesignation().equalsIgnoreCase("director")) {
			return rates.directorSeries(financeRequest);
		} else if (financeRequest.getDesignation().equalsIgnoreCase("manager")) {
			return rates.managerSeries(financeRequest);
		} else if (financeRequest.getDesignation().equalsIgnoreCase("project")) {
			return null;
		} else {
			return rates.directorSeries(financeRequest);
		}
	}

}

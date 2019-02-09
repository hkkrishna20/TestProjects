package com.operationtool.controller.highchart;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.operationtool.controller.ratecard.FinanceRequest;
import com.operationtool.controller.ratecard.FinanceSeries;
import com.operationtool.controller.ratecard.IDepartmentData;
import com.operationtool.controller.ratecard.IDepartmentListData;
import com.operationtool.database.models.ratecard.IndividualDirectorsSum;
import com.operationtool.database.repository.CandiatePCBAmountRepository;

@Component
public class FinanceComponent {
	@Autowired
	CandiatePCBAmountRepository rates;

	public IDepartmentListData projectRevenue(FinanceRequest projectRevenueRequest) {
		// TODO Auto-generated method stub
		IDepartmentListData inc = new IDepartmentListData();
		inc.setMonthsList(getCategories());
		List<IDepartmentData> data = new ArrayList<IDepartmentData>();
		inc.setDepartmentData(data);

		return inc;
	}

	public List<FinanceSeries> directorSeries(FinanceRequest financeRequest) {
		// TODO Auto-generated method stub
		List<FinanceSeries> ds = new ArrayList<FinanceSeries>();
		Set<String> directorNames = rates.getDirectorNames(financeRequest.getBussinessUnit());
		for (String dirName : directorNames) {
			FinanceSeries series1 = new FinanceSeries();
			series1.setName(dirName);
			List<Double> dataLabelsSeries = new ArrayList<Double>();
			series1.setMonths(getCategories());
			/*
			 * dataLabelsSeries.add(Double.valueOf(121));
			 * dataLabelsSeries.add(Double.valueOf(120));
			 * dataLabelsSeries.add(Double.valueOf(101));
			 * dataLabelsSeries.add(Double.valueOf(201));
			 * dataLabelsSeries.add(Double.valueOf(101));
			 * dataLabelsSeries.add(Double.valueOf(211));
			 */
			series1.setData(dataLabelsSeries);
			series1.setNextLevel("manager");
			series1.setPrevLevel("director");
			ds.add(series1);
		}
		return ds;

	}

	public List<FinanceSeries> managerSeries(FinanceRequest financeRequest) {
		// TODO Auto-generated method stub
		List<FinanceSeries> ds = new ArrayList<FinanceSeries>();
		Set<String> managerNames = rates.getManagerNames(financeRequest.getName(), financeRequest.getBussinessUnit());
		for (String managerName : managerNames) {
			FinanceSeries series1 = new FinanceSeries();
			series1.setName(managerName);
			series1.setMonths(getCategories());
			List<Double> dataLabelsSeries = new ArrayList<Double>();
			/*
			 * dataLabelsSeries.add(201.4); dataLabelsSeries.add(101.4);
			 * dataLabelsSeries.add(121.4); dataLabelsSeries.add(101.4);
			 * dataLabelsSeries.add(191.4); dataLabelsSeries.add(161.4);
			 */

			series1.setNextLevel("project");
			series1.setPrevLevel("manager");
			ds.add(series1);
		}
		return ds;

	}

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

	public String[] getCategories() {
		String[] months = new DateFormatSymbols().getShortMonths();
		months[0] = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		months[1] = LocalDate.now().plusMonths(2).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		months[2] = LocalDate.now().plusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		months[3] = LocalDate.now().plusMonths(4).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		months[4] = LocalDate.now().plusMonths(5).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		months[5] = LocalDate.now().plusMonths(6).format(DateTimeFormatter.ofPattern("yyyy-MMM"));
		System.out.println(months[0]);
		return months;

	}

	public IDepartmentListData projectRevenue() {
		// TODO Auto-generated method stub
		getCategories();
		return null;
	}

}

package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "data" })
public class Series_Finance implements Serializable {

	@JsonProperty("id")
	private String id;
	

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	@JsonProperty("data")
	@Valid
	private  List<List<Datum>> data = new ArrayList<List<Datum>>();
	
	private final static long serialVersionUID = 4928560153869250577L;

	@JsonProperty("id")
	public String getId() {

		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	

	@JsonProperty("dataLabels")
	private DataLablesFinanceSeriesData dataLabels; 
	
	
	public DataLablesFinanceSeriesData getDataLabels() {
		if(dataLabels == null) {
			dataLabels = new DataLablesFinanceSeriesData();
			
		}
		return dataLabels;
	}

	public void setDataLabels(DataLablesFinanceSeriesData dataLabels) {
		this.dataLabels =dataLabels;
	}
	
	
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("data")
	public   List<List<Datum>> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData( List<List<Datum>>  test) {
		this.data = test;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("data", data).toString();
	}

}

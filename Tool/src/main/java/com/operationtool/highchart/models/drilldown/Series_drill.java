package com.operationtool.highchart.models.drilldown;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id","colorByPoint", "name", "data" ,"dataLabels"})

public class Series_drill {
	@JsonProperty("id")
	private String id;
	@JsonProperty("colorByPoint")
	private boolean colorByPoint =true;
	public boolean isColorByPoint() {
		return colorByPoint;
	}

	public void setColorByPoint(boolean colorByPoint) {
		this.colorByPoint = true;
	}

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	@JsonProperty("data")
	@Valid
	private List<DrillDownDatum> data = new  ArrayList<DrillDownDatum>();
	
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
	
	/*
	 dataLabels: {
        enabled: true,
        rotation: -90,
        color: \"#FFFFFF\",
        align: \"right\",
        format: \"{point.y:.1f}\", // one decimal
        y: 10, // 10 pixels down from the top
        style: {
            fontSize: \"13px\",
            fontFamily: \"Verdana, sans-serif\"
        }
    }*/
	
	
	
	public DataLablesFinanceSeriesData getDataLabels() {
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
	public List<DrillDownDatum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData( List<DrillDownDatum>  data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("data", data).toString();
	}


}

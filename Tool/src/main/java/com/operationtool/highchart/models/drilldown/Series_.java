package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "data" ,"dataLabels" })
public class Series_ implements Serializable {

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


	@JsonProperty("dataLabels")
	private DataLabels dataLabels;
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
	
	
	
	public DataLabels getDataLabels() {
		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}




	@JsonProperty("name")
	private String name;
	
	@JsonProperty("type")
	private String type;
	@JsonProperty("data")
	@Valid
	private List<Datum> data = new ArrayList<Datum>();
	
	private final static long serialVersionUID = 4928560153869250577L;

	@JsonProperty("id")
	public String getId() {

		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
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
	public List<Datum> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).append("data", data).toString();
	}

}

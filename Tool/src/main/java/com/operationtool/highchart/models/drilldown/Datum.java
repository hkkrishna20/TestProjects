package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "y", "drilldown" })
public class Datum implements Serializable {

	@JsonProperty("name")
	private String name;
	@JsonProperty("y")
	private Double y;
	@JsonProperty("drilldown")
	private String drilldown;
	
	@JsonProperty("dataLabels")
	private DataLablesforData dataLabels;
	private final static long serialVersionUID = 559618086222013873L;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("y")
	public Double getY() {
		return y;
	}

	@JsonProperty("y")
	public void setY(Double y) {
		this.y = y;
	}

	@JsonProperty("drilldown")
	public String getDrilldown() {
		return drilldown;
	}

	@JsonProperty("drilldown")
	public void setDrilldown(String drilldown) {
		this.drilldown = drilldown;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("y", y).append("drilldown", drilldown).toString();
	}

}

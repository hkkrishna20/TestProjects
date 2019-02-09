package com.operationtool.highchart.models.drilldown;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Drilldown {
	@JsonProperty("series")
	@Valid
	private List<Series_> drilldown = new ArrayList<Series_>();

	public List<Series_> getDrilldown() {
		return drilldown;
	}

	public void setDrilldown(List<Series_> drilldown) {
		this.drilldown = drilldown;
	}

}

package com.operationtool.highchart.models.drilldown;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.operationtool.highchart.models.drilldown.Datum;

public class DummySeries1 {
	
	private  String name;
	@JsonProperty("colorByPoint")
	private boolean colorByPoint =true;
	public boolean isColorByPoint() {
		return colorByPoint;
	}
	private List<Datum> data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Datum> getData() {
		return data;
	}
	public void setData(List<Datum> data) {
		this.data = data;
	}
	
	


}

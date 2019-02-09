package com.operationtool.highchart.models.drilldown;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dataLabels", "pointPadding", "borderWidth", "groupPadding", "shadow" })

public class Column {

	@JsonProperty("dataLabels")
	private DataLabels dataLabels;

	@JsonProperty("pointPadding")
	private int pointPadding = 0;
	@JsonProperty("borderWidth")
	private int borderWidth = 0;
	@JsonProperty("groupPadding")
	private int groupPadding = 0;
	@JsonProperty("shadow")
	private boolean shadow = false;

	public int getPointPadding() {
		return pointPadding;
	}

	public void setPointPadding(int pointPadding) {
		this.pointPadding = pointPadding;
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}

	public int getGroupPadding() {
		return groupPadding;
	}

	public void setGroupPadding(int groupPadding) {
		this.groupPadding = groupPadding;
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}

	public DataLabels getDataLabels() {
		if (dataLabels == null) {
			dataLabels = new DataLabels();

		}

		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}

}

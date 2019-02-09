package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "headerFormat", "pointFormat" })
public class Tooltip implements Serializable {

	@JsonProperty("headerFormat")
	private String headerFormat;
	@JsonProperty("pointFormat")
	private String pointFormat;
	private final static long serialVersionUID = -8816426799876156327L;

	@JsonProperty("headerFormat")
	public String getHeaderFormat() {
		return headerFormat;
	}

	@JsonProperty("headerFormat")
	public void setHeaderFormat(String headerFormat) {
		this.headerFormat = headerFormat;
	}

	@JsonProperty("pointFormat")
	public String getPointFormat() {
		return pointFormat;
	}

	@JsonProperty("pointFormat")
	public void setPointFormat(String pointFormat) {
		this.pointFormat = pointFormat;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("headerFormat", headerFormat).append("pointFormat", pointFormat)
				.toString();
	}

}
package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"showCheckbox", "dataLabels" })
public class Series implements Serializable {

	@JsonProperty("dataLabels")
	@Valid
	private DataLabels dataLabels;
	private final static long serialVersionUID = -7440492915243388962L;
	@JsonProperty("showCheckbox")
	@Valid
	private boolean showCheckbox = true;
	
	
	@JsonProperty("dataLabels")
	public DataLabels getDataLabels() {
		if(dataLabels==null) {
			this.dataLabels = new DataLabels();
		}
		return dataLabels;
	}

	@JsonProperty("dataLabels")
	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("dataLabels", dataLabels).toString();
	}

}

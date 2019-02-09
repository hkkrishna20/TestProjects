package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "series" ,"column"})
public class PlotOptions implements Serializable {

	@JsonProperty("series")
	@Valid
	private Series series;

	@JsonProperty("column")
	@Valid
	private Column column;

	public Column getColumn() {
		if(column==null) {
			column = new Column();
			
		}
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	private final static long serialVersionUID = -7602193717730122420L;

	@JsonProperty("series")
	public Series getSeries() {
		if(series == null) {
			series = new Series();
		}
		return series;
	}

	@JsonProperty("series")
	public void setSeries(Series series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("series", series).toString();
	}

}

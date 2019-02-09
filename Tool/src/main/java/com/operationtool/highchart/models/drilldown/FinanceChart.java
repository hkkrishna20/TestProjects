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
@JsonPropertyOrder({ "chart", "credits","events",  "title", "legend","subtitle","xAxis", "yAxis", "plotOptions", "tooltip", "series","drilldown" })
public class FinanceChart implements Serializable {

	@JsonProperty("chart")
	@Valid
	private Chart chart;
	@JsonProperty("credits")
	@Valid
	private Credits credits;
	@JsonProperty("xAxis")
	@Valid
	private XAxis xAxis;
	@JsonProperty("yAxis")
	@Valid
	private XAxis yAxis;

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public XAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(XAxis yAxis) {
		this.yAxis = yAxis;
	}

	@JsonProperty("title")
	@Valid
	private Title title;
	@JsonProperty("subtitle")
	@Valid
	private Subtitle subtitle;

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	@JsonProperty("plotOptions")
	@Valid
	private PlotOptions plotOptions;
	@JsonProperty("tooltip")
	@Valid
	private Tooltip tooltip;

	@JsonProperty("series")
	@Valid
	private List<Series_Finance2> series = new ArrayList<Series_Finance2>();

	@JsonProperty("drilldown")
	@Valid
	private DrilldownFinance drilldown = new DrilldownFinance();
	
	@JsonProperty("legend")
	@Valid
	private Legend legend;
	
	
	private final static long serialVersionUID = 8237293617964803479L;

	public DrilldownFinance getDrilldown() {
		return drilldown;
	}

	public void setDrilldown(DrilldownFinance drilldown) {
		this.drilldown = drilldown;
	}

	@JsonProperty("chart")
	public Chart getChart() {
		if (this.chart == null) {
			this.chart = new Chart();
		}
		return chart;
	}

	@JsonProperty("chart")
	public void setChart(Chart chart) {
		this.chart = chart;
	}

	@JsonProperty("title")
	public Title getTitle() {
		if (this.title == null) {
			this.title = new Title();
		}
		return title;
	}

	@JsonProperty("title")
	public void setTitle(Title title) {

		this.title = title;
	}

	@JsonProperty("subtitle")
	public Subtitle getSubtitle() {
		if (this.subtitle == null) {
			this.subtitle = new Subtitle();
		}

		return subtitle;
	}

	@JsonProperty("subtitle")
	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}

	@JsonProperty("plotOptions")
	public PlotOptions getPlotOptions() {
		if (this.plotOptions == null) {
			this.plotOptions = new PlotOptions();
		}
		return plotOptions;
	}

	@JsonProperty("plotOptions")
	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

	@JsonProperty("tooltip")
	public Tooltip getTooltip() {
		if (this.tooltip == null) {
			this.tooltip = new Tooltip();
		}
		return tooltip;
	}

	@JsonProperty("tooltip")
	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	@JsonProperty("series")
	public @Valid List<Series_Finance2> getSeries() {
		return series;
	}

	@JsonProperty("series")
	public void setSeries(List<Series_Finance2> series) {
		this.series = series;
	}

	public void nullSeries() {
		this.series = new ArrayList<Series_Finance2>();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("chart", chart).append("title", title).append("subtitle", subtitle)
				.append("plotOptions", plotOptions).append("tooltip", tooltip).append("series", series).toString();
	}

}

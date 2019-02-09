package com.operationtool.highchart.models.AxesChart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"chart",
"title",
"subtitle",
"legend",
"xAxis",
"yAxis",
"plotOptions",
"series"
})
public class InvertedAxesChart implements Serializable
{

@JsonProperty("chart")
private Chart chart;
@JsonProperty("title")
private Title title;
@JsonProperty("subtitle")
private Subtitle subtitle;
@JsonProperty("legend")
private Legend legend;
@JsonProperty("xAxis")
private XAxis xAxis;
@JsonProperty("yAxis")
private YAxis yAxis;
@JsonProperty("plotOptions")
private PlotOptions plotOptions;
@JsonProperty("series")
private List<Series> series = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 5654058133425138023L;

@JsonProperty("chart")
public Chart getChart() {
return chart;
}

@JsonProperty("chart")
public void setChart(Chart chart) {
this.chart = chart;
}

@JsonProperty("title")
public Title getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(Title title) {
this.title = title;
}

@JsonProperty("subtitle")
public Subtitle getSubtitle() {
return subtitle;
}

@JsonProperty("subtitle")
public void setSubtitle(Subtitle subtitle) {
this.subtitle = subtitle;
}

@JsonProperty("legend")
public Legend getLegend() {
return legend;
}

@JsonProperty("legend")
public void setLegend(Legend legend) {
this.legend = legend;
}

@JsonProperty("xAxis")
public XAxis getXAxis() {
return xAxis;
}

@JsonProperty("xAxis")
public void setXAxis(XAxis xAxis) {
this.xAxis = xAxis;
}

@JsonProperty("yAxis")
public YAxis getYAxis() {
return yAxis;
}

@JsonProperty("yAxis")
public void setYAxis(YAxis yAxis) {
this.yAxis = yAxis;
}

@JsonProperty("plotOptions")
public PlotOptions getPlotOptions() {
return plotOptions;
}

@JsonProperty("plotOptions")
public void setPlotOptions(PlotOptions plotOptions) {
this.plotOptions = plotOptions;
}

@JsonProperty("series")
public List<Series> getSeries() {
return series;
}

@JsonProperty("series")
public void setSeries(List<Series> series) {
this.series = series;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


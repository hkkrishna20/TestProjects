
package com.operationtool.highchart.models.basicLinechart;

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
"title",
"subtitle",
"yAxis",
"legend",
"plotOptions",
"series",
"responsive"
})
public class BasicLineChart implements Serializable
{

@JsonProperty("title")
private Title title;
@JsonProperty("subtitle")
private Subtitle subtitle;
@JsonProperty("yAxis")
private YAxis yAxis;
@JsonProperty("legend")
private Legend legend;
@JsonProperty("plotOptions")
private PlotOptions plotOptions;
@JsonProperty("series")
private List<Series_> series = null;
@JsonProperty("responsive")
private Responsive responsive;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -7127271004281066076L;

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

@JsonProperty("yAxis")
public YAxis getYAxis() {
return yAxis;
}

@JsonProperty("yAxis")
public void setYAxis(YAxis yAxis) {
this.yAxis = yAxis;
}

@JsonProperty("legend")
public Legend getLegend() {
return legend;
}

@JsonProperty("legend")
public void setLegend(Legend legend) {
this.legend = legend;
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
public List<Series_> getSeries() {
return series;
}

@JsonProperty("series")
public void setSeries(List<Series_> series) {
this.series = series;
}

@JsonProperty("responsive")
public Responsive getResponsive() {
return responsive;
}

@JsonProperty("responsive")
public void setResponsive(Responsive responsive) {
this.responsive = responsive;
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


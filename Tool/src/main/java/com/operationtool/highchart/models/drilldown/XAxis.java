package com.operationtool.highchart.models.drilldown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.operationtool.highchart.models.AxesChart.Labels;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"labels",
"title",
"min",
"max",
"scrollbar",
"tickLength",
"crosshair"
})
public class XAxis {


@JsonProperty("crosshair")
private boolean crosshair = true;
	
public boolean isCrosshair() {
	return crosshair;
}

public void setCrosshair(boolean crosshair) {
	this.crosshair = crosshair;
}

@JsonProperty("labels")
private Labels labels;

@JsonProperty("type")
private String type;
@JsonProperty("title")
private Title title;
@JsonProperty("min")
private Integer min;
@JsonProperty("max")
private Integer max;
@JsonProperty("scrollbar")
private Scrollbar scrollbar;
@JsonProperty("tickLength")
private Integer tickLength;

@JsonProperty("categories")
private List<String> categories = null;

@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<String> getCategories() {
	return categories;
}

public void setCategories(List<String> monthsList) {
	this.categories = monthsList;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}


public Labels getLabels() {
	return labels;
}

public void setLabels(Labels labels) {
	this.labels = labels;
}

@JsonProperty("title")
public Title getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(Title title) {
this.title = title;
}

@JsonProperty("min")
public Integer getMin() {
return min;
}

@JsonProperty("min")
public void setMin(Integer min) {
this.min = min;
}

@JsonProperty("max")
public Integer getMax() {
return max;
}

@JsonProperty("max")
public void setMax(Integer max) {
this.max = max;
}

@JsonProperty("scrollbar")
public Scrollbar getScrollbar() {
return scrollbar;
}

@JsonProperty("scrollbar")
public void setScrollbar(Scrollbar scrollbar) {
this.scrollbar = scrollbar;
}

@JsonProperty("tickLength")
public Integer getTickLength() {
return tickLength;
}

@JsonProperty("tickLength")
public void setTickLength(Integer tickLength) {
this.tickLength = tickLength;
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
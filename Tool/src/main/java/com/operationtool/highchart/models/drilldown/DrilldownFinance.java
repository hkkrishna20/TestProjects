package com.operationtool.highchart.models.drilldown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "activeAxisLabelStyle", "activeDataLabelStyle", "allowPointDrilldown", "animation",
		"drillUpButton", "series" })

public class DrilldownFinance {
	@JsonProperty("series")
	@Valid
	private List<Series_Finance> drilldown = new ArrayList<Series_Finance>();


@JsonProperty("allowPointDrilldown")
private Boolean allowPointDrilldown;
@JsonProperty("activeAxisLabelStyle")
private ActiveAxisLabelStyle activeAxisLabelStyle;
@JsonProperty("activeDataLabelStyle")
private ActiveDataLabelStyle activeDataLabelStyle;
@JsonProperty("animation")
private Animation animation;
@JsonProperty("drillUpButton")
private DrillUpButton drillUpButton;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("allowPointDrilldown")
public Boolean getAllowPointDrilldown() {
return allowPointDrilldown;
}

@JsonProperty("allowPointDrilldown")
public void setAllowPointDrilldown(Boolean allowPointDrilldown) {
this.allowPointDrilldown = allowPointDrilldown;
}

@JsonProperty("activeAxisLabelStyle")
public ActiveAxisLabelStyle getActiveAxisLabelStyle() {
return activeAxisLabelStyle;
}

@JsonProperty("activeAxisLabelStyle")
public void setActiveAxisLabelStyle(ActiveAxisLabelStyle activeAxisLabelStyle) {
this.activeAxisLabelStyle = activeAxisLabelStyle;
}

@JsonProperty("activeDataLabelStyle")
public ActiveDataLabelStyle getActiveDataLabelStyle() {
return activeDataLabelStyle;
}

@JsonProperty("activeDataLabelStyle")
public void setActiveDataLabelStyle(ActiveDataLabelStyle activeDataLabelStyle) {
this.activeDataLabelStyle = activeDataLabelStyle;
}

@JsonProperty("animation")
public Animation getAnimation() {
return animation;
}

@JsonProperty("animation")
public void setAnimation(Animation animation) {
this.animation = animation;
}

@JsonProperty("drillUpButton")
public DrillUpButton getDrillUpButton() {
return drillUpButton;
}

@JsonProperty("drillUpButton")
public void setDrillUpButton(DrillUpButton drillUpButton) {
this.drillUpButton = drillUpButton;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

	public List<Series_Finance>getDrilldown() {
		return drilldown;
	}

	public void setDrilldown(List<Series_Finance> drilldown) {
		this.drilldown = drilldown;
	}

}

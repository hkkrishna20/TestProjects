package com.operationtool.highchart.models.basicLinechart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"label",
"pointStart"
})
public class Series implements Serializable
{

@JsonProperty("label")
private Label label;
@JsonProperty("pointStart")
private int pointStart;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -1946527655796688281L;

@JsonProperty("label")
public Label getLabel() {
return label;
}

@JsonProperty("label")
public void setLabel(Label label) {
this.label = label;
}

@JsonProperty("pointStart")
public int getPointStart() {
return pointStart;
}

@JsonProperty("pointStart")
public void setPointStart(int pointStart) {
this.pointStart = pointStart;
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


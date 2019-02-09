package com.operationtool.highchart.models.AxesChart;

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
"position",
"right",
"bottom"
})
public class Style implements Serializable
{

@JsonProperty("position")
private String position;
@JsonProperty("right")
private String right;
@JsonProperty("bottom")
private String bottom;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 6345476590196598042L;

@JsonProperty("position")
public String getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(String position) {
this.position = position;
}

@JsonProperty("right")
public String getRight() {
return right;
}

@JsonProperty("right")
public void setRight(String right) {
this.right = right;
}

@JsonProperty("bottom")
public String getBottom() {
return bottom;
}

@JsonProperty("bottom")
public void setBottom(String bottom) {
this.bottom = bottom;
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


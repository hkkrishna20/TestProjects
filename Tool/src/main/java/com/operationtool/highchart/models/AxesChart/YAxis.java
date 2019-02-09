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
"title",
"allowDecimals",
"min"
})
public class YAxis implements Serializable
{

@JsonProperty("title")
private Title_ title;
@JsonProperty("allowDecimals")
private boolean allowDecimals;
@JsonProperty("min")
private int min;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -5363670744304327121L;

@JsonProperty("title")
public Title_ getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(Title_ title) {
this.title = title;
}

@JsonProperty("allowDecimals")
public boolean isAllowDecimals() {
return allowDecimals;
}

@JsonProperty("allowDecimals")
public void setAllowDecimals(boolean allowDecimals) {
this.allowDecimals = allowDecimals;
}

@JsonProperty("min")
public int getMin() {
return min;
}

@JsonProperty("min")
public void setMin(int min) {
this.min = min;
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
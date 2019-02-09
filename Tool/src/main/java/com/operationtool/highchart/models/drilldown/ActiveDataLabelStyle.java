package com.operationtool.highchart.models.drilldown;

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
"color",
"cursor",
"fontWeight",
"textDecoration"
})
public class ActiveDataLabelStyle {

@JsonProperty("color")
private String color;
@JsonProperty("cursor")
private String cursor;
@JsonProperty("fontWeight")
private String fontWeight;
@JsonProperty("textDecoration")
private String textDecoration;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("color")
public String getColor() {
return color;
}

@JsonProperty("color")
public void setColor(String color) {
this.color = color;
}

@JsonProperty("cursor")
public String getCursor() {
return cursor;
}

@JsonProperty("cursor")
public void setCursor(String cursor) {
this.cursor = cursor;
}

@JsonProperty("fontWeight")
public String getFontWeight() {
return fontWeight;
}

@JsonProperty("fontWeight")
public void setFontWeight(String fontWeight) {
this.fontWeight = fontWeight;
}

@JsonProperty("textDecoration")
public String getTextDecoration() {
return textDecoration;
}

@JsonProperty("textDecoration")
public void setTextDecoration(String textDecoration) {
this.textDecoration = textDecoration;
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


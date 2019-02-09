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
"fontSize",
"fontWeight",
"textOutline"
})
public class Style {

@JsonProperty("color")
private String color;
@JsonProperty("fontSize")
private String fontSize;
@JsonProperty("fontWeight")
private String fontWeight ="normal";
@JsonProperty("textOutline")
private String textOutline;
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

@JsonProperty("fontSize")
public String getFontSize() {
return fontSize;
}

@JsonProperty("fontSize")
public void setFontSize(String fontSize) {
this.fontSize = fontSize;
}

@JsonProperty("fontWeight")
public String getFontWeight() {
return fontWeight;
}

@JsonProperty("fontWeight")
public void setFontWeight(String fontWeight) {
this.fontWeight = fontWeight;
}

@JsonProperty("textOutline")
public String getTextOutline() {
return textOutline;
}

@JsonProperty("textOutline")
public void setTextOutline(String textOutline) {
this.textOutline = textOutline;
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
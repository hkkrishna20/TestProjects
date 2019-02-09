package com.operationtool.highchart.models.basicLinechart;

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
"fontSize",
"fontFamily"
})
public class Style {

@JsonProperty("fontSize")
private String fontSize;
@JsonProperty("fontFamily")
private String fontFamily;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("fontSize")
public String getFontSize() {
return fontSize;
}

@JsonProperty("fontSize")
public void setFontSize(String fontSize) {
this.fontSize = fontSize;
}

@JsonProperty("fontFamily")
public String getFontFamily() {
return fontFamily;
}

@JsonProperty("fontFamily")
public void setFontFamily(String fontFamily) {
this.fontFamily = fontFamily;
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
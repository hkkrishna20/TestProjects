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
"position",
"relativeTo",
"theme"
})
public class DrillUpButton {

@JsonProperty("position")
private Position position;
@JsonProperty("relativeTo")
private String relativeTo;
@JsonProperty("theme")
private String theme;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("position")
public Position getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(Position position) {
this.position = position;
}

@JsonProperty("relativeTo")
public String getRelativeTo() {
return relativeTo;
}

@JsonProperty("relativeTo")
public void setRelativeTo(String relativeTo) {
this.relativeTo = relativeTo;
}

@JsonProperty("theme")
public String getTheme() {
return theme;
}

@JsonProperty("theme")
public void setTheme(String theme) {
this.theme = theme;
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


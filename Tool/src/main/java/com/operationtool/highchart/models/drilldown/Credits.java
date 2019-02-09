
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
"enabled",
"href",
"position",
"style",
"text"
})
public class Credits {

@JsonProperty("enabled")
private Boolean enabled;
@JsonProperty("href")
private String href;
@JsonProperty("position")
private Position position;
@JsonProperty("style")
private Style style;
@JsonProperty("text")
private String text;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("enabled")
public Boolean getEnabled() {
return enabled;
}

@JsonProperty("enabled")
public void setEnabled(Boolean enabled) {
this.enabled = enabled;
}

@JsonProperty("href")
public String getHref() {
return href;
}

@JsonProperty("href")
public void setHref(String href) {
this.href = href;
}

@JsonProperty("position")
public Position getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(Position position) {
this.position = position;
}

@JsonProperty("style")
public Style getStyle() {
return style;
}

@JsonProperty("style")
public void setStyle(Style style) {
this.style = style;
}

@JsonProperty("text")
public String getText() {
return text;
}

@JsonProperty("text")
public void setText(String text) {
this.text = text;
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


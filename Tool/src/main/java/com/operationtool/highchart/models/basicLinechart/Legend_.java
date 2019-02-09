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
"layout",
"align",
"verticalAlign"
})
public class Legend_ implements Serializable
{

@JsonProperty("layout")
private String layout;
@JsonProperty("align")
private String align;
@JsonProperty("verticalAlign")
private String verticalAlign;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 92106802376499440L;

@JsonProperty("layout")
public String getLayout() {
return layout;
}

@JsonProperty("layout")
public void setLayout(String layout) {
this.layout = layout;
}

@JsonProperty("align")
public String getAlign() {
return align;
}

@JsonProperty("align")
public void setAlign(String align) {
this.align = align;
}

@JsonProperty("verticalAlign")
public String getVerticalAlign() {
return verticalAlign;
}

@JsonProperty("verticalAlign")
public void setVerticalAlign(String verticalAlign) {
this.verticalAlign = verticalAlign;
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


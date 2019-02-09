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
"operator",
"property",
"value"
})
public class Filter {

@JsonProperty("operator")
private String operator;
@JsonProperty("property")
private String property;
@JsonProperty("value")
private String value;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("operator")
public String getOperator() {
return operator;
}

@JsonProperty("operator")
public void setOperator(String operator) {
this.operator = operator;
}

@JsonProperty("property")
public String getProperty() {
return property;
}

@JsonProperty("property")
public void setProperty(String property) {
this.property = property;
}

@JsonProperty("value")
public String getValue() {
return value;
}

@JsonProperty("value")
public void setValue(String value) {
this.value = value;
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


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
"condition",
"chartOptions"
})
public class Rule implements Serializable
{

@JsonProperty("condition")
private Condition condition;
@JsonProperty("chartOptions")
private ChartOptions chartOptions;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -2212869218999757205L;

@JsonProperty("condition")
public Condition getCondition() {
return condition;
}

@JsonProperty("condition")
public void setCondition(Condition condition) {
this.condition = condition;
}

@JsonProperty("chartOptions")
public ChartOptions getChartOptions() {
return chartOptions;
}

@JsonProperty("chartOptions")
public void setChartOptions(ChartOptions chartOptions) {
this.chartOptions = chartOptions;
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



package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type"
})
public class Chart implements Serializable
{

@JsonProperty("type")
private String type;

private final static long serialVersionUID = -3937863775031061503L;


@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("type", type).toString();
}

}


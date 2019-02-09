
package com.operationtool.highchart.models.AxesChart;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.operationtool.highchart.models.basicLinechart.Style;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "rotation", "style" })
public class Labels {

	@JsonProperty("rotation")
	private Integer rotation;
	@JsonProperty("style")
	private Style style;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("rotation")
	public Integer getRotation() {
		return rotation;
	}

	@JsonProperty("rotation")
	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	@JsonProperty("style")
	public Style getStyle() {
		if (style == null) {
			style = new Style();
		}
		return style;
	}

	@JsonProperty("style")
	public void setStyle(Style style) {
		this.style = style;
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

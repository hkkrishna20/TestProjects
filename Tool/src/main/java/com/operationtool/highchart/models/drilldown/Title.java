package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "text" })
public class Title implements Serializable {

	@JsonProperty("text")
	private String text;
	private final static long serialVersionUID = -5312828281414131743L;
	@JsonProperty("align")
	private String align;

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("text", text).toString();
	}

}

package com.operationtool.highchart.models.drilldown;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "enabled", "borderRadius", "y","color","shape", "format", "backgroundColor", "borderWidth", "borderColor",
		"align", "rotation", "x", "style" })
public class DataLabels implements Serializable {

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(String borderWidth) {
		this.borderWidth = borderWidth;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	@JsonProperty("enabled")
	private boolean enabled = true;
	@JsonProperty("format")
	private String format;


	@JsonProperty("color")
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Style getStyle() {
		if (style == null) {

			style = new Style();
		}
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@JsonProperty("style")
	private Style style;

	@JsonProperty("align")
	private String align;
	@JsonProperty("rotation")
	private int rotation;
	@JsonProperty("x")
	private int x;

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@JsonProperty("borderRadius")
	private Integer borderRadius;

	@JsonProperty("backgroundColor")
	private String backgroundColor;

	@JsonProperty("borderWidth")
	private String borderWidth;

	@JsonProperty("borderColor")
	private String borderColor;

	public Integer getBorderRadius() {
		return borderRadius;
	}

	public void setBorderRadius(Integer borderRadius) {
		this.borderRadius = borderRadius;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@JsonProperty("y")
	private Integer y;

	@JsonProperty("shape")
	private String shape;

	private final static long serialVersionUID = -6289366659414648415L;

	@JsonProperty("enabled")
	public boolean isEnabled() {
		return enabled;
	}

	@JsonProperty("enabled")
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@JsonProperty("format")
	public String getFormat() {
		return format;
	}

	@JsonProperty("format")
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("enabled", enabled).append("format", format).toString();
	}

}

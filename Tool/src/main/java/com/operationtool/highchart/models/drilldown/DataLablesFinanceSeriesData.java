
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
"align",
"allowOverlap",
"backgroundColor",
"borderColor",
"borderRadius",
"borderWidth",
"className",
"color",
"crop",
"defer",
"enabled",
"filter",
"format",
"formatter",
"inside",
"overflow",
"padding",
"rotation",
"shadow",
"shape",
"style",
"useHTML",
"verticalAlign",
"x",
"y",
"zIndex"
})
public class DataLablesFinanceSeriesData {

@JsonProperty("align")
private String align;
@JsonProperty("allowOverlap")
private Boolean allowOverlap;
@JsonProperty("backgroundColor")
private String backgroundColor;
@JsonProperty("borderColor")
private String borderColor;
@JsonProperty("borderRadius")
private Integer borderRadius;
@JsonProperty("borderWidth")
private Integer borderWidth;
@JsonProperty("className")
private String className;
@JsonProperty("color")
private String color;
@JsonProperty("crop")
private Boolean crop;
@JsonProperty("defer")
private Boolean defer;
@JsonProperty("enabled")
private Boolean enabled = true;
@JsonProperty("filter")
private Filter filter;
@JsonProperty("format")
private String format;
@JsonProperty("formatter")
private String formatter;
@JsonProperty("inside")
private String inside;
@JsonProperty("overflow")
private String overflow;
@JsonProperty("padding")
private Integer padding;
@JsonProperty("rotation")
private Integer rotation;
@JsonProperty("shadow")
private Boolean shadow;
@JsonProperty("shape")
private String shape;
@JsonProperty("style")
private Style style;
@JsonProperty("useHTML")
private Boolean useHTML;
@JsonProperty("verticalAlign")
private Object verticalAlign;
@JsonProperty("x")
private Integer x;
@JsonProperty("y")
private Integer y;
@JsonProperty("zIndex")
private String zIndex;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("align")
public String getAlign() {
return align;
}

@JsonProperty("align")
public void setAlign(String align) {
this.align = align;
}

@JsonProperty("allowOverlap")
public Boolean getAllowOverlap() {
return allowOverlap;
}

@JsonProperty("allowOverlap")
public void setAllowOverlap(Boolean allowOverlap) {
this.allowOverlap = allowOverlap;
}

@JsonProperty("backgroundColor")
public String getBackgroundColor() {
return backgroundColor;
}

@JsonProperty("backgroundColor")
public void setBackgroundColor(String backgroundColor) {
this.backgroundColor = backgroundColor;
}

@JsonProperty("borderColor")
public String getBorderColor() {
return borderColor;
}

@JsonProperty("borderColor")
public void setBorderColor(String borderColor) {
this.borderColor = borderColor;
}

@JsonProperty("borderRadius")
public Integer getBorderRadius() {
return borderRadius;
}

@JsonProperty("borderRadius")
public void setBorderRadius(Integer borderRadius) {
this.borderRadius = borderRadius;
}

@JsonProperty("borderWidth")
public Integer getBorderWidth() {
return borderWidth;
}

@JsonProperty("borderWidth")
public void setBorderWidth(Integer borderWidth) {
this.borderWidth = borderWidth;
}

@JsonProperty("className")
public String getClassName() {
return className;
}

@JsonProperty("className")
public void setClassName(String className) {
this.className = className;
}

@JsonProperty("color")
public String getColor() {
return color;
}

@JsonProperty("color")
public void setColor(String color) {
this.color = color;
}

@JsonProperty("crop")
public Boolean getCrop() {
return crop;
}

@JsonProperty("crop")
public void setCrop(Boolean crop) {
this.crop = crop;
}

@JsonProperty("defer")
public Boolean getDefer() {
return defer;
}

@JsonProperty("defer")
public void setDefer(Boolean defer) {
this.defer = defer;
}

@JsonProperty("enabled")
public Boolean getEnabled() {
return enabled;
}

@JsonProperty("enabled")
public void setEnabled(Boolean enabled) {
this.enabled = enabled;
}

@JsonProperty("filter")
public Filter getFilter() {
return filter;
}

@JsonProperty("filter")
public void setFilter(Filter filter) {
this.filter = filter;
}

@JsonProperty("format")
public String getFormat() {
return format;
}

@JsonProperty("format")
public void setFormat(String format) {
this.format = format;
}

@JsonProperty("formatter")
public String getFormatter() {
return formatter;
}

@JsonProperty("formatter")
public void setFormatter(String formatter) {
this.formatter = formatter;
}

@JsonProperty("inside")
public String getInside() {
return inside;
}

@JsonProperty("inside")
public void setInside(String inside) {
this.inside = inside;
}

@JsonProperty("overflow")
public String getOverflow() {
return overflow;
}

@JsonProperty("overflow")
public void setOverflow(String overflow) {
this.overflow = overflow;
}

@JsonProperty("padding")
public Integer getPadding() {
return padding;
}

@JsonProperty("padding")
public void setPadding(Integer padding) {
this.padding = padding;
}

@JsonProperty("rotation")
public Integer getRotation() {
return rotation;
}

@JsonProperty("rotation")
public void setRotation(Integer rotation) {
this.rotation = rotation;
}

@JsonProperty("shadow")
public Boolean getShadow() {
return shadow;
}

@JsonProperty("shadow")
public void setShadow(Boolean shadow) {
this.shadow = shadow;
}

@JsonProperty("shape")
public String getShape() {
return shape;
}

@JsonProperty("shape")
public void setShape(String shape) {
this.shape = shape;
}

@JsonProperty("style")
public Style getStyle() {
return style;
}

@JsonProperty("style")
public void setStyle(Style style) {
this.style = style;
}

@JsonProperty("useHTML")
public Boolean getUseHTML() {
return useHTML;
}

@JsonProperty("useHTML")
public void setUseHTML(Boolean useHTML) {
this.useHTML = useHTML;
}

@JsonProperty("verticalAlign")
public Object getVerticalAlign() {
return verticalAlign;
}

@JsonProperty("verticalAlign")
public void setVerticalAlign(Object verticalAlign) {
this.verticalAlign = verticalAlign;
}

@JsonProperty("x")
public Integer getX() {
return x;
}

@JsonProperty("x")
public void setX(int i) {
this.x = i;
}

@JsonProperty("y")
public Integer getY() {
return y;
}

@JsonProperty("y")
public void setY(int i) {
this.y = i;
}

@JsonProperty("zIndex")
public String getZIndex() {
return zIndex;
}

@JsonProperty("zIndex")
public void setZIndex(String zIndex) {
this.zIndex = zIndex;
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


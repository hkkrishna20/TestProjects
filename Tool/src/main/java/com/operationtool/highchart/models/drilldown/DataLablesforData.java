
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
"rotation",
"shape",
"borderColor",
"borderWidth",
"padding",
"shadow",
"style"
})
public class DataLablesforData {

@JsonProperty("align")
private String align;
@JsonProperty("rotation")
private Integer rotation;
@JsonProperty("shape")
private String shape;
@JsonProperty("borderColor")
private String borderColor;
@JsonProperty("borderWidth")
private Integer borderWidth;
@JsonProperty("padding")
private Integer padding;
@JsonProperty("shadow")
private Boolean shadow;
@JsonProperty("style")
private Style style;
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

@JsonProperty("rotation")
public Integer getRotation() {
return rotation;
}

@JsonProperty("rotation")
public void setRotation(Integer rotation) {
this.rotation = rotation;
}

@JsonProperty("shape")
public String getShape() {
return shape;
}

@JsonProperty("shape")
public void setShape(String shape) {
this.shape = shape;
}

@JsonProperty("borderColor")
public String getBorderColor() {
return borderColor;
}

@JsonProperty("borderColor")
public void setBorderColor(String borderColor) {
this.borderColor = borderColor;
}

@JsonProperty("borderWidth")
public Integer getBorderWidth() {
return borderWidth;
}

@JsonProperty("borderWidth")
public void setBorderWidth(Integer borderWidth) {
this.borderWidth = borderWidth;
}

@JsonProperty("padding")
public Integer getPadding() {
return padding;
}

@JsonProperty("padding")
public void setPadding(Integer padding) {
this.padding = padding;
}

@JsonProperty("shadow")
public Boolean getShadow() {
return shadow;
}

@JsonProperty("shadow")
public void setShadow(Boolean shadow) {
this.shadow = shadow;
}

@JsonProperty("style")
public Style getStyle() {
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


package com.operationtool.highchart.models.AxesChart;

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
"verticalAlign",
"x",
"y",
"floating",
"borderWidth",
"backgroundColor"
})
public class Legend implements Serializable
{

@JsonProperty("layout")
private String layout;
@JsonProperty("align")
private String align;
@JsonProperty("verticalAlign")
private String verticalAlign;
@JsonProperty("x")
private int x;
@JsonProperty("y")
private int y;
@JsonProperty("floating")
private boolean floating;
@JsonProperty("borderWidth")
private int borderWidth;
@JsonProperty("backgroundColor")
private String backgroundColor;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -3470660251233045186L;

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

@JsonProperty("x")
public int getX() {
return x;
}

@JsonProperty("x")
public void setX(int x) {
this.x = x;
}

@JsonProperty("y")
public int getY() {
return y;
}

@JsonProperty("y")
public void setY(int y) {
this.y = y;
}

@JsonProperty("floating")
public boolean isFloating() {
return floating;
}

@JsonProperty("floating")
public void setFloating(boolean floating) {
this.floating = floating;
}

@JsonProperty("borderWidth")
public int getBorderWidth() {
return borderWidth;
}

@JsonProperty("borderWidth")
public void setBorderWidth(int borderWidth) {
this.borderWidth = borderWidth;
}

@JsonProperty("backgroundColor")
public String getBackgroundColor() {
return backgroundColor;
}

@JsonProperty("backgroundColor")
public void setBackgroundColor(String backgroundColor) {
this.backgroundColor = backgroundColor;
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


package com.mappls.sdk.maps.rctmgl.components.geoAnalytics;

/* JADX INFO: loaded from: classes4.dex */
public class StyleRequest {
    private String fillColor;
    private Double fillOpacity;
    private String labelColor;
    private Integer labelSize;
    private Integer pointSize;
    private String strokeColor;
    private Double strokeWidth;

    public String getLabelColor() {
        return this.labelColor;
    }

    public void setLabelColor(String str) {
        this.labelColor = str;
    }

    public Integer getLabelSize() {
        return this.labelSize;
    }

    public void setLabelSize(Integer num) {
        this.labelSize = num;
    }

    public String getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(String str) {
        this.fillColor = str;
    }

    public Integer getPointSize() {
        return this.pointSize;
    }

    public void setPointSize(Integer num) {
        this.pointSize = num;
    }

    public String getStrokeColor() {
        return this.strokeColor;
    }

    public void setStrokeColor(String str) {
        this.strokeColor = str;
    }

    public Double getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeWidth(Double d) {
        this.strokeWidth = d;
    }

    public Double getFillOpacity() {
        return this.fillOpacity;
    }

    public void setFillOpacity(Double d) {
        this.fillOpacity = d;
    }
}

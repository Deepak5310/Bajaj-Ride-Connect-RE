package com.mappls.sdk.geoanalytics;

/* JADX INFO: loaded from: classes6.dex */
public class GeoAnalyticsAppearanceOption {
    private String fillColor = "42a5f4";
    private double fillOpacity = 0.5d;
    private String strokeColor = "000000";
    private double strokeWidth = 0.0d;
    private int labelSize = 10;
    private String labelColor = "000000";
    private int pointSize = 1;

    public GeoAnalyticsAppearanceOption fillColor(String str) {
        if (str.contains("#")) {
            str = str.substring(1);
        }
        this.fillColor = str;
        return this;
    }

    public GeoAnalyticsAppearanceOption fillOpacity(double d) {
        this.fillOpacity = d;
        return this;
    }

    public GeoAnalyticsAppearanceOption labelColor(String str) {
        if (str.contains("#")) {
            str = str.substring(1);
        }
        this.labelColor = str;
        return this;
    }

    public GeoAnalyticsAppearanceOption labelSize(int i) {
        this.labelSize = i;
        return this;
    }

    public GeoAnalyticsAppearanceOption pointSize(int i) {
        this.pointSize = i;
        return this;
    }

    public GeoAnalyticsAppearanceOption strokeColor(String str) {
        if (str.contains("#")) {
            str = str.substring(1);
        }
        this.strokeColor = str;
        return this;
    }

    public GeoAnalyticsAppearanceOption strokeWidth(double d) {
        this.strokeWidth = d;
        return this;
    }

    String toJson() {
        return "fillcolor:" + this.fillColor + ";fillopacity:" + this.fillOpacity + ";strokecolor:" + this.strokeColor + ";strokewidth:" + this.strokeWidth + ";labelsize:" + this.labelSize + ";labelcolor:" + this.labelColor;
    }

    String toPointJson() {
        return "fillcolor:" + this.fillColor + ";fillopacity:" + this.fillOpacity + ";strokecolor:" + this.strokeColor + ";strokewidth:" + this.strokeWidth + ";labelsize:" + this.labelSize + ";pointsize:" + this.pointSize + ";labelcolor:" + this.labelColor;
    }
}

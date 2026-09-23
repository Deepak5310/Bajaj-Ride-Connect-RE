package com.mappls.sdk.maps.rctmgl.components.geoAnalytics;

/* JADX INFO: loaded from: classes4.dex */
public class LayerRequest {
    private String attribute;
    private String[] geoBound;
    private String[] propertyNames;
    private String query;
    private StyleRequest styleRequest;

    public String[] getGeoBound() {
        return this.geoBound;
    }

    public void setGeoBound(String[] strArr) {
        this.geoBound = strArr;
    }

    public String[] getPropertyNames() {
        return this.propertyNames;
    }

    public void setPropertyNames(String[] strArr) {
        this.propertyNames = strArr;
    }

    public StyleRequest getStyleRequest() {
        return this.styleRequest;
    }

    public void setStyleRequest(StyleRequest styleRequest) {
        this.styleRequest = styleRequest;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }
}

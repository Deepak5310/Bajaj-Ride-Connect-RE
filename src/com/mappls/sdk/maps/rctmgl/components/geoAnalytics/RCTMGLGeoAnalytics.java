package com.mappls.sdk.maps.rctmgl.components.geoAnalytics;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.actions.SearchIntents;
import com.mappls.sdk.geoanalytics.GeoAnalyticsAppearanceOption;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsRequest;
import com.mappls.sdk.geoanalytics.MapplsGeoAnalyticsType;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLGeoAnalytics extends AbstractMapFeature {
    private String geoBoundType;
    ArrayList<LayerRequest> layerRequests;
    private RCTMGLMapView mapView;
    List<MapplsGeoAnalyticsRequest> nativeRequest;
    private MapplsGeoAnalyticsType showGeoAnalytics;

    public RCTMGLGeoAnalytics(Context context) {
        super(context);
        this.layerRequests = new ArrayList<>();
        this.nativeRequest = new ArrayList();
        this.geoBoundType = null;
        this.showGeoAnalytics = null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mapView = rCTMGLMapView;
        setupGeoAnalytics();
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
        removeGeoAnalytics(this.showGeoAnalytics);
    }

    private void setupGeoAnalytics() {
        for (int i = 0; i < this.layerRequests.size(); i++) {
            MapplsGeoAnalyticsRequest.Builder builder = MapplsGeoAnalyticsRequest.builder();
            LayerRequest layerRequest = this.layerRequests.get(i);
            if (layerRequest.getAttribute() != null) {
                builder.attribute(layerRequest.getAttribute());
            }
            if (layerRequest.getGeoBound() != null) {
                builder.geoBound(layerRequest.getGeoBound());
            }
            String str = this.geoBoundType;
            if (str != null) {
                builder.geoboundType(str);
            }
            if (layerRequest.getPropertyNames() != null) {
                builder.propertyNames(layerRequest.getPropertyNames());
            }
            if (layerRequest.getQuery() != null) {
                builder.query(layerRequest.getQuery());
            }
            if (layerRequest.getStyleRequest() != null) {
                builder.style(setUpGeoAnalyticsStyle(layerRequest.getStyleRequest()));
            }
            this.nativeRequest.add(builder.build());
        }
        if (this.showGeoAnalytics != null) {
            this.mapView.getGeoAnalyticsPlugin().showGeoAnalytics(this.showGeoAnalytics, this.nativeRequest);
        }
    }

    private GeoAnalyticsAppearanceOption setUpGeoAnalyticsStyle(StyleRequest styleRequest) {
        GeoAnalyticsAppearanceOption geoAnalyticsAppearanceOption = new GeoAnalyticsAppearanceOption();
        if (styleRequest.getLabelColor() != null) {
            geoAnalyticsAppearanceOption.labelColor(styleRequest.getLabelColor());
        }
        if (styleRequest.getLabelSize() != null) {
            geoAnalyticsAppearanceOption.labelSize(styleRequest.getLabelSize().intValue());
        }
        if (styleRequest.getFillColor() != null) {
            geoAnalyticsAppearanceOption.fillColor(styleRequest.getFillColor());
        }
        if (styleRequest.getPointSize() != null) {
            geoAnalyticsAppearanceOption.pointSize(styleRequest.getPointSize().intValue());
        }
        if (styleRequest.getStrokeColor() != null) {
            geoAnalyticsAppearanceOption.strokeColor(styleRequest.getStrokeColor());
        }
        if (styleRequest.getStrokeWidth() != null) {
            geoAnalyticsAppearanceOption.strokeWidth(styleRequest.getStrokeWidth().doubleValue());
        }
        if (styleRequest.getFillOpacity() != null) {
            geoAnalyticsAppearanceOption.fillOpacity(styleRequest.getFillOpacity().doubleValue());
        }
        return geoAnalyticsAppearanceOption;
    }

    public void showGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
        this.showGeoAnalytics = mapplsGeoAnalyticsType;
    }

    public void removeGeoAnalytics(MapplsGeoAnalyticsType mapplsGeoAnalyticsType) {
        this.mapView.getGeoAnalyticsPlugin().removeGeoAnalytics(mapplsGeoAnalyticsType);
    }

    public void setLayerRequest(ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            String string = map.getString("attribute");
            String string2 = map.getString(SearchIntents.EXTRA_QUERY);
            ReadableArray readableArrayCreateArray = map.isNull("geoBound") ? Arguments.createArray() : map.getArray("geoBound");
            String[] strArr = new String[readableArrayCreateArray.size()];
            for (int i2 = 0; i2 < readableArrayCreateArray.size(); i2++) {
                strArr[i2] = readableArrayCreateArray.getString(i2);
            }
            ReadableArray readableArrayCreateArray2 = map.isNull("propertyNames") ? Arguments.createArray() : map.getArray("propertyNames");
            String[] strArr2 = new String[readableArrayCreateArray2.size()];
            for (int i3 = 0; i3 < readableArrayCreateArray2.size(); i3++) {
                strArr2[i3] = readableArrayCreateArray2.getString(i3);
            }
            ReadableMap map2 = map.getMap("styles");
            String string3 = map2.getString("labelColor");
            String string4 = map2.getString("fillColor");
            String string5 = map2.getString("strokeColor");
            Integer numValueOf = Integer.valueOf(map2.hasKey("pointSize") ? map2.getInt("pointSize") : 1);
            Double dValueOf = null;
            Integer numValueOf2 = map2.hasKey("labelSize") ? Integer.valueOf(map2.getInt("labelSize")) : null;
            Double dValueOf2 = map2.hasKey("strokeWidth") ? Double.valueOf(map2.getDouble("strokeWidth")) : null;
            if (map2.hasKey("fillOpacity")) {
                dValueOf = Double.valueOf(map2.getDouble("fillOpacity"));
            }
            StyleRequest styleRequest = new StyleRequest();
            styleRequest.setLabelColor(string3);
            styleRequest.setLabelSize(numValueOf2);
            styleRequest.setFillColor(string4);
            styleRequest.setPointSize(numValueOf);
            styleRequest.setStrokeColor(string5);
            styleRequest.setStrokeWidth(dValueOf2);
            styleRequest.setFillOpacity(dValueOf);
            LayerRequest layerRequest = new LayerRequest();
            layerRequest.setAttribute(string);
            layerRequest.setQuery(string2);
            layerRequest.setGeoBound(strArr);
            layerRequest.setPropertyNames(strArr2);
            layerRequest.setStyleRequest(styleRequest);
            this.layerRequests.add(layerRequest);
        }
    }

    public void setGeoboundType(String str) {
        this.geoBoundType = str;
    }
}

package com.mappls.sdk.maps.rctmgl.components.annotation;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLMarkerView extends AbstractMapFeature implements com.mappls.sdk.plugin.markerview.MarkerView.OnPositionUpdateListener, View.OnLayoutChangeListener {
    private Float[] mAnchor;
    private View mChildView;
    private Point mCoordinate;
    private RCTMGLMarkerViewManager mManager;
    private RCTMGLMapView mMapView;
    private MarkerView mMarkerView;
    private MarkerViewManager mMarkerViewManager;

    public RCTMGLMarkerView(Context context, RCTMGLMarkerViewManager rCTMGLMarkerViewManager) {
        super(context);
        this.mManager = rCTMGLMarkerViewManager;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        this.mChildView = view;
    }

    public void setCoordinate(Point point) {
        this.mCoordinate = point;
        MarkerView markerView = this.mMarkerView;
        if (markerView != null) {
            markerView.setLatLng(GeoJSONUtils.toLatLng(point));
        }
    }

    public void setAnchor(float f, float f2) {
        this.mAnchor = new Float[]{Float.valueOf(f), Float.valueOf(f2)};
        refresh();
    }

    public void refresh() {
        MarkerView markerView = this.mMarkerView;
        if (markerView != null) {
            markerView.setLatLng(GeoJSONUtils.toLatLng(this.mCoordinate));
        }
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mMapView = rCTMGLMapView;
        rCTMGLMapView.getMapAsync(new OnMapReadyCallback() { // from class: com.mappls.sdk.maps.rctmgl.components.annotation.RCTMGLMarkerView.1
            @Override // com.mappls.sdk.maps.OnMapReadyCallback
            public void onMapError(int i, String str) {
            }

            @Override // com.mappls.sdk.maps.OnMapReadyCallback
            public void onMapReady(MapplsMap mapplsMap) {
                RCTMGLMarkerView rCTMGLMarkerView = RCTMGLMarkerView.this;
                rCTMGLMarkerView.mMarkerViewManager = rCTMGLMarkerView.mMapView.getMarkerViewManager(mapplsMap);
                if (RCTMGLMarkerView.this.mChildView != null) {
                    RCTMGLMarkerView.this.mMarkerView = new MarkerView(GeoJSONUtils.toLatLng(RCTMGLMarkerView.this.mCoordinate), RCTMGLMarkerView.this.mChildView);
                    RCTMGLMarkerView.this.mMarkerView.setOnPositionUpdateListener(this);
                    RCTMGLMarkerView.this.mChildView.addOnLayoutChangeListener(this);
                    RCTMGLMarkerView.this.mMarkerViewManager.addMarker(RCTMGLMarkerView.this.mMarkerView);
                }
            }
        });
    }

    @Override // com.mappls.sdk.plugin.markerview.MarkerView.OnPositionUpdateListener
    public PointF onUpdate(PointF pointF) {
        return this.mAnchor != null ? new PointF(pointF.x - (this.mChildView.getWidth() * this.mAnchor[0].floatValue()), pointF.y - (this.mChildView.getHeight() * this.mAnchor[1].floatValue())) : pointF;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
        MarkerView markerView = this.mMarkerView;
        if (markerView != null) {
            this.mMarkerViewManager.removeMarker(markerView);
            this.mChildView.removeOnLayoutChangeListener(this);
            this.mMarkerView.setOnPositionUpdateListener(null);
            this.mMarkerView = null;
            this.mMarkerViewManager = null;
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i3 == i7 && i2 == i6 && i4 == i8) {
            return;
        }
        refresh();
    }
}

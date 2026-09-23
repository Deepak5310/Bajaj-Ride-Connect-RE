package com.mappls.sdk.maps.rctmgl.components.location;

import android.content.Context;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.location.permissions.PermissionsManager;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLNativeUserLocation extends AbstractMapFeature implements OnMapReadyCallback, Style.OnStyleLoaded {
    private boolean mEnabled;
    private MapplsMap mMap;
    private RCTMGLMapView mMapView;
    private int mRenderMode;

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapError(int i, String str) {
    }

    public RCTMGLNativeUserLocation(Context context) {
        super(context);
        this.mEnabled = true;
        this.mRenderMode = 4;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mEnabled = true;
        this.mMapView = rCTMGLMapView;
        rCTMGLMapView.getMapAsync(this);
        setRenderMode(this.mRenderMode);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
        this.mEnabled = false;
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap != null) {
            mapplsMap.getStyle(this);
        }
    }

    @Override // com.mappls.sdk.maps.OnMapReadyCallback
    public void onMapReady(MapplsMap mapplsMap) {
        this.mMap = mapplsMap;
        mapplsMap.getStyle(this);
    }

    @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
    public void onStyleLoaded(Style style) {
        if (PermissionsManager.areLocationPermissionsGranted(getContext())) {
            LocationComponentManager locationComponentManager = this.mMapView.getLocationComponentManager();
            locationComponentManager.update(style);
            locationComponentManager.showUserLocation(this.mEnabled);
        }
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
        RCTMGLMapView rCTMGLMapView = this.mMapView;
        if (rCTMGLMapView != null) {
            rCTMGLMapView.getLocationComponentManager().setRenderMode(i);
        }
    }
}

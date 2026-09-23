package com.mappls.sdk.maps.rctmgl.components.mapview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.mappls.sdk.maps.MapplsMapOptions;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLAndroidTextureMapViewManager extends RCTMGLMapViewManager {
    public static final String LOG_TAG = "RCTMGLAndroidTextureMapViewManager";
    public static final String REACT_CLASS = "RCTMGLAndroidTextureMapView";

    public RCTMGLAndroidTextureMapViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLAndroidTextureMapView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapViewManager, com.facebook.react.uimanager.ViewManager
    public RCTMGLAndroidTextureMapView createViewInstance(ThemedReactContext themedReactContext) {
        MapplsMapOptions mapplsMapOptionsCreateFromAttributes = MapplsMapOptions.createFromAttributes(themedReactContext);
        mapplsMapOptionsCreateFromAttributes.textureMode(true);
        return new RCTMGLAndroidTextureMapView(themedReactContext, this, mapplsMapOptionsCreateFromAttributes);
    }
}

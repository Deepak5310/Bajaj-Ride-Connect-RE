package com.mappls.sdk.maps.rctmgl.components.location;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLNativeUserLocationManager extends ViewGroupManager<RCTMGLNativeUserLocation> {
    public static final String REACT_CLASS = "RCTMGLNativeUserLocation";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "androidRenderMode")
    public void setAndroidRenderMode(RCTMGLNativeUserLocation rCTMGLNativeUserLocation, String str) {
        if ("compass".equalsIgnoreCase(str)) {
            rCTMGLNativeUserLocation.setRenderMode(4);
        } else if ("gps".equalsIgnoreCase(str)) {
            rCTMGLNativeUserLocation.setRenderMode(8);
        } else {
            rCTMGLNativeUserLocation.setRenderMode(18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public RCTMGLNativeUserLocation createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new RCTMGLNativeUserLocation(themedReactContext);
    }
}

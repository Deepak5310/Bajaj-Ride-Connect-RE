package com.mappls.sdk.maps.rctmgl.components.styles.light;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLLightManager extends ViewGroupManager<RCTMGLLight> {
    public static final String REACT_CLASS = "RCTMGLLight";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLLight createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLLight(themedReactContext);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLLight rCTMGLLight, ReadableMap readableMap) {
        rCTMGLLight.setReactStyle(readableMap);
    }
}

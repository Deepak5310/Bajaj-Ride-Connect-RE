package com.mappls.sdk.maps.rctmgl.components.annotation;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLCalloutManager extends ViewGroupManager<RCTMGLCallout> {
    public static final String REACT_CLASS = "RCTMGLCallout";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLCallout createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLCallout(themedReactContext);
    }
}

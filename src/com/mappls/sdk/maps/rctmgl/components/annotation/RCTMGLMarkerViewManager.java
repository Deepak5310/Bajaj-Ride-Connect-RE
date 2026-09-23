package com.mappls.sdk.maps.rctmgl.components.annotation;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLMarkerViewManager extends AbstractEventEmitter<RCTMGLMarkerView> {
    public static final String REACT_CLASS = "RCTMGLMarkerView";

    public RCTMGLMarkerViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(RCTMGLMarkerView rCTMGLMarkerView, String str) {
        rCTMGLMarkerView.setCoordinate(GeoJSONUtils.toPointGeometry(str));
    }

    @ReactProp(name = "anchor")
    public void setAnchor(RCTMGLMarkerView rCTMGLMarkerView, ReadableMap readableMap) {
        rCTMGLMarkerView.setAnchor((float) readableMap.getDouble("x"), (float) readableMap.getDouble("y"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLMarkerView createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLMarkerView(themedReactContext, this);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().build();
    }
}

package com.mappls.sdk.maps.rctmgl.components.geoAnalytics;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.utils.GeoAnalyticsUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLGeoAnalyticsManager extends AbstractEventEmitter<RCTMGLGeoAnalytics> {
    public static final String REACT_CLASS = "RCTMGLGeoAnalytics";
    private ReactApplicationContext mContext;

    public RCTMGLGeoAnalyticsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return new HashMap();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLGeoAnalytics createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLGeoAnalytics(themedReactContext);
    }

    @ReactProp(name = "showGeoAnalytics")
    public void showGeoAnalytics(RCTMGLGeoAnalytics rCTMGLGeoAnalytics, int i) {
        rCTMGLGeoAnalytics.showGeoAnalytics(GeoAnalyticsUtils.geoAnalyticsType(i));
    }

    @ReactProp(name = "layerRequest")
    public void setLayerRequest(RCTMGLGeoAnalytics rCTMGLGeoAnalytics, ReadableArray readableArray) {
        if (readableArray != null) {
            rCTMGLGeoAnalytics.setLayerRequest(readableArray);
        }
    }

    @ReactProp(name = "geoboundType")
    public void setGeoboundType(RCTMGLGeoAnalytics rCTMGLGeoAnalytics, String str) {
        if (str != null) {
            rCTMGLGeoAnalytics.setGeoboundType(str);
        }
    }
}

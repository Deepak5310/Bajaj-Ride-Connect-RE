package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLCircleLayerManager extends ViewGroupManager<RCTMGLCircleLayer> {
    public static final String REACT_CLASS = "RCTMGLCircleLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLCircleLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLCircleLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLCircleLayer rCTMGLCircleLayer, String str) {
        rCTMGLCircleLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLCircleLayer rCTMGLCircleLayer, String str) {
        rCTMGLCircleLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLCircleLayer rCTMGLCircleLayer, String str) {
        rCTMGLCircleLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLCircleLayer rCTMGLCircleLayer, String str) {
        rCTMGLCircleLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLCircleLayer rCTMGLCircleLayer, int i) {
        rCTMGLCircleLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLCircleLayer rCTMGLCircleLayer, double d) {
        rCTMGLCircleLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLCircleLayer rCTMGLCircleLayer, double d) {
        rCTMGLCircleLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLCircleLayer rCTMGLCircleLayer, ReadableMap readableMap) {
        rCTMGLCircleLayer.setReactStyle(readableMap);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLCircleLayer rCTMGLCircleLayer, String str) {
        rCTMGLCircleLayer.setSourceLayerID(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLCircleLayer rCTMGLCircleLayer, ReadableArray readableArray) {
        rCTMGLCircleLayer.setFilter(readableArray);
    }
}

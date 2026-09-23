package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLFillLayerManager extends ViewGroupManager<RCTMGLFillLayer> {
    public static final String REACT_CLASS = "RCTMGLFillLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLFillLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLFillLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLFillLayer rCTMGLFillLayer, String str) {
        rCTMGLFillLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLFillLayer rCTMGLFillLayer, String str) {
        rCTMGLFillLayer.setSourceID(str);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLFillLayer rCTMGLFillLayer, String str) {
        rCTMGLFillLayer.setSourceLayerID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLFillLayer rCTMGLFillLayer, String str) {
        rCTMGLFillLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLFillLayer rCTMGLFillLayer, String str) {
        rCTMGLFillLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLFillLayer rCTMGLFillLayer, int i) {
        rCTMGLFillLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLFillLayer rCTMGLFillLayer, double d) {
        rCTMGLFillLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLFillLayer rCTMGLFillLayer, double d) {
        rCTMGLFillLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLFillLayer rCTMGLFillLayer, ReadableMap readableMap) {
        rCTMGLFillLayer.setReactStyle(readableMap);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLFillLayer rCTMGLFillLayer, ReadableArray readableArray) {
        rCTMGLFillLayer.setFilter(readableArray);
    }
}

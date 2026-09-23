package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLLineLayerManager extends ViewGroupManager<RCTMGLLineLayer> {
    public static final String REACT_CLASS = "RCTMGLLineLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLLineLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLLineLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLLineLayer rCTMGLLineLayer, String str) {
        rCTMGLLineLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLLineLayer rCTMGLLineLayer, String str) {
        rCTMGLLineLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLLineLayer rCTMGLLineLayer, String str) {
        rCTMGLLineLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLLineLayer rCTMGLLineLayer, String str) {
        rCTMGLLineLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLLineLayer rCTMGLLineLayer, int i) {
        rCTMGLLineLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLLineLayer rCTMGLLineLayer, double d) {
        rCTMGLLineLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLLineLayer rCTMGLLineLayer, double d) {
        rCTMGLLineLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLLineLayer rCTMGLLineLayer, ReadableMap readableMap) {
        rCTMGLLineLayer.setReactStyle(readableMap);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLLineLayer rCTMGLLineLayer, String str) {
        rCTMGLLineLayer.setSourceLayerID(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLLineLayer rCTMGLLineLayer, ReadableArray readableArray) {
        rCTMGLLineLayer.setFilter(readableArray);
    }
}

package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLHeatmapLayerManager extends ViewGroupManager<RCTMGLHeatmapLayer> {
    public static final String REACT_CLASS = "RCTMGLHeatmapLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLHeatmapLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLHeatmapLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, String str) {
        rCTMGLHeatmapLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, String str) {
        rCTMGLHeatmapLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, String str) {
        rCTMGLHeatmapLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, String str) {
        rCTMGLHeatmapLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, int i) {
        rCTMGLHeatmapLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, double d) {
        rCTMGLHeatmapLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, double d) {
        rCTMGLHeatmapLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, ReadableMap readableMap) {
        rCTMGLHeatmapLayer.setReactStyle(readableMap);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, String str) {
        rCTMGLHeatmapLayer.setSourceLayerID(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLHeatmapLayer rCTMGLHeatmapLayer, ReadableArray readableArray) {
        rCTMGLHeatmapLayer.setFilter(readableArray);
    }
}

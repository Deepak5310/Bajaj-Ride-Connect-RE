package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLFillExtrusionLayerManager extends ViewGroupManager<RCTMGLFillExtrusionLayer> {
    public static final String REACT_CLASS = "RCTMGLFillExtrusionLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLFillExtrusionLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLFillExtrusionLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, String str) {
        rCTMGLFillExtrusionLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, String str) {
        rCTMGLFillExtrusionLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, String str) {
        rCTMGLFillExtrusionLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, String str) {
        rCTMGLFillExtrusionLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, int i) {
        rCTMGLFillExtrusionLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, double d) {
        rCTMGLFillExtrusionLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, double d) {
        rCTMGLFillExtrusionLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, ReadableMap readableMap) {
        rCTMGLFillExtrusionLayer.setReactStyle(readableMap);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, String str) {
        rCTMGLFillExtrusionLayer.setSourceLayerID(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLFillExtrusionLayer rCTMGLFillExtrusionLayer, ReadableArray readableArray) {
        rCTMGLFillExtrusionLayer.setFilter(readableArray);
    }
}

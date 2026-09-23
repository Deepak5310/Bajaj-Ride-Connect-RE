package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLSymbolLayerManager extends ViewGroupManager<RCTMGLSymbolLayer> {
    public static final String REACT_CLASS = "RCTMGLSymbolLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLSymbolLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLSymbolLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLSymbolLayer rCTMGLSymbolLayer, String str) {
        rCTMGLSymbolLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLSymbolLayer rCTMGLSymbolLayer, String str) {
        rCTMGLSymbolLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLSymbolLayer rCTMGLSymbolLayer, String str) {
        rCTMGLSymbolLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLSymbolLayer rCTMGLSymbolLayer, String str) {
        rCTMGLSymbolLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLSymbolLayer rCTMGLSymbolLayer, int i) {
        rCTMGLSymbolLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLSymbolLayer rCTMGLSymbolLayer, double d) {
        rCTMGLSymbolLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLSymbolLayer rCTMGLSymbolLayer, double d) {
        rCTMGLSymbolLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLSymbolLayer rCTMGLSymbolLayer, ReadableMap readableMap) {
        rCTMGLSymbolLayer.setReactStyle(readableMap);
    }

    @ReactProp(name = "sourceLayerID")
    public void setSourceLayerId(RCTMGLSymbolLayer rCTMGLSymbolLayer, String str) {
        rCTMGLSymbolLayer.setSourceLayerID(str);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    @ReactProp(name = "filter")
    public void setFilter(RCTMGLSymbolLayer rCTMGLSymbolLayer, ReadableArray readableArray) {
        rCTMGLSymbolLayer.setFilter(readableArray);
    }
}

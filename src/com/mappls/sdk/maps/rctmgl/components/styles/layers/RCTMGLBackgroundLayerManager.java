package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLBackgroundLayerManager extends ViewGroupManager<RCTMGLBackgroundLayer> {
    public static final String REACT_CLASS = "RCTMGLBackgroundLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLBackgroundLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLBackgroundLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, String str) {
        rCTMGLBackgroundLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, String str) {
        rCTMGLBackgroundLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, String str) {
        rCTMGLBackgroundLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, String str) {
        rCTMGLBackgroundLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, int i) {
        rCTMGLBackgroundLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, double d) {
        rCTMGLBackgroundLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, double d) {
        rCTMGLBackgroundLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLBackgroundLayer rCTMGLBackgroundLayer, ReadableMap readableMap) {
        rCTMGLBackgroundLayer.setReactStyle(readableMap);
    }
}

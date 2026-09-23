package com.mappls.sdk.maps.rctmgl.components.styles.layers;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLRasterLayerManager extends ViewGroupManager<RCTMGLRasterLayer> {
    public static final String REACT_CLASS = "RCTMGLRasterLayer";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLRasterLayer createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLRasterLayer(themedReactContext);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLRasterLayer rCTMGLRasterLayer, String str) {
        rCTMGLRasterLayer.setID(str);
    }

    @ReactProp(name = "sourceID")
    public void setSourceID(RCTMGLRasterLayer rCTMGLRasterLayer, String str) {
        rCTMGLRasterLayer.setSourceID(str);
    }

    @ReactProp(name = "aboveLayerID")
    public void setAboveLayerID(RCTMGLRasterLayer rCTMGLRasterLayer, String str) {
        rCTMGLRasterLayer.setAboveLayerID(str);
    }

    @ReactProp(name = "belowLayerID")
    public void setBelowLayerID(RCTMGLRasterLayer rCTMGLRasterLayer, String str) {
        rCTMGLRasterLayer.setBelowLayerID(str);
    }

    @ReactProp(name = "layerIndex")
    public void setLayerIndex(RCTMGLRasterLayer rCTMGLRasterLayer, int i) {
        rCTMGLRasterLayer.setLayerIndex(i);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLRasterLayer rCTMGLRasterLayer, double d) {
        rCTMGLRasterLayer.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLRasterLayer rCTMGLRasterLayer, double d) {
        rCTMGLRasterLayer.setMaxZoomLevel(d);
    }

    @ReactProp(name = "reactStyle")
    public void setReactStyle(RCTMGLRasterLayer rCTMGLRasterLayer, ReadableMap readableMap) {
        rCTMGLRasterLayer.setReactStyle(readableMap);
    }
}

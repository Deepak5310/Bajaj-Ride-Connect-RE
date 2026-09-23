package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.internal.ImagesContract;
import com.mappls.sdk.maps.geometry.LatLngQuad;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLImageSourceManager extends ViewGroupManager<RCTMGLImageSource> {
    public static final String REACT_CLASS = "RCTMGLImageSource";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLImageSource";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLImageSource createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLImageSource(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(RCTMGLImageSource rCTMGLImageSource, int i) {
        return rCTMGLImageSource.getLayerAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(RCTMGLImageSource rCTMGLImageSource) {
        return rCTMGLImageSource.getLayerCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(RCTMGLImageSource rCTMGLImageSource, View view, int i) {
        rCTMGLImageSource.addLayer(view, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(RCTMGLImageSource rCTMGLImageSource, int i) {
        rCTMGLImageSource.removeLayer(i);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLImageSource rCTMGLImageSource, String str) {
        rCTMGLImageSource.setID(str);
    }

    @ReactProp(name = ImagesContract.URL)
    public void setUrl(RCTMGLImageSource rCTMGLImageSource, String str) {
        rCTMGLImageSource.setURL(str);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinates(RCTMGLImageSource rCTMGLImageSource, ReadableArray readableArray) {
        LatLngQuad latLngQuad = GeoJSONUtils.toLatLngQuad(readableArray);
        if (latLngQuad == null) {
            return;
        }
        rCTMGLImageSource.setCoordinates(latLngQuad);
    }
}

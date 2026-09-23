package com.mappls.sdk.maps.rctmgl.components.styles.light;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyle;
import com.mappls.sdk.maps.rctmgl.components.styles.RCTMGLStyleFactory;
import com.mappls.sdk.maps.style.light.Light;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLLight extends AbstractMapFeature {
    private MapplsMap mMap;
    private ReadableMap mReactStyle;

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
    }

    public RCTMGLLight(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(RCTMGLMapView rCTMGLMapView) {
        this.mMap = rCTMGLMapView.getMapplsMap();
        setLight();
    }

    public void setReactStyle(ReadableMap readableMap) {
        this.mReactStyle = readableMap;
        setLight();
    }

    private void setLight(Light light) {
        RCTMGLStyleFactory.setLightLayerStyle(light, new RCTMGLStyle(getContext(), this.mReactStyle, this.mMap));
    }

    private void setLight() {
        Style style = getStyle();
        if (style != null) {
            setLight(style.getLight());
        }
    }

    private Style getStyle() {
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null) {
            return null;
        }
        return mapplsMap.getStyle();
    }
}

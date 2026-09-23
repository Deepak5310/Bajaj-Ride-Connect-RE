package com.mappls.sdk.maps.rctmgl.components.camera;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLCameraManager extends AbstractEventEmitter<RCTMGLCamera> {
    public static final String REACT_CLASS = "RCTMGLCamera";
    private ReactApplicationContext mContext;

    public RCTMGLCameraManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return new HashMap();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLCamera createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLCamera(themedReactContext, this);
    }

    @ReactProp(name = "stop")
    public void setStop(RCTMGLCamera rCTMGLCamera, ReadableMap readableMap) {
        if (readableMap != null) {
            rCTMGLCamera.setStop(CameraStop.fromReadableMap(this.mContext, readableMap, null));
        }
    }

    @ReactProp(name = "defaultStop")
    public void setDefaultStop(RCTMGLCamera rCTMGLCamera, ReadableMap readableMap) {
        if (readableMap != null) {
            rCTMGLCamera.setDefaultStop(CameraStop.fromReadableMap(this.mContext, readableMap, null));
        }
    }

    @ReactProp(name = "maxBounds")
    public void setMaxBounds(RCTMGLCamera rCTMGLCamera, String str) {
        if (str != null) {
            rCTMGLCamera.setMaxBounds(GeoJSONUtils.toLatLngBounds(FeatureCollection.fromJson(str)));
        }
    }

    @ReactProp(name = "userTrackingMode")
    public void setUserTrackingMode(RCTMGLCamera rCTMGLCamera, int i) {
        rCTMGLCamera.setUserTrackingMode(i);
        throw new AssertionError("Unused code");
    }

    @ReactProp(name = "followZoomLevel")
    public void setZoomLevel(RCTMGLCamera rCTMGLCamera, double d) {
        rCTMGLCamera.setZoomLevel(d);
    }

    @ReactProp(name = "followUserLocation")
    public void setFollowUserLocation(RCTMGLCamera rCTMGLCamera, boolean z) {
        rCTMGLCamera.setFollowUserLocation(z);
    }

    @ReactProp(name = "followUserMode")
    public void setFollowUserMode(RCTMGLCamera rCTMGLCamera, String str) {
        rCTMGLCamera.setFollowUserMode(str);
    }

    @ReactProp(name = "minZoomLevel")
    public void setMinZoomLevel(RCTMGLCamera rCTMGLCamera, double d) {
        rCTMGLCamera.setMinZoomLevel(d);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLCamera rCTMGLCamera, double d) {
        rCTMGLCamera.setMaxZoomLevel(d);
    }

    @ReactProp(name = "followPitch")
    public void setFollowPitch(RCTMGLCamera rCTMGLCamera, double d) {
        rCTMGLCamera.setFollowPitch(d);
    }
}

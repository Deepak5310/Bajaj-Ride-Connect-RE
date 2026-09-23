package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.internal.ImagesContract;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.utils.ExpressionParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLShapeSourceManager extends AbstractEventEmitter<RCTMGLShapeSource> {
    public static final String LOG_TAG = "RCTMGLShapeSourceManager";
    public static final int METHOD_FEATURES = 103;
    public static final int METHOD_GET_CLUSTER_CHILDREN = 106;
    public static final int METHOD_GET_CLUSTER_CHILDREN_BY_ID = 109;
    public static final int METHOD_GET_CLUSTER_EXPANSION_ZOOM = 104;
    public static final int METHOD_GET_CLUSTER_EXPANSION_ZOOM_BY_ID = 107;
    public static final int METHOD_GET_CLUSTER_LEAVES = 105;
    public static final int METHOD_GET_CLUSTER_LEAVES_BY_ID = 108;
    public static final String REACT_CLASS = "RCTMGLShapeSource";
    private ReactApplicationContext mContext;

    public RCTMGLShapeSourceManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLShapeSource createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLShapeSource(themedReactContext, this);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        return rCTMGLShapeSource.getLayerAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(RCTMGLShapeSource rCTMGLShapeSource) {
        return rCTMGLShapeSource.getLayerCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(RCTMGLShapeSource rCTMGLShapeSource, View view, int i) {
        rCTMGLShapeSource.addLayer(view, getChildCount(rCTMGLShapeSource));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.removeLayer(i);
    }

    @ReactProp(name = "id")
    public void setId(RCTMGLShapeSource rCTMGLShapeSource, String str) {
        rCTMGLShapeSource.setID(str);
    }

    @ReactProp(name = ImagesContract.URL)
    public void setURL(RCTMGLShapeSource rCTMGLShapeSource, String str) {
        try {
            rCTMGLShapeSource.setURL(new URL(str));
        } catch (MalformedURLException e) {
            Log.w(LOG_TAG, e.getLocalizedMessage());
        }
    }

    @ReactProp(name = "shape")
    public void setGeometry(RCTMGLShapeSource rCTMGLShapeSource, String str) {
        rCTMGLShapeSource.setShape(str);
    }

    @ReactProp(name = "cluster")
    public void setCluster(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.setCluster(i == 1);
    }

    @ReactProp(name = "clusterRadius")
    public void setClusterRadius(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.setClusterRadius(i);
    }

    @ReactProp(name = "clusterMaxZoomLevel")
    public void setClusterMaxZoomLevel(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.setClusterMaxZoom(i);
    }

    @ReactProp(name = "maxZoomLevel")
    public void setMaxZoomLevel(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.setMaxZoom(i);
    }

    @ReactProp(name = "buffer")
    public void setBuffer(RCTMGLShapeSource rCTMGLShapeSource, int i) {
        rCTMGLShapeSource.setBuffer(i);
    }

    @ReactProp(name = "tolerance")
    public void setTolerance(RCTMGLShapeSource rCTMGLShapeSource, double d) {
        rCTMGLShapeSource.setTolerance(d);
    }

    @ReactProp(name = "lineMetrics")
    public void setLineMetrics(RCTMGLShapeSource rCTMGLShapeSource, boolean z) {
        rCTMGLShapeSource.setLineMetrics(z);
    }

    @ReactProp(name = "hasPressListener")
    public void setHasPressListener(RCTMGLShapeSource rCTMGLShapeSource, boolean z) {
        rCTMGLShapeSource.setHasPressListener(z);
    }

    @ReactProp(name = "hitbox")
    public void setHitbox(RCTMGLShapeSource rCTMGLShapeSource, ReadableMap readableMap) {
        rCTMGLShapeSource.setHitbox(readableMap);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().put(EventKeys.SHAPE_SOURCE_LAYER_CLICK, "onMapboxShapeSourcePress").put(EventKeys.MAP_ANDROID_CALLBACK, "onAndroidCallback").build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("features", 103).put("getClusterExpansionZoom", 104).put("getClusterLeaves", 105).put("getClusterChildren", Integer.valueOf(METHOD_GET_CLUSTER_CHILDREN)).put("getClusterExpansionZoomById", 107).put("getClusterLeavesById", 108).put("getClusterChildrenById", 109).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(RCTMGLShapeSource rCTMGLShapeSource, int i, ReadableArray readableArray) {
        switch (i) {
            case 103:
                rCTMGLShapeSource.querySourceFeatures(readableArray.getString(0), ExpressionParser.from(readableArray.getArray(1)));
                break;
            case 104:
                rCTMGLShapeSource.getClusterExpansionZoom(readableArray.getString(0), readableArray.getString(1));
                break;
            case 105:
                rCTMGLShapeSource.getClusterLeaves(readableArray.getString(0), readableArray.getString(1), readableArray.getInt(2), readableArray.getInt(3));
                break;
            case METHOD_GET_CLUSTER_CHILDREN /* 106 */:
                rCTMGLShapeSource.getClusterChildren(readableArray.getString(0), readableArray.getString(1));
                break;
            case 107:
                rCTMGLShapeSource.getClusterExpansionZoomById(readableArray.getString(0), readableArray.getInt(1));
                break;
            case 108:
                rCTMGLShapeSource.getClusterLeavesById(readableArray.getString(0), readableArray.getInt(1), readableArray.getInt(2), readableArray.getInt(3));
                break;
            case 109:
                rCTMGLShapeSource.getClusterChildrenById(readableArray.getString(0), readableArray.getInt(1));
                break;
        }
    }
}

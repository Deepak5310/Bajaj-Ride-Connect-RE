package com.mappls.sdk.maps.rctmgl.components.mapview;

import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter;
import com.mappls.sdk.maps.rctmgl.events.constants.EventKeys;
import com.mappls.sdk.maps.rctmgl.utils.ConvertUtils;
import com.mappls.sdk.maps.rctmgl.utils.ExpressionParser;
import com.mappls.sdk.maps.rctmgl.utils.GeoJSONUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLMapViewManager extends AbstractEventEmitter<RCTMGLMapView> {
    public static final String LOG_TAG = "RCTMGLMapViewManager";
    public static final int METHOD_ENABLE_TRAFFIC = 13;
    public static final int METHOD_ENABLE_TRAFFIC_CLOSURE = 14;
    public static final int METHOD_ENABLE_TRAFFIC_FREE_FLOW = 15;
    public static final int METHOD_ENABLE_TRAFFIC_NON_FREE_FLOW = 16;
    public static final int METHOD_ENABLE_TRAFFIC_STOP_ICON = 17;
    public static final int METHOD_GET_CENTER = 9;
    public static final int METHOD_GET_COORDINATE_FROM_VIEW = 6;
    public static final int METHOD_GET_POINT_IN_VIEW = 5;
    public static final int METHOD_GET_ZOOM = 8;
    public static final int METHOD_QUERY_FEATURES_POINT = 2;
    public static final int METHOD_QUERY_FEATURES_RECT = 3;
    public static final int METHOD_SET_HANDLED_MAP_EVENTS = 10;
    public static final int METHOD_SET_SOURCE_VISIBILITY = 12;
    public static final int METHOD_SHOW_ATTRIBUTION = 11;
    public static final int METHOD_TAKE_SNAP = 7;
    public static final int METHOD_VISIBLE_BOUNDS = 4;
    public static final String REACT_CLASS = "RCTMGLMapView";
    private Map<Integer, RCTMGLMapView> mViews;

    @ReactProp(name = "styleURL")
    public void setStyleURL(RCTMGLMapView rCTMGLMapView, String str) {
    }

    public RCTMGLMapViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mViews = new HashMap();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLMapView";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new MapShadowNode(this);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return MapShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(RCTMGLMapView rCTMGLMapView) {
        super.onAfterUpdateTransaction(rCTMGLMapView);
        if (rCTMGLMapView.getMapplsMap() == null) {
            this.mViews.put(Integer.valueOf(rCTMGLMapView.getId()), rCTMGLMapView);
            rCTMGLMapView.init();
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(RCTMGLMapView rCTMGLMapView, View view, int i) {
        rCTMGLMapView.addFeature(view, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(RCTMGLMapView rCTMGLMapView) {
        return rCTMGLMapView.getFeatureCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(RCTMGLMapView rCTMGLMapView, int i) {
        return rCTMGLMapView.getFeatureAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(RCTMGLMapView rCTMGLMapView, int i) {
        rCTMGLMapView.removeFeature(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public RCTMGLMapView createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTMGLMapView(themedReactContext, this, null);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(RCTMGLMapView rCTMGLMapView) {
        int id = rCTMGLMapView.getId();
        if (this.mViews.containsKey(Integer.valueOf(id))) {
            this.mViews.remove(Integer.valueOf(id));
        }
        super.onDropViewInstance(rCTMGLMapView);
    }

    public RCTMGLMapView getByReactTag(int i) {
        return this.mViews.get(Integer.valueOf(i));
    }

    @ReactProp(name = "mapplsStyle")
    public void setMapplsStyle(RCTMGLMapView rCTMGLMapView, String str) {
        rCTMGLMapView.setReactMapplsStyle(str);
    }

    @ReactProp(name = "preferredFramesPerSecond")
    public void setPreferredFramesPerSecond(RCTMGLMapView rCTMGLMapView, int i) {
        rCTMGLMapView.setReactPreferredFramesPerSecond(Integer.valueOf(i));
    }

    @ReactProp(name = "localizeLabels")
    public void setLocalizeLabels(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setLocalizeLabels(z);
    }

    @ReactProp(name = "zoomEnabled")
    public void setZoomEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactZoomEnabled(z);
    }

    @ReactProp(name = "scrollEnabled")
    public void setScrollEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactScrollEnabled(z);
    }

    @ReactProp(name = "pitchEnabled")
    public void setPitchEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactPitchEnabled(z);
    }

    @ReactProp(name = "rotateEnabled")
    public void setRotateEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactRotateEnabled(z);
    }

    @ReactProp(name = "anchorRotateOrZoomGesturesToCenter")
    public void setAnchorRotateOrZoomGesturesToCenter(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactAnchorRotateOrZoomGesturesToCenter(z);
    }

    @ReactProp(name = "attributionEnabled")
    public void setAttributionEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactAttributionEnabled(z);
    }

    @ReactProp(name = PlaceTypes.FLOOR)
    public void setFloor(RCTMGLMapView rCTMGLMapView, Integer num) {
        rCTMGLMapView.setReactFloor(num.intValue());
    }

    @ReactProp(name = "layerControlEnabled")
    public void setLayerControlEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactLayerControlEnabled(z);
    }

    @ReactProp(name = "logoClickEnabled")
    public void setLogoClickEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactLogoClickEnabled(z);
    }

    @ReactProp(name = "attributionPosition")
    public void setAttributionPosition(RCTMGLMapView rCTMGLMapView, @Nullable ReadableMap readableMap) {
        rCTMGLMapView.setReactAttributionPosition(readableMap);
    }

    @ReactProp(name = "logoEnabled")
    public void setLogoEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactLogoEnabled(z);
    }

    @ReactProp(name = "eventPosition")
    public void setEventPosition(RCTMGLMapView rCTMGLMapView, @Nullable ReadableMap readableMap) {
        rCTMGLMapView.setReactEventPosition(readableMap);
    }

    @ReactProp(name = "layerControlPosition")
    public void setLayerControlPosition(RCTMGLMapView rCTMGLMapView, @Nullable ReadableMap readableMap) {
        rCTMGLMapView.setReactLayerControlPosition(readableMap);
    }

    @ReactProp(name = "enableGeoAnalyticsInfoWindow")
    public void setEnableInfoWindow(RCTMGLMapView rCTMGLMapView, @Nullable Boolean bool) {
        rCTMGLMapView.setEnableInfoWindow(bool);
    }

    @ReactProp(name = "logoPosition")
    public void setLogoPosition(RCTMGLMapView rCTMGLMapView, ReadableMap readableMap) {
        rCTMGLMapView.setReactLogoPosition(readableMap);
    }

    @ReactProp(name = "compassEnabled")
    public void setCompassEnabled(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactCompassEnabled(z);
    }

    @ReactProp(name = "compassViewMargins")
    public void setCompassViewMargins(RCTMGLMapView rCTMGLMapView, ReadableMap readableMap) {
        rCTMGLMapView.setReactCompassViewMargins(readableMap);
    }

    @ReactProp(name = "compassViewPosition")
    public void setCompassViewPosition(RCTMGLMapView rCTMGLMapView, int i) {
        rCTMGLMapView.setReactCompassViewPosition(i);
    }

    @ReactProp(name = "contentInset")
    public void setContentInset(RCTMGLMapView rCTMGLMapView, ReadableArray readableArray) {
        rCTMGLMapView.setReactContentInset(readableArray);
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(RCTMGLMapView rCTMGLMapView, @Nullable Integer num) {
        rCTMGLMapView.setTintColor(num);
    }

    @ReactProp(name = "enableTraffic")
    public void setEnableTraffic(RCTMGLMapView rCTMGLMapView, boolean z) {
        rCTMGLMapView.setReactEnableTraffic(z);
    }

    @ReactProp(name = "enableTrafficClosure")
    public void setEnableTrafficClosure(RCTMGLMapView rCTMGLMapView, Boolean bool) {
        if (bool != null) {
            rCTMGLMapView.setReactEnableTrafficClosure(bool.booleanValue());
        }
    }

    @ReactProp(name = "enableTrafficFreeFlow")
    public void setEnableTrafficFreeFlow(RCTMGLMapView rCTMGLMapView, Boolean bool) {
        if (bool != null) {
            rCTMGLMapView.setReactEnableTrafficFreeFlow(bool.booleanValue());
        }
    }

    @ReactProp(name = "enableTrafficNonFreeFlow")
    public void setEnableTrafficNonFreeFlow(RCTMGLMapView rCTMGLMapView, Boolean bool) {
        if (bool != null) {
            rCTMGLMapView.setReactEnableTrafficNonFreeFlow(bool.booleanValue());
        }
    }

    @ReactProp(name = "enableTrafficStopIcon")
    public void setEnableTrafficStopIcon(RCTMGLMapView rCTMGLMapView, Boolean bool) {
        if (bool != null) {
            rCTMGLMapView.setReactTrafficStopIcon(bool.booleanValue());
        }
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractEventEmitter
    public Map<String, String> customEvents() {
        return MapBuilder.builder().put(EventKeys.MAP_CLICK, "onPress").put(EventKeys.MAP_LONG_CLICK, "onLongPress").put(EventKeys.MAP_ERROR, "onMapError").put(EventKeys.MAP_STYLE_LOADED, "onDidLoadedMapplsMapsStyles").put(EventKeys.MAP_REINIT, "onMapReinit").put(EventKeys.MAP_PLACE_CLICK, "onPlaceClick").put(EventKeys.MAP_ONCHANGE, "onMapChange").put(EventKeys.MAP_ON_LOCATION_CHANGE, "onLocationChange").put(EventKeys.MAP_USER_TRACKING_MODE_CHANGE, "onUserTrackingModeChange").put(EventKeys.MAP_ANDROID_CALLBACK, "onAndroidCallback").put(EventKeys.SHOW_INDOOR_CONTROL, "onShowIndoorControl").put(EventKeys.HIDE_INDOOR_CONTROL, "onHideIndoorControl").put(EventKeys.GEO_ANALYTICS_LAYER_PRESS, "onGeoAnalyticsSelectedFeatures").build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("queryRenderedFeaturesAtPoint", 2).put("queryRenderedFeaturesInRect", 3).put("getVisibleBounds", 4).put("getPointInView", 5).put("getCoordinateFromView", 6).put("takeSnap", 7).put("getZoom", 8).put("getCenter", 9).put("setHandledMapChangedEvents", 10).put("showAttribution", 11).put("setSourceVisibility", 12).put("getEnableTraffic", 13).put("getEnableTrafficClosure", 14).put("getEnableTrafficFreeFlow", 15).put("getEnableTrafficNonFreeFlow", 16).put("getEnableTrafficStopIcon", 17).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(RCTMGLMapView rCTMGLMapView, int i, @Nullable ReadableArray readableArray) {
        if (rCTMGLMapView.getMapplsMap() == null) {
            rCTMGLMapView.enqueuePreRenderMapMethod(Integer.valueOf(i), readableArray);
        }
        switch (i) {
            case 2:
                rCTMGLMapView.queryRenderedFeaturesAtPoint(readableArray.getString(0), ConvertUtils.toPointF(readableArray.getArray(1)), ExpressionParser.from(readableArray.getArray(2)), ConvertUtils.toStringList(readableArray.getArray(3)));
                break;
            case 3:
                rCTMGLMapView.queryRenderedFeaturesInRect(readableArray.getString(0), ConvertUtils.toRectF(readableArray.getArray(1)), ExpressionParser.from(readableArray.getArray(2)), ConvertUtils.toStringList(readableArray.getArray(3)));
                break;
            case 4:
                rCTMGLMapView.getVisibleBounds(readableArray.getString(0));
                break;
            case 5:
                rCTMGLMapView.getPointInView(readableArray.getString(0), GeoJSONUtils.toLatLng(readableArray.getArray(1)));
                break;
            case 6:
                rCTMGLMapView.getCoordinateFromView(readableArray.getString(0), ConvertUtils.toPointF(readableArray.getArray(1)));
                break;
            case 7:
                rCTMGLMapView.takeSnap(readableArray.getString(0), readableArray.getBoolean(1));
                break;
            case 8:
                rCTMGLMapView.getZoom(readableArray.getString(0));
                break;
            case 9:
                rCTMGLMapView.getCenter(readableArray.getString(0));
                break;
            case 10:
                if (readableArray != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i2 = 1; i2 < readableArray.size(); i2++) {
                        arrayList.add(readableArray.getString(i2));
                    }
                    rCTMGLMapView.setHandledMapChangedEvents(arrayList);
                }
                break;
            case 11:
                rCTMGLMapView.showAttribution();
                break;
            case 12:
                rCTMGLMapView.setSourceVisibility(readableArray.getBoolean(1), readableArray.getString(2), readableArray.getString(3));
            case 13:
                rCTMGLMapView.getEnableTraffic(readableArray.getString(0));
            case 14:
                rCTMGLMapView.getEnableTrafficClosure(readableArray.getString(0));
            case 15:
                rCTMGLMapView.getEnableTrafficFreeFlow(readableArray.getString(0));
            case 16:
                rCTMGLMapView.getEnableTrafficNonFreeFlow(readableArray.getString(0));
            case 17:
                rCTMGLMapView.getEnableTrafficStopIcon(readableArray.getString(0));
                break;
        }
    }

    private static final class MapShadowNode extends LayoutShadowNode {
        private RCTMGLMapViewManager mViewManager;

        public MapShadowNode(RCTMGLMapViewManager rCTMGLMapViewManager) {
            this.mViewManager = rCTMGLMapViewManager;
        }

        @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
        public void dispose() {
            super.dispose();
            diposeNativeMapView();
        }

        private void diposeNativeMapView() {
            final RCTMGLMapView byReactTag = this.mViewManager.getByReactTag(getReactTag());
            if (byReactTag != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapViewManager.MapShadowNode.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            byReactTag.dispose();
                        } catch (Exception e) {
                            Log.e(RCTMGLMapViewManager.LOG_TAG, " disposeNativeMapView() exception destroying map view", e);
                        }
                    }
                });
            }
        }
    }
}

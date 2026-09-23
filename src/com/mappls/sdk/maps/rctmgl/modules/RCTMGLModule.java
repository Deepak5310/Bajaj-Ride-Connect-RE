package com.mappls.sdk.maps.rctmgl.modules;

import android.os.Handler;
import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.google.common.net.HttpHeaders;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.MapplsMapConfiguration;
import com.mappls.sdk.maps.module.http.HttpRequestUtil;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource;
import com.mappls.sdk.maps.rctmgl.events.constants.EventTypes;
import com.mappls.sdk.maps.rctmgl.http.CustomHeadersInterceptor;
import com.mappls.sdk.maps.style.layers.Property;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.utils.DigipinUtility;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLModule")
public class RCTMGLModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RCTMGLModule";
    private static boolean customHeaderInterceptorAdded = false;
    private ReactApplicationContext mReactContext;
    private Handler mUiThreadHandler;

    public RCTMGLModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("MapClick", EventTypes.MAP_CLICK);
        map.put("MapLongClick", EventTypes.MAP_LONG_CLICK);
        map.put("RegionWillChange", EventTypes.REGION_WILL_CHANGE);
        map.put("RegionIsChanging", EventTypes.REGION_IS_CHANGING);
        map.put("RegionDidChange", EventTypes.REGION_DID_CHANGE);
        map.put("UserLocationUpdated", EventTypes.USER_LOCATION_UPDATED);
        map.put("WillStartLoadingMap", EventTypes.WILL_START_LOADING_MAP);
        map.put("DidFinishLoadingMap", EventTypes.DID_FINISH_LOADING_MAP);
        map.put("DidFailLoadingMap", EventTypes.DID_FAIL_LOADING_MAP);
        map.put("WillStartRenderingFrame", EventTypes.WILL_START_RENDERING_FRAME);
        map.put("DidFinishRenderingFrame", EventTypes.DID_FINISH_RENDERING_FRAME);
        map.put("DidFinishRenderingFrameFully", EventTypes.DID_FINISH_RENDERING_FRAME_FULLY);
        map.put("WillStartRenderingMap", EventTypes.WILL_START_RENDERING_MAP);
        map.put("DidFinishRenderingMap", EventTypes.DID_FINISH_RENDERING_MAP);
        map.put("DidFinishRenderingMapFully", EventTypes.DID_FINISH_RENDERING_MAP_FULLY);
        map.put("DidFinishLoadingStyle", EventTypes.DID_FINISH_LOADING_STYLE);
        HashMap map2 = new HashMap();
        map2.put("None", 0);
        map2.put("Follow", 1);
        map2.put("FollowWithCourse", 2);
        map2.put("FollowWithHeading", 3);
        HashMap map3 = new HashMap();
        map3.put("Center", 0);
        map3.put("Top", 1);
        map3.put("Bottom", 2);
        HashMap map4 = new HashMap();
        map4.put("Flight", 1);
        map4.put("Ease", 2);
        map4.put("Linear", 3);
        map4.put("None", 4);
        HashMap map5 = new HashMap();
        map5.put("DefaultSourceID", RCTSource.DEFAULT_ID);
        HashMap map6 = new HashMap();
        map6.put("Exponential", 100);
        map6.put("Categorical", 102);
        map6.put("Interval", 101);
        map6.put("Identity", 103);
        HashMap map7 = new HashMap();
        map7.put("Bevel", Property.LINE_JOIN_BEVEL);
        map7.put("Round", "round");
        map7.put("Miter", Property.LINE_JOIN_MITER);
        HashMap map8 = new HashMap();
        map8.put("Butt", Property.LINE_CAP_BUTT);
        map8.put("Round", "round");
        map8.put("Square", Property.LINE_CAP_SQUARE);
        HashMap map9 = new HashMap();
        map9.put("Map", "map");
        map9.put("Viewport", "viewport");
        HashMap map10 = new HashMap();
        map10.put("Map", "map");
        map10.put("Viewport", "viewport");
        HashMap map11 = new HashMap();
        map11.put("Map", "map");
        map11.put("Viewport", "viewport");
        HashMap map12 = new HashMap();
        map12.put("Map", "map");
        map12.put("Viewport", "viewport");
        HashMap map13 = new HashMap();
        map13.put("Map", "map");
        map13.put("Viewport", "viewport");
        HashMap map14 = new HashMap();
        map14.put("Map", "map");
        map14.put("Viewport", "viewport");
        HashMap map15 = new HashMap();
        map15.put("Auto", "auto");
        map15.put("Map", "map");
        map15.put("Viewport", "viewport");
        HashMap map16 = new HashMap();
        map16.put("None", "none");
        map16.put(HttpHeaders.WIDTH, "width");
        map16.put("Height", "height");
        map16.put("Both", Property.ICON_TEXT_FIT_BOTH);
        HashMap map17 = new HashMap();
        map17.put("Center", "center");
        map17.put("Left", "left");
        map17.put("Right", "right");
        map17.put("Top", "top");
        map17.put("Bottom", "bottom");
        map17.put("TopLeft", "top-left");
        map17.put("TopRight", "top-right");
        map17.put("BottomLeft", "bottom-left");
        map17.put("BottomRight", "bottom-right");
        HashMap map18 = new HashMap();
        map18.put("Auto", "auto");
        map18.put("Map", "map");
        map18.put("Viewport", "viewport");
        HashMap map19 = new HashMap();
        map19.put("Map", "map");
        map19.put("Viewport", "viewport");
        HashMap map20 = new HashMap();
        map20.put("Line", Property.SYMBOL_PLACEMENT_LINE);
        map20.put("Point", "point");
        HashMap map21 = new HashMap();
        map21.put("Center", "center");
        map21.put("Left", "left");
        map21.put("Right", "right");
        map21.put("Top", "top");
        map21.put("Bottom", "bottom");
        map21.put("TopLeft", "top-left");
        map21.put("TopRight", "top-right");
        map21.put("BottomLeft", "bottom-left");
        map21.put("BottomRight", "bottom-right");
        HashMap map22 = new HashMap();
        map22.put("Center", "center");
        map22.put("Left", "left");
        map22.put("Right", "right");
        HashMap map23 = new HashMap();
        map23.put("Auto", "auto");
        map23.put("Map", "map");
        map23.put("Viewport", "viewport");
        HashMap map24 = new HashMap();
        map24.put("Auto", "auto");
        map24.put("Map", "map");
        map24.put("Viewport", "viewport");
        HashMap map25 = new HashMap();
        map25.put("None", "none");
        map25.put("Lowercase", Property.TEXT_TRANSFORM_LOWERCASE);
        map25.put("Uppercase", Property.TEXT_TRANSFORM_UPPERCASE);
        HashMap map26 = new HashMap();
        map26.put("Map", "map");
        map26.put("Viewport", "viewport");
        HashMap map27 = new HashMap();
        map27.put("Map", "map");
        map27.put("Viewport", "viewport");
        HashMap map28 = new HashMap();
        map28.put("Inactive", 0);
        map28.put("Active", 1);
        map28.put("Complete", 2);
        HashMap map29 = new HashMap();
        map29.put("Error", RCTMGLOfflineModule.OFFLINE_ERROR);
        map29.put("Progress", RCTMGLOfflineModule.OFFLINE_PROGRESS);
        HashMap map30 = new HashMap();
        map30.put("Update", RCTMGLLocationModule.LOCATION_UPDATE);
        return MapBuilder.builder().put("EventTypes", map).put("UserTrackingModes", map2).put("UserLocationVerticalAlignment", map3).put("CameraModes", map4).put("StyleSource", map5).put("InterpolationMode", map6).put("LineJoin", map7).put("LineCap", map8).put("LineTranslateAnchor", map9).put("CirclePitchScale", map10).put("CircleTranslateAnchor", map11).put("CirclePitchAlignment", map12).put("FillExtrusionTranslateAnchor", map13).put("FillTranslateAnchor", map14).put("IconRotationAlignment", map15).put("IconTextFit", map16).put("IconTranslateAnchor", map19).put("SymbolPlacement", map20).put("IconAnchor", map17).put("TextAnchor", map21).put("TextJustify", map22).put("IconPitchAlignment", map18).put("TextPitchAlignment", map23).put("TextRotationAlignment", map24).put("TextTransform", map25).put("TextTranslateAnchor", map26).put("LightAnchor", map27).put("OfflinePackDownloadState", map28).put("OfflineCallbackName", map29).put("LocationCallbackName", map30).build();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.1
            @Override // java.lang.Runnable
            public void run() {
                Mappls.getInstance(RCTMGLModule.this.getReactApplicationContext());
            }
        });
    }

    @ReactMethod
    public void setRestAPIKey(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.2
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setRestAPIKey(str);
            }
        });
    }

    @ReactMethod
    public void setMapSDKKey(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.3
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setMapSDKKey(str);
            }
        });
    }

    @ReactMethod
    public void setAtlasClientId(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.4
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setAtlasClientId(str);
            }
        });
    }

    @ReactMethod
    public void setAtlasClientSecret(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.5
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setAtlasClientSecret(str);
            }
        });
    }

    @ReactMethod
    public void setRegion(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.6
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setRegion(str);
            }
        });
    }

    @ReactMethod
    public void setDeveloperShowingSplash(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.7
            @Override // java.lang.Runnable
            public void run() {
                MapplsMapConfiguration.getInstance().setDeveloperShowingSplash(z);
            }
        });
    }

    @ReactMethod
    public void setEnablePromotion(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.8
            @Override // java.lang.Runnable
            public void run() {
                MapplsMapConfiguration.getInstance().setEnablePromotion(z);
            }
        });
    }

    @ReactMethod
    public void setAssociationId(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.9
            @Override // java.lang.Runnable
            public void run() {
                MapplsAccountManager.getInstance().setAssociationId(str);
            }
        });
    }

    @ReactMethod
    public void setUsingRasterStyle(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.10
            @Override // java.lang.Runnable
            public void run() {
                MapplsMapConfiguration.getInstance().setUsingRasterStyle(z);
            }
        });
    }

    @ReactMethod
    public void setAllowOtherUrls(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.11
            @Override // java.lang.Runnable
            public void run() {
                MapplsMapConfiguration.getInstance().setAllowOtherUrls(z);
            }
        });
    }

    @ReactMethod
    public void removeCustomHeader(final String str) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.12
            @Override // java.lang.Runnable
            public void run() {
                CustomHeadersInterceptor.INSTANCE.removeHeader(str);
            }
        });
    }

    @ReactMethod
    public void addCustomHeader(final String str, final String str2) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.13
            @Override // java.lang.Runnable
            public void run() {
                if (!RCTMGLModule.customHeaderInterceptorAdded) {
                    Log.i("header", "Add interceptor");
                    HttpRequestUtil.setOkHttpClient(new OkHttpClient.Builder().addInterceptor(CustomHeadersInterceptor.INSTANCE).dispatcher(RCTMGLModule.this.getDispatcher()).build());
                    RCTMGLModule.customHeaderInterceptorAdded = true;
                }
                CustomHeadersInterceptor.INSTANCE.addHeader(str, str2);
            }
        });
    }

    @ReactMethod
    public void settingClusterId(final String str, final String str2) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.14
            @Override // java.lang.Runnable
            public void run() {
                if (str2 == null) {
                    MapplsAccountManager.getInstance().setClusterId(str);
                } else {
                    MapplsAccountManager.getInstance().setClusterId(str, str2);
                }
            }
        });
    }

    @ReactMethod
    public void getClusterId(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getClusterId());
    }

    @ReactMethod
    public void setConnected(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.15
            @Override // java.lang.Runnable
            public void run() {
                Mappls.setConnected(Boolean.valueOf(z));
            }
        });
    }

    @ReactMethod
    public void setShowLastSelectedStyle(final boolean z) {
        this.mReactContext.runOnUiQueueThread(new Runnable() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLModule.16
            @Override // java.lang.Runnable
            public void run() {
                MapplsMapConfiguration.getInstance().setShowLastSelectedStyle(z);
            }
        });
    }

    @ReactMethod
    public void isShowLastSelectedStyle(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isShowLastSelectedStyle()));
    }

    @ReactMethod
    public void isUsingRasterStyle(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isUsingRasterStyle()));
    }

    @ReactMethod
    public void isAllowOtherUrls(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isAllowOtherUrls()));
    }

    @ReactMethod
    public void isDeveloperShowingSplash(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isDeveloperShowingSplash()));
    }

    @ReactMethod
    public void isEnablePromotion(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isEnablePromotion()));
    }

    @ReactMethod
    public void getAssociationId(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getAssociationId());
    }

    @ReactMethod
    public void getAtlasClientId(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getAtlasClientId());
    }

    @ReactMethod
    public void getAtlasClientSecret(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getAtlasClientSecret());
    }

    @ReactMethod
    public void getMapSDKKey(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getMapSDKKey());
    }

    @ReactMethod
    public void getRestAPIKey(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getRestAPIKey());
    }

    @ReactMethod
    public void getDeviceAlias(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getDeviceAlias());
    }

    @ReactMethod
    public void getRegion(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getRegion());
    }

    @ReactMethod
    public void getUserId(Promise promise) {
        promise.resolve(MapplsAccountManager.getInstance().getUserId());
    }

    @ReactMethod
    public void setUserId(String str) {
        MapplsAccountManager.getInstance().setUserId(str);
    }

    @ReactMethod
    public void setDisableHostnameVerifier(boolean z) {
        MapplsAccountManager.getInstance().setDisableHostnameVerifier(z);
    }

    @ReactMethod
    public void isDisableHostnameVerifier(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsAccountManager.getInstance().isDisableHostnameVerifier()));
    }

    @ReactMethod
    public void setProxy(String str, int i) {
        Mappls.setProxy(str, i);
    }

    @ReactMethod
    public void setReinitEnable(boolean z) {
        MapplsMapConfiguration.getInstance().setReinitEnable(z);
    }

    @ReactMethod
    public void isReinitEnable(Promise promise) {
        promise.resolve(Boolean.valueOf(MapplsMapConfiguration.getInstance().isMapReinitEnable()));
    }

    @ReactMethod
    public void getDigipinFromCoordinate(ReadableArray readableArray, Promise promise) {
        if (readableArray.size() == 2) {
            promise.resolve(DigipinUtility.getDigipinFromCoordinate(Point.fromLngLat(readableArray.getDouble(0), readableArray.getDouble(1))));
        } else {
            promise.reject("Invalid Coordinates", new RuntimeException("Invalid Coordinates"));
        }
    }

    @ReactMethod
    public void getCoordinateFromDigipin(String str, Promise promise) {
        Point coordinateFromDigipin = DigipinUtility.getCoordinateFromDigipin(str);
        if (coordinateFromDigipin != null) {
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.pushDouble(coordinateFromDigipin.longitude());
            writableNativeArray.pushDouble(coordinateFromDigipin.latitude());
            promise.resolve(writableNativeArray);
            return;
        }
        promise.reject("Invalid Digipin", new RuntimeException("Invalid Digipin"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Dispatcher getDispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(20);
        return dispatcher;
    }
}

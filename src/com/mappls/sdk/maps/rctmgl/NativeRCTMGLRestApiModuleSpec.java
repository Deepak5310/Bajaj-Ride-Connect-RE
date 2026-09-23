package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLRestApiModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLRestApiModule";

    @ReactMethod
    public abstract void POIAlongRoute(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void autoSuggest(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void clusterLinkedDevices(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void deleteClusterLinkedDevice(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void direction(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void directionRefresh(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void distance(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void endSession(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void eventCategoryMaster(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void feedback(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void fuelCost(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void generateOtp(String str, Promise promise);

    @ReactMethod
    public abstract void geoAnalyticsList(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void geocode(ReadableMap readableMap, Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void hateosnearby(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void nearby(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void nearbyReports(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void placeDetail(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void reverseGeocode(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void roadTrafficDetail(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void routeReportSummary(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void textSearch(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void transitPlanner(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void tripCostEstimation(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void tripOptimisation(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void weather(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void whiteList(ReadableMap readableMap, Promise promise);

    public NativeRCTMGLRestApiModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }
}

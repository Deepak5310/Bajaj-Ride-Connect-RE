package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLOfflineModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLOfflineModule";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void clearAmbientCache(Promise promise);

    @ReactMethod
    public abstract void createPack(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void deletePack(String str, Promise promise);

    @ReactMethod
    public abstract void getPackStatus(String str, Promise promise);

    @ReactMethod
    public abstract void getPacks(Promise promise);

    @ReactMethod
    public abstract void invalidateAmbientCache(Promise promise);

    @ReactMethod
    public abstract void invalidatePack(String str, Promise promise);

    @ReactMethod
    public abstract void mergeOfflineRegions(String str, Promise promise);

    @ReactMethod
    public abstract void pausePackDownload(String str, Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void resetDatabase(Promise promise);

    @ReactMethod
    public abstract void resumePackDownload(String str, Promise promise);

    @ReactMethod
    public abstract void setMaximumAmbientCacheSize(double d, Promise promise);

    @ReactMethod
    public abstract void setPackObserver(String str, Promise promise);

    @ReactMethod
    public abstract void setProgressEventThrottle(double d);

    @ReactMethod
    public abstract void setTileCountLimit(double d);

    public NativeRCTMGLOfflineModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RCTMGLOfflineModule";
    }
}

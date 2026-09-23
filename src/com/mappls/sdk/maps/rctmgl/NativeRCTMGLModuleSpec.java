package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLModule";

    @ReactMethod
    public abstract void addCustomHeader(String str, String str2);

    @ReactMethod
    public abstract void getAssociationId(Promise promise);

    @ReactMethod
    public abstract void getAtlasClientId(Promise promise);

    @ReactMethod
    public abstract void getAtlasClientSecret(Promise promise);

    @ReactMethod
    public abstract void getClusterId(Promise promise);

    @ReactMethod
    public abstract void getCoordinateFromDigipin(String str, Promise promise);

    @ReactMethod
    public abstract void getDeviceAlias(Promise promise);

    @ReactMethod
    public abstract void getDigipinFromCoordinate(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void getMapSDKKey(Promise promise);

    @ReactMethod
    public abstract void getRegion(Promise promise);

    @ReactMethod
    public abstract void getRestAPIKey(Promise promise);

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void getUserId(Promise promise);

    @ReactMethod
    public abstract void isAllowOtherUrls(Promise promise);

    @ReactMethod
    public abstract void isDeveloperShowingSplash(Promise promise);

    @ReactMethod
    public abstract void isDisableHostnameVerifier(Promise promise);

    @ReactMethod
    public abstract void isEnablePromotion(Promise promise);

    @ReactMethod
    public abstract void isReinitEnable(Promise promise);

    @ReactMethod
    public abstract void isShowLastSelectedStyle(Promise promise);

    @ReactMethod
    public abstract void isUsingRasterStyle(Promise promise);

    @ReactMethod
    public abstract void removeCustomHeader(String str);

    @ReactMethod
    public abstract void setAllowOtherUrls(boolean z);

    @ReactMethod
    public abstract void setAssociationId(String str);

    @ReactMethod
    public abstract void setAtlasClientId(String str);

    @ReactMethod
    public abstract void setAtlasClientSecret(String str);

    @ReactMethod
    public abstract void setConnected(boolean z);

    @ReactMethod
    public abstract void setDeveloperShowingSplash(boolean z);

    @ReactMethod
    public abstract void setDisableHostnameVerifier(boolean z);

    @ReactMethod
    public abstract void setEnablePromotion(boolean z);

    @ReactMethod
    public abstract void setMapSDKKey(String str);

    @ReactMethod
    public abstract void setProxy(String str, double d);

    @ReactMethod
    public abstract void setRegion(String str);

    @ReactMethod
    public abstract void setReinitEnable(boolean z);

    @ReactMethod
    public abstract void setRestAPIKey(String str);

    @ReactMethod
    public abstract void setShowLastSelectedStyle(boolean z);

    @ReactMethod
    public abstract void setUserId(String str);

    @ReactMethod
    public abstract void setUsingRasterStyle(boolean z);

    @ReactMethod
    public abstract void settingClusterId(@Nullable String str, @Nullable String str2);

    public NativeRCTMGLModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RCTMGLModule";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }
}

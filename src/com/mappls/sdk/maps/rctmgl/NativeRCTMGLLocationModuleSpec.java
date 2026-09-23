package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLLocationModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLLocationModule";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void getLastKnownLocation(Promise promise);

    @ReactMethod
    public abstract void pause();

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void setMinDisplacement(double d);

    @ReactMethod
    public abstract void start(double d);

    @ReactMethod
    public abstract void stop();

    public NativeRCTMGLLocationModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RCTMGLLocationModule";
    }
}

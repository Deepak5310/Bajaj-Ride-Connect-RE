package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLLoggingSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLLogging";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void setLogLevel(String str);

    public NativeRCTMGLLoggingSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RCTMGLLogging";
    }
}

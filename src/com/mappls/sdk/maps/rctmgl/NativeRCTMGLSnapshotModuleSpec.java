package com.mappls.sdk.maps.rctmgl;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRCTMGLSnapshotModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RCTMGLSnapshotModule";

    @ReactMethod
    public abstract void takeSnap(ReadableMap readableMap, Promise promise);

    public NativeRCTMGLSnapshotModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RCTMGLSnapshotModule";
    }
}

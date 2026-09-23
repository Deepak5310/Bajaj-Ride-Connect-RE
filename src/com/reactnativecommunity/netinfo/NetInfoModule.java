package com.reactnativecommunity.netinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes4.dex */
public class NetInfoModule extends ReactContextBaseJavaModule {
    private NetInfoModuleImpl implementation;

    @ReactMethod
    public void configure(ReadableMap readableMap) {
    }

    NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.implementation = new NetInfoModuleImpl(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NetInfoModuleImpl.NAME;
    }

    @ReactMethod
    public void getCurrentState(String str, Promise promise) {
        this.implementation.getCurrentState(str, promise);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.implementation.onCatalystInstanceDestroy();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        this.implementation.initialize();
    }

    @ReactMethod
    public void addListener(String str) {
        this.implementation.addListener(str);
    }

    @ReactMethod
    public void removeListeners(double d) {
        this.implementation.removeListeners(d);
    }
}

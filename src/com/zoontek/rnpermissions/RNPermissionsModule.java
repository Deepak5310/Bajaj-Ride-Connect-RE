package com.zoontek.rnpermissions;

import android.util.SparseArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = RNPermissionsModuleImpl.NAME)
public class RNPermissionsModule extends ReactContextBaseJavaModule implements PermissionListener {
    private final SparseArray<Callback> mCallbacks;

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCallbacks = new SparseArray<>();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RNPermissionsModuleImpl.NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return RNPermissionsModuleImpl.getConstants();
    }

    @ReactMethod
    public void openSettings(Promise promise) {
        RNPermissionsModuleImpl.openSettings(getReactApplicationContext(), promise);
    }

    @ReactMethod
    public void check(String str, Promise promise) {
        RNPermissionsModuleImpl.check(getReactApplicationContext(), str, promise);
    }

    @ReactMethod
    public void checkNotifications(Promise promise) {
        RNPermissionsModuleImpl.checkNotifications(getReactApplicationContext(), promise);
    }

    @ReactMethod
    public void checkMultiple(ReadableArray readableArray, Promise promise) {
        RNPermissionsModuleImpl.checkMultiple(getReactApplicationContext(), readableArray, promise);
    }

    @ReactMethod
    public void request(String str, Promise promise) {
        RNPermissionsModuleImpl.request(getReactApplicationContext(), this, this.mCallbacks, str, promise);
    }

    @ReactMethod
    public void requestNotifications(ReadableArray readableArray, Promise promise) {
        RNPermissionsModuleImpl.requestNotifications(getReactApplicationContext(), promise);
    }

    @ReactMethod
    public void requestMultiple(ReadableArray readableArray, Promise promise) {
        RNPermissionsModuleImpl.requestMultiple(getReactApplicationContext(), this, this.mCallbacks, readableArray, promise);
    }

    @ReactMethod
    public void shouldShowRequestRationale(String str, Promise promise) {
        RNPermissionsModuleImpl.shouldShowRequestRationale(getReactApplicationContext(), str, promise);
    }

    @ReactMethod
    public void checkLocationAccuracy(Promise promise) {
        RNPermissionsModuleImpl.checkLocationAccuracy(promise);
    }

    @ReactMethod
    public void requestLocationAccuracy(String str, Promise promise) {
        RNPermissionsModuleImpl.requestLocationAccuracy(promise);
    }

    @ReactMethod
    public void openPhotoPicker(Promise promise) {
        RNPermissionsModuleImpl.openPhotoPicker(promise);
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        return RNPermissionsModuleImpl.onRequestPermissionsResult(getReactApplicationContext(), this.mCallbacks, i, iArr);
    }
}

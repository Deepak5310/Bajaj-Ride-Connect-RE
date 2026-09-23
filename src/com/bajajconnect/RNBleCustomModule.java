package com.bajajconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.interfaces.BleConnectionCallback;
import com.bajajconnect.music.MusicCallbackImpl;
import com.bajajconnect.variables.GlobalVar;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: loaded from: classes3.dex */
public class RNBleCustomModule extends ReactContextBaseJavaModule implements BleConnectionCallback {
    public static MusicCallbackImpl callback;
    private static RNBleCustomModule sInstance;
    String MODULE_NAME;
    String TAG;
    private long lastEmitTs;
    private String lastEmittedAddress;
    private Boolean lastEmittedState;
    private final ReactApplicationContext reactContext;

    public RNBleCustomModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.MODULE_NAME = "RNBleCustomModule";
        this.TAG = "RNBleCustomModule";
        this.lastEmittedState = null;
        this.lastEmittedAddress = "";
        this.lastEmitTs = 0L;
        this.reactContext = reactApplicationContext;
        sInstance = this;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        if (sInstance == this) {
            sInstance = null;
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return this.MODULE_NAME;
    }

    @Override // com.bajajconnect.interfaces.BleConnectionCallback
    public void onStateChange(boolean z) {
        emitInfo(z);
    }

    @Override // com.bajajconnect.interfaces.BleConnectionCallback
    public void onScanning(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isScanning", z);
        sendEvent("SCANNING_EVENT", writableMapCreateMap);
    }

    @ReactMethod
    public void startBle() {
        BleFeatures.getInstance().registerBleCallback(this);
        BleFeatures.getInstance().init(this.reactContext.getApplicationContext());
        callback = new MusicCallbackImpl();
        BleFeatures.getInstance().listenMusic(this.reactContext.getApplicationContext(), callback);
    }

    @ReactMethod
    public void stopBle() {
        BleFeatures.getInstance().stop(this.reactContext.getApplicationContext());
        BleFeatures.getInstance().stopMusicListening();
    }

    @ReactMethod
    public void listenMusic() {
        callback = new MusicCallbackImpl();
        BleFeatures.getInstance().listenMusic(this.reactContext.getApplicationContext(), callback);
    }

    @ReactMethod
    public void setBleName(String str) {
        BleFeatures.getInstance().setBleDeviceName(str);
    }

    @ReactMethod
    public void setBleAddress(String str) {
        BleFeatures.getInstance().setBleDeviceAddress(str);
    }

    @ReactMethod
    public void setCallRejectMsg(String str) {
        GlobalVar.callRejectMsg = str;
    }

    public void emitInfo(boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isConnected", z);
        String str = "";
        if (z) {
            writableMapCreateMap.putString("deviceName", GlobalVar.bleDeviceName);
            writableMapCreateMap.putString("deviceAddress", GlobalVar.bleDeviceAddress != null ? GlobalVar.bleDeviceAddress : "");
            writableMapCreateMap.putString("id", GlobalVar.bleDeviceAddress != null ? GlobalVar.bleDeviceAddress : "");
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (GlobalVar.bleDeviceAddress != null) {
                str = GlobalVar.bleDeviceAddress;
            }
            Boolean bool = this.lastEmittedState;
            boolean z2 = true;
            boolean z3 = bool != null && bool.booleanValue() == z && this.lastEmittedAddress.equals(str);
            if (!z || !this.lastEmittedAddress.isEmpty() || str.isEmpty()) {
                z2 = false;
            }
            if (z3 && z && !z2 && jCurrentTimeMillis - this.lastEmitTs < 1500) {
                return;
            }
            this.lastEmittedState = Boolean.valueOf(z);
            this.lastEmittedAddress = str;
            this.lastEmitTs = jCurrentTimeMillis;
        } catch (Exception unused) {
        }
        sendEvent("INFO_EVENT", writableMapCreateMap);
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public static void emitAdapterState(Context context, boolean z) {
        RNBleCustomModule rNBleCustomModule = sInstance;
        if (rNBleCustomModule == null) {
            Log.d("BLE_ADAPTER", "emitAdapterState skipped — RNBleCustomModule not instantiated yet");
            return;
        }
        try {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean(ViewProps.ENABLED, z);
            rNBleCustomModule.sendEvent("BT_ADAPTER_STATE_EVENT", writableMapCreateMap);
            Log.i("BLE_ADAPTER", "BT_ADAPTER_STATE_EVENT emitted enabled=" + z);
        } catch (Exception e) {
            Log.w("BLE_ADAPTER", "emitAdapterState failed: " + e.getMessage());
        }
    }

    @ReactMethod
    public void disconnect() {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BleService.class);
        intent.setAction("com.bajajconnect.ble.ACTION_BLE_DISCONNECT");
        getReactApplicationContext().startService(intent);
    }

    @ReactMethod
    public void startForeground() {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BleService.class);
        intent.setAction(BleService.ACTION_START_FOREGROUND);
        if (Build.VERSION.SDK_INT >= 26) {
            getReactApplicationContext().startForegroundService(intent);
        } else {
            getReactApplicationContext().startService(intent);
        }
    }

    @ReactMethod
    public void isConnected(Callback callback2) {
        callback2.invoke(Boolean.valueOf(GlobalVar.isBlueToothConnected));
    }

    @ReactMethod
    public void connectToBle() {
        try {
            Intent intent = new Intent(getReactApplicationContext(), (Class<?>) BleService.class);
            intent.setAction("com.bajajconnect.ble.ACTION_BLE_CONNECT");
            getReactApplicationContext().startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void openNotificationSettings(Promise promise) {
        try {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intent.addFlags(268435456);
            this.reactContext.startActivity(intent);
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject("Error", e.getMessage());
        }
    }

    @ReactMethod
    public void isNotificationServiceEnabled(Promise promise) {
        String packageName = this.reactContext.getPackageName();
        String string = Settings.Secure.getString(this.reactContext.getContentResolver(), "enabled_notification_listeners");
        promise.resolve(Boolean.valueOf(string != null && string.contains(packageName)));
    }

    @ReactMethod
    public void setSmsText(String str) {
        GlobalVar.callRejectMsg = str;
    }

    @ReactMethod
    public void setDndEnabled(boolean z) {
        GlobalVar.isDndEnabled = z;
    }
}

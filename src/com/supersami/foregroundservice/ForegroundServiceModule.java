package com.supersami.foregroundservice;

import android.app.NotificationManager;
import android.content.Intent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.devsupport.StackTraceHelper;

/* JADX INFO: loaded from: classes4.dex */
public class ForegroundServiceModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public ForegroundServiceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ForegroundService";
    }

    private boolean isRunning() {
        ForegroundService foregroundService = ForegroundService.getInstance();
        return (foregroundService != null ? foregroundService.isRunning() : 0) > 0;
    }

    @ReactMethod
    public void startService(ReadableMap readableMap, Promise promise) {
        if (readableMap == null) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: Notification config is invalid");
            return;
        }
        if (!readableMap.hasKey("id")) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: id is required");
            return;
        }
        if (!readableMap.hasKey("title")) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: title is reqired");
            return;
        }
        if (!readableMap.hasKey(StackTraceHelper.MESSAGE_KEY)) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: message is required");
            return;
        }
        try {
            Intent intent = new Intent(getReactApplicationContext(), (Class<?>) ForegroundService.class);
            intent.setAction("com.supersami.foregroundservice.service_start");
            intent.putExtra("com.supersami.foregroundservice.notif_config", Arguments.toBundle(readableMap));
            if (getReactApplicationContext().startService(intent) != null) {
                promise.resolve(null);
            } else {
                promise.reject("ERROR_SERVICE_ERROR", "ForegroundService: Foreground service failed to start.");
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERROR_SERVICE_ERROR", "ForegroundService: Foreground service failed to start.");
        }
    }

    @ReactMethod
    public void updateNotification(ReadableMap readableMap, Promise promise) {
        if (readableMap == null) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: Notification config is invalid");
            return;
        }
        if (!readableMap.hasKey("id")) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: id is required");
            return;
        }
        if (!readableMap.hasKey("title")) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: title is reqired");
            return;
        }
        if (!readableMap.hasKey(StackTraceHelper.MESSAGE_KEY)) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: message is required");
            return;
        }
        try {
            Intent intent = new Intent(getReactApplicationContext(), (Class<?>) ForegroundService.class);
            intent.setAction("com.supersami.foregroundservice.service_update_notification");
            intent.putExtra("com.supersami.foregroundservice.notif_config", Arguments.toBundle(readableMap));
            if (getReactApplicationContext().startService(intent) == null) {
                promise.reject("ERROR_SERVICE_ERROR", "Update notification failed.");
            } else {
                promise.resolve(null);
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERROR_SERVICE_ERROR", "Update notification failed, service failed to start.");
        }
    }

    @ReactMethod
    public void cancelNotification(ReadableMap readableMap, Promise promise) {
        if (readableMap == null) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: Notification config is invalid");
            return;
        }
        if (!readableMap.hasKey("id")) {
            promise.reject("ERROR_INVALID_CONFIG", "ForegroundService: id is required");
            return;
        }
        try {
            ((NotificationManager) this.reactContext.getSystemService("notification")).cancel((int) readableMap.getDouble("id"));
            promise.resolve(null);
        } catch (Exception unused) {
            promise.reject("ERROR_SERVICE_ERROR", "Failed to cancel notification.");
        }
    }

    @ReactMethod
    public void stopService(Promise promise) {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) ForegroundService.class);
        intent.setAction("com.supersami.foregroundservice.service_stop");
        try {
            try {
                getReactApplicationContext().startService(intent);
            } catch (IllegalStateException unused) {
                getReactApplicationContext().stopService(intent);
            }
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject("ERROR_SERVICE_ERROR", "Service stop failed: " + e.getMessage());
        }
    }

    @ReactMethod
    public void stopServiceAll(Promise promise) {
        Intent intent = new Intent(getReactApplicationContext(), (Class<?>) ForegroundService.class);
        intent.setAction("com.supersami.foregroundservice.service_all");
        try {
            try {
                getReactApplicationContext().startService(intent);
            } catch (IllegalStateException unused) {
                getReactApplicationContext().stopService(intent);
            }
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject("ERROR_SERVICE_ERROR", "Service stop all failed: " + e.getMessage());
        }
    }

    @ReactMethod
    public void runTask(ReadableMap readableMap, Promise promise) {
        if (!readableMap.hasKey("taskName")) {
            promise.reject("ERROR_INVALID_CONFIG", "taskName is required");
            return;
        }
        if (!readableMap.hasKey("delay")) {
            promise.reject("ERROR_INVALID_CONFIG", "delay is required");
            return;
        }
        try {
            Intent intent = new Intent(getReactApplicationContext(), (Class<?>) ForegroundService.class);
            intent.setAction("com.supersami.foregroundservice.service_run_task");
            intent.putExtra("com.supersami.foregroundservice.task_config", Arguments.toBundle(readableMap));
            if (getReactApplicationContext().startService(intent) != null) {
                promise.resolve(null);
            } else {
                promise.reject("ERROR_SERVICE_ERROR", "Failed to run task: Service did not start");
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERROR_SERVICE_ERROR", "Failed to run task: Service did not start");
        }
    }

    @ReactMethod
    public void isRunning(Promise promise) {
        ForegroundService foregroundService = ForegroundService.getInstance();
        promise.resolve(Integer.valueOf(foregroundService != null ? foregroundService.isRunning() : 0));
    }
}

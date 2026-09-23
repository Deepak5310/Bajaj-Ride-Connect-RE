package com.mappls.sdk.maps.rctmgl.modules;

import android.util.Log;
import app.notifee.core.event.LogEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.log.LoggerDefinition;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RCTMGLLogging")
public class RCTMGLLogging extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "RCTMGLLogging";
    private ReactApplicationContext mReactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RCTMGLLogging(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        Logger.setVerbosity(5);
        Logger.setLoggerDefinition(new LoggerDefinition() { // from class: com.mappls.sdk.maps.rctmgl.modules.RCTMGLLogging.1
            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void v(String str, String str2) {
                Log.v(str, str2);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_VERBOSE, str, str2, null);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void v(String str, String str2, Throwable th) {
                Log.v(str, str2, th);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_VERBOSE, str, str2, th);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void d(String str, String str2) {
                Log.d(str, str2);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_DEBUG, str, str2, null);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void d(String str, String str2, Throwable th) {
                Log.d(str, str2, th);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_DEBUG, str, str2, th);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void i(String str, String str2) {
                Log.i(str, str2);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_INFO, str, str2, null);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void i(String str, String str2, Throwable th) {
                Log.i(str, str2, th);
                RCTMGLLogging.this.onLog(LogEvent.LEVEL_INFO, str, str2, th);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void w(String str, String str2) {
                Log.w(str, str2);
                RCTMGLLogging.this.onLog("warning", str, str2, null);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void w(String str, String str2, Throwable th) {
                Log.w(str, str2, th);
                RCTMGLLogging.this.onLog("warning", str, str2, th);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void e(String str, String str2) {
                Log.e(str, str2);
                RCTMGLLogging.this.onLog("error", str, str2, null);
            }

            @Override // com.mappls.sdk.maps.log.LoggerDefinition
            public void e(String str, String str2, Throwable th) {
                Log.e(str, str2, th);
                RCTMGLLogging.this.onLog("error", str, str2, th);
            }
        });
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RCTMGLLogging";
    }

    @ReactMethod
    public void setLogLevel(String str) {
        str.hashCode();
        int i = 4;
        switch (str) {
            case "info":
                break;
            case "debug":
                i = 3;
                break;
            case "error":
                i = 6;
                break;
            case "verbose":
                i = 2;
                break;
            case "warning":
                i = 5;
                break;
            default:
                i = 99;
                break;
        }
        Logger.setVerbosity(i);
    }

    public void onLog(String str, String str2, String str3, Throwable th) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(StackTraceHelper.MESSAGE_KEY, str3);
        writableMapCreateMap.putString("tag", str2);
        writableMapCreateMap.putString(FirebaseAnalytics.Param.LEVEL, str);
    }
}

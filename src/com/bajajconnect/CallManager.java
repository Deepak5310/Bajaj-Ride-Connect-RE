package com.bajajconnect;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.utils.SmsUtil;
import com.bajajconnect.variables.GlobalVar;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CallManager extends ReactContextBaseJavaModule implements Application.ActivityLifecycleCallbacks, CallDetectionPhoneStateListener.PhoneCallStateUpdate, CustomTelephonyCallback.CallStateUpdate {
    private Activity activity;
    private AudioManager audioManager;
    private CallDetectionPhoneStateListener callDetectionPhoneStateListener;
    private CustomTelephonyCallback customTelephonyCallback;
    private final ReactApplicationContext reactContext;
    private TelephonyManager telephonyManager;
    private boolean wasAppInOffHook;
    private boolean wasAppInRinging;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    CallManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.wasAppInOffHook = false;
        this.wasAppInRinging = false;
        this.activity = null;
        this.reactContext = reactApplicationContext;
        this.audioManager = (AudioManager) reactApplicationContext.getSystemService("audio");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCallManager";
    }

    private void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void registerTelephonyCallback() {
        this.customTelephonyCallback = new CustomTelephonyCallback(this);
        this.telephonyManager.registerTelephonyCallback(this.reactContext.getMainExecutor(), this.customTelephonyCallback);
    }

    @ReactMethod
    public void startListener() {
        try {
            if (this.activity == null) {
                Activity currentActivity = getCurrentActivity();
                this.activity = currentActivity;
                currentActivity.getApplication().registerActivityLifecycleCallbacks(this);
            }
            this.telephonyManager = (TelephonyManager) this.reactContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            this.callDetectionPhoneStateListener = new CallDetectionPhoneStateListener(this);
            if (Build.VERSION.SDK_INT >= 31) {
                registerTelephonyCallback();
            } else {
                this.telephonyManager.listen(this.callDetectionPhoneStateListener, 32);
            }
        } catch (Exception e) {
            Log.e("Error startListner", e.getMessage());
        }
    }

    @ReactMethod
    public void stopListener() {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                registerTelephonyCallback();
            } else {
                this.telephonyManager.listen(this.callDetectionPhoneStateListener, 0);
            }
        } catch (Exception e) {
            Log.e("Error stopListner", e.getMessage());
        }
        this.telephonyManager = null;
        this.callDetectionPhoneStateListener = null;
    }

    @ReactMethod
    public void acceptIncomingCall() {
        try {
            Log.i("calling accept call", NotificationCompat.CATEGORY_CALL);
            if (Build.VERSION.SDK_INT >= 26) {
                TelecomManager telecomManager = (TelecomManager) this.reactContext.getSystemService("telecom");
                if (telecomManager != null) {
                    if (ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.ANSWER_PHONE_CALLS") != 0) {
                    } else {
                        telecomManager.acceptRingingCall();
                    }
                }
            } else {
                throughMediaController(this.reactContext);
            }
        } catch (Exception e) {
            Log.e("error occurred", e.getMessage());
        }
    }

    @ReactMethod
    public void rejectIncomingCall() {
        try {
            Log.i("calling accept call", NotificationCompat.CATEGORY_CALL);
            boolean z = this.wasAppInRinging;
            String str = GlobalVar.callerNumber;
            String str2 = GlobalVar.callRejectMsg;
            if (Build.VERSION.SDK_INT >= 28) {
                TelecomManager telecomManager = (TelecomManager) this.reactContext.getSystemService("telecom");
                if (telecomManager != null) {
                    if (ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.ANSWER_PHONE_CALLS") != 0) {
                        return;
                    } else {
                        telecomManager.endCall();
                    }
                }
            } else {
                throughMediaController(this.reactContext);
            }
            if (z) {
                SmsUtil.sendAutoReplyIfConfigured(this.reactContext, str, str2, "appReject");
            }
        } catch (Exception e) {
            Log.e("error occurred", e.getMessage());
        }
    }

    private TelephonyManager getTelephonyService(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        try {
            Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", null);
            declaredMethod.setAccessible(true);
            return (TelephonyManager) declaredMethod.invoke(telephonyManager, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void throughTelephonyService(Context context) {
        getTelephonyService(context);
    }

    private void throughAudioManager() {
        KeyEvent keyEvent = new KeyEvent(0, 79);
        KeyEvent keyEvent2 = new KeyEvent(1, 79);
        this.audioManager.dispatchMediaKeyEvent(keyEvent);
        this.audioManager.dispatchMediaKeyEvent(keyEvent2);
    }

    private void throughReceiver(Context context) {
        try {
            throughTelephonyService(context);
        } catch (Exception unused) {
            boolean z = "HTC".equalsIgnoreCase(Build.MANUFACTURER) && !this.audioManager.isWiredHeadsetOn();
            if (z) {
                broadcastHeadsetConnected(false, context);
            }
            try {
                Runtime.getRuntime().exec("input keyevent 79");
            } catch (IOException unused2) {
                throughPhoneHeadsetHook(context);
            } finally {
                if (z) {
                    broadcastHeadsetConnected(false, context);
                }
            }
        }
    }

    private void broadcastHeadsetConnected(boolean z, Context context) {
        Intent intent = new Intent("android.intent.action.HEADSET_PLUG");
        intent.addFlags(1073741824);
        intent.putExtra("state", z ? 1 : 0);
        intent.putExtra("name", "mysms");
        try {
            context.sendOrderedBroadcast(intent, null);
        } catch (Exception unused) {
        }
    }

    private void throughMediaController(Context context) {
        try {
            for (MediaController mediaController : ((MediaSessionManager) context.getSystemService("media_session")).getActiveSessions(new ComponentName(context, (Class<?>) NotificationListenerService.class))) {
                if ("com.android.server.telecom".equals(mediaController.getPackageName())) {
                    mediaController.dispatchMediaButtonEvent(new KeyEvent(1, 79));
                    return;
                }
            }
        } catch (Exception unused) {
            throughAudioManager();
        }
    }

    private void throughPhoneHeadsetHook(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, 79));
        context.sendOrderedBroadcast(intent, "android.permission.CALL_PRIVILEGED");
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
        intent2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79));
        context.sendOrderedBroadcast(intent2, "android.permission.CALL_PRIVILEGED");
    }

    @ReactMethod
    public void endCall() {
        TelecomManager telecomManager = (TelecomManager) this.reactContext.getSystemService("telecom");
        if (telecomManager == null || ActivityCompat.checkSelfPermission(this.reactContext, "android.permission.ANSWER_PHONE_CALLS") != 0) {
            return;
        }
        telecomManager.endCall();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("Incoming", "Incoming");
        map.put("Offhook", "Offhook");
        map.put("Disconnected", "Disconnected");
        map.put("Missed", "Missed");
        return map;
    }

    @Override // com.bajajconnect.CallDetectionPhoneStateListener.PhoneCallStateUpdate, com.bajajconnect.CustomTelephonyCallback.CallStateUpdate
    public void phoneCallStateUpdated(int i, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (i == 0) {
            if (this.wasAppInOffHook) {
                writableMapCreateMap.putString("callState", "Disconnected");
            } else if (this.wasAppInRinging) {
                writableMapCreateMap.putString("callState", "Missed");
            }
            this.wasAppInRinging = false;
            this.wasAppInOffHook = false;
        } else if (i == 1) {
            this.wasAppInRinging = true;
            writableMapCreateMap.putString("callState", "Incoming");
        } else if (i == 2) {
            this.wasAppInOffHook = true;
            writableMapCreateMap.putString("callState", "Offhook");
        }
        sendEvent(this.reactContext, "CallState", writableMapCreateMap);
    }
}

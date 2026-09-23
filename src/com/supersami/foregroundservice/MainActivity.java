package com.supersami.foregroundservice;

import android.content.Intent;
import android.util.Log;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/* JADX INFO: loaded from: classes4.dex */
public class MainActivity extends ReactActivity {
    public boolean isOnNewIntent = false;

    @Override // com.facebook.react.ReactActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.isOnNewIntent = true;
        ForegroundEmitter();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.isOnNewIntent) {
            return;
        }
        ForegroundEmitter();
    }

    public void ForegroundEmitter() {
        String stringExtra = getIntent().getStringExtra("mainOnPress");
        String stringExtra2 = getIntent().getStringExtra("buttonOnPress");
        String stringExtra3 = getIntent().getStringExtra("button2OnPress");
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (stringExtra != null) {
            writableMapCreateMap.putString("main", stringExtra);
        }
        if (stringExtra2 != null) {
            writableMapCreateMap.putString("button", stringExtra2);
        }
        if (stringExtra3 != null) {
            writableMapCreateMap.putString("button", stringExtra2);
        }
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactInstanceManager().getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("notificationClickHandle", writableMapCreateMap);
        } catch (Exception e) {
            Log.e("SuperLog", "Caught Exception: " + e.getMessage());
        }
    }
}

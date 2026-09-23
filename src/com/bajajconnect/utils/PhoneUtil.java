package com.bajajconnect.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneUtil {
    private static final String TAG = "PhoneUtil";

    private static int clampPercent(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > 100) {
            return 100;
        }
        return i;
    }

    public static int getBatteryStatus(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                if (intExtra >= 0 && intExtra2 > 0) {
                    return clampPercent(Math.round((intExtra * 100.0f) / intExtra2));
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "sticky BATTERY_CHANGED failed: " + e.getMessage());
        }
        try {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager != null) {
                int intProperty = batteryManager.getIntProperty(4);
                if (intProperty >= 0 && intProperty <= 100) {
                    return intProperty;
                }
                Log.w(TAG, "BATTERY_PROPERTY_CAPACITY invalid: " + intProperty);
            }
        } catch (Exception e2) {
            Log.w(TAG, "BatteryManager capacity failed: " + e2.getMessage());
        }
        return -1;
    }
}

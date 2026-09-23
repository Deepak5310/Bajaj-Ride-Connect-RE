package com.bajajconnect.utils;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.bajajconnect.NavApplication;
import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class NavCancelledEventBridge {
    public static final String EVENT_NAME = "NAV_CANCELLED_EVENT";
    private static final String TAG = "NavCancelledBridge";

    private NavCancelledEventBridge() {
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00aa  */
    public static WritableMap buildBody(boolean z, boolean z2, long j, Double d, Double d2, List<double[]> list) {
        String str;
        double[] dArr;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("fromAutoStart", z2);
        if (!z) {
            writableMapCreateMap.putBoolean("showSaveTrip", false);
            return writableMapCreateMap;
        }
        double dHaversineMeters = haversineMeters(list);
        double dMax = 0.0d;
        if (d != null && d2 != null) {
            dMax = Math.max(0.0d, d.doubleValue() - d2.doubleValue());
        }
        double dMax2 = Math.max(dHaversineMeters, dMax);
        int iMax = j > 0 ? (int) Math.max(0L, (System.currentTimeMillis() - j) / 60000) : 0;
        writableMapCreateMap.putBoolean("showSaveTrip", true);
        writableMapCreateMap.putDouble(DirectionsCriteria.ANNOTATION_DISTANCE, dMax2);
        writableMapCreateMap.putInt("timeOfTravel", iMax);
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (list != null) {
            for (double[] dArr2 : list) {
                if (dArr2 != null && dArr2.length >= 2) {
                    WritableArray writableArrayCreateArray2 = Arguments.createArray();
                    writableArrayCreateArray2.pushDouble(dArr2[0]);
                    writableArrayCreateArray2.pushDouble(dArr2[1]);
                    writableArrayCreateArray.pushArray(writableArrayCreateArray2);
                }
            }
        }
        writableMapCreateMap.putArray("wayPointsCovered", writableArrayCreateArray);
        ELocation eLocation = NavApplication.eLocation;
        if (eLocation == null) {
            str = null;
        } else if (eLocation.placeAddress != null && !eLocation.placeAddress.isEmpty()) {
            str = eLocation.placeAddress;
        } else if (eLocation.placeName == null || eLocation.placeName.isEmpty()) {
            str = null;
        } else {
            str = eLocation.placeName;
        }
        if (str != null) {
            writableMapCreateMap.putString("destinationAddress", str);
        } else {
            writableMapCreateMap.putNull("destinationAddress");
        }
        writableMapCreateMap.putNull("sourceAddress");
        writableMapCreateMap.putNull("locationData");
        writableMapCreateMap.putNull("currentLocationAddress");
        if (list != null && !list.isEmpty() && (dArr = list.get(list.size() - 1)) != null && dArr.length >= 2) {
            WritableArray writableArrayCreateArray3 = Arguments.createArray();
            writableArrayCreateArray3.pushDouble(dArr[0]);
            writableArrayCreateArray3.pushDouble(dArr[1]);
            writableMapCreateMap.putArray("currentLocation", writableArrayCreateArray3);
        } else {
            writableMapCreateMap.putNull("currentLocation");
        }
        writableMapCreateMap.putString("mapProvider", DirectionsCriteria.PROFILE_DEFAULT_USER);
        StringBuilder sb = new StringBuilder("payload showSaveTrip=true distance=");
        sb.append((int) dMax2);
        sb.append("m time=");
        sb.append(iMax);
        sb.append("min samples=");
        sb.append(list != null ? list.size() : 0);
        Log.i(TAG, sb.toString());
        return writableMapCreateMap;
    }

    public static void emit(Context context, WritableMap writableMap) {
        ComponentCallbacks2 componentCallbacks2;
        if (context == null || writableMap == null) {
            return;
        }
        try {
            if (context instanceof Application) {
                componentCallbacks2 = (Application) context;
            } else {
                componentCallbacks2 = (Application) context.getApplicationContext();
            }
            if (!(componentCallbacks2 instanceof ReactApplication)) {
                Log.w(TAG, "emit skipped — not ReactApplication");
                return;
            }
            ReactContext currentReactContext = ((ReactApplication) componentCallbacks2).getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
            if (currentReactContext == null) {
                Log.w(TAG, "emit skipped — no ReactContext");
            } else {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(EVENT_NAME, writableMap);
                Log.i(TAG, "emitted NAV_CANCELLED_EVENT");
            }
        } catch (Exception e) {
            Log.e(TAG, "emit failed", e);
        }
    }

    public static double haversineMeters(List<double[]> list) {
        double d = 0.0d;
        if (list != null && list.size() >= 2) {
            int i = 0;
            while (i < list.size() - 1) {
                double[] dArr = list.get(i);
                i++;
                double[] dArr2 = list.get(i);
                if (dArr != null && dArr2 != null && dArr.length >= 2 && dArr2.length >= 2) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(dArr[1], dArr[0], dArr2[1], dArr2[0], fArr);
                    d += (double) fArr[0];
                }
            }
        }
        return d;
    }
}

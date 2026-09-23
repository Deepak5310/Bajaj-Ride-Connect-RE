package com.mappls.sdk.navigation.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.s;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements SensorEventListener {
    private long b = 0;
    private boolean c = false;
    private s.j<s.k> a = NavigationContext.getNavigationContext().k().q;

    public static SunriseSunset a() {
        NavLocation lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getLastKnownLocation();
        if (lastKnownLocation == null) {
            lastKnownLocation = NavigationContext.getNavigationContext().getLocationProvider().getFirstTimeRunDefaultLocation();
        }
        if (lastKnownLocation == null) {
            return null;
        }
        double longitude = lastKnownLocation.getLongitude();
        Date date = new Date();
        double latitude = lastKnownLocation.getLatitude();
        if (longitude < 0.0d) {
            longitude += 360.0d;
        }
        return new SunriseSunset(latitude, longitude, date, TimeZone.getDefault());
    }

    public final boolean b() {
        s.k kVar = this.a.get();
        kVar.getClass();
        if (kVar == s.k.DAY) {
            return false;
        }
        if (kVar == s.k.NIGHT) {
            return true;
        }
        if (kVar != s.k.AUTO) {
            if (kVar == s.k.SENSOR) {
                return this.c;
            }
            return false;
        }
        if (System.currentTimeMillis() - this.b > 60000) {
            this.b = System.currentTimeMillis();
            try {
                SunriseSunset sunriseSunsetA = a();
                if (sunriseSunsetA != null) {
                    boolean zIsDaytime = sunriseSunsetA.isDaytime();
                    NavigationLogger.d("Sunrise/sunset setting to day: " + zIsDaytime, new Object[0]);
                    this.c = zIsDaytime ^ true;
                }
            } catch (IllegalArgumentException e) {
                NavigationLogger.w(e, "Network location provider not available", new Object[0]);
            } catch (SecurityException e2) {
                NavigationLogger.w(e2, "Missing permissions to get actual location!", new Object[0]);
            }
        }
        return this.c;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr.length > 0) {
            boolean z = fArr[0] <= 100.0f;
            if (z == this.c || System.currentTimeMillis() - this.b <= 10000) {
                return;
            }
            this.b = System.currentTimeMillis();
            this.c = z;
            throw null;
        }
    }
}

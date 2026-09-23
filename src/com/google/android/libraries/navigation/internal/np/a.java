package com.google.android.libraries.navigation.internal.np;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final LocationManager a;

    public a(LocationManager locationManager) {
        this.a = locationManager;
    }

    public final int a() {
        return this.a.getGnssCapabilities().hasAccumulatedDeltaRange();
    }

    public final GpsStatus b(GpsStatus gpsStatus) {
        return this.a.getGpsStatus(gpsStatus);
    }

    public final Location c(String str) {
        return this.a.getLastKnownLocation(str);
    }

    public final List d() {
        return this.a.getAllProviders();
    }

    public final void e(GpsStatus.Listener listener) {
        this.a.removeGpsStatusListener(listener);
    }

    public final void f(LocationListener locationListener) {
        this.a.removeUpdates(locationListener);
    }

    public final void g(GnssMeasurementsEvent.Callback callback) {
        this.a.unregisterGnssMeasurementsCallback(callback);
    }

    public final void h(GnssStatus.Callback callback) {
        this.a.unregisterGnssStatusCallback(callback);
    }

    public final boolean i(GpsStatus.Listener listener) {
        return this.a.addGpsStatusListener(listener);
    }

    public final boolean j(String str) {
        return this.a.isProviderEnabled(str);
    }

    public final boolean k(GnssStatus.Callback callback, Handler handler) {
        return this.a.registerGnssStatusCallback(callback, handler);
    }

    public final void l(String str, long j, LocationListener locationListener, Looper looper) {
        this.a.requestLocationUpdates(str, j, 0.0f, locationListener, looper);
    }
}

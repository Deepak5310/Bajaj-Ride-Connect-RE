package com.mappls.sdk.navigation.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;

/* JADX INFO: loaded from: classes4.dex */
final class e implements GpsStatus.Listener {
    private GpsStatus a;
    final /* synthetic */ LocationManager b;
    final /* synthetic */ f c;

    e(f fVar, LocationManager locationManager) {
        this.c = fVar;
        this.b = locationManager;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int i) {
        if (ActivityCompat.checkSelfPermission(this.c.d, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            GpsStatus gpsStatus = this.b.getGpsStatus(this.a);
            this.a = gpsStatus;
            f.a(this.c, gpsStatus);
        }
    }
}

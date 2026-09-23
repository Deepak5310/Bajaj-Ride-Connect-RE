package com.mappls.sdk.navigation.location;

import android.content.Context;
import android.location.GnssStatus;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.util.GPSInfo;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements d {
    private LocationManager a;
    private com.mappls.sdk.navigation.location.a b;
    private final GnssStatus.Callback c = new a();
    private Context d;

    final class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            GPSInfo gPSInfo = new GPSInfo();
            if (gnssStatus.getSatelliteCount() > 0) {
                int i = 0;
                for (int i2 = 0; i2 < gnssStatus.getSatelliteCount(); i2++) {
                    if (gnssStatus.usedInFix(i2)) {
                        i++;
                    }
                }
                gPSInfo.fixed = i > 0;
                gPSInfo.foundSatellites = gnssStatus.getSatelliteCount();
                gPSInfo.usedSatellites = i;
                if (c.this.b != null) {
                    c.this.b.a(gPSInfo);
                }
            }
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
        }
    }

    public c(Context context) {
        this.d = context;
    }

    @Override // com.mappls.sdk.navigation.location.d
    public final void a() {
        LocationManager locationManager;
        try {
            if (ActivityCompat.checkSelfPermission(this.d, "android.permission.ACCESS_FINE_LOCATION") != 0 || (locationManager = this.a) == null) {
                return;
            }
            locationManager.unregisterGnssStatusCallback(this.c);
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @Override // com.mappls.sdk.navigation.location.d
    public final void a(com.mappls.sdk.navigation.location.a aVar) {
        LocationManager locationManager;
        this.b = aVar;
        this.a = (LocationManager) this.d.getSystemService(FirebaseAnalytics.Param.LOCATION);
        try {
            if (ActivityCompat.checkSelfPermission(this.d, "android.permission.ACCESS_FINE_LOCATION") != 0 || (locationManager = this.a) == null) {
                return;
            }
            locationManager.registerGnssStatusCallback(this.c);
        } catch (Exception e) {
            Timber.e(e);
        }
    }
}

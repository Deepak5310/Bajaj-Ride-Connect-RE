package com.mappls.sdk.navigation.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.util.GPSInfo;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements d {
    GpsStatus.Listener a;
    private LocationManager b;
    private a c;
    private final Context d;

    public f(Context context) {
        this.d = context;
    }

    static void a(f fVar, GpsStatus gpsStatus) {
        int i;
        int i2;
        fVar.getClass();
        boolean z = false;
        if (gpsStatus != null) {
            Iterator<GpsSatellite> it2 = gpsStatus.getSatellites().iterator();
            i = 0;
            i2 = 0;
            while (it2.hasNext()) {
                i++;
                if (it2.next().usedInFix()) {
                    i2++;
                    z = true;
                }
            }
        } else {
            i = 0;
            i2 = 0;
        }
        GPSInfo gPSInfo = new GPSInfo();
        gPSInfo.fixed = z;
        gPSInfo.foundSatellites = i;
        gPSInfo.usedSatellites = i2;
        a aVar = fVar.c;
        if (aVar != null) {
            aVar.a(gPSInfo);
        }
    }

    @Override // com.mappls.sdk.navigation.location.d
    public final void a() {
        if (this.b == null || ActivityCompat.checkSelfPermission(this.d, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        this.b.removeGpsStatusListener(this.a);
    }

    @Override // com.mappls.sdk.navigation.location.d
    public final void a(a aVar) {
        this.c = aVar;
        this.b = (LocationManager) this.d.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (ActivityCompat.checkSelfPermission(this.d, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationManager locationManager = this.b;
            e eVar = new e(this, locationManager);
            this.a = eVar;
            locationManager.addGpsStatusListener(eVar);
        }
    }
}

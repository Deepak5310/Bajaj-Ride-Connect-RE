package com.google.android.libraries.navigation.internal.dh;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.OnNmeaMessageListener;
import android.os.Handler;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ap implements GpsStatus.Listener {
    public static final /* synthetic */ int f = 0;
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dh.ap");
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public com.google.android.libraries.navigation.internal.kl.a c;
    public final al e;
    private LocationListener i;
    private ao j;
    private OnNmeaMessageListener l;
    private final com.google.android.libraries.navigation.internal.np.a m;
    public final long b = -2000;
    private GpsStatus h = null;
    private boolean k = false;
    public final u d = new u();

    public ap(al alVar, com.google.android.libraries.navigation.internal.np.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2) {
        this.e = alVar;
        this.m = aVar;
        this.a = aVar2;
    }

    public static float a(float[] fArr) {
        int length = fArr.length;
        if (length == 0) {
            return -1.0f;
        }
        return length < 5 ? fArr[0] : fArr[length - 5];
    }

    public final void b() {
        try {
            if (this.i == null) {
                an anVar = new an();
                this.m.l("gps", 997L, anVar, null);
                this.i = anVar;
            }
            if (this.j == null) {
                ao aoVar = new ao(this);
                if (this.m.k(aoVar, new Handler())) {
                    this.j = aoVar;
                }
            }
        } catch (RuntimeException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 395)).p("Encountered exception while starting SatelliteStatusTracker.");
        }
    }

    public final void c() {
        try {
            LocationListener locationListener = this.i;
            if (locationListener != null) {
                this.m.f(locationListener);
            }
            ao aoVar = this.j;
            if (aoVar != null) {
                this.m.h(aoVar);
            }
        } catch (IllegalStateException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 397)).p("Ignoring IllegalStateException");
        } catch (SecurityException unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 396)).p("Ignoring SecurityException");
        }
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = null;
    }

    public final boolean d() {
        if (this.i != null) {
            return this.j != null || this.k;
        }
        return false;
    }

    public final boolean e(com.google.android.libraries.navigation.internal.kl.a aVar) {
        this.c = aVar;
        if (d()) {
            return true;
        }
        b();
        boolean zD = d();
        com.google.android.apps.gmm.location.navigation.ap.a(aVar, 22, zD);
        return zD;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int i) {
        try {
            GpsStatus gpsStatusB = this.m.b(this.h);
            this.h = gpsStatusB;
            if (gpsStatusB == null) {
                return;
            }
            int maxSatellites = gpsStatusB.getMaxSatellites();
            float[] fArrCopyOf = new float[maxSatellites];
            int i2 = 0;
            int i3 = 0;
            float f2 = -1.0f;
            for (GpsSatellite gpsSatellite : this.h.getSatellites()) {
                float snr = gpsSatellite.getSnr();
                if (f2 < snr) {
                    f2 = snr;
                }
                i3++;
                if (gpsSatellite.usedInFix()) {
                    if (i2 < maxSatellites) {
                        fArrCopyOf[i3] = snr;
                    }
                    i2++;
                }
            }
            if (i2 < maxSatellites) {
                fArrCopyOf = Arrays.copyOf(fArrCopyOf, i2);
            }
            Arrays.sort(fArrCopyOf);
            if (!this.d.a(fArrCopyOf)) {
                this.e.a(i2, i3, f2, a(fArrCopyOf), false);
            } else {
                com.google.android.libraries.navigation.internal.kl.a aVar = this.c;
                if (aVar != null) {
                    ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(19);
                }
            }
        } catch (NullPointerException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 394)).p("ignoring crash in LocationManager.getGpsStatus");
        }
    }
}

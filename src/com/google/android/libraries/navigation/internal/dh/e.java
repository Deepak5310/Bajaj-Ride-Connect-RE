package com.google.android.libraries.navigation.internal.dh;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Looper;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements LocationListener {
    final /* synthetic */ f a;
    private final String b;
    private final boolean c;
    private boolean d;
    private boolean e;
    private long f = -4611686018427387904L;
    private final int g;

    public e(f fVar, String str, int i, boolean z) {
        this.a = fVar;
        this.b = str;
        this.g = i;
        this.c = z;
    }

    final void a() {
        if (this.d) {
            try {
                this.a.t.f(this);
                int i = com.google.android.libraries.navigation.internal.km.l.a;
                int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
            } catch (SecurityException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 345)).p("SecurityException from cancelLocationUpdates");
            }
        }
        this.d = false;
    }

    final void b(Looper looper) {
        if (this.d) {
            return;
        }
        List listD = this.a.t.d();
        boolean z = false;
        if (listD == null || !listD.contains(this.b)) {
            this.d = false;
            if (this.e) {
                return;
            }
            com.google.android.apps.gmm.location.navigation.ap.a(this.a.c, this.g, false);
            this.e = true;
            return;
        }
        try {
            this.a.t.l(this.b, 900L, this, looper);
            this.d = true;
            int i = com.google.android.libraries.navigation.internal.km.l.a;
            int i2 = com.google.android.libraries.navigation.internal.fp.a.a;
            z = true;
        } catch (SecurityException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 352)).p("SecurityException from requestLocationUpdates");
            this.d = false;
        }
        if (this.e) {
            return;
        }
        com.google.android.apps.gmm.location.navigation.ap.a(this.a.c, this.g, z);
        this.e = true;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        if (location != null) {
            try {
                long jB = this.a.b.b();
                if ((jB - this.f) / 1000000 < 800) {
                    return;
                }
                long j = (-500000000) + jB;
                if (location.getElapsedRealtimeNanos() < j) {
                    location.setElapsedRealtimeNanos(j);
                    com.google.android.libraries.navigation.internal.kl.a aVar = this.a.c;
                    if (aVar != null) {
                        ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(18);
                    }
                }
                this.a.a.a(new a(location));
                this.f = jB;
                f fVar = this.a;
                com.google.android.libraries.navigation.internal.kl.a aVar2 = fVar.c;
                if (aVar2 != null && this.c && jB - fVar.g < 1300000000) {
                    ((com.google.android.libraries.navigation.internal.kk.k) aVar2.a(com.google.android.libraries.navigation.internal.km.af.o)).a(23);
                }
                if (this.c) {
                    this.a.d();
                }
            } catch (RuntimeException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 347)).p("Exception in onLocationChanged. Ignoring.");
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("provider", this.b);
        return akVarB.e("updatesActive", this.d).toString();
    }
}

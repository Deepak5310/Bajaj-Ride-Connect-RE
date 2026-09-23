package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj implements v {
    public static final double[] a = {-180.0d, 180.0d};
    public static final double[] b = {0.0d, 360.0d};
    public static final double c = 1.0d / Math.log(2.0d);
    private final CameraPosition d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final long h;
    private final int i;
    private boolean j;
    private ag k;
    private long l;
    private long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.abf.q f143n;

    public aj(CameraPosition cameraPosition, boolean z, boolean z2, long j, int i) {
        synchronized (this) {
            this.d = cameraPosition;
            this.e = z;
            this.f = z2;
            this.g = true;
            this.h = j;
            this.i = i;
            this.j = false;
            this.k = null;
            this.f143n = null;
            this.l = 0L;
            this.m = 0L;
        }
    }

    public static double b(double d, double d2, double[] dArr, double d3) {
        double d4 = ((1.0d - d3) * d) + (d3 * d2);
        if (dArr == null) {
            return d4;
        }
        double dAbs = Math.abs(d2 - d);
        double dMin = Math.min(d, d2);
        double d5 = dArr[0];
        double d6 = dArr[1];
        double dMax = (dMin - d5) + (d6 - Math.max(d, d2));
        if (dAbs <= dMax) {
            return d4;
        }
        double d7 = ((d < d2 ? -1.0d : 1.0d) * dMax * d3) + d;
        if (d7 < d5) {
            return d6 - (d5 - d7);
        }
        return d7 <= d6 ? d7 : d5 + (d7 - d6);
    }

    private final synchronized void g(be beVar, long j) {
        CameraPosition cameraPositionF = beVar.f();
        if (com.google.android.libraries.navigation.internal.abf.r.a(cameraPositionF, this.d)) {
            this.j = true;
        }
        this.k = this.f ? new ai(cameraPositionF, this.d, this.h) : new ah(cameraPositionF, this.d, this.h);
        this.l = j;
        this.f143n = new com.google.android.libraries.navigation.internal.abf.q(this.d, Long.valueOf(j + this.h));
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final int a() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized CameraPosition c(be beVar, long j) {
        CameraPosition cameraPosition;
        if (this.k == null) {
            g(beVar, j);
        }
        this.m = j;
        ag agVar = this.k;
        long j2 = j - this.l;
        com.google.android.libraries.navigation.internal.abf.s.b(j2 >= 0, "invalid relativeTimeMs: %s", Long.valueOf(j2));
        long j3 = agVar.c;
        if (j2 >= j3) {
            cameraPosition = agVar.b;
        } else if (j2 <= 0) {
            cameraPosition = agVar.a;
        } else {
            double dA = agVar.a(j2 / j3);
            LatLng latLng = new LatLng(b(agVar.a.target.latitude, agVar.b.target.latitude, null, dA), b(agVar.a.target.longitude, agVar.b.target.longitude, a, dA));
            float fB = (float) agVar.b(agVar.a.zoom, agVar.b.zoom, dA);
            CameraPosition cameraPosition2 = agVar.a;
            float f = cameraPosition2.tilt;
            CameraPosition cameraPosition3 = agVar.b;
            cameraPosition = new CameraPosition(latLng, fB, (float) b(f, cameraPosition3.tilt, null, dA), (float) b(cameraPosition2.bearing, cameraPosition3.bearing, b, dA));
        }
        return cameraPosition;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final CameraPosition d() {
        if (this.h == 0) {
            return this.d;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final /* synthetic */ com.google.android.libraries.navigation.internal.pd.e e() {
        return null;
    }

    public final synchronized boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        synchronized (ajVar) {
            if (!com.google.android.libraries.navigation.internal.abf.r.a(this.d, ajVar.d) || this.e != ajVar.e || this.f != ajVar.f || this.g != ajVar.g || this.h != ajVar.h || this.l != ajVar.l || this.i != ajVar.i) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized com.google.android.libraries.navigation.internal.abf.q f() {
        return this.f143n;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final void h(boolean z) {
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{this.d, Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g), Long.valueOf(this.h), Long.valueOf(this.l), Integer.valueOf(this.i)});
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final synchronized boolean i() {
        return this.j || this.m - this.l >= this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean j() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.v
    public final boolean k(CameraPosition cameraPosition, be beVar) {
        return this.g;
    }

    public final synchronized String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF;
        ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("endPosition", this.d);
        return ajVarF.e("isNoopAnimation", this.j).e("isUserGesture", this.e).e("isLinear", this.f).e("allowClampedCamera", this.g).d("durationMs", this.h).d("startWorldTimeMs", this.l).d("currWorldTimeMs", this.m).c("animationReason", this.i).toString();
    }
}

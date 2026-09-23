package com.google.android.libraries.navigation.internal.fi;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.bp.ao;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public Location a;
    public double b;
    private final bg c;
    private final float d;
    private long e;
    private long f;
    private boolean g;

    public n(bg bgVar, float f, com.google.android.libraries.navigation.internal.mj.a aVar) {
        ar.q(bgVar);
        this.c = bgVar;
        ar.a(f > 0.0f);
        this.d = f;
        this.e = aVar.f().toEpochMilli();
        this.f = aVar.a();
        this.b = 0.0d;
        ar.k(a(0L));
        ar.q(this.a);
    }

    public final boolean a(long j) {
        ar.q(this.c);
        ar.a(j >= 0);
        if (this.g) {
            return false;
        }
        this.e += j;
        this.f += j;
        bg bgVar = this.c;
        ao aoVar = bgVar.t != null ? bgVar.t : bgVar.s;
        ar.q(aoVar);
        double dA = com.google.android.libraries.navigation.internal.aaa.a.a(aoVar.c(this.b));
        double dMax = Math.max(0.0d, dA - (((double) (j * this.d)) / 1000.0d));
        if (dMax == 0.0d) {
            this.g = true;
        }
        if (dMax != dA) {
            this.b = o.a(aoVar, dMax);
        }
        double d = this.c.J;
        com.google.android.libraries.navigation.internal.oe.x xVarW = this.c.w(Math.max(0.0d, Math.min(d, o.a(aoVar, dMax + 1.0d))));
        ar.q(xVarW);
        com.google.android.libraries.navigation.internal.oe.x xVarW2 = this.c.w(Math.max(0.0d, Math.min(d, o.a(aoVar, dMax - 1.0d))));
        ar.q(xVarW2);
        float fA = (float) com.google.android.libraries.navigation.internal.oe.x.a(xVarW, xVarW2);
        float fL = this.d * xVarW.l(xVarW2);
        com.google.android.libraries.navigation.internal.oe.x xVarB = xVarW.B(xVarW2, 0.5f);
        double dE = xVarB.e();
        double d2 = this.f * 6.283185307179586d;
        double d3 = d2 / 60000.0d;
        double dSin = Math.sin(d3) * dE * 0.0d;
        double dCos = Math.cos(d3) * dE * 0.0d;
        xVarB.a += (int) dSin;
        xVarB.b += (int) dCos;
        double dSin2 = Math.sin(d2 / 137000.0d);
        Location location = new Location("gps");
        location.setLatitude(xVarB.b());
        location.setLongitude(xVarB.d());
        location.setAccuracy((dSin2 > 1.0d ? 500 : 0) + 5.99f);
        location.setTime(this.e);
        Bundle bundle = new Bundle();
        bundle.putInt("signal_possible_in_tunnels", 1);
        location.setExtras(bundle);
        if (Build.VERSION.SDK_INT >= 31) {
            location.setMock(true);
        }
        location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(this.f));
        location.setSpeed(fL / 2.0f);
        location.setBearing(fA);
        this.a = location;
        return true;
    }
}

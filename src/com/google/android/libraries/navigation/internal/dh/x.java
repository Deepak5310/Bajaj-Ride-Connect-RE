package com.google.android.libraries.navigation.internal.dh;

import android.location.Location;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x extends com.google.android.libraries.navigation.internal.kp.b {
    public final Location a;

    protected x(Location location) {
        this.a = location;
    }

    public final float d() {
        if (j()) {
            return this.a.getBearingAccuracyDegrees();
        }
        return Float.NaN;
    }

    public final float e() {
        if (n()) {
            return this.a.getSpeedAccuracyMetersPerSecond();
        }
        return Float.NaN;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof x) {
            return com.google.android.libraries.navigation.internal.yx.am.a(this.a, ((x) obj).a);
        }
        return false;
    }

    public final float f() {
        if (o()) {
            return this.a.getVerticalAccuracyMeters();
        }
        return Float.NaN;
    }

    public final int g() {
        if (l()) {
            return this.a.getExtras().getInt("locationType");
        }
        return -1;
    }

    public final int h() {
        com.google.android.libraries.navigation.internal.yx.ar.k(m());
        return this.a.getExtras().getInt("satellites");
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final com.google.android.libraries.navigation.internal.pt.d i() {
        return com.google.android.libraries.navigation.internal.db.d.a(this.a);
    }

    public final boolean j() {
        return Build.VERSION.SDK_INT >= 26 && this.a.hasBearingAccuracy();
    }

    public final boolean l() {
        return this.a.getExtras() != null && this.a.getExtras().containsKey("locationType");
    }

    public final boolean m() {
        return this.a.getExtras() != null && this.a.getExtras().containsKey("satellites");
    }

    public final boolean n() {
        return Build.VERSION.SDK_INT >= 26 && this.a.hasSpeedAccuracy();
    }

    public final boolean o() {
        return Build.VERSION.SDK_INT >= 26 && this.a.hasVerticalAccuracy();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("provider", this.a.getProvider());
        com.google.android.libraries.navigation.internal.yx.ak akVarD = akVarB.a("lat", this.a.getLatitude()).a("lng", this.a.getLongitude()).d("time", this.a.getTime());
        if (this.a.hasAltitude()) {
            akVarD.a(SavingTrackHelper.TRACK_COL_ALTITUDE, this.a.getAltitude());
        }
        if (this.a.hasBearing()) {
            akVarD.b("bearing", this.a.getBearing());
        }
        if (this.a.hasSpeed()) {
            akVarD.b("speed", this.a.getSpeed());
        }
        if (this.a.hasAccuracy()) {
            akVarD.b("accuracy", this.a.getAccuracy());
        }
        if (n()) {
            akVarD.b("speedAcc", e());
        }
        if (j()) {
            akVarD.b("bearingAcc", d());
        }
        if (o()) {
            akVarD.b("vertAcc", f());
        }
        akVarD.d("elapsedRealtimeMillis", TimeUnit.NANOSECONDS.toMillis(this.a.getElapsedRealtimeNanos()));
        if (m()) {
            akVarD.c("numSatellites", h());
        }
        if (l()) {
            akVarD.c("fusedLocationType", g());
        }
        com.google.android.libraries.navigation.internal.pt.d dVarI = i();
        if (dVarI != null) {
            akVarD.g(FirebaseAnalytics.Param.LEVEL, dVarI);
        }
        return akVarD.toString();
    }
}

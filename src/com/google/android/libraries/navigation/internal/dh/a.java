package com.google.android.libraries.navigation.internal.dh;

import android.location.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@com.google.android.libraries.navigation.internal.ib.a
public final class a extends x implements com.google.android.libraries.navigation.internal.ic.a {
    public a(Location location) {
        super(location);
    }

    @Override // com.google.android.libraries.navigation.internal.kp.b
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f(FirebaseAnalytics.Param.LOCATION);
        fVar.m("provider", this.a.getProvider());
        com.google.android.libraries.navigation.internal.kp.f fVarG = fVar.a("lat", this.a.getLatitude()).a("lng", this.a.getLongitude()).g("time", this.a.getTime()).i(SavingTrackHelper.TRACK_COL_ALTITUDE, this.a.hasAltitude() ? this.a.getAltitude() : Double.NaN).j("bearing", this.a.hasBearing() ? this.a.getBearing() : Float.NaN).j("speed", this.a.hasSpeed() ? this.a.getSpeed() : Float.NaN).j("accuracy", this.a.hasAccuracy() ? this.a.getAccuracy() : Float.NaN).j("speedAcc", n() ? e() : Float.NaN).j("bearingAcc", j() ? d() : Float.NaN).j("vertAcc", o() ? f() : Float.NaN).g("etms", TimeUnit.NANOSECONDS.toMillis(this.a.getElapsedRealtimeNanos()));
        if (m()) {
            fVarG.f("numSatellites", h());
        }
        if (l()) {
            fVarG.f("fusedLocationType", g());
        }
        com.google.android.libraries.navigation.internal.pt.d dVarI = i();
        if (dVarI != null) {
            fVarG.m("levelId", dVarI.b.f());
            fVarG.f("levelNum", dVarI.c);
        }
        return fVarG;
    }
}

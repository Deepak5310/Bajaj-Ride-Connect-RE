package com.google.android.libraries.navigation.internal.db;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import j$.time.Duration;
import j$.time.Instant;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public static Location a(r rVar) {
        Location location = new Location(rVar.a);
        location.setLatitude(rVar.b);
        location.setLongitude(rVar.c);
        if (rVar.r()) {
            location.setAccuracy(rVar.d);
        }
        if (rVar.s()) {
            location.setAltitude(rVar.e);
        }
        if (rVar.t()) {
            location.setBearing(rVar.f());
        }
        if (rVar.x()) {
            location.setSpeed(rVar.f);
        }
        if (rVar.z()) {
            location.setTime(rVar.q().toEpochMilli());
        }
        location.setElapsedRealtimeNanos(rVar.g.toNanos());
        if (Build.VERSION.SDK_INT >= 26) {
            if (rVar.y()) {
                location.setSpeedAccuracyMetersPerSecond(rVar.h());
            }
            if (rVar.u()) {
                location.setBearingAccuracyDegrees(rVar.g());
            }
            if (rVar.A()) {
                location.setVerticalAccuracyMeters(rVar.i());
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            location.setMock(rVar.p);
        }
        Bundle bundle = new Bundle();
        int i = rVar.o;
        if (i != 0) {
            bundle.putInt("locationType", i);
        }
        if (rVar.k().a()) {
            bundle.putInt("satellites", rVar.k().c);
        }
        location.setExtras(bundle);
        float f = rVar.m;
        if (!Float.isNaN(f)) {
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putFloat("indoorProbability", f);
            location.setExtras(extras);
        }
        com.google.android.libraries.navigation.internal.pt.d dVar = rVar.f387n;
        if (dVar != null) {
            Bundle extras2 = location.getExtras();
            if (extras2 == null) {
                extras2 = new Bundle();
            }
            extras2.putInt("locationType", 3);
            extras2.putString("levelId", dVar.b.f());
            extras2.putInt("levelNumberE3", dVar.c);
            location.setExtras(extras2);
        }
        f fVar = rVar.j;
        if (fVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("bluewave_correction_type", ((e) fVar).a.ordinal());
            location.setExtras(bundle2);
        }
        return location;
    }

    public static q b(Location location) {
        int i;
        q qVar = new q(Duration.ofMillis(TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos())));
        String provider = location.getProvider();
        if (provider != null) {
            qVar.a = provider;
        }
        qVar.s(location.getLatitude(), location.getLongitude());
        if (location.hasAccuracy()) {
            qVar.d = location.getAccuracy();
        }
        if (location.hasAltitude()) {
            qVar.e = location.getAltitude();
        }
        if (location.hasBearing()) {
            qVar.g = location.getBearing();
        }
        if (location.hasSpeed()) {
            qVar.i = location.getSpeed();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (location.hasVerticalAccuracy()) {
                qVar.f = location.getVerticalAccuracyMeters();
            }
            if (location.hasBearingAccuracy()) {
                qVar.h = location.getBearingAccuracyDegrees();
            }
            if (location.hasSpeedAccuracy()) {
                qVar.j = location.getSpeedAccuracyMetersPerSecond();
            }
        }
        Float fB = d.b(location);
        if (fB != null) {
            qVar.r = fB.floatValue();
        }
        com.google.android.libraries.navigation.internal.pt.d dVarA = d.a(location);
        if (dVarA != null) {
            qVar.t(dVarA);
        }
        Bundle extras = location.getExtras();
        boolean zIsMock = false;
        if (extras != null) {
            qVar.t = extras.getInt("locationType", 0);
            if (extras.containsKey("satellites")) {
                int i2 = extras.getInt("satellites");
                qVar.w = true;
                qVar.x = i2;
            }
            if (extras.containsKey("signal_possible_in_tunnels")) {
                qVar.y = true;
            }
            if (extras.containsKey("autodrive_speed_multiplier") || extras.containsKey("replayedEvent")) {
                zIsMock = true;
            }
        }
        Bundle extras2 = location.getExtras();
        e eVar = null;
        if (extras2 != null && (i = extras2.getInt("bluewave_correction_type", -1)) != -1) {
            eVar = new e(com.google.android.libraries.navigation.internal.abc.a.values()[i]);
        }
        if (eVar != null) {
            qVar.o = eVar;
        }
        if (!zIsMock) {
            zIsMock = Build.VERSION.SDK_INT >= 31 ? location.isMock() : location.isFromMockProvider();
        }
        qVar.u = zIsMock;
        qVar.l = Instant.ofEpochMilli(location.getTime());
        qVar.k = Duration.ofNanos(location.getElapsedRealtimeNanos());
        return qVar;
    }

    public static r c(Location location) {
        return b(location).a();
    }
}

package com.google.android.libraries.navigation.internal.db;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar {
    public static float a(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double dAbs = Math.abs(radians2 - Math.toRadians(d4));
        double dSin = Math.sin(radians);
        double dCos = Math.cos(radians);
        double dSin2 = Math.sin(radians3);
        double dCos2 = Math.cos(radians3);
        double dCos3 = Math.cos(dAbs);
        return (float) (Math.atan2(Math.hypot(Math.sin(dAbs) * dCos2, (dCos * dSin2) - ((dSin * dCos2) * dCos3)), (dSin * dSin2) + (dCos * dCos2 * dCos3)) * 6371010.0d);
    }

    public static boolean b(as asVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        return d(asVar, as.s, aVar, Duration.ZERO);
    }

    @Deprecated
    public static boolean c(Instant instant, Instant instant2) {
        return instant.plus(as.s).isBefore(instant2);
    }

    public static boolean d(as asVar, Duration duration, com.google.android.libraries.navigation.internal.mj.a aVar, Duration duration2) {
        return asVar.p().plus(duration).compareTo(Duration.ofMillis(aVar.a()).plus(duration2)) < 0;
    }
}

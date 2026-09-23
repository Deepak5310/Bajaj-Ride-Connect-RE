package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oe.p");
    private static final double b = Math.log(2.0d);

    public static double a(double d, double d2, double d3, int i) {
        if (d2 < -90.0d || d2 > 90.0d) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(813)).s("invalid latitude %s", Double.valueOf(d2));
        }
        return Math.max(0.0d, Math.log((((1.0d / Math.tan(Math.toRadians(d3) / 2.0d)) * (((double) i) / 2.0d)) * 6.283185307179586d) / ((d / (Math.cos(Math.toRadians(d2)) * 6371010.0d)) * 256.0d)) / b);
    }

    public static double b(r rVar, r rVar2) {
        double d = rVar2.b;
        double d2 = rVar2.a;
        double d3 = rVar.b;
        double radians = Math.toRadians(rVar.a);
        double radians2 = Math.toRadians(d3);
        double radians3 = Math.toRadians(d2);
        double dAbs = Math.abs(radians2 - Math.toRadians(d));
        double dSin = Math.sin(radians);
        double dCos = Math.cos(radians);
        double dSin2 = Math.sin(radians3);
        double dCos2 = Math.cos(radians3);
        double dCos3 = Math.cos(dAbs);
        return Math.atan2(Math.hypot(Math.sin(dAbs) * dCos2, (dCos * dSin2) - ((dSin * dCos2) * dCos3)), (dSin * dSin2) + (dCos * dCos2 * dCos3)) * 6371010.0d;
    }

    public static double c(double d, double d2, double d3, int i) {
        double radians = Math.toRadians(d3) / 2.0d;
        double radians2 = Math.toRadians(d2);
        return ((((1.0d / Math.tan(radians)) * (6.283185307179586d / (Math.pow(2.0d, d) * 256.0d))) * ((double) i)) / 2.0d) * 6371010.0d * Math.cos(radians2);
    }
}

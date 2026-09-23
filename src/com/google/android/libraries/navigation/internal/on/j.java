package com.google.android.libraries.navigation.internal.on;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static double a(double d, double d2) {
        double dAbs = Math.abs(d2 - d);
        return dAbs < 180.0d ? dAbs : 360.0d - dAbs;
    }
}

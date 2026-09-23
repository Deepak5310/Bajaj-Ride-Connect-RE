package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa {
    public static final aa a = new aa();
    private static final double b = 1.0d / Math.log(2.0d);

    private aa() {
    }

    public static double a(int i, double d, double d2) {
        return Math.log(((d / (d2 * 256.0d)) / ((double) i)) * 1.073741824E9d) * b;
    }

    private static int d(com.google.android.libraries.navigation.internal.abj.c cVar, com.google.android.libraries.navigation.internal.abj.c cVar2) {
        return cVar.b - cVar2.b;
    }

    private static int e(com.google.android.libraries.navigation.internal.abj.c cVar, com.google.android.libraries.navigation.internal.abj.c cVar2) {
        int i = cVar.a;
        int i2 = cVar2.a;
        return i < i2 ? (1073741824 - i2) + i : i - i2;
    }

    public final double b(LatLngBounds latLngBounds, double d, double d2, double d3) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLngBounds, "LatLngBounds");
        boolean z = true;
        if (d <= 0.0d && d2 <= 0.0d) {
            z = false;
        }
        com.google.android.libraries.navigation.internal.abf.s.d(z, "screenWidthPx and screenHeight are both <= 0");
        com.google.android.libraries.navigation.internal.abf.s.l(d3, "screenDensity is 0");
        com.google.android.libraries.navigation.internal.abj.c cVar = new com.google.android.libraries.navigation.internal.abj.c(latLngBounds.northeast);
        com.google.android.libraries.navigation.internal.abj.c cVar2 = new com.google.android.libraries.navigation.internal.abj.c(latLngBounds.southwest);
        int iE = e(cVar, cVar2);
        int iD = d(cVar, cVar2);
        double dA = d > 0.0d ? a(iE, d, d3) : -1.0d;
        double dA2 = d2 > 0.0d ? a(iD, d2, d3) : -1.0d;
        if (dA < 0.0d) {
            return dA2;
        }
        return dA2 < 0.0d ? dA : Math.min(dA, dA2);
    }

    public final com.google.android.libraries.navigation.internal.abj.c c(LatLngBounds latLngBounds) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLngBounds, "LatLngBounds");
        com.google.android.libraries.navigation.internal.abj.c cVar = new com.google.android.libraries.navigation.internal.abj.c(latLngBounds.northeast);
        com.google.android.libraries.navigation.internal.abj.c cVar2 = new com.google.android.libraries.navigation.internal.abj.c(latLngBounds.southwest);
        int iE = e(cVar, cVar2);
        int iD = d(cVar, cVar2);
        int i = cVar2.a;
        int i2 = iE / 2;
        while (true) {
            i += i2;
            if (i >= -536870912) {
                break;
            }
            i2 = 1073741824;
        }
        while (i >= 536870912) {
            i -= 1073741824;
        }
        return new com.google.android.libraries.navigation.internal.abj.c(i, cVar2.b + (iD / 2));
    }
}

package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah extends ag {
    private final double d;

    public ah(CameraPosition cameraPosition, CameraPosition cameraPosition2, long j) {
        super(cameraPosition, cameraPosition2, j);
        com.google.android.libraries.navigation.internal.abf.s.k(cameraPosition2, "b");
        double dPow = 0.0d;
        if (!com.google.android.libraries.navigation.internal.abf.r.a(cameraPosition.target, cameraPosition2.target)) {
            LatLng latLng = cameraPosition.target;
            LatLng latLng2 = cameraPosition2.target;
            com.google.android.libraries.navigation.internal.abf.s.k(latLng, "a");
            com.google.android.libraries.navigation.internal.abf.s.k(latLng2, "b");
            int iE = e(latLng.longitude);
            int iD = d(latLng.latitude);
            int iE2 = e(latLng2.longitude);
            int iD2 = d(latLng2.latitude);
            int i = iE2 - iE;
            if (i > 536870912) {
                iE2 -= 1073741824;
            } else if (i < -536870912) {
                iE2 += 1073741824;
            }
            double dHypot = Math.hypot(iE - iE2, iD - iD2);
            if (dHypot / ((double) (1073741824 >> Math.min(30, Math.round((cameraPosition.zoom + cameraPosition2.zoom) * 0.5f)))) > 6.0d) {
                dPow = Math.pow(2.0d, ((Math.log(dHypot) * aj.c) * 2.39d) - 58.71d);
            }
        }
        this.d = dPow;
    }

    private static double c(double d) {
        return Math.exp((4.0d - d) / aj.c) * 10.0d;
    }

    private static int d(double d) {
        boolean z = false;
        if (d >= -90.0d && d <= 90.0d) {
            z = true;
        }
        com.google.android.libraries.navigation.internal.abf.s.b(z, "latitude: %s", Double.valueOf(d));
        return (int) Math.round(Math.log(Math.max(0.0d, Math.tan((d * 0.5d * 0.017453292519943295d) + 0.7853981633974483d))) * 1.708913188941079E8d);
    }

    private static int e(double d) {
        return (int) Math.round(d * 0.017453292519943295d * 1.708913188941079E8d);
    }

    @Override // com.google.android.libraries.navigation.internal.abn.ag
    protected final double a(double d) {
        return 1.0d - ((Math.cos(d * 3.141592653589793d) + 1.0d) * 0.5d);
    }

    @Override // com.google.android.libraries.navigation.internal.abn.ag
    protected final double b(double d, double d2, double d3) {
        double dB = aj.b(c(d), c(d2), null, d3) + (Math.pow((float) Math.sin(3.1415927410125732d * d3), 1.2d) * 0.5d * Math.pow(this.d, 0.4d));
        if (dB > 0.0d) {
            return ((-Math.log(dB * 0.1d)) * aj.c) + 4.0d;
        }
        return 32.0d;
    }
}

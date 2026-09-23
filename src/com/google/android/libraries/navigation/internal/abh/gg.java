package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gg {
    public final double a;
    public final double b;
    public final double c;

    public gg(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    public static gg b(LatLng latLng) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double dCos = Math.cos(radians);
        return new gg(Math.cos(radians2) * dCos, Math.sin(radians2) * dCos, Math.sin(radians));
    }

    public final LatLng a() {
        double d = this.a;
        if (d == 0.0d && this.b == 0.0d && this.c == 0.0d) {
            throw new ArithmeticException();
        }
        double d2 = this.c;
        double d3 = this.b;
        return new LatLng(Math.toDegrees(Math.atan2(d2, Math.sqrt((d * d) + (d3 * d3)))), Math.toDegrees((d3 == 0.0d && d == 0.0d) ? 0.0d : Math.atan2(d3, d)));
    }

    public final gg c(double d) {
        double d2 = this.c;
        return new gg(d * this.a, d * this.b, d * d2);
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.abf.aj.f(this).a("x", this.a).a("y", this.b).a("z", this.c).toString();
    }
}

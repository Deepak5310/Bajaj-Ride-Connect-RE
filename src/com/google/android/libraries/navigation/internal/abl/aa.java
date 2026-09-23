package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Point;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.libraries.navigation.internal.abh.ga;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements ga {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final CameraPosition e;
    public final int f;
    public final int g;
    public final double h;
    private final double i;
    private final Point j;

    public aa(CameraPosition cameraPosition, int i, int i2, double d, int i3, int i4, int i5, int i6) {
        com.google.android.libraries.navigation.internal.abf.s.j(cameraPosition);
        this.a = i3;
        this.b = i4;
        this.c = i5;
        this.d = i6;
        this.e = cameraPosition;
        this.f = i;
        this.g = i2;
        this.h = d;
        this.i = cameraPosition.zoom;
        this.j = new Point(i3 + (((i - i3) - i5) / 2), i4 + (((i2 - i4) - i6) / 2));
    }

    public static double d(double d, double d2) {
        return Math.pow(2.0d, d) * 256.0d * d2;
    }

    public static z f(LatLng latLng, double d, double d2) {
        if (d < 0.0d) {
            throw new IllegalArgumentException();
        }
        com.google.android.libraries.navigation.internal.abf.s.j(latLng);
        double d3 = latLng.longitude;
        double d4 = d(d, d2);
        double d5 = d4 / 2.0d;
        double dSin = Math.sin(Math.toRadians(latLng.latitude));
        return new z((long) (d5 + ((d3 / 360.0d) * d4)), (long) (d5 - (((Math.log((dSin + 1.0d) / (1.0d - dSin)) / 4.0d) / 3.141592653589793d) * d4)));
    }

    private static double g(double d) {
        return d * 6.283185307179586d;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final Point a(LatLng latLng) {
        CameraPosition cameraPosition = this.e;
        double d = this.i;
        double d2 = this.h;
        z zVarF = f(latLng, d, d2);
        z zVarF2 = f(cameraPosition.target, d, d2);
        long j = zVarF.a;
        long j2 = zVarF2.a;
        long jE = e();
        long j3 = j - j2;
        if (j3 > jE / 2) {
            j3 -= jE;
        }
        if (j3 < (-jE) / 2) {
            j3 += jE;
        }
        return new Point((int) (((long) this.j.x) + j3), (int) (((long) this.j.y) + (zVarF.b - zVarF2.b)));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final LatLng b(Point point) {
        z zVarF = f(this.e.target, this.i, this.h);
        z zVar = new z((zVarF.a - this.j.x) + ((long) point.x), (zVarF.b - ((long) this.j.y)) + ((long) point.y));
        long j = zVar.a;
        double d = d(this.i, this.h);
        double dAtan = Math.atan(Math.exp(g(((-zVar.b) / d) + 0.5d)));
        return new LatLng(Math.toDegrees((dAtan + dAtan) - 1.5707963267948966d), Math.toDegrees(g((j / d) - 0.5d)));
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ga
    public final VisibleRegion c() {
        LatLng latLngB = b(new Point(this.a, this.b));
        LatLng latLngB2 = b(new Point(this.f - this.c, this.b));
        LatLng latLngB3 = b(new Point(this.a, this.g - this.d));
        return new VisibleRegion(latLngB3, b(new Point(this.f - this.c, this.g - this.d)), latLngB, latLngB2, new LatLngBounds(latLngB3, latLngB2));
    }

    public final long e() {
        return (long) d(this.i, this.h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        if (com.google.android.libraries.navigation.internal.abf.r.a(this.e, aaVar.e)) {
            if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.f), Integer.valueOf(aaVar.f))) {
                if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.g), Integer.valueOf(aaVar.g))) {
                    if (com.google.android.libraries.navigation.internal.abf.r.a(Double.valueOf(this.h), Double.valueOf(aaVar.h))) {
                        if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.a), Integer.valueOf(aaVar.a))) {
                            if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.b), Integer.valueOf(aaVar.b))) {
                                if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.c), Integer.valueOf(aaVar.c))) {
                                    if (com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.d), Integer.valueOf(aaVar.d))) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.e, Integer.valueOf(this.f), Integer.valueOf(this.g), Double.valueOf(this.h), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }
}

package com.google.android.libraries.navigation.internal.abj;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Comparable {
    public int a;
    public int b;

    public c() {
        this(0, 0);
    }

    public c(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public c(LatLng latLng) {
        this(b.b(latLng.longitude), b.a(latLng.latitude));
    }

    public static c b(double d, double d2) {
        return new c(b.b(d2), b.a(d));
    }

    public static boolean e(c cVar, c cVar2, c cVar3) {
        int i = cVar.a;
        int i2 = cVar.b;
        int i3 = cVar2.a;
        int i4 = cVar2.b;
        int i5 = cVar3.a;
        int i6 = cVar3.b;
        if (i2 <= i6 && i4 <= i6) {
            return false;
        }
        if (i5 >= i && i5 >= i3) {
            return false;
        }
        if (i5 < i && i5 < i3) {
            return false;
        }
        int i7 = i5 - i;
        long j = i4 - i2;
        long j2 = i6 - i2;
        if (i3 >= i) {
            return ((long) i7) * j > j2 * ((long) (i3 - i));
        }
        return ((long) i7) * j < j2 * ((long) (i3 - i));
    }

    public static boolean f(c cVar, c cVar2, c cVar3, c cVar4) {
        int i = cVar2.a;
        int i2 = cVar.a;
        int i3 = i - i2;
        int i4 = cVar2.b;
        int i5 = cVar.b;
        int i6 = i4 - i5;
        int i7 = cVar4.a;
        int i8 = cVar3.a;
        int i9 = i7 - i8;
        int i10 = cVar4.b;
        int i11 = cVar3.b;
        int i12 = i10 - i11;
        int i13 = i8 - i2;
        int i14 = i11 - i5;
        long j = i12;
        long j2 = i3;
        long j3 = i9;
        long j4 = i6;
        long j5 = (j3 * j4) - (j * j2);
        if (j5 != 0) {
            long j6 = i14;
            double d = ((((long) (-i13)) * j4) + (j2 * j6)) / j5;
            if (d >= 0.0d && d <= 1.0d) {
                double d2 = ((((long) i13) * j) - (j6 * j3)) / (-j5);
                if (d2 >= 0.0d && d2 <= 1.0d) {
                    return true;
                }
            }
            return false;
        }
        if (i13 == 0) {
            if (i14 == 0) {
                return true;
            }
            i13 = 0;
        }
        if ((((long) i13) * j4) - (((long) i14) * j2) != 0) {
            return false;
        }
        if (i3 == 0 && i6 == 0) {
            return h(cVar3, cVar4, cVar);
        }
        if (i9 == 0 && i12 == 0) {
            return h(cVar, cVar2, cVar3);
        }
        return g(cVar, cVar2, cVar3) || g(cVar, cVar2, cVar4) || g(cVar3, cVar4, cVar) || g(cVar3, cVar4, cVar2);
    }

    private static boolean g(c cVar, c cVar2, c cVar3) {
        int i = cVar2.a;
        int i2 = cVar.a;
        int i3 = cVar2.b;
        int i4 = cVar.b;
        int i5 = cVar3.a - i2;
        int i6 = cVar3.b - i4;
        long j = i3 - i4;
        long j2 = i - i2;
        long j3 = (((long) i5) * j2) + (((long) i6) * j);
        if (j3 >= 0) {
            return j3 <= (j2 * j2) + (j * j);
        }
        return false;
    }

    private static boolean h(c cVar, c cVar2, c cVar3) {
        int i = cVar2.a;
        int i2 = cVar.a;
        int i3 = cVar2.b;
        int i4 = cVar.b;
        int i5 = cVar3.a - i2;
        int i6 = cVar3.b - i4;
        long j = i3 - i4;
        long j2 = i6;
        long j3 = i - i2;
        long j4 = i5;
        double dSqrt = Math.sqrt((j3 * j3) + (j * j));
        double dSqrt2 = Math.sqrt((j4 * j4) + (j2 * j2));
        if (dSqrt2 <= dSqrt) {
            return ((double) ((j3 * j4) + (j * j2))) == dSqrt * dSqrt2;
        }
        return false;
    }

    public final LatLng a() {
        double dAtan = Math.atan(Math.exp(((double) this.b) * 5.8516723170686385E-9d)) - 0.7853981633974483d;
        double degrees = Math.toDegrees(dAtan + dAtan);
        double degrees2 = Math.toDegrees(((double) this.a) * 5.8516723170686385E-9d);
        while (degrees2 > 180.0d) {
            degrees2 -= 360.0d;
        }
        while (degrees2 < -180.0d) {
            degrees2 += 360.0d;
        }
        return new LatLng(degrees, degrees2);
    }

    public final void c(c cVar) {
        d(cVar.a, cVar.b);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int i = this.a;
        int i2 = cVar.a;
        return i == i2 ? this.b - cVar.b : i - i2;
    }

    public final void d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = this.b;
        int i3 = i - i2;
        int i4 = (i2 - i3) ^ (i3 << 8);
        int i5 = i4 >> 13;
        int i6 = i5 ^ ((-i3) - i4);
        int i7 = ((i3 - i4) - i6) ^ (i6 >> 12);
        int i8 = ((i4 - i6) - i7) ^ (i7 << 16);
        int i9 = ((i6 - i7) - i8) ^ (i8 >> 5);
        int i10 = ((i7 - i8) - i9) ^ (i9 >> 3);
        int i11 = i9 - i10;
        int i12 = ((i8 - i9) - i10) ^ (i10 << 10);
        return (i12 >> 15) ^ (i11 - i12);
    }

    public final String toString() {
        return "(" + this.a + "," + this.b + ")";
    }
}

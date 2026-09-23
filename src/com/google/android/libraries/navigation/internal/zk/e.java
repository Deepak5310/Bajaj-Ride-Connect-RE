package com.google.android.libraries.navigation.internal.zk;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Serializable {
    public final double a;
    public final double b;

    public e() {
        this(0.0d, 0.0d);
    }

    private e(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public e(a aVar, a aVar2) {
        this(aVar.a, aVar2.a);
    }

    public static e d(double d, double d2) {
        return new e(a.a(d), a.a(d2));
    }

    public static e e(int i, int i2) {
        return new e(a.b(i), a.b(i2));
    }

    public final double a() {
        return this.a * 57.29577951308232d;
    }

    public final double b() {
        return this.b * 57.29577951308232d;
    }

    public final a c(e eVar) {
        double d = eVar.a;
        double d2 = this.a;
        double dSin = Math.sin((d - d2) * 0.5d);
        double dSin2 = Math.sin((eVar.b - this.b) * 0.5d);
        double dAsin = Math.asin(Math.sqrt(Math.min(1.0d, (dSin * dSin) + (dSin2 * dSin2 * Math.cos(d2) * Math.cos(d)))));
        return new a(dAsin + dAsin);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.a && this.b == eVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.a) + 646;
        long jDoubleToLongBits2 = jDoubleToLongBits + (37 * jDoubleToLongBits) + Double.doubleToLongBits(this.b);
        return (int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32));
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e(f fVar) {
        double d = fVar.i + 0.0d;
        double d2 = fVar.g;
        double d3 = fVar.h;
        this(Math.atan2(d, Math.sqrt((d2 * d2) + (d3 * d3))), Math.atan2(d3 + 0.0d, d2 + 0.0d));
    }
}

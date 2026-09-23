package com.google.android.libraries.navigation.internal.zk;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Comparable, Serializable {
    public static final f a = new f(1.0d, 0.0d, 0.0d);
    public static final f b = new f(-1.0d, 0.0d, 0.0d);
    public static final f c = new f(0.0d, 1.0d, 0.0d);
    public static final f d = new f(0.0d, -1.0d, 0.0d);
    public static final f e = new f(0.0d, 0.0d, 1.0d);
    public static final f f = new f(0.0d, 0.0d, -1.0d);
    final double g;
    final double h;
    final double i;

    public f() {
        this(0.0d, 0.0d, 0.0d);
    }

    public f(double d2, double d3, double d4) {
        this.g = d2;
        this.h = d3;
        this.i = d4;
    }

    public static final f b(f fVar) {
        double d2 = fVar.i;
        double d3 = fVar.h;
        double d4 = fVar.g;
        double dSqrt = Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
        if (dSqrt != 0.0d) {
            dSqrt = 1.0d / dSqrt;
        }
        return new f(dSqrt * d4, dSqrt * d3, dSqrt * d2);
    }

    public final double a(f fVar) {
        double d2 = this.i - fVar.i;
        double d3 = this.h - fVar.h;
        double d4 = this.g - fVar.g;
        return Math.sqrt((d4 * d4) + (d3 * d3) + (d2 * d2));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        double d2 = fVar.g;
        double d3 = this.g;
        int i = -1;
        if (d3 >= d2) {
            if (d2 < d3) {
                i = 1;
                if (d3 != d2 && this.h == fVar.h && this.i == fVar.i) {
                    return 0;
                }
            } else {
                double d4 = this.h;
                double d5 = fVar.h;
                if (d4 >= d5 && (d5 < d4 || this.i >= fVar.i)) {
                    i = 1;
                    if (d3 != d2) {
                    }
                }
            }
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.g == fVar.g && this.h == fVar.h && this.i == fVar.i;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(Math.abs(this.g)) + 646;
        long jDoubleToLongBits2 = jDoubleToLongBits + (jDoubleToLongBits * 37) + Double.doubleToLongBits(Math.abs(this.h));
        long jDoubleToLongBits3 = jDoubleToLongBits2 + (37 * jDoubleToLongBits2) + Double.doubleToLongBits(Math.abs(this.i));
        return (int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32));
    }

    public final String toString() {
        return "(" + this.g + ", " + this.h + ", " + this.i + ")";
    }
}

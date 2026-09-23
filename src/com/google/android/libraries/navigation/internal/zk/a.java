package com.google.android.libraries.navigation.internal.zk;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Comparable, Serializable {
    public final double a;

    public a() {
        this(0.0d);
    }

    public a(double d) {
        this.a = d;
    }

    public static a a(double d) {
        return new a(d * 0.017453292519943295d);
    }

    public static a b(int i) {
        return a(((double) i) * 1.0E-7d);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        double d = ((a) obj).a;
        double d2 = this.a;
        if (d2 < d) {
            return -1;
        }
        return d2 <= d ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.a);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final String toString() {
        return (this.a * 57.29577951308232d) + "d";
    }
}

package com.google.android.libraries.navigation.internal.zy;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends Number implements Comparable, Serializable {
    public static final n a;
    public final long b;

    static {
        new n(0L);
        new n(1L);
        a = new n(-1L);
    }

    public n(long j) {
        this.b = j;
    }

    public static n a(String str) {
        return new n(p.c(str, 16));
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        ar.q(nVar);
        return p.a(this.b, nVar.b);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        long j = this.b;
        if (j >= 0) {
            return j;
        }
        double d = (j & 1) | (j >>> 1);
        return d + d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof n) && this.b == ((n) obj).b;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        long j = this.b;
        if (j >= 0) {
            return j;
        }
        float f = (j & 1) | (j >>> 1);
        return f + f;
    }

    public final int hashCode() {
        return k.a(this.b);
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) this.b;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.b;
    }

    public final String toString() {
        ar.d(true, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", 10);
        long j = this.b;
        if (j == 0) {
            return "0";
        }
        if (j > 0) {
            return Long.toString(j, 10);
        }
        long j2 = (j >>> 1) / 5;
        char[] cArr = new char[64];
        int i = 63;
        cArr[63] = Character.forDigit((int) (j - (j2 * 10)), 10);
        while (j2 > 0) {
            i--;
            cArr[i] = Character.forDigit((int) (j2 % 10), 10);
            j2 /= 10;
        }
        return new String(cArr, i, 64 - i);
    }
}

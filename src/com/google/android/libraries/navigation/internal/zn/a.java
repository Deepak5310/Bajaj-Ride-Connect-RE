package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a {
    public final char[] a;
    final int b;
    final int c;
    final int d;
    final int e;
    public final byte[] f;
    private final String g;
    private final boolean[] h;
    private final boolean i;

    /* JADX WARN: Illegal instructions before constructor call */
    public a(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            boolean z = true;
            ar.c(c < 128, "Non-ASCII character: %s", c);
            if (bArr[c] != -1) {
                z = false;
            }
            ar.c(z, "Duplicate character: %s", c);
            bArr[c] = (byte) i;
        }
        this(str, cArr, bArr);
    }

    final char a(int i) {
        return this.a[i];
    }

    final int b(char c) throws d {
        if (c > 127) {
            throw new d("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        byte b = this.f[c];
        if (b != -1) {
            return b;
        }
        if (c <= ' ' || c == 127) {
            throw new d("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        throw new d("Unrecognized character: " + c);
    }

    final boolean c(int i) {
        return this.h[i % this.d];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            boolean z = aVar.i;
            if (Arrays.equals(this.a, aVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a) + 1237;
    }

    public final String toString() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065 A[LOOP:0: B:18:0x0061->B:20:0x0065, LOOP_END] */
    private a(String str, char[] cArr, byte[] bArr) {
        int iNumberOfLeadingZeros;
        boolean[] zArr;
        int i;
        this.g = str;
        ar.q(cArr);
        this.a = cArr;
        try {
            int length = cArr.length;
            RoundingMode roundingMode = RoundingMode.UNNECESSARY;
            if (length > 0) {
                switch (com.google.android.libraries.navigation.internal.zw.d.a[roundingMode.ordinal()]) {
                    case 1:
                        com.google.android.libraries.navigation.internal.zw.h.c(((length + (-1)) & length) == 0);
                    case 2:
                    case 3:
                        iNumberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(length);
                        this.c = iNumberOfLeadingZeros;
                        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iNumberOfLeadingZeros);
                        int i2 = 1 << (3 - iNumberOfTrailingZeros);
                        this.d = i2;
                        this.e = iNumberOfLeadingZeros >> iNumberOfTrailingZeros;
                        this.b = length - 1;
                        this.f = bArr;
                        zArr = new boolean[i2];
                        for (i = 0; i < this.e; i++) {
                            zArr[com.google.android.libraries.navigation.internal.zw.e.a(i * 8, this.c, RoundingMode.CEILING)] = true;
                        }
                        this.h = zArr;
                        this.i = false;
                        return;
                    case 4:
                    case 5:
                        iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(length - 1);
                        this.c = iNumberOfLeadingZeros;
                        int iNumberOfTrailingZeros2 = Integer.numberOfTrailingZeros(iNumberOfLeadingZeros);
                        int i3 = 1 << (3 - iNumberOfTrailingZeros2);
                        this.d = i3;
                        this.e = iNumberOfLeadingZeros >> iNumberOfTrailingZeros2;
                        this.b = length - 1;
                        this.f = bArr;
                        zArr = new boolean[i3];
                        while (i < this.e) {
                            zArr[com.google.android.libraries.navigation.internal.zw.e.a(i * 8, this.c, RoundingMode.CEILING)] = true;
                        }
                        this.h = zArr;
                        this.i = false;
                        return;
                    case 6:
                    case 7:
                    case 8:
                        int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(length);
                        iNumberOfLeadingZeros = (31 - iNumberOfLeadingZeros2) + ((((-1257966797) >>> iNumberOfLeadingZeros2) - length) >>> 31);
                        this.c = iNumberOfLeadingZeros;
                        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(iNumberOfLeadingZeros);
                        int i4 = 1 << (3 - iNumberOfTrailingZeros3);
                        this.d = i4;
                        this.e = iNumberOfLeadingZeros >> iNumberOfTrailingZeros3;
                        this.b = length - 1;
                        this.f = bArr;
                        zArr = new boolean[i4];
                        while (i < this.e) {
                            zArr[com.google.android.libraries.navigation.internal.zw.e.a(i * 8, this.c, RoundingMode.CEILING)] = true;
                        }
                        this.h = zArr;
                        this.i = false;
                        return;
                    default:
                        throw new AssertionError();
                }
            } else {
                throw new IllegalArgumentException("x (0) must be > 0");
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }
}

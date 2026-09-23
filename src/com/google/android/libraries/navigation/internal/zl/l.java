package com.google.android.libraries.navigation.internal.zl;

import com.google.common.base.Ascii;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public abstract int a();

    public abstract int b();

    public abstract long c();

    public abstract boolean d(l lVar);

    public abstract byte[] e();

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (b() == lVar.b() && d(lVar)) {
                return true;
            }
        }
        return false;
    }

    public byte[] f() {
        return e();
    }

    public final int hashCode() {
        if (b() >= 32) {
            return a();
        }
        byte[] bArrF = f();
        int i = bArrF[0] & 255;
        for (int i2 = 1; i2 < bArrF.length; i2++) {
            i |= (bArrF[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] bArrF = f();
        int length = bArrF.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArrF) {
            char[] cArr = a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }
}

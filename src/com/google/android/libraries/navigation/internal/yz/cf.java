package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf {
    static int a(int i, int i2) {
        return i & (~i2);
    }

    static int b(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    static int c(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    static int d(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iB = eh.b(obj);
        int i2 = iB & i;
        int iE = e(obj3, i2);
        if (iE == 0) {
            return -1;
        }
        int iA = a(iB, i);
        int i3 = -1;
        while (true) {
            int i4 = iE - 1;
            int i5 = iArr[i4];
            int i6 = i5 & i;
            if (a(i5, i) == iA && com.google.android.libraries.navigation.internal.yx.am.a(obj, objArr[i4]) && (objArr2 == null || com.google.android.libraries.navigation.internal.yx.am.a(obj2, objArr2[i4]))) {
                if (i3 == -1) {
                    i(obj3, i2, i6);
                } else {
                    iArr[i3] = b(iArr[i3], i6, i);
                }
                return i4;
            }
            if (i6 == 0) {
                return -1;
            }
            i3 = i4;
            iE = i6;
        }
    }

    static int e(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    static int f(int i) {
        return Math.max(4, eh.c(i + 1));
    }

    static Object g(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i <= 256) {
            return new byte[i];
        }
        return i <= 65536 ? new short[i] : new int[i];
    }

    static void h(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static void i(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}

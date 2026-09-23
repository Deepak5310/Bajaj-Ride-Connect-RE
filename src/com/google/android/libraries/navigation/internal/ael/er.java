package com.google.android.libraries.navigation.internal.ael;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class er {
    private static final eo a;

    static {
        if (em.b && em.a) {
            int i = g.a;
        }
        a = new ep();
    }

    static int a(String str, byte[] bArr, int i, int i2) {
        return a.a(str, bArr, i, i2);
    }

    static int b(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= 2048) {
                int length2 = str.length();
                while (i2 < length2) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) < 65536) {
                                throw new eq(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                break;
            }
            i3 += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    public static int c(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int d(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int e(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static int f(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte b = bArr[i - 1];
        if (i3 == 0) {
            return c(b);
        }
        if (i3 == 1) {
            return d(b, bArr[i]);
        }
        if (i3 == 2) {
            return e(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    static String g(ByteBuffer byteBuffer, int i, int i2) throws cc {
        eo eoVar = a;
        if (byteBuffer.hasArray()) {
            return eoVar.b(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return byteBuffer.isDirect() ? eoVar.c(byteBuffer, i, i2) : eo.d(byteBuffer, i, i2);
    }

    static String h(byte[] bArr, int i, int i2) throws cc {
        return a.b(bArr, i, i2);
    }

    static boolean i(byte[] bArr, int i, int i2) {
        return a.e(bArr, i, i2) == 0;
    }
}

package com.google.android.libraries.navigation.internal.ael;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class eo {
    static final String d(ByteBuffer byteBuffer, int i, int i2) throws cc {
        int i3;
        if ((((byteBuffer.limit() - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = byteBuffer.get(i);
            if (!en.e(b)) {
                break;
            }
            i++;
            en.b(b, cArr, i5);
            i5++;
        }
        int i6 = i5;
        while (i < i4) {
            int i7 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (en.e(b2)) {
                en.b(b2, cArr, i6);
                i6++;
                i = i7;
                while (i < i4) {
                    byte b3 = byteBuffer.get(i);
                    if (!en.e(b3)) {
                        break;
                    }
                    i++;
                    en.b(b3, cArr, i6);
                    i6++;
                }
            } else {
                if (en.g(b2)) {
                    if (i7 >= i4) {
                        throw new cc("Protocol message had invalid UTF-8.");
                    }
                    i3 = i6 + 1;
                    i += 2;
                    en.d(b2, byteBuffer.get(i7), cArr, i6);
                } else if (en.f(b2)) {
                    if (i7 >= i4 - 1) {
                        throw new cc("Protocol message had invalid UTF-8.");
                    }
                    i3 = i6 + 1;
                    int i8 = i + 2;
                    i += 3;
                    en.c(b2, byteBuffer.get(i7), byteBuffer.get(i8), cArr, i6);
                } else {
                    if (i7 >= i4 - 2) {
                        throw new cc("Protocol message had invalid UTF-8.");
                    }
                    byte b4 = byteBuffer.get(i7);
                    int i9 = i + 3;
                    byte b5 = byteBuffer.get(i + 2);
                    i += 4;
                    en.a(b2, b4, b5, byteBuffer.get(i9), cArr, i6);
                    i6 += 2;
                }
                i6 = i3;
            }
        }
        return new String(cArr, 0, i6);
    }

    public abstract int a(String str, byte[] bArr, int i, int i2);

    public abstract String b(byte[] bArr, int i, int i2) throws cc;

    public abstract String c(ByteBuffer byteBuffer, int i, int i2) throws cc;

    public abstract int e(byte[] bArr, int i, int i2);
}

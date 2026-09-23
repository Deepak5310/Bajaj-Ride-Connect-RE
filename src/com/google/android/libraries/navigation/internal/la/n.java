package com.google.android.libraries.navigation.internal.la;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static long a(byte[] bArr) {
        int length = bArr.length;
        int i = 37;
        char c = 0;
        if (length <= 32) {
            if (length > 16) {
                long jD = d(bArr, 0) * (-5435081209227447693L);
                long jD2 = d(bArr, 8);
                long j = ((long) (length + length)) - 7286425919675154353L;
                long jD3 = d(bArr, length - 8) * j;
                return c(Long.rotateRight(jD + jD2, 43) + Long.rotateRight(jD3, 30) + (d(bArr, length - 16) * (-7286425919675154353L)), jD + Long.rotateRight(jD2 - 7286425919675154353L, 18) + jD3, j);
            }
            if (length >= 8) {
                long j2 = ((long) (length + length)) - 7286425919675154353L;
                long jD4 = d(bArr, 0) - 7286425919675154353L;
                long jD5 = d(bArr, length - 8);
                return c((Long.rotateRight(jD5, 37) * j2) + jD4, (Long.rotateRight(jD4, 25) + jD5) * j2, j2);
            }
            if (length >= 4) {
                return c(((long) length) + ((((long) b(bArr, 0)) & 4294967295L) << 3), ((long) b(bArr, length - 4)) & 4294967295L, ((long) (length + length)) - 7286425919675154353L);
            }
            if (length <= 0) {
                return -7286425919675154353L;
            }
            return (-7286425919675154353L) * e((((long) ((bArr[0] & 255) + ((bArr[length >> 1] & 255) << 8))) * (-7286425919675154353L)) ^ (((long) (length + ((bArr[length - 1] & 255) << 2))) * (-4348849565147123417L)));
        }
        int i2 = 64;
        if (length <= 64) {
            long jD6 = d(bArr, 0) * (-7286425919675154353L);
            long jD7 = d(bArr, 8);
            long j3 = ((long) (length + length)) - 7286425919675154353L;
            long jD8 = d(bArr, length - 8) * j3;
            long jD9 = d(bArr, length - 16) * (-7286425919675154353L);
            long jRotateRight = Long.rotateRight(jD6 + jD7, 43) + Long.rotateRight(jD8, 30);
            long jRotateRight2 = Long.rotateRight(jD7 - 7286425919675154353L, 18) + jD6;
            long jD10 = d(bArr, 16) * j3;
            long jD11 = d(bArr, 24);
            long j4 = jRotateRight + jD9;
            long jD12 = j4 + d(bArr, length - 32);
            long j5 = jD12 * j3;
            return c(Long.rotateRight(jD10 + jD11, 43) + Long.rotateRight(j5, 30) + ((c(j4, jRotateRight2 + jD8, j3) + d(bArr, length - 24)) * j3), jD10 + Long.rotateRight(jD11 + jD6, 18) + j5, j3);
        }
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jD13 = d(bArr, 0) + 95310865018149119L;
        long jE = e(-7956866745689871395L) * (-7286425919675154353L);
        long j6 = 2480279821605975764L;
        int i3 = 0;
        while (true) {
            int i4 = length - 1;
            int i5 = (i4 >> 6) * i2;
            long jRotateRight3 = Long.rotateRight(jD13 + j6 + jArr[c] + d(bArr, i3 + 8), i) * (-5435081209227447693L);
            long jRotateRight4 = Long.rotateRight(j6 + jArr[1] + d(bArr, i3 + 48), 42) * (-5435081209227447693L);
            long j7 = jRotateRight3 ^ jArr2[1];
            long jD14 = jArr[c] + d(bArr, i3 + 40);
            long j8 = jArr2[c];
            long jRotateRight5 = Long.rotateRight(jE + j8, 33) * (-5435081209227447693L);
            char c2 = c;
            f(bArr, i3, jArr[1] * (-5435081209227447693L), j7 + j8, jArr);
            long j9 = jRotateRight4 + jD14;
            f(bArr, i3 + 32, jRotateRight5 + jArr2[1], d(bArr, i3 + 16) + j9, jArr2);
            int i6 = i3 + 64;
            if (i6 == i5) {
                int i7 = i4 & 63;
                int i8 = i5 + i7;
                long j10 = j7 & 255;
                long j11 = (j10 + j10) - 5435081209227447693L;
                long j12 = jArr2[c2] + ((long) i7);
                long j13 = jArr[c2] + j12;
                jArr[c2] = j13;
                jArr2[c2] = j12 + j13;
                long jRotateRight6 = Long.rotateRight(jRotateRight5 + j9 + j13 + d(bArr, i8 - 55), 37) * j11;
                long jRotateRight7 = Long.rotateRight(j9 + jArr[1] + d(bArr, i8 - 15), 42) * j11;
                long j14 = jArr2[1] * 9;
                long jD15 = (jArr[c2] * 9) + d(bArr, i8 - 23);
                long j15 = jArr2[c2];
                long jRotateRight8 = Long.rotateRight(j7 + j15, 33) * j11;
                long j16 = jRotateRight6 ^ j14;
                f(bArr, i8 - 63, jArr[1] * j11, j16 + j15, jArr);
                long j17 = jRotateRight7 + jD15;
                f(bArr, i8 - 31, jArr2[1] + jRotateRight8, j17 + d(bArr, i8 - 47), jArr2);
                return c(c(jArr[c2], jArr2[c2], j11) + (e(j17) * (-4348849565147123417L)) + j16, c(jArr[1], jArr2[1], j11) + jRotateRight8, j11);
            }
            i3 = i6;
            jE = j7;
            i2 = 64;
            c = c2;
            jD13 = jRotateRight5;
            i = 37;
            j6 = j9;
        }
    }

    private static int b(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    private static long c(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long d(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferWrap.getLong();
    }

    private static long e(long j) {
        return j ^ (j >>> 47);
    }

    private static void f(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jD = j + d(bArr, i);
        long jD2 = d(bArr, i + 8);
        long jD3 = d(bArr, i + 16);
        long jD4 = d(bArr, i + 24);
        long j3 = jD2 + jD + jD3;
        long jRotateRight = Long.rotateRight(j2 + jD + jD4, 21) + Long.rotateRight(j3, 44);
        jArr[0] = j3 + jD4;
        jArr[1] = jRotateRight + jD;
    }
}

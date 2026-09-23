package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends f {
    public static final m a = new h();

    private static long f(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    private static long g(long j) {
        return j ^ (j >>> 47);
    }

    private static void h(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jB = j + t.b(bArr, i);
        long jB2 = t.b(bArr, i + 8);
        long jB3 = t.b(bArr, i + 16);
        long jB4 = t.b(bArr, i + 24);
        long j3 = jB2 + jB + jB3;
        long jRotateRight = Long.rotateRight(j2 + jB + jB4, 21) + Long.rotateRight(j3, 44);
        jArr[0] = j3 + jB4;
        jArr[1] = jRotateRight + jB;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.b
    public final l d(byte[] bArr, int i) {
        int i2;
        int i3;
        long j;
        long jRotateRight;
        long[] jArr;
        long[] jArr2;
        long j2;
        char c = 0;
        ar.j(0, i, bArr.length);
        long jF = -7286425919675154353L;
        if (i > 32) {
            char c2 = '@';
            if (i <= 64) {
                long jB = t.b(bArr, 0) * (-7286425919675154353L);
                long jB2 = t.b(bArr, 8);
                long j3 = i;
                long j4 = (j3 + j3) - 7286425919675154353L;
                long jB3 = t.b(bArr, i - 8) * j4;
                long jB4 = t.b(bArr, i - 16) * (-7286425919675154353L);
                long jRotateRight2 = Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30);
                long jRotateRight3 = Long.rotateRight(jB2 - 7286425919675154353L, 18) + jB;
                long jB5 = t.b(bArr, 16) * j4;
                long jB6 = t.b(bArr, 24);
                long j5 = jRotateRight2 + jB4;
                long jB7 = j5 + t.b(bArr, i - 32);
                long jF2 = f(j5, jRotateRight3 + jB3, j4) + t.b(bArr, i - 24);
                long j6 = jB7 * j4;
                jF = f(Long.rotateRight(jB5 + jB6, 43) + Long.rotateRight(j6, 30) + (jF2 * j4), jB5 + Long.rotateRight(jB6 + jB, 18) + j6, j4);
            } else {
                long[] jArr3 = new long[2];
                long[] jArr4 = new long[2];
                long jB8 = t.b(bArr, 0) + 95310865018149119L;
                long jG = g(-7956866745689871395L) * (-7286425919675154353L);
                long j7 = 2480279821605975764L;
                int i4 = 0;
                while (true) {
                    i2 = i - 1;
                    i3 = (i2 >> 6) * 64;
                    long jRotateRight4 = Long.rotateRight(jB8 + j7 + jArr3[c] + t.b(bArr, i4 + 8), 37) * (-5435081209227447693L);
                    long jRotateRight5 = Long.rotateRight(j7 + jArr3[1] + t.b(bArr, i4 + 48), 42) * (-5435081209227447693L);
                    j = jRotateRight4 ^ jArr4[1];
                    long jB9 = jArr3[c] + t.b(bArr, i4 + 40);
                    long j8 = jArr4[c];
                    jRotateRight = Long.rotateRight(jG + j8, 33) * (-5435081209227447693L);
                    char c3 = c2;
                    jArr = jArr4;
                    jArr2 = jArr3;
                    h(bArr, i4, jArr3[1] * (-5435081209227447693L), j + j8, jArr3);
                    j2 = jRotateRight5 + jB9;
                    h(bArr, i4 + 32, jArr[1] + jRotateRight, j2 + t.b(bArr, i4 + 16), jArr);
                    int i5 = i4 + 64;
                    if (i5 == i3) {
                        break;
                    }
                    i4 = i5;
                    jB8 = jRotateRight;
                    jArr4 = jArr;
                    jG = j;
                    j7 = j2;
                    jArr3 = jArr2;
                    c2 = c3;
                    c = 0;
                }
                int i6 = i2 & 63;
                int i7 = i3 + i6;
                long j9 = j & 255;
                long j10 = (-5435081209227447693L) + j9 + j9;
                long j11 = jArr[0] + ((long) i6);
                long j12 = jArr2[0] + j11;
                jArr2[0] = j12;
                jArr[0] = j11 + j12;
                long jRotateRight6 = Long.rotateRight(jRotateRight + j2 + j12 + t.b(bArr, i7 - 55), 37) * j10;
                long jRotateRight7 = Long.rotateRight(j2 + jArr2[1] + t.b(bArr, i7 - 15), 42) * j10;
                long j13 = jArr[1] * 9;
                long jB10 = t.b(bArr, i7 - 23) + (jArr2[0] * 9);
                long j14 = jArr[0];
                long jRotateRight8 = Long.rotateRight(j + j14, 33) * j10;
                long j15 = jRotateRight6 ^ j13;
                h(bArr, i7 - 63, jArr2[1] * j10, j15 + j14, jArr2);
                long j16 = jRotateRight7 + jB10;
                h(bArr, i7 - 31, jArr[1] + jRotateRight8, t.b(bArr, i7 - 47) + j16, jArr);
                jF = f(f(jArr2[0], jArr[0], j10) + (g(j16) * (-4348849565147123417L)) + j15, f(jArr2[1], jArr[1], j10) + jRotateRight8, j10);
            }
        } else if (i > 16) {
            long jB11 = t.b(bArr, 0) * (-5435081209227447693L);
            long jB12 = t.b(bArr, 8);
            long j17 = i;
            long j18 = (j17 + j17) - 7286425919675154353L;
            long jB13 = t.b(bArr, i - 8) * j18;
            jF = f(Long.rotateRight(jB11 + jB12, 43) + Long.rotateRight(jB13, 30) + (t.b(bArr, i - 16) * (-7286425919675154353L)), jB11 + Long.rotateRight(jB12 - 7286425919675154353L, 18) + jB13, j18);
        } else if (i >= 8) {
            long j19 = i;
            long j20 = (j19 + j19) - 7286425919675154353L;
            long jB14 = t.b(bArr, 0) - 7286425919675154353L;
            long jB15 = t.b(bArr, i - 8);
            jF = f(jB14 + (Long.rotateRight(jB15, 37) * j20), (Long.rotateRight(jB14, 25) + jB15) * j20, j20);
        } else if (i >= 4) {
            jF = f(((((long) t.a(bArr, 0)) & 4294967295L) << 3) + ((long) i), ((long) t.a(bArr, i - 4)) & 4294967295L, ((long) (i + i)) - 7286425919675154353L);
        } else if (i > 0) {
            jF = (-7286425919675154353L) * g((((long) ((bArr[0] & 255) + ((bArr[i >> 1] & 255) << 8))) * (-7286425919675154353L)) ^ (((long) (((bArr[i - 1] & 255) << 2) + i)) * (-4348849565147123417L)));
        }
        return new k(jF);
    }

    public final String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}

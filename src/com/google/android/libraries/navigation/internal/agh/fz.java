package com.google.android.libraries.navigation.internal.agh;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fz {
    public static final long[] a = new long[0];
    public static final long[] b = new long[0];

    public static void a(long[] jArr, int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.b(jArr.length, i, i2);
    }

    public static void b(long[] jArr, int i, int i2, gk gkVar, long[] jArr2) {
        int i3 = i2 - i;
        if (i3 >= 16) {
            if (jArr2 == null) {
                jArr2 = Arrays.copyOf(jArr, i2);
            }
            int i4 = (i + i2) >>> 1;
            b(jArr2, i, i4, gkVar, jArr);
            b(jArr2, i4, i2, gkVar, jArr);
            if (gkVar.a(jArr2[i4 - 1], jArr2[i4]) <= 0) {
                System.arraycopy(jArr2, i, jArr, i, i3);
                return;
            }
            int i5 = i;
            int i6 = i4;
            while (i < i2) {
                if (i6 >= i2 || (i5 < i4 && gkVar.a(jArr2[i5], jArr2[i6]) <= 0)) {
                    jArr[i] = jArr2[i5];
                    i5++;
                } else {
                    jArr[i] = jArr2[i6];
                    i6++;
                }
                i++;
            }
            return;
        }
        int i7 = i;
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= i2) {
                return;
            }
            long j = jArr[i8];
            long j2 = jArr[i7];
            int i9 = i8;
            while (gkVar.a(j, j2) < 0) {
                jArr[i9] = j2;
                int i10 = i9 - 1;
                if (i == i10) {
                    i9 = i10;
                    break;
                } else {
                    long j3 = jArr[i9 - 2];
                    i9 = i10;
                    j2 = j3;
                }
            }
            jArr[i9] = j;
            i7 = i8;
        }
    }

    public static void c(long[] jArr, int i, int i2) {
        int iH;
        int iH2;
        int i3 = i2 - i;
        if (i3 < 16) {
            int i4 = i2 - 1;
            while (i < i4) {
                int i5 = i + 1;
                int i6 = i;
                for (int i7 = i5; i7 < i2; i7++) {
                    if (jArr[i7] < jArr[i6]) {
                        i6 = i7;
                    }
                }
                if (i6 != i) {
                    long j = jArr[i];
                    jArr[i] = jArr[i6];
                    jArr[i6] = j;
                }
                i = i5;
            }
            return;
        }
        int i8 = i2 - 1;
        int iH3 = (i3 >> 1) + i;
        if (i3 > 128) {
            int i9 = i3 >> 3;
            int i10 = i9 + i9;
            iH = h(jArr, i, i + i9, i + i10);
            iH3 = h(jArr, iH3 - i9, iH3, iH3 + i9);
            iH2 = h(jArr, i8 - i10, i8 - i9, i8);
        } else {
            iH = i;
            iH2 = i8;
        }
        long j2 = jArr[h(jArr, iH, iH3, iH2)];
        int i11 = i;
        int i12 = i11;
        int i13 = i8;
        while (true) {
            if (i11 <= i8) {
                int iCompare = Long.compare(jArr[i11], j2);
                if (iCompare <= 0) {
                    if (iCompare == 0) {
                        d(jArr, i12, i11);
                        i12++;
                    }
                    i11++;
                }
            }
            while (i8 >= i11) {
                int iCompare2 = Long.compare(jArr[i8], j2);
                if (iCompare2 < 0) {
                    break;
                }
                if (iCompare2 == 0) {
                    d(jArr, i8, i13);
                    i13--;
                }
                i8--;
            }
            if (i11 > i8) {
                break;
            }
            d(jArr, i11, i8);
            i11++;
            i8--;
        }
        int i14 = i11 - i12;
        int iMin = Math.min(i12 - i, i14);
        e(jArr, i, i11 - iMin, iMin);
        int i15 = i13 - i8;
        int iMin2 = Math.min(i15, (i2 - i13) - 1);
        e(jArr, i11, i2 - iMin2, iMin2);
        if (i14 > 1) {
            c(jArr, i, i14 + i);
        }
        if (i15 > 1) {
            c(jArr, i2 - i15, i2);
        }
    }

    public static void d(long[] jArr, int i, int i2) {
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
    }

    public static void e(long[] jArr, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            d(jArr, i, i2);
            i++;
            i2++;
        }
    }

    public static void f(long[] jArr, int i, gk gkVar) {
        b(jArr, 0, i, gkVar, null);
    }

    public static void g(long[] jArr, int i) {
        int i2;
        int i3 = 0;
        if (i < 4000) {
            c(jArr, 0, i);
            return;
        }
        int[] iArr = new int[1786];
        int[] iArr2 = new int[1786];
        int[] iArr3 = new int[1786];
        iArr[0] = 0;
        iArr2[0] = i;
        iArr3[0] = 0;
        int i4 = 256;
        int[] iArr4 = new int[256];
        int[] iArr5 = new int[256];
        int i5 = 1;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int i7 = iArr[i6];
            int i8 = iArr2[i6];
            int i9 = iArr3[i6];
            int i10 = i9 % 8;
            int i11 = i10 == 0 ? 128 : i3;
            int i12 = (7 - i10) * 8;
            int i13 = i8 + i7;
            int i14 = i13;
            while (true) {
                int i15 = i14 - 1;
                if (i14 == i7) {
                    break;
                }
                int i16 = (int) (((jArr[i15] >>> i12) & 255) ^ ((long) i11));
                iArr4[i16] = iArr4[i16] + i5;
                i14 = i15;
                iArr = iArr;
            }
            int[] iArr6 = iArr;
            int i17 = -1;
            int i18 = i7;
            for (int i19 = 0; i19 < i4; i19++) {
                int i20 = iArr4[i19];
                if (i20 != 0) {
                    i17 = i19;
                }
                i18 += i20;
                iArr5[i19] = i18;
            }
            int i21 = i13 - iArr4[i17];
            while (i7 <= i21) {
                int[] iArr7 = iArr3;
                long j = i11;
                long j2 = jArr[i7];
                int i22 = i6;
                int i23 = (int) (((j2 >>> i12) & 255) ^ j);
                if (i7 < i21) {
                    while (true) {
                        int i24 = iArr5[i23] - 1;
                        iArr5[i23] = i24;
                        if (i24 <= i7) {
                            break;
                        }
                        long j3 = jArr[i24];
                        jArr[i24] = j2;
                        i23 = (int) (((j3 >>> i12) & 255) ^ j);
                        j2 = j3;
                    }
                    jArr[i7] = j2;
                }
                if (i9 < 7) {
                    int i25 = iArr4[i23];
                    i2 = 1;
                    if (i25 > 1) {
                        if (i25 < 1024) {
                            c(jArr, i7, i25 + i7);
                        } else {
                            iArr6[i22] = i7;
                            iArr2[i22] = i25;
                            i6 = i22 + 1;
                            iArr7[i22] = i9 + 1;
                        }
                    }
                    i7 += iArr4[i23];
                    iArr4[i23] = 0;
                    i5 = i2;
                    iArr3 = iArr7;
                    i4 = 256;
                } else {
                    i2 = 1;
                }
                i6 = i22;
                i7 += iArr4[i23];
                iArr4[i23] = 0;
                i5 = i2;
                iArr3 = iArr7;
                i4 = 256;
            }
            i3 = 0;
            iArr = iArr6;
        }
    }

    private static int h(long[] jArr, int i, int i2, int i3) {
        long j = jArr[i];
        long j2 = jArr[i2];
        int iCompare = Long.compare(j, j2);
        long j3 = jArr[i3];
        int iCompare2 = Long.compare(j, j3);
        int iCompare3 = Long.compare(j2, j3);
        if (iCompare < 0) {
            if (iCompare3 >= 0) {
                return iCompare2 >= 0 ? i : i3;
            }
        } else if (iCompare3 <= 0) {
            return iCompare2 <= 0 ? i : i3;
        }
        return i2;
    }
}

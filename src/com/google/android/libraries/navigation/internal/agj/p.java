package com.google.android.libraries.navigation.internal.agj;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static final short[] a = new short[0];
    public static final short[] b = new short[0];

    public static void a(short[] sArr, int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.b(sArr.length, i, i2);
    }

    public static void b(short[] sArr, int i, int i2, x xVar, short[] sArr2) {
        int i3 = i2 - i;
        if (i3 >= 16) {
            if (sArr2 == null) {
                sArr2 = Arrays.copyOf(sArr, i2);
            }
            int i4 = (i + i2) >>> 1;
            b(sArr2, i, i4, xVar, sArr);
            b(sArr2, i4, i2, xVar, sArr);
            if (xVar.b(sArr2[i4 - 1], sArr2[i4]) <= 0) {
                System.arraycopy(sArr2, i, sArr, i, i3);
                return;
            }
            int i5 = i;
            int i6 = i4;
            while (i < i2) {
                if (i6 >= i2 || (i5 < i4 && xVar.b(sArr2[i5], sArr2[i6]) <= 0)) {
                    sArr[i] = sArr2[i5];
                    i5++;
                } else {
                    sArr[i] = sArr2[i6];
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
            short s = sArr[i8];
            short s2 = sArr[i7];
            int i9 = i8;
            while (xVar.b(s, s2) < 0) {
                sArr[i9] = s2;
                int i10 = i9 - 1;
                if (i == i10) {
                    i9 = i10;
                    break;
                } else {
                    short s3 = sArr[i9 - 2];
                    i9 = i10;
                    s2 = s3;
                }
            }
            sArr[i9] = s;
            i7 = i8;
        }
    }

    public static void c(short[] sArr, int i, int i2) {
        int iH;
        int iH2;
        int i3 = i2 - i;
        if (i3 < 16) {
            int i4 = i2 - 1;
            while (i < i4) {
                int i5 = i + 1;
                int i6 = i;
                for (int i7 = i5; i7 < i2; i7++) {
                    if (sArr[i7] < sArr[i6]) {
                        i6 = i7;
                    }
                }
                if (i6 != i) {
                    short s = sArr[i];
                    sArr[i] = sArr[i6];
                    sArr[i6] = s;
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
            iH = h(sArr, i, i + i9, i + i10);
            iH3 = h(sArr, iH3 - i9, iH3, iH3 + i9);
            iH2 = h(sArr, i8 - i10, i8 - i9, i8);
        } else {
            iH = i;
            iH2 = i8;
        }
        short s2 = sArr[h(sArr, iH, iH3, iH2)];
        int i11 = i;
        int i12 = i11;
        int i13 = i8;
        while (true) {
            if (i11 <= i8) {
                int iCompare = Short.compare(sArr[i11], s2);
                if (iCompare <= 0) {
                    if (iCompare == 0) {
                        d(sArr, i12, i11);
                        i12++;
                    }
                    i11++;
                }
            }
            while (i8 >= i11) {
                int iCompare2 = Short.compare(sArr[i8], s2);
                if (iCompare2 < 0) {
                    break;
                }
                if (iCompare2 == 0) {
                    d(sArr, i8, i13);
                    i13--;
                }
                i8--;
            }
            if (i11 > i8) {
                break;
            }
            d(sArr, i11, i8);
            i11++;
            i8--;
        }
        int i14 = i12 - i;
        int i15 = i11 - i12;
        int iMin = Math.min(i14, i15);
        e(sArr, i, i11 - iMin, iMin);
        int i16 = i13 - i8;
        int iMin2 = Math.min(i16, (i2 - i13) - 1);
        e(sArr, i11, i2 - iMin2, iMin2);
        if (i15 > 1) {
            c(sArr, i, i15 + i);
        }
        if (i16 > 1) {
            c(sArr, i2 - i16, i2);
        }
    }

    public static void d(short[] sArr, int i, int i2) {
        short s = sArr[i];
        sArr[i] = sArr[i2];
        sArr[i2] = s;
    }

    public static void e(short[] sArr, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            d(sArr, i, i2);
            i++;
            i2++;
        }
    }

    public static void f(short[] sArr, int i, x xVar) {
        b(sArr, 0, i, xVar, null);
    }

    public static void g(short[] sArr, int i) {
        int i2;
        char c;
        int i3;
        int i4 = 0;
        if (i < 1000) {
            c(sArr, 0, i);
            return;
        }
        if (i < 1024) {
            c(sArr, 0, i);
            return;
        }
        int i5 = 256;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[256];
        iArr[0] = 0;
        iArr2[0] = i;
        iArr3[0] = 0;
        int[] iArr4 = new int[256];
        int[] iArr5 = new int[256];
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int i7 = iArr[i6];
            int i8 = iArr2[i6];
            int i9 = iArr3[i6];
            int i10 = i9 % 2;
            int i11 = i10 == 0 ? 128 : i4;
            int i12 = 1 - i10;
            int i13 = i8 + i7;
            int i14 = i13;
            while (true) {
                i2 = i12 * 8;
                int i15 = i14 - 1;
                if (i14 == i7) {
                    break;
                }
                int i16 = ((sArr[i15] >>> i2) & 255) ^ i11;
                iArr4[i16] = iArr4[i16] + 1;
                i14 = i15;
            }
            int i17 = -1;
            int i18 = i7;
            for (int i19 = 0; i19 < i5; i19++) {
                int i20 = iArr4[i19];
                if (i20 != 0) {
                    i17 = i19;
                }
                i18 += i20;
                iArr5[i19] = i18;
            }
            int i21 = i13 - iArr4[i17];
            while (i7 <= i21) {
                short s = sArr[i7];
                int i22 = ((s >>> i2) & 255) ^ i11;
                if (i7 < i21) {
                    while (true) {
                        int i23 = iArr5[i22] - 1;
                        iArr5[i22] = i23;
                        if (i23 <= i7) {
                            break;
                        }
                        short s2 = sArr[i23];
                        sArr[i23] = s;
                        s = s2;
                        i22 = ((s2 >>> i2) & 255) ^ i11;
                    }
                    sArr[i7] = s;
                }
                if (i9 > 0 || (i3 = iArr4[i22]) <= 1) {
                    c = 1024;
                } else {
                    c = 1024;
                    if (i3 < 1024) {
                        c(sArr, i7, i3 + i7);
                    } else {
                        iArr[i6] = i7;
                        iArr2[i6] = i3;
                        iArr3[i6] = i9 + 1;
                        i6++;
                    }
                }
                i7 += iArr4[i22];
                iArr4[i22] = 0;
                i5 = 256;
            }
            i4 = 0;
        }
    }

    private static int h(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[i2];
        int iCompare = Short.compare(s, s2);
        short s3 = sArr[i3];
        int iCompare2 = Short.compare(s, s3);
        int iCompare3 = Short.compare(s2, s3);
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

package com.google.android.libraries.navigation.internal.agg;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class di {
    public static final int[] a = new int[0];
    public static final int[] b = new int[0];

    public static void a(int[] iArr, int i, int i2) {
        com.google.android.libraries.navigation.internal.agc.a.b(iArr.length, i, i2);
    }

    public static void b(int[] iArr, int i, int i2, dt dtVar, int[] iArr2) {
        int i3 = i2 - i;
        if (i3 >= 16) {
            if (iArr2 == null) {
                iArr2 = Arrays.copyOf(iArr, i2);
            }
            int i4 = (i + i2) >>> 1;
            b(iArr2, i, i4, dtVar, iArr);
            b(iArr2, i4, i2, dtVar, iArr);
            if (dtVar.a(iArr2[i4 - 1], iArr2[i4]) <= 0) {
                System.arraycopy(iArr2, i, iArr, i, i3);
                return;
            }
            int i5 = i;
            int i6 = i4;
            while (i < i2) {
                if (i6 >= i2 || (i5 < i4 && dtVar.a(iArr2[i5], iArr2[i6]) <= 0)) {
                    iArr[i] = iArr2[i5];
                    i5++;
                } else {
                    iArr[i] = iArr2[i6];
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
            int i9 = iArr[i8];
            int i10 = iArr[i7];
            int i11 = i8;
            while (dtVar.a(i9, i10) < 0) {
                iArr[i11] = i10;
                int i12 = i11 - 1;
                if (i == i12) {
                    i11 = i12;
                    break;
                } else {
                    int i13 = iArr[i11 - 2];
                    i11 = i12;
                    i10 = i13;
                }
            }
            iArr[i11] = i9;
            i7 = i8;
        }
    }

    public static void c(int[] iArr, int i, int i2) {
        int iH;
        int iH2;
        int i3 = i2 - i;
        if (i3 < 16) {
            int i4 = i2 - 1;
            while (i < i4) {
                int i5 = i + 1;
                int i6 = i;
                for (int i7 = i5; i7 < i2; i7++) {
                    if (iArr[i7] < iArr[i6]) {
                        i6 = i7;
                    }
                }
                if (i6 != i) {
                    int i8 = iArr[i];
                    iArr[i] = iArr[i6];
                    iArr[i6] = i8;
                }
                i = i5;
            }
            return;
        }
        int i9 = i2 - 1;
        int iH3 = (i3 >> 1) + i;
        if (i3 > 128) {
            int i10 = i3 >> 3;
            int i11 = i10 + i10;
            iH = h(iArr, i, i + i10, i + i11);
            iH3 = h(iArr, iH3 - i10, iH3, iH3 + i10);
            iH2 = h(iArr, i9 - i11, i9 - i10, i9);
        } else {
            iH = i;
            iH2 = i9;
        }
        int i12 = iArr[h(iArr, iH, iH3, iH2)];
        int i13 = i;
        int i14 = i13;
        int i15 = i9;
        while (true) {
            if (i13 <= i9) {
                int iCompare = Integer.compare(iArr[i13], i12);
                if (iCompare <= 0) {
                    if (iCompare == 0) {
                        d(iArr, i14, i13);
                        i14++;
                    }
                    i13++;
                }
            }
            while (i9 >= i13) {
                int iCompare2 = Integer.compare(iArr[i9], i12);
                if (iCompare2 < 0) {
                    break;
                }
                if (iCompare2 == 0) {
                    d(iArr, i9, i15);
                    i15--;
                }
                i9--;
            }
            if (i13 > i9) {
                break;
            }
            d(iArr, i13, i9);
            i13++;
            i9--;
        }
        int i16 = i14 - i;
        int i17 = i13 - i14;
        int iMin = Math.min(i16, i17);
        e(iArr, i, i13 - iMin, iMin);
        int i18 = i15 - i9;
        int iMin2 = Math.min(i18, (i2 - i15) - 1);
        e(iArr, i13, i2 - iMin2, iMin2);
        if (i17 > 1) {
            c(iArr, i, i17 + i);
        }
        if (i18 > 1) {
            c(iArr, i2 - i18, i2);
        }
    }

    public static void d(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static void e(int[] iArr, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            d(iArr, i, i2);
            i++;
            i2++;
        }
    }

    public static void f(int[] iArr, int i, dt dtVar) {
        b(iArr, 0, i, dtVar, null);
    }

    public static void g(int[] iArr, int i) {
        int i2;
        int i3;
        int i4 = 0;
        if (i < 2000) {
            c(iArr, 0, i);
            return;
        }
        int[] iArr2 = new int[766];
        int[] iArr3 = new int[766];
        int[] iArr4 = new int[766];
        iArr2[0] = 0;
        iArr3[0] = i;
        iArr4[0] = 0;
        int i5 = 256;
        int[] iArr5 = new int[256];
        int[] iArr6 = new int[256];
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int i7 = iArr2[i6];
            int i8 = iArr3[i6];
            int i9 = iArr4[i6];
            int i10 = i9 % 4;
            int i11 = i10 == 0 ? 128 : i4;
            int i12 = 3 - i10;
            int i13 = i8 + i7;
            int i14 = i13;
            while (true) {
                i2 = i12 * 8;
                int i15 = i14 - 1;
                if (i14 == i7) {
                    break;
                }
                int i16 = ((iArr[i15] >>> i2) & 255) ^ i11;
                iArr5[i16] = iArr5[i16] + 1;
                i14 = i15;
            }
            int i17 = i7;
            int i18 = -1;
            for (int i19 = i4; i19 < i5; i19++) {
                int i20 = iArr5[i19];
                if (i20 != 0) {
                    i18 = i19;
                }
                i17 += i20;
                iArr6[i19] = i17;
            }
            int i21 = i13 - iArr5[i18];
            while (i7 <= i21) {
                int i22 = iArr[i7];
                int i23 = ((i22 >>> i2) & 255) ^ i11;
                if (i7 < i21) {
                    while (true) {
                        int i24 = iArr6[i23] - 1;
                        iArr6[i23] = i24;
                        if (i24 <= i7) {
                            break;
                        }
                        int i25 = iArr[i24];
                        iArr[i24] = i22;
                        i22 = i25;
                        i23 = ((i25 >>> i2) & 255) ^ i11;
                    }
                    iArr[i7] = i22;
                }
                if (i9 < 3 && (i3 = iArr5[i23]) > 1) {
                    if (i3 < 1024) {
                        c(iArr, i7, i3 + i7);
                    } else {
                        iArr2[i6] = i7;
                        iArr3[i6] = i3;
                        iArr4[i6] = i9 + 1;
                        i6++;
                    }
                }
                i7 += iArr5[i23];
                i4 = 0;
                iArr5[i23] = 0;
                i5 = 256;
            }
        }
    }

    private static int h(int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[i];
        int i5 = iArr[i2];
        int iCompare = Integer.compare(i4, i5);
        int i6 = iArr[i3];
        int iCompare2 = Integer.compare(i4, i6);
        int iCompare3 = Integer.compare(i5, i6);
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

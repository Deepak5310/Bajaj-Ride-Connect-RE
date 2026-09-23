package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.adg.jh;
import com.google.maps.android.BuildConfig;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static int a(com.google.android.libraries.navigation.internal.ael.x xVar) {
        com.google.android.libraries.navigation.internal.ael.s it2 = xVar.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (it2.a() >= 0) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0019 A[PHI: r7 r8
      0x0019: PHI (r7v11 int) = (r7v1 int), (r7v3 int) binds: [B:9:0x0017, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0019: PHI (r8v10 int) = (r8v0 int), (r8v4 int) binds: [B:9:0x0017, B:14:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x005b A[PHI: r8 r9
      0x005b: PHI (r8v3 int) = (r8v2 int), (r8v5 int) binds: [B:12:0x0028, B:16:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x005b: PHI (r9v1 int) = (r9v0 int), (r9v3 int) binds: [B:12:0x0028, B:16:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    private static int d(com.google.android.libraries.navigation.internal.ael.x xVar, int[] iArr, int i) throws IOException {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = true;
        while (i3 < xVar.d() && (i2 = i + i4) < iArr.length) {
            int i7 = i3 + 1;
            try {
                int iA = xVar.a(i3);
                if (iA >= 0) {
                    i3 = i7;
                } else {
                    int i8 = i3 + 2;
                    byte bA = xVar.a(i7);
                    iA = (iA & 127) | ((bA & 127) << 7);
                    if (bA < 0) {
                        i7 = i3 + 3;
                        byte bA2 = xVar.a(i8);
                        iA |= (bA2 & 127) << 14;
                        if (bA2 < 0) {
                            i8 = i3 + 4;
                            byte bA3 = xVar.a(i7);
                            iA |= (bA3 & 127) << 21;
                            if (bA3 < 0) {
                                i3 += 5;
                                byte bA4 = xVar.a(i8);
                                iA |= (bA4 & 127) << 28;
                                while (bA4 < 0) {
                                    int i9 = i3 + 1;
                                    bA4 = xVar.a(i3);
                                    i3 = i9;
                                }
                            } else {
                                i3 = i8;
                            }
                        } else {
                            i3 = i7;
                        }
                    } else {
                        i3 = i8;
                    }
                }
                int i10 = (iA >>> 1) ^ (-(iA & 1));
                if (z) {
                    i5 += i10;
                    iArr[i2] = i5;
                } else {
                    i6 += i10;
                    iArr[i2] = i6;
                }
                z = !z;
                i4++;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IOException("Invalid vertex data", e);
            }
        }
        if (z) {
            return i4;
        }
        throw new IOException("Odd number of vertices");
    }

    public static int[] c(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int i2, int i3) throws IOException {
        if (i3 <= 0) {
            int i4 = i - 1;
            if (i == 0) {
                throw null;
            }
            if (i4 == 1) {
                i3 = a(xVar);
            } else if (i4 != 2) {
                if (i4 != 3) {
                    throw new IOException("Unknown vertex encoding :".concat(String.valueOf(String.valueOf(i != 0 ? jh.toString$ar$edu$6cec161_0(i) : BuildConfig.TRAVIS))));
                }
                i3 = a(xVar);
            } else {
                i3 = xVar.d() / 2;
            }
        }
        int[] iArr = new int[i3];
        b(xVar, i, i2, iArr, 0);
        return iArr;
    }

    public static int b(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int i2, int[] iArr, int i3) throws IOException {
        int i4;
        if (i == 0) {
            throw null;
        }
        int i5 = i - 1;
        int i6 = 0;
        if (i5 == 1) {
            com.google.android.libraries.navigation.internal.ael.ac acVarK = xVar.k();
            while (!acVarK.C()) {
                iArr[i3 + i6] = acVarK.l();
                i6++;
            }
            return i6;
        }
        if (i5 == 2) {
            com.google.android.libraries.navigation.internal.zn.s sVar = new com.google.android.libraries.navigation.internal.zn.s(xVar.l());
            while (sVar.available() > 0 && (i4 = i3 + i6) < iArr.length) {
                iArr[i4] = sVar.readShort();
                i6++;
            }
            return i6;
        }
        if (i5 != 3) {
            throw new IOException("Unknown vertex encoding :".concat(String.valueOf(String.valueOf(i != 0 ? jh.toString$ar$edu$6cec161_0(i) : BuildConfig.TRAVIS))));
        }
        if (i2 != 3) {
            return d(xVar, iArr, i3);
        }
        com.google.android.libraries.navigation.internal.ael.ac acVarK2 = xVar.k();
        int iL = 0;
        int iL2 = 0;
        int iL3 = 0;
        while (!acVarK2.C()) {
            iL += acVarK2.l();
            iL2 += acVarK2.l();
            iL3 += acVarK2.l();
            int i7 = i3 + i6;
            iArr[i7] = iL;
            iArr[i7 + 1] = iL2;
            iArr[i7 + 2] = iL3;
            i6 += 3;
        }
        return i6;
    }
}

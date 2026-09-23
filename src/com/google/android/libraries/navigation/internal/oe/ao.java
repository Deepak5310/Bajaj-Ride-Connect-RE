package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.adg.jh;
import com.google.maps.android.BuildConfig;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao extends o {
    private final ax b;

    public ao(ax axVar) {
        this.b = axVar;
    }

    private static void a(com.google.android.libraries.navigation.internal.ael.x xVar, ax axVar, int[] iArr, int i, boolean z) throws IOException {
        int iMax;
        int i2;
        int iB = n.b(xVar, axVar.d, 2, iArr, i);
        int iA = axVar.a();
        int iMax2 = z ? Math.max(iA, 0) : axVar.c + iA;
        if (z) {
            iMax = Math.max(4 - iA, 4);
            i2 = 256;
        } else {
            iMax = 12 - iA;
            i2 = 1;
        }
        int i3 = i2 << iMax;
        int iMin = Math.min(iB + i, iArr.length);
        if (!z) {
            while (i < iMin) {
                int i4 = i + 1;
                int i5 = i3 - iArr[i4];
                if (iMax2 < 0) {
                    int i6 = -iMax2;
                    iArr[i] = (iArr[i] >> i6) + axVar.a;
                    iArr[i4] = (i5 >> i6) + axVar.b;
                } else {
                    iArr[i] = (iArr[i] << iMax2) + axVar.a;
                    iArr[i4] = (i5 << iMax2) + axVar.b;
                }
                i += 2;
            }
            return;
        }
        if (iMax2 == 0) {
            while (i < iMin) {
                int i7 = i + 1;
                iArr[i7] = i3 - iArr[i7];
                i += 2;
            }
            return;
        }
        while (i < iMin) {
            iArr[i] = iArr[i] << iMax2;
            int i8 = i + 1;
            iArr[i8] = i3 - (iArr[i8] << iMax2);
            i += 2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    protected final int c(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        return i == 0 ? b(xVar) : i;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final int d() {
        try {
            ax axVar = this.b;
            return axVar.c + Math.min(0, axVar.a());
        } catch (IOException unused) {
            return this.b.c;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final int e() {
        return this.b.a;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final int f() {
        return this.b.b;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void i(com.google.android.libraries.navigation.internal.ael.x xVar, int i, float[] fArr) {
        throw new UnsupportedOperationException("Tile-based geometry doesn't have float geometry.");
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void k(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) throws IOException {
        a(xVar, this.b, iArr, i + i, false);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void l(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) throws IOException {
        a(xVar, this.b, iArr, i + i, true);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final int b(com.google.android.libraries.navigation.internal.ael.x xVar) throws IOException {
        int iA;
        int i = this.b.d;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            iA = n.a(xVar);
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new IOException("Unknown vertex encoding :".concat(String.valueOf(String.valueOf(i != 0 ? jh.toString$ar$edu$6cec161_0(i) : BuildConfig.TRAVIS))));
            }
            iA = n.a(xVar);
        } else {
            iA = xVar.d() / 2;
        }
        return iA / 2;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.o
    public final void j(com.google.android.libraries.navigation.internal.ael.x xVar, x xVar2) throws IOException {
        int iL;
        int i;
        int i2;
        int i3 = this.b.d;
        if (i3 == 0) {
            throw null;
        }
        int i4 = i3 - 1;
        if (i4 == 1) {
            com.google.android.libraries.navigation.internal.ael.ac acVarK = xVar.k();
            int iL2 = acVarK.l();
            iL = acVarK.l();
            i = iL2;
        } else if (i4 != 2) {
            if (i4 != 3) {
                throw new IOException("Unknown vertex encoding :".concat(String.valueOf(String.valueOf(i3 != 0 ? jh.toString$ar$edu$6cec161_0(i3) : BuildConfig.TRAVIS))));
            }
            com.google.android.libraries.navigation.internal.ael.ac acVarK2 = xVar.k();
            int iL3 = acVarK2.l();
            iL = acVarK2.l();
            i = iL3;
        } else {
            com.google.android.libraries.navigation.internal.zn.s sVar = new com.google.android.libraries.navigation.internal.zn.s(xVar.l());
            i = sVar.readShort();
            iL = sVar.readShort();
        }
        xVar2.J(i, iL);
        int iA = this.b.a();
        ax axVar = this.b;
        int i5 = axVar.c + iA;
        int i6 = (1 << (12 - iA)) - xVar2.b;
        if (i5 < 0) {
            int i7 = -i5;
            xVar2.a = (xVar2.a >> i7) + axVar.a;
            i2 = i6 >> i7;
        } else {
            xVar2.a = (xVar2.a << i5) + axVar.a;
            i2 = i6 << i5;
        }
        xVar2.b = i2 + axVar.b;
    }
}

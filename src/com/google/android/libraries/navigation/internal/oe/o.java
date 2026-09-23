package com.google.android.libraries.navigation.internal.oe;

import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o {
    public static final ad[] a = new ad[0];

    public abstract int b(com.google.android.libraries.navigation.internal.ael.x xVar) throws IOException;

    protected int c(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        int iB = b(xVar);
        if (i <= iB) {
            return i == 0 ? iB : i;
        }
        throw new IOException("Buffer too small for the given number of vertices");
    }

    public int d() {
        return 0;
    }

    public int e() {
        return 0;
    }

    public int f() {
        return 0;
    }

    public final x g(com.google.android.libraries.navigation.internal.ael.x xVar) throws IOException {
        x xVar2 = new x();
        j(xVar, xVar2);
        return xVar2;
    }

    public final ad h(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        return new ad(n(xVar, i), 0, 0, 0);
    }

    public abstract void i(com.google.android.libraries.navigation.internal.ael.x xVar, int i, float[] fArr);

    public void j(com.google.android.libraries.navigation.internal.ael.x xVar, x xVar2) throws IOException {
        int[] iArrN = n(xVar, 1);
        if (iArrN.length < 2) {
            throw new IOException("Too few vertices for getPoint");
        }
        xVar2.J(iArrN[0], iArrN[1]);
    }

    public abstract void k(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) throws IOException;

    public void l(com.google.android.libraries.navigation.internal.ael.x xVar, int i, int[] iArr) throws IOException {
        k(xVar, i, iArr);
    }

    public final float[] m(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        int iC = c(xVar, i);
        float[] fArr = new float[iC + iC];
        i(xVar, 0, fArr);
        return fArr;
    }

    public int[] n(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        int iC = c(xVar, i);
        int[] iArr = new int[iC + iC];
        k(xVar, 0, iArr);
        return iArr;
    }

    public final int[] o(com.google.android.libraries.navigation.internal.ael.x xVar, int i) throws IOException {
        int iC = c(xVar, i);
        int[] iArr = new int[iC + iC];
        l(xVar, 0, iArr);
        return iArr;
    }
}

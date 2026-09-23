package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ac {
    private static volatile int a = 100;
    public static final /* synthetic */ int g = 0;
    int b;
    int c;
    int d = a;
    int e = Integer.MAX_VALUE;
    ad f;

    public static int H(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long I(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static ac J(InputStream inputStream) {
        return inputStream == null ? K(ca.b) : new aa(inputStream);
    }

    public static ac K(byte[] bArr) {
        return L(bArr, 0, bArr.length);
    }

    public static ac L(byte[] bArr, int i, int i2) {
        return M(bArr, 0, i2, false);
    }

    static ac M(byte[] bArr, int i, int i2, boolean z) {
        y yVar = new y(bArr, i, i2);
        try {
            yVar.e(i2);
            return yVar;
        } catch (cc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract void A(int i);

    public abstract boolean C() throws IOException;

    public abstract boolean D() throws IOException;

    public abstract boolean E(int i) throws IOException;

    public abstract byte[] F() throws IOException;

    public final void N() throws cc {
        if (this.b + this.c >= this.d) {
            throw new cc("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void O() throws cc {
        if (this.c == 0) {
            z(0);
        }
    }

    public final void P() throws IOException {
        boolean zE;
        do {
            int iM = m();
            if (iM == 0) {
                return;
            }
            N();
            this.c++;
            zE = E(iM);
            this.c--;
        } while (zE);
    }

    public abstract double b() throws IOException;

    public abstract float c() throws IOException;

    public abstract int d();

    public abstract int e(int i) throws cc;

    public abstract int f() throws IOException;

    public abstract int g() throws IOException;

    public abstract int h() throws IOException;

    public abstract int j() throws IOException;

    public abstract int k() throws IOException;

    public abstract int l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract long o() throws IOException;

    public abstract long p() throws IOException;

    public abstract long r() throws IOException;

    public abstract long t() throws IOException;

    public abstract long u() throws IOException;

    public abstract long v() throws IOException;

    public abstract x w() throws IOException;

    public abstract String x() throws IOException;

    public abstract String y() throws IOException;

    public abstract void z(int i) throws cc;
}

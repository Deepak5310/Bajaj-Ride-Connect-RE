package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ai extends n {
    private static final Logger a = Logger.getLogger(ai.class.getName());
    public static final boolean e = em.b;
    aj f;

    public static int B(int i, x xVar) {
        return U(i) + C(xVar);
    }

    public static int C(x xVar) {
        return K(xVar.d());
    }

    public static int D(int i, int i2) {
        return U(i) + G(i2);
    }

    @Deprecated
    static int E(int i, cy cyVar, dr drVar) {
        int iU = U(i);
        return iU + iU + ((c) cyVar).j(drVar);
    }

    public static int F(int i, int i2) {
        return U(i) + G(i2);
    }

    public static int G(int i) {
        return Y(i);
    }

    public static int H(int i, long j) {
        return U(i) + Y(j);
    }

    public static int I(int i, ci ciVar) {
        return U(i) + J(ciVar);
    }

    public static int J(ci ciVar) {
        int iP;
        if (ciVar.b != null) {
            iP = ciVar.b.d();
        } else {
            iP = ciVar.a != null ? ciVar.a.p() : 0;
        }
        return K(iP);
    }

    static int K(int i) {
        return W(i) + i;
    }

    public static int L(cy cyVar) {
        return K(cyVar.p());
    }

    static int M(cy cyVar, dr drVar) {
        return K(((c) cyVar).j(drVar));
    }

    public static int N(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int O(int i, int i2) {
        return U(i) + P(i2);
    }

    public static int P(int i) {
        return W(Z(i));
    }

    public static int Q(int i, long j) {
        return U(i) + R(j);
    }

    public static int R(long j) {
        return Y(aa(j));
    }

    public static int S(int i, String str) {
        return U(i) + T(str);
    }

    public static int T(String str) {
        int length;
        try {
            length = er.b(str);
        } catch (eq unused) {
            length = str.getBytes(ca.a).length;
        }
        return K(length);
    }

    public static int U(int i) {
        return W(eu.c(i, 0));
    }

    public static int V(int i, int i2) {
        return U(i) + W(i2);
    }

    public static int W(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int X(int i, long j) {
        return U(i) + Y(j);
    }

    public static int Y(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int Z(int i) {
        return (i >> 31) ^ (i + i);
    }

    public static long aa(long j) {
        return (j >> 63) ^ (j + j);
    }

    public static ai ab(byte[] bArr) {
        return new af(bArr, 0, bArr.length);
    }

    public static int an(int i) {
        return U(i) + 1;
    }

    public static int ao(int i) {
        return U(i) + 8;
    }

    public static int ap(int i) {
        return U(i) + 4;
    }

    public static int aq(int i) {
        return U(i) + 8;
    }

    public static int ar(int i) {
        return U(i) + 4;
    }

    public static int as(int i) {
        return U(i) + 4;
    }

    public static int at(int i) {
        return U(i) + 8;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.n
    public abstract void a(byte[] bArr, int i, int i2) throws IOException;

    public abstract void aA(x xVar) throws IOException;

    public final void ac() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void ad(String str, eq eqVar) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) eqVar);
        byte[] bytes = str.getBytes(ca.a);
        try {
            int length = bytes.length;
            w(length);
            a(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new ag(e2);
        }
    }

    public final void ae(int i, double d) throws IOException {
        k(i, Double.doubleToRawLongBits(d));
    }

    public final void af(double d) throws IOException {
        l(Double.doubleToRawLongBits(d));
    }

    public final void ag(int i, float f) throws IOException {
        i(i, Float.floatToRawIntBits(f));
    }

    public final void ah(float f) throws IOException {
        j(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void ai(cy cyVar) throws IOException {
        cyVar.aJ(this);
    }

    public final void aj(int i, int i2) throws IOException {
        v(i, Z(i2));
    }

    public final void ak(int i) throws IOException {
        w(Z(i));
    }

    public final void al(int i, long j) throws IOException {
        x(i, aa(j));
    }

    public final void am(long j) throws IOException {
        y(aa(j));
    }

    public abstract void aw() throws IOException;

    public abstract void ax(byte b) throws IOException;

    public abstract void ay(int i, boolean z) throws IOException;

    public abstract void az(int i, x xVar) throws IOException;

    public abstract int b();

    public abstract void i(int i, int i2) throws IOException;

    public abstract void j(int i) throws IOException;

    public abstract void k(int i, long j) throws IOException;

    public abstract void l(long j) throws IOException;

    public abstract void m(int i, int i2) throws IOException;

    public abstract void n(int i) throws IOException;

    public abstract void o(int i, cy cyVar, dr drVar) throws IOException;

    public abstract void p(cy cyVar) throws IOException;

    public abstract void q(int i, cy cyVar) throws IOException;

    public abstract void r(int i, x xVar) throws IOException;

    public abstract void s(int i, String str) throws IOException;

    public abstract void t(String str) throws IOException;

    public abstract void u(int i, int i2) throws IOException;

    public abstract void v(int i, int i2) throws IOException;

    public abstract void w(int i) throws IOException;

    public abstract void x(int i, long j) throws IOException;

    public abstract void y(long j) throws IOException;

    public abstract void z(byte[] bArr, int i) throws IOException;
}

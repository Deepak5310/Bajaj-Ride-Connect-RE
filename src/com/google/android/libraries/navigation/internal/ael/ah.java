package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah extends ae {
    private final OutputStream g;

    public ah(OutputStream outputStream, int i) {
        super(i);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.g = outputStream;
    }

    private final void au() throws IOException {
        this.g.write(this.a, 0, this.c);
        this.c = 0;
    }

    private final void av(int i) throws IOException {
        if (this.b - this.c < i) {
            au();
        }
    }

    public final void A(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        int i4 = this.c;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.a, i4, i2);
            this.c += i2;
            this.d += i2;
            return;
        }
        System.arraycopy(bArr, i, this.a, i4, i5);
        int i6 = i + i5;
        this.c = this.b;
        this.d += i5;
        au();
        int i7 = i2 - i5;
        if (i7 <= this.b) {
            System.arraycopy(bArr, i6, this.a, 0, i7);
            this.c = i7;
        } else {
            this.g.write(bArr, i6, i7);
        }
        this.d += i7;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai, com.google.android.libraries.navigation.internal.ael.n
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        A(bArr, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void aA(x xVar) throws IOException {
        w(xVar.d());
        xVar.o(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void aw() throws IOException {
        if (this.c > 0) {
            au();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void ax(byte b) throws IOException {
        if (this.c == this.b) {
            au();
        }
        c(b);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void ay(int i, boolean z) throws IOException {
        av(11);
        f(i, 0);
        c(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void az(int i, x xVar) throws IOException {
        u(i, 2);
        aA(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void i(int i, int i2) throws IOException {
        av(14);
        f(i, 5);
        d(i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void j(int i) throws IOException {
        av(4);
        d(i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void k(int i, long j) throws IOException {
        av(18);
        f(i, 1);
        e(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void l(long j) throws IOException {
        av(8);
        e(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void m(int i, int i2) throws IOException {
        av(20);
        f(i, 0);
        if (i2 >= 0) {
            g(i2);
        } else {
            h(i2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void n(int i) throws IOException {
        if (i >= 0) {
            w(i);
        } else {
            y(i);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void o(int i, cy cyVar, dr drVar) throws IOException {
        u(i, 2);
        w(((c) cyVar).j(drVar));
        drVar.j(cyVar, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void p(cy cyVar) throws IOException {
        w(cyVar.p());
        cyVar.aJ(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void q(int i, cy cyVar) throws IOException {
        u(1, 3);
        v(2, i);
        u(3, 2);
        p(cyVar);
        u(1, 4);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void r(int i, x xVar) throws IOException {
        u(1, 3);
        v(2, i);
        az(3, xVar);
        u(1, 4);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void s(int i, String str) throws IOException {
        u(i, 2);
        t(str);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void u(int i, int i2) throws IOException {
        w(eu.c(i, i2));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void v(int i, int i2) throws IOException {
        av(20);
        f(i, 0);
        g(i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void w(int i) throws IOException {
        av(5);
        g(i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void x(int i, long j) throws IOException {
        av(20);
        f(i, 0);
        h(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void y(long j) throws IOException {
        av(10);
        h(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void z(byte[] bArr, int i) throws IOException {
        w(i);
        A(bArr, 0, i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void t(String str) throws IOException {
        int iB;
        try {
            int length = str.length() * 3;
            int iW = W(length);
            int i = iW + length;
            int i2 = this.b;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iA = er.a(str, bArr, 0, length);
                w(iA);
                A(bArr, 0, iA);
                return;
            }
            if (i > i2 - this.c) {
                au();
            }
            int iW2 = W(str.length());
            int i3 = this.c;
            try {
                if (iW2 == iW) {
                    int i4 = i3 + iW2;
                    this.c = i4;
                    int iA2 = er.a(str, this.a, i4, this.b - i4);
                    this.c = i3;
                    iB = (iA2 - i3) - iW2;
                    g(iB);
                    this.c = iA2;
                } else {
                    iB = er.b(str);
                    g(iB);
                    this.c = er.a(str, this.a, this.c, iB);
                }
                this.d += iB;
            } catch (eq e) {
                this.d -= this.c - i3;
                this.c = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new ag(e2);
            }
        } catch (eq e3) {
            ad(str, e3);
        }
    }
}

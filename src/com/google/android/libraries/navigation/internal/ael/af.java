package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af extends ai {
    private final byte[] a;
    private final int b;
    private int c;

    public af(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.a = bArr;
        this.c = 0;
        this.b = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai, com.google.android.libraries.navigation.internal.ael.n
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        e(bArr, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void aA(x xVar) throws IOException {
        w(xVar.d());
        xVar.o(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void aw() {
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void ax(byte b) throws IOException {
        int i = this.c;
        try {
            int i2 = i + 1;
            try {
                this.a[i] = b;
                this.c = i2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                i = i2;
                throw new ag(i, this.b, 1, e);
            }
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void ay(int i, boolean z) throws IOException {
        u(i, 0);
        ax(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void az(int i, x xVar) throws IOException {
        u(i, 2);
        aA(xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final int b() {
        return this.b - this.c;
    }

    public final void e(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.a, this.c, i2);
            this.c += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new ag(this.c, this.b, i2, e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void i(int i, int i2) throws IOException {
        u(i, 5);
        j(i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void j(int i) throws IOException {
        int i2 = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.c = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new ag(i2, this.b, 4, e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void k(int i, long j) throws IOException {
        u(i, 1);
        l(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void l(long j) throws IOException {
        int i = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.c = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new ag(i, this.b, 8, e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void m(int i, int i2) throws IOException {
        u(i, 0);
        n(i2);
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
    public final void t(String str) throws IOException {
        int i = this.c;
        try {
            int iW = W(str.length() * 3);
            int iW2 = W(str.length());
            if (iW2 != iW) {
                w(er.b(str));
                this.c = er.a(str, this.a, this.c, b());
                return;
            }
            int i2 = i + iW2;
            this.c = i2;
            int iA = er.a(str, this.a, i2, b());
            this.c = i;
            w((iA - i) - iW2);
            this.c = iA;
        } catch (eq e) {
            this.c = i;
            ad(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new ag(e2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void u(int i, int i2) throws IOException {
        w(eu.c(i, i2));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void v(int i, int i2) throws IOException {
        u(i, 0);
        w(i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void x(int i, long j) throws IOException {
        u(i, 0);
        y(j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void z(byte[] bArr, int i) throws IOException {
        w(i);
        e(bArr, 0, i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void w(int i) throws IOException {
        int i2;
        int i3 = this.c;
        while ((i & (-128)) != 0) {
            try {
                i2 = i3 + 1;
                try {
                    this.a[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                    i3 = i2;
                    throw new ag(i3, this.b, 1, e);
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                throw new ag(i3, this.b, 1, e);
            }
        }
        i2 = i3 + 1;
        this.a[i3] = (byte) i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ai
    public final void y(long j) throws IOException {
        int i;
        int i2 = this.c;
        if (!ai.e || b() < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i3 = i2 + 1;
                    try {
                        this.a[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i2 = i3;
                        throw new ag(i2, this.b, 1, e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                }
            }
            i = i2 + 1;
            try {
                this.a[i2] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i2 = i;
                throw new ag(i2, this.b, 1, e);
            }
        } else {
            while ((j & (-128)) != 0) {
                em.p(this.a, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            em.p(this.a, i2, (byte) j);
        }
        this.c = i;
    }
}

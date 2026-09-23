package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dp extends InputStream {
    final /* synthetic */ dq a;
    private Cdo b;
    private u c;
    private int d;
    private int e;
    private int f;
    private int g;

    public dp(dq dqVar) {
        this.a = dqVar;
        d();
    }

    private final int a() {
        return this.a.d - (this.f + this.e);
    }

    private final int b(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            c();
            u uVar = this.c;
            if (uVar == null) {
                break;
            }
            int i4 = this.d;
            int i5 = this.e;
            int iMin = Math.min(i4 - i5, i3);
            if (bArr != null) {
                uVar.z(bArr, i5, i, iMin);
                i += iMin;
            }
            this.e += iMin;
            i3 -= iMin;
        }
        return i2 - i3;
    }

    private final void c() {
        if (this.c != null) {
            int i = this.e;
            int i2 = this.d;
            if (i == i2) {
                this.f += i2;
                int iD = 0;
                this.e = 0;
                if (this.b.hasNext()) {
                    u next = this.b.next();
                    this.c = next;
                    iD = next.d();
                } else {
                    this.c = null;
                }
                this.d = iD;
            }
        }
    }

    private final void d() {
        Cdo cdo = new Cdo(this.a);
        this.b = cdo;
        u next = cdo.next();
        this.c = next;
        this.d = next.d();
        this.e = 0;
        this.f = 0;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return a();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.g = this.f + this.e;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        c();
        u uVar = this.c;
        if (uVar == null) {
            return -1;
        }
        int i = this.e;
        this.e = i + 1;
        return uVar.a(i) & 255;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        d();
        b(null, 0, this.g);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return b(null, 0, (int) j);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int iB = b(bArr, i, i2);
        if (iB == 0) {
            return (i2 > 0 || a() == 0) ? -1 : 0;
        }
        return iB;
    }
}

package com.google.android.libraries.navigation.internal.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends ByteArrayOutputStream {
    private final d a;

    public o(d dVar, int i) {
        this.a = dVar;
        this.buf = dVar.b(Math.max(i, 256));
    }

    private final void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        d dVar = this.a;
        int i2 = this.count + i;
        byte[] bArrB = dVar.b(i2 + i2);
        System.arraycopy(this.buf, 0, bArrB, 0, this.count);
        this.a.a(this.buf);
        this.buf = bArrB;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}

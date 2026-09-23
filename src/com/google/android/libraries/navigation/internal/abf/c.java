package com.google.android.libraries.navigation.internal.abf;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends InputStream {
    private int a;
    private final byte[] b;
    private int c;
    private int d;
    private final InputStream e;

    public c(InputStream inputStream, int i) {
        this.e = inputStream;
        this.a = i;
        this.b = new byte[Math.min(i, 4096)];
    }

    private final boolean a() throws IOException {
        int i = this.a;
        if (i <= 0) {
            return false;
        }
        if (this.c < this.d) {
            return true;
        }
        InputStream inputStream = this.e;
        byte[] bArr = this.b;
        int i2 = inputStream.read(bArr, 0, Math.min(i, bArr.length));
        this.d = i2;
        if (i2 <= 0) {
            this.a = 0;
            return false;
        }
        this.c = 0;
        return true;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.d - this.c;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (!a()) {
            return -1;
        }
        this.a--;
        byte[] bArr = this.b;
        int i = this.c;
        this.c = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!a()) {
            return -1;
        }
        int i3 = this.d;
        int i4 = this.c;
        int iMin = Math.min(i2, i3 - i4);
        System.arraycopy(this.b, i4, bArr, i, iMin);
        this.c += iMin;
        this.a -= iMin;
        return iMin;
    }
}

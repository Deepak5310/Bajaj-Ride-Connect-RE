package com.google.ar.imp.core.media;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
class ImpMediaDataSource extends MediaDataSource {
    private byte[] a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.a.length;
    }

    @Override // android.media.MediaDataSource
    public final synchronized int readAt(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.a;
        long length = bArr2.length;
        if (j >= length) {
            return -1;
        }
        long j2 = i2;
        long j3 = j + j2;
        if (j3 > length) {
            i2 = (int) ((j2 - j3) + length);
        }
        System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }

    public synchronized void setData(byte[] bArr) {
        this.a = bArr;
    }
}

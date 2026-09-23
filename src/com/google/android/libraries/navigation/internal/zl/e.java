package com.google.android.libraries.navigation.internal.zl;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends ByteArrayOutputStream {
    public e(int i) {
        super(i);
    }

    final int a() {
        return this.count;
    }

    final void b(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (this.count + iRemaining > this.buf.length) {
            this.buf = Arrays.copyOf(this.buf, this.count + iRemaining);
        }
        byteBuffer.get(this.buf, this.count, iRemaining);
        this.count += iRemaining;
    }

    final byte[] c() {
        return this.buf;
    }
}

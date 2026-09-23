package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class g extends c {
    private final ByteBuffer a;
    private final int b;
    private final int c;

    protected g(int i, int i2) {
        ar.a(i2 % i == 0);
        this.a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }

    private final void l() {
        this.a.flip();
        while (byteBuffer.remaining() >= this.c) {
            h(this.a);
        }
        this.a.compact();
    }

    private final void m() {
        if (this.a.remaining() < 8) {
            l();
        }
    }

    private final void n(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.a.remaining()) {
            this.a.put(byteBuffer);
            m();
            return;
        }
        int iPosition = this.b - this.a.position();
        for (int i = 0; i < iPosition; i++) {
            this.a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.c) {
            h(byteBuffer);
        }
        this.a.put(byteBuffer);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n a(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            n(byteBuffer);
            return this;
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n c(int i) {
        this.a.putInt(i);
        m();
        return this;
    }

    protected abstract l e();

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final void f(byte b) {
        this.a.put(b);
        m();
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n g(byte[] bArr, int i) {
        n(ByteBuffer.wrap(bArr, 0, i).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    protected abstract void h(ByteBuffer byteBuffer);

    protected void k(ByteBuffer byteBuffer) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final l o() {
        l();
        this.a.flip();
        if (this.a.remaining() > 0) {
            k(this.a);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.limit());
        }
        return e();
    }
}

package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class a extends c {
    private final ByteBuffer a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    private final void k(int i) {
        try {
            h(this.a.array(), i);
        } finally {
            this.a.clear();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n a(ByteBuffer byteBuffer) {
        e(byteBuffer);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n b(byte[] bArr) {
        ar.q(bArr);
        h(bArr, bArr.length);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n c(int i) {
        this.a.putInt(i);
        k(4);
        return this;
    }

    protected abstract void d(byte b);

    protected void e(ByteBuffer byteBuffer) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final void f(byte b) {
        d(b);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n g(byte[] bArr, int i) {
        ar.j(0, i, bArr.length);
        h(bArr, i);
        return this;
    }

    protected void h(byte[] bArr, int i) {
        throw null;
    }
}

package com.google.android.libraries.navigation.internal.zl;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class c implements n {
    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n a(ByteBuffer byteBuffer) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n b(byte[] bArr) {
        return g(bArr, bArr.length);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n c(int i) {
        f((byte) i);
        f((byte) (i >>> 8));
        f((byte) (i >>> 16));
        f((byte) (i >> 24));
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n g(byte[] bArr, int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n i(long j) {
        for (int i = 0; i < 64; i += 8) {
            f((byte) (j >>> i));
        }
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public n j(CharSequence charSequence, Charset charset) {
        return b(charSequence.toString().getBytes(charset));
    }
}

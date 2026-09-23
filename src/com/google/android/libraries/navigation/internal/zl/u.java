package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends a {
    private final MessageDigest a;
    private final int b;
    private boolean c;

    public u(MessageDigest messageDigest, int i) {
        this.a = messageDigest;
        this.b = i;
    }

    private final void k() {
        ar.l(!this.c, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.libraries.navigation.internal.zl.a
    protected final void d(byte b) {
        k();
        this.a.update(b);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.a
    protected final void e(ByteBuffer byteBuffer) {
        k();
        this.a.update(byteBuffer);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.a
    protected final void h(byte[] bArr, int i) {
        k();
        this.a.update(bArr, 0, i);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final l o() {
        k();
        this.c = true;
        if (this.b == this.a.getDigestLength()) {
            return new i(this.a.digest());
        }
        MessageDigest messageDigest = this.a;
        return new i(Arrays.copyOf(messageDigest.digest(), this.b));
    }
}

package com.google.android.libraries.navigation.internal.zl;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends l implements Serializable {
    private static final long serialVersionUID = 0;
    final int a;

    public j(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int b() {
        return 32;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final long c() {
        throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final boolean d(l lVar) {
        return this.a == lVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final byte[] e() {
        int i = this.a;
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }
}

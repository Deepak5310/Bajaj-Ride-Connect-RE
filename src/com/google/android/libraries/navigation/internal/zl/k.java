package com.google.android.libraries.navigation.internal.zl;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends l implements Serializable {
    private static final long serialVersionUID = 0;
    final long a;

    public k(long j) {
        this.a = j;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int a() {
        return (int) this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final int b() {
        return 64;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final long c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final boolean d(l lVar) {
        return this.a == lVar.c();
    }

    @Override // com.google.android.libraries.navigation.internal.zl.l
    public final byte[] e() {
        long j = this.a;
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }
}

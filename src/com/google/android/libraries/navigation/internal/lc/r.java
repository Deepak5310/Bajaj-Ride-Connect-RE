package com.google.android.libraries.navigation.internal.lc;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends q {
    private final byte[] a;

    public r(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.lc.q
    public final byte[] f() {
        return this.a;
    }
}

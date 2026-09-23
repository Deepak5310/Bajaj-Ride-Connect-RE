package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements m {
    public final l a(byte[] bArr) {
        return d(bArr, bArr.length);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final l b(CharSequence charSequence, Charset charset) {
        return e().j(charSequence, charset).o();
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public n c(int i) {
        ar.d(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return e();
    }

    public l d(byte[] bArr, int i) {
        ar.j(0, i, bArr.length);
        return c(i).g(bArr, i).o();
    }
}

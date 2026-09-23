package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f extends b {
    @Override // com.google.android.libraries.navigation.internal.zl.b, com.google.android.libraries.navigation.internal.zl.m
    public final n c(int i) {
        ar.a(i >= 0);
        return new d(this, i);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final n e() {
        return c(32);
    }
}

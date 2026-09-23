package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.google.android.libraries.navigation.internal.gh.e {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    public final com.google.android.libraries.navigation.internal.iv.f b;

    public n(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.iv.f fVar) {
        this.a = aVar;
        this.b = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final bj a() {
        throw new UnsupportedOperationException("Cached values are either immediately available or not at all. Use getNonBlocking().");
    }
}

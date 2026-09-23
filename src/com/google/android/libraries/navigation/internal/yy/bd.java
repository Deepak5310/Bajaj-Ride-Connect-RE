package com.google.android.libraries.navigation.internal.yy;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bd extends bb {
    volatile long a;
    bj b;
    bj c;

    public bd(ReferenceQueue referenceQueue, Object obj, int i, bj bjVar) {
        super(referenceQueue, obj, i, bjVar);
        this.a = Long.MAX_VALUE;
        int i2 = bi.y;
        this.b = an.INSTANCE;
        this.c = an.INSTANCE;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final long c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj i() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void m(bj bjVar) {
        this.b = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void o(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void q(long j) {
        this.a = j;
    }
}

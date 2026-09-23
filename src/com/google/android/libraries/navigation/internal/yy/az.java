package com.google.android.libraries.navigation.internal.yy;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends bb {
    volatile long a;
    bj b;
    bj c;

    public az(ReferenceQueue referenceQueue, Object obj, int i, bj bjVar) {
        super(referenceQueue, obj, i, bjVar);
        this.a = Long.MAX_VALUE;
        int i2 = bi.y;
        this.b = an.INSTANCE;
        this.c = an.INSTANCE;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final long b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj f() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj h() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void k(long j) {
        this.a = j;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void l(bj bjVar) {
        this.b = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void n(bj bjVar) {
        this.c = bjVar;
    }
}

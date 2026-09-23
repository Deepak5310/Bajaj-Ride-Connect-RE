package com.google.android.libraries.navigation.internal.yy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class av extends at {
    volatile long a;
    bj b;
    bj c;

    public av(Object obj, int i, bj bjVar) {
        super(obj, i, bjVar);
        this.a = Long.MAX_VALUE;
        int i2 = bi.y;
        this.b = an.INSTANCE;
        this.c = an.INSTANCE;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final long c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final bj g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final bj i() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final void m(bj bjVar) {
        this.b = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final void o(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final void q(long j) {
        this.a = j;
    }
}

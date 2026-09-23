package com.google.android.libraries.navigation.internal.yy;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba extends bb {
    volatile long a;
    bj b;
    bj c;
    volatile long d;
    bj e;
    bj f;

    public ba(ReferenceQueue referenceQueue, Object obj, int i, bj bjVar) {
        super(referenceQueue, obj, i, bjVar);
        this.a = Long.MAX_VALUE;
        int i2 = bi.y;
        this.b = an.INSTANCE;
        this.c = an.INSTANCE;
        this.d = Long.MAX_VALUE;
        this.e = an.INSTANCE;
        this.f = an.INSTANCE;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final long b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final long c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj f() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj g() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj h() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final bj i() {
        return this.f;
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
    public final void m(bj bjVar) {
        this.e = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void n(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void o(bj bjVar) {
        this.f = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.bb, com.google.android.libraries.navigation.internal.yy.bj
    public final void q(long j) {
        this.d = j;
    }
}

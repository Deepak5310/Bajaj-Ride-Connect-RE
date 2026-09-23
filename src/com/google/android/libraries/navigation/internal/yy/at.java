package com.google.android.libraries.navigation.internal.yy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class at extends q {
    final Object g;
    final int h;
    final bj i;
    volatile ax j = bi.b;

    public at(Object obj, int i, bj bjVar) {
        this.g = obj;
        this.h = i;
        this.i = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final int a() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final ax d() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final bj e() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final Object j() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.yy.q, com.google.android.libraries.navigation.internal.yy.bj
    public final void p(ax axVar) {
        this.j = axVar;
    }
}

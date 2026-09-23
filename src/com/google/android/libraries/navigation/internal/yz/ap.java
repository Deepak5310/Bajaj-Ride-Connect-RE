package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ap extends kx {
    final /* synthetic */ aq a;

    public ap(aq aqVar) {
        this.a = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kx
    public ku a() {
        return this.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.a.f();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.c();
    }
}

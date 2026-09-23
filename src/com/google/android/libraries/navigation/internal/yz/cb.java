package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cb extends AbstractCollection {
    final /* synthetic */ cc a;

    public cb(cc ccVar) {
        this.a = ccVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        cc ccVar = this.a;
        Map mapN = ccVar.n();
        return mapN != null ? mapN.values().iterator() : new bw(ccVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.size();
    }
}

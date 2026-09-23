package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bz extends AbstractSet {
    final /* synthetic */ cc a;

    public bz(cc ccVar) {
        this.a = ccVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        cc ccVar = this.a;
        Map mapN = ccVar.n();
        return mapN != null ? mapN.keySet().iterator() : new bu(ccVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapN = this.a.n();
        if (mapN != null) {
            return mapN.keySet().remove(obj);
        }
        return this.a.h(obj) != cc.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }
}

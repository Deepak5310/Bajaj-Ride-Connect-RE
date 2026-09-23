package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ni extends jv {
    final Iterable a;
    final /* synthetic */ nk b;

    public ni(nk nkVar, Iterable iterable) {
        this.b = nkVar;
        this.a = iterable;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jv
    public final Iterator a() {
        return this.a.iterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof lr)) {
            return null;
        }
        lr lrVar = (lr) obj;
        nk nkVar = this.b;
        nj njVar = (nj) nkVar.a.get(lrVar.b);
        if (njVar == null || !njVar.a.equals(lrVar)) {
            return null;
        }
        return njVar.b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.b.a.size();
    }
}

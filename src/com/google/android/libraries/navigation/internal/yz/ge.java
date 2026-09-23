package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ge extends ev {
    final /* synthetic */ gf a;

    public ge(gf gfVar) {
        this.a = gfVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return new AbstractMap.SimpleImmutableEntry(this.a.a.c.d.get(i), this.a.a.d.get(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

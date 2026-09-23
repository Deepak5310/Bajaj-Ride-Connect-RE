package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class al extends AbstractList implements RandomAccess {
    private final com.google.android.libraries.navigation.internal.adh.b a;

    public al(com.google.android.libraries.navigation.internal.adh.b bVar) {
        this.a = bVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return Long.valueOf(this.a.e(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.a();
    }
}

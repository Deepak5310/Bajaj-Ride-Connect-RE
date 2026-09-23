package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class am extends AbstractList implements RandomAccess {
    private final com.google.android.libraries.navigation.internal.adh.b a;

    public am(com.google.android.libraries.navigation.internal.adh.b bVar) {
        this.a = bVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        try {
            return Integer.valueOf(this.a.f(i).b);
        } catch (com.google.android.libraries.navigation.internal.ael.cc unused) {
            return -1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.d();
    }
}

package com.google.android.libraries.navigation.internal.ael;

import java.util.AbstractList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends AbstractList {
    private final bq a;
    private final br b;

    public bs(bq bqVar, br brVar) {
        this.a = bqVar;
        this.b = brVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.b.a(this.a.d(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }
}

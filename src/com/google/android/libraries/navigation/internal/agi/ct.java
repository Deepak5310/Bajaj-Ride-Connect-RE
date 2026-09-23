package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ct extends com.google.android.libraries.navigation.internal.agh.n {
    final /* synthetic */ cu a;

    public ct(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public final com.google.android.libraries.navigation.internal.agh.gs m() {
        return new cr(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agh.hl spliterator() {
        return new cs(this, 0, this.a.d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.m(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new cr(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.d;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

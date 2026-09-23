package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cn extends v {
    final /* synthetic */ cv a;

    public cn(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a */
    public final gs listIterator() {
        return new cm(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new co(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.e(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v
    public final boolean l(long j) {
        cv cvVar = this.a;
        int i = cvVar.i;
        cvVar.c(j);
        return this.a.i != i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

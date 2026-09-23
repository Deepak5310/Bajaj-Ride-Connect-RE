package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ci extends n {
    final /* synthetic */ cv a;

    public ci(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final gs listIterator() {
        return new ct(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new cu(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.r(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

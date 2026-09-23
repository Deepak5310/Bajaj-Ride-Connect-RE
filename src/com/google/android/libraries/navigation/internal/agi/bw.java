package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bw extends com.google.android.libraries.navigation.internal.agg.h {
    final /* synthetic */ cj a;

    public bw(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.agg.ei n() {
        return new ch(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agg.fh spliterator() {
        return new ci(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        return this.a.m(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

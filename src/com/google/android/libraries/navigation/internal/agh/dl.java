package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dl extends com.google.android.libraries.navigation.internal.agi.m {
    final /* synthetic */ du a;

    public dl(du duVar) {
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new dt(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new com.google.android.libraries.navigation.internal.agi.hq(listIterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 80);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        du duVar = this.a;
        int i = duVar.k;
        int i2 = duVar.e;
        while (i != 0) {
            i--;
            du duVar2 = this.a;
            int i3 = (int) duVar2.g[i2];
            consumer.accept(duVar2.b[i2]);
            i2 = i3;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

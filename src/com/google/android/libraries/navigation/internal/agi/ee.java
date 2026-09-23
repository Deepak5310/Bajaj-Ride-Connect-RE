package com.google.android.libraries.navigation.internal.agi;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee extends m {
    final /* synthetic */ ef a;

    public ee(ef efVar) {
        this.a = efVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new ec(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new ed(this, 0, this.a.c);
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
        int i = this.a.c;
        for (int i2 = 0; i2 < i; i2++) {
            consumer.accept(this.a.b[i2]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new ec(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

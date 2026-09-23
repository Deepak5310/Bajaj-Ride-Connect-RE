package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ed extends com.google.android.libraries.navigation.internal.agi.m {
    final /* synthetic */ eq a;

    public ed(eq eqVar) {
        this.a = eqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new eo(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new ep(this.a);
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
        eq eqVar = this.a;
        if (eqVar.d) {
            consumer.accept(eqVar.b[eqVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            eq eqVar2 = this.a;
            if (eqVar2.a[i] != 0) {
                consumer.accept(eqVar2.b[i]);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

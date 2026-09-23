package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hj;
import com.google.android.libraries.navigation.internal.agi.hq;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class av extends com.google.android.libraries.navigation.internal.agi.m {
    final /* synthetic */ be a;

    public av(be beVar) {
        this.a = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final gi listIterator() {
        return new bd(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new hq(listIterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 80);
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
        be beVar = this.a;
        int i = beVar.k;
        int i2 = beVar.e;
        while (i != 0) {
            i--;
            be beVar2 = this.a;
            int i3 = (int) beVar2.g[i2];
            consumer.accept(beVar2.b[i2]);
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

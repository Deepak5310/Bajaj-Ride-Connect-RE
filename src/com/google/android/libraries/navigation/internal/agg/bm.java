package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bm extends com.google.android.libraries.navigation.internal.agi.m {
    final /* synthetic */ bz a;

    public bm(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b */
    public final gi listIterator() {
        return new bx(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new by(this.a);
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
        bz bzVar = this.a;
        if (bzVar.d) {
            consumer.accept(bzVar.b[bzVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            bz bzVar2 = this.a;
            if (bzVar2.a[i] != 0) {
                consumer.accept(bzVar2.b[i]);
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

package com.google.android.libraries.navigation.internal.agh;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fc extends com.google.android.libraries.navigation.internal.agi.ad {
    final /* synthetic */ fp a;

    public fc(fp fpVar) {
        this.a = fpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final com.google.android.libraries.navigation.internal.agi.gi listIterator() {
        return new fn(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final com.google.android.libraries.navigation.internal.agi.hj spliterator() {
        return new fo(this.a);
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
        fp fpVar = this.a;
        if (fpVar.d) {
            consumer.accept(fpVar.b[fpVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            fp fpVar2 = this.a;
            if (fpVar2.a[i] != 0) {
                consumer.accept(fpVar2.b[i]);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jx extends ad {
    final /* synthetic */ kk a;

    public jx(kk kkVar) {
        this.a = kkVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final gi listIterator() {
        return new ki(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new kj(this.a);
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
        kk kkVar = this.a;
        if (kkVar.d) {
            consumer.accept(kkVar.b[kkVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            kk kkVar2 = this.a;
            if (kkVar2.a[i] != null) {
                consumer.accept(kkVar2.b[i]);
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

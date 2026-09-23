package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.hj;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cl extends com.google.android.libraries.navigation.internal.agi.ad {
    final /* synthetic */ cy a;

    public cl(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final gi listIterator() {
        return new cw(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new cx(this.a);
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
        cy cyVar = this.a;
        if (cyVar.d) {
            consumer.accept(cyVar.b[cyVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            cy cyVar2 = this.a;
            if (cyVar2.a[i] != 0) {
                consumer.accept(cyVar2.b[i]);
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

package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jf extends ak {
    final /* synthetic */ jn a;

    public jf(jn jnVar) {
        this.a = jnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: a */
    public final gi listIterator() {
        return new je(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: b */
    public final hj spliterator() {
        return new jg(this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        jn jnVar = this.a;
        if (jnVar.d) {
            consumer.accept(jnVar.a[jnVar.e]);
        }
        int i = this.a.e;
        while (i != 0) {
            i--;
            Object obj = this.a.a[i];
            if (obj != null) {
                consumer.accept(obj);
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        jn jnVar = this.a;
        int i = jnVar.h;
        jnVar.remove(obj);
        return this.a.h != i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ak, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

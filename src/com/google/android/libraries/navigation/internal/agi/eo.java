package com.google.android.libraries.navigation.internal.agi;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eo extends v {
    final /* synthetic */ et a;

    public eo(et etVar) {
        this.a = etVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public final hj spliterator() {
        return new hq(iterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 81);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final gw listIterator() {
        return new en(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final hi headSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final hi subSet(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        et etVar = this.a;
        if (etVar.k != 0) {
            return etVar.a[etVar.e];
        }
        throw new NoSuchElementException();
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        et etVar = this.a;
        int i = etVar.k;
        int i2 = etVar.e;
        while (i != 0) {
            i--;
            et etVar2 = this.a;
            int i3 = (int) etVar2.g[i2];
            consumer.accept(etVar2.a[i2]);
            i2 = i3;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, java.util.SortedSet
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final hi tailSet(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public final Object last() {
        et etVar = this.a;
        if (etVar.k != 0) {
            return etVar.a[etVar.f];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        et etVar = this.a;
        int i = etVar.k;
        etVar.remove(obj);
        return this.a.k != i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.v, com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}

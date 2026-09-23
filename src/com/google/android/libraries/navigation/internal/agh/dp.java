package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dp extends w {
    final /* synthetic */ du a;

    public dp(du duVar) {
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.w, com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.w, com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public final hl spliterator() {
        return new hr(iterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 337);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.w, java.util.SortedSet
    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf
    public final boolean e(long j) {
        return this.a.c(j);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v
    public final boolean l(long j) {
        du duVar = this.a;
        int i = duVar.k;
        duVar.b(j);
        return this.a.k != i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final long s() {
        du duVar = this.a;
        if (duVar.k != 0) {
            return duVar.a[duVar.e];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.w, com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final long t() {
        du duVar = this.a;
        if (duVar.k != 0) {
            return duVar.a[duVar.f];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.w
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ha m() {
        return new Cdo(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final hi v() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final hi w() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final hi x() {
        throw new UnsupportedOperationException();
    }
}

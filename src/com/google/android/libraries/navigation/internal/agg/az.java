package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends q {
    final /* synthetic */ be a;

    public az(be beVar) {
        this.a = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return dn.a(this, (Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public final fh spliterator() {
        return new fo(iterator(), com.google.android.libraries.navigation.internal.agc.h.b(this.a), 337);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, java.util.SortedSet
    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    public final boolean f(int i) {
        return this.a.c(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p
    public final boolean m(int i) {
        be beVar = this.a;
        int i2 = beVar.k;
        beVar.b(i);
        return this.a.k != i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.k;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q, com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final int t() {
        be beVar = this.a;
        if (beVar.k != 0) {
            return beVar.a[beVar.e];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final int u() {
        be beVar = this.a;
        if (beVar.k != 0) {
            return beVar.a[beVar.f];
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.q
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final eu n() {
        return new ay(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe w() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe x() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final fe y() {
        throw new UnsupportedOperationException();
    }
}

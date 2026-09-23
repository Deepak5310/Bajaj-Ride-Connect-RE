package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class w extends v implements hi {
    protected w() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ gs m() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: b */
    public /* synthetic */ hl spliterator() {
        throw null;
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object first() {
        return q();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return n((Long) obj);
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object last() {
        return r();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract gb m();

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final /* synthetic */ hi n(Long l) {
        return v();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final /* synthetic */ hi o(Long l, Long l2) {
        return w();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final /* synthetic */ hi p(Long l) {
        return x();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final /* synthetic */ Long q() {
        return Long.valueOf(s());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hi
    public final /* synthetic */ Long r() {
        return Long.valueOf(t());
    }

    @Override // com.google.android.libraries.navigation.internal.agh.v, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return o((Long) obj, (Long) obj2);
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return p((Long) obj);
    }
}

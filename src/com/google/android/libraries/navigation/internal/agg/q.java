package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class q extends p implements fe {
    protected q() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ ei n() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public /* synthetic */ boolean add(Object obj) {
        return dn.a(this, (Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: b */
    public /* synthetic */ fh spliterator() {
        throw null;
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return null;
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object first() {
        return r();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return o((Integer) obj);
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ Object last() {
        return s();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract dk n();

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final /* synthetic */ fe o(Integer num) {
        return w();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final /* synthetic */ fe p(Integer num, Integer num2) {
        return x();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final /* synthetic */ fe q(Integer num) {
        return y();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final /* synthetic */ Integer r() {
        return Integer.valueOf(t());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fe
    public final /* synthetic */ Integer s() {
        return Integer.valueOf(u());
    }

    @Override // com.google.android.libraries.navigation.internal.agg.p, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return p((Integer) obj, (Integer) obj2);
    }

    @Override // java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return q((Integer) obj);
    }
}

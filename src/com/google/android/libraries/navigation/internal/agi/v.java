package com.google.android.libraries.navigation.internal.agi;

import java.util.SortedSet;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class v extends u implements hi {
    protected v() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract ge iterator();

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ gi iterator() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: c */
    public /* synthetic */ hj spliterator() {
        throw null;
    }

    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return e(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.u, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    public /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return f(obj, obj2);
    }

    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return g(obj);
    }
}

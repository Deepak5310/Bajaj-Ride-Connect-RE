package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mo extends dr implements NavigableSet, Serializable {
    private static final long serialVersionUID = 0;
    private final NavigableSet a;
    private final SortedSet b;
    private transient mo c;

    public mo(NavigableSet navigableSet) {
        com.google.android.libraries.navigation.internal.yx.ar.q(navigableSet);
        this.a = navigableSet;
        this.b = Collections.unmodifiableSortedSet(navigableSet);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq, com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Collection aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dr, com.google.android.libraries.navigation.internal.yz.dq
    /* JADX INFO: renamed from: b */
    protected final /* synthetic */ Set aF() {
        return this.b;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return this.a.ceiling(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return hb.a(this.a.descendingIterator());
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        mo moVar = this.c;
        if (moVar != null) {
            return moVar;
        }
        mo moVar2 = new mo(this.a.descendingSet());
        this.c = moVar2;
        moVar2.c = this;
        return moVar2;
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return this.a.floor(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dr
    protected final SortedSet h() {
        return this.b;
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z) {
        return mp.h(this.a.headSet(obj, z));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return this.a.higher(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return this.a.lower(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return mp.h(this.a.subSet(obj, z, obj2, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z) {
        return mp.h(this.a.tailSet(obj, z));
    }
}

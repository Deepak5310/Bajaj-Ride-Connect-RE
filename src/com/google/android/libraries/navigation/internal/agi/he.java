package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class he extends gg implements Serializable, Cloneable, hd {
    private static final long serialVersionUID = -7046029254386353129L;

    protected he() {
    }

    private Object readResolve() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gg, com.google.android.libraries.navigation.internal.agi.m, com.google.android.libraries.navigation.internal.agi.gf, com.google.android.libraries.navigation.internal.agi.hd
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ gi listIterator() {
        return go.a;
    }

    public final Object clone() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gg, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gg, com.google.android.libraries.navigation.internal.agi.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return go.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gg, com.google.android.libraries.navigation.internal.agi.m, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return hr.a;
    }
}

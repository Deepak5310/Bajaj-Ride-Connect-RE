package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lc extends ky implements Serializable, Cloneable, lb {
    private static final long serialVersionUID = -7046029254386353129L;

    protected lc() {
    }

    private Object readResolve() {
        return le.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ky, com.google.android.libraries.navigation.internal.agi.ad, com.google.android.libraries.navigation.internal.agi.kx
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ gi listIterator() {
        return go.a;
    }

    public final Object clone() {
        return le.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ky, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ky, com.google.android.libraries.navigation.internal.agi.ad, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return go.a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ky, com.google.android.libraries.navigation.internal.agi.ad, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return hr.a;
    }
}

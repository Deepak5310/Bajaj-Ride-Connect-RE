package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hf extends gg implements Serializable, Cloneable, he {
    private static final long serialVersionUID = -7046029254386353129L;

    protected hf() {
    }

    private Object readResolve() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gg, com.google.android.libraries.navigation.internal.agh.n, com.google.android.libraries.navigation.internal.agh.gf, com.google.android.libraries.navigation.internal.agh.he
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ gs m() {
        return gx.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return ge.a(this, (Long) obj);
    }

    public final Object clone() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gg, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gg, com.google.android.libraries.navigation.internal.agh.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return gx.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gg, com.google.android.libraries.navigation.internal.agh.n, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Spliterator spliterator() {
        return hs.a;
    }
}

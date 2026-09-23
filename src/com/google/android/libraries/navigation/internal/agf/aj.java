package com.google.android.libraries.navigation.internal.agf;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends m implements Serializable, Cloneable, ai {
    private static final long serialVersionUID = -7046029254386353129L;

    protected aj() {
    }

    private Object readResolve() {
        return al.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.m, com.google.android.libraries.navigation.internal.agf.a, com.google.android.libraries.navigation.internal.agf.l
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ v iterator() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return k.a(this, (Float) obj);
    }

    public final Object clone() {
        return al.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.m, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.m, com.google.android.libraries.navigation.internal.agf.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.m, com.google.android.libraries.navigation.internal.agf.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return aq.a;
    }
}

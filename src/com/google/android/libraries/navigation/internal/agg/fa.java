package com.google.android.libraries.navigation.internal.agg;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fa extends dp implements Serializable, Cloneable, ez {
    private static final long serialVersionUID = -7046029254386353129L;

    protected fa() {
    }

    private Object readResolve() {
        return fd.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dp, com.google.android.libraries.navigation.internal.agg.h, com.google.android.libraries.navigation.internal.agg.Cdo
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ei n() {
        return eo.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return dn.a(this, (Integer) obj);
    }

    public final Object clone() {
        return fd.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dp, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dp, com.google.android.libraries.navigation.internal.agg.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator n() {
        return eo.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dp, com.google.android.libraries.navigation.internal.agg.h, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return fp.a;
    }
}

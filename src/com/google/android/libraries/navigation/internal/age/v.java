package com.google.android.libraries.navigation.internal.age;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends l implements Serializable, Cloneable, u {
    private static final long serialVersionUID = -7046029254386353129L;

    protected v() {
    }

    private Object readResolve() {
        return x.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.l, com.google.android.libraries.navigation.internal.age.a, com.google.android.libraries.navigation.internal.age.k
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ q iterator() {
        return t.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final /* synthetic */ boolean add(Object obj) {
        return j.a(this, (Double) obj);
    }

    public final Object clone() {
        return x.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.l, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // com.google.android.libraries.navigation.internal.age.l, com.google.android.libraries.navigation.internal.age.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return t.a;
    }

    @Override // com.google.android.libraries.navigation.internal.age.l, com.google.android.libraries.navigation.internal.age.a, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Spliterator spliterator() {
        return ae.a;
    }
}

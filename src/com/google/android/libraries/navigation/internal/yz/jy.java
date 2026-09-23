package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class jy extends df {
    private final Collection a;

    public jy(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final Collection aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new jr(this.a.iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return lj.a(this, objArr);
    }
}

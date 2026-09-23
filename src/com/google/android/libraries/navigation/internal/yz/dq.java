package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class dq extends df implements Set {
    protected dq() {
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df
    protected /* bridge */ /* synthetic */ Collection a() {
        throw null;
    }

    protected abstract Set b();

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    protected final boolean g(Collection collection) {
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        return mp.k(this, collection);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return b().hashCode();
    }
}

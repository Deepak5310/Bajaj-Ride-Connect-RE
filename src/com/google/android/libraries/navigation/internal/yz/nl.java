package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class nl extends df implements Set {
    final Collection a;

    public nl(Collection collection) {
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

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return mp.j(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return mp.a(this);
    }
}

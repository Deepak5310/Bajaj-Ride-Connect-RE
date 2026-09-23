package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cl extends dq {
    final /* synthetic */ Set a;

    public cl(Set set) {
        this.a = set;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq, com.google.android.libraries.navigation.internal.yz.df
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Collection aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dq
    /* JADX INFO: renamed from: b */
    protected final Set a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return obj != null && bt.c(this.a, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return bt.b(this, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return obj != null && bt.d(this.a, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        return g(collection);
    }
}

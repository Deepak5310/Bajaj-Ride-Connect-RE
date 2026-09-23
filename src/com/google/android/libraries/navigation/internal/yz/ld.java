package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ld extends dq {
    final /* synthetic */ lf a;

    public ld(lf lfVar) {
        this.a = lfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final Set aF() {
        return this.a.a.entrySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new lc(aF().iterator());
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

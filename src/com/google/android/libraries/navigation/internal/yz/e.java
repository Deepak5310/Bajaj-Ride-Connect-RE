package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends dq {
    final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.libraries.navigation.internal.yz.df, com.google.android.libraries.navigation.internal.yz.Cdo
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Set aF() {
        return this.a.a.keySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new jn(this.a.entrySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.a.e(obj);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        return g(collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        return e(collection);
    }
}

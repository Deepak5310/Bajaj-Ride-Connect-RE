package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.bt;
import com.google.android.libraries.navigation.internal.yz.df;
import com.google.android.libraries.navigation.internal.yz.hb;
import com.google.android.libraries.navigation.internal.yz.lj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends df {
    final Collection a;
    final Set b;

    public e(Collection collection, Set set) {
        this.a = collection;
        this.b = set;
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

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return bt.b(this, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new d(this.b.iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (am.a(it2.next(), obj)) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        return hb.h(iterator(), collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        return e(collection);
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

package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends dq {
    final Set a;
    final /* synthetic */ g b;

    public c(g gVar) {
        this.b = gVar;
        this.a = gVar.a.entrySet();
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
    protected final Set aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return this.a.contains(kc.j((Map.Entry) obj));
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return bt.b(this, collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        g gVar = this.b;
        return new a(gVar, gVar.a.entrySet().iterator());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!this.a.contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        this.b.b.a.remove(entry.getValue());
        this.a.remove(entry);
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

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.df, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        return lj.a(this, objArr);
    }
}

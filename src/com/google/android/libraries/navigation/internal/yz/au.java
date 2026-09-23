package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class au extends AbstractSet {
    final /* synthetic */ av a;

    public au(av avVar) {
        this.a = avVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.a.e();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof nc) {
            nc ncVar = (nc) obj;
            Map map = (Map) kc.e(this.a.j(), ncVar.b());
            if (map != null && bt.c(map.entrySet(), new el(ncVar.a(), ncVar.c()))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return this.a.c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (obj instanceof nc) {
            nc ncVar = (nc) obj;
            Map map = (Map) kc.e(this.a.j(), ncVar.b());
            if (map != null && bt.d(map.entrySet(), new el(ncVar.a(), ncVar.c()))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.h();
    }
}

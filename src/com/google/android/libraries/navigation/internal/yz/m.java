package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends jt {
    final /* synthetic */ o a;

    public m(o oVar) {
        this.a = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt
    public final Map a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return bt.c(this.a.a.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new n(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jt, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        o oVar = this.a;
        Object key = entry.getKey();
        ae aeVar = oVar.b;
        Collection collection = (Collection) kc.f(aeVar.a, key);
        if (collection == null) {
            return true;
        }
        int size = collection.size();
        collection.clear();
        aeVar.b -= size;
        return true;
    }
}

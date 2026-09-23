package com.google.android.libraries.navigation.internal.agi;

import com.google.android.libraries.navigation.internal.agg.Cdo;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bu extends bm implements Serializable, Cloneable, bs {
    private static final long serialVersionUID = -7046029254386353129L;
    protected transient hd b;
    protected transient hd c;
    protected transient Cdo d;

    public bu(Object obj) {
        super(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agi.bk
    public final /* synthetic */ Integer c(Object obj) {
        return bj.a(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ void clear() {
        bq.k();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return ((Integer) obj).intValue() == 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    @Deprecated
    public final hd e() {
        return entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        return ((Map.Entry) map.entrySet().iterator().next()).equals(((hf) entrySet()).listIterator().next());
    }

    @Override // java.util.Map
    public final /* synthetic */ void forEach(BiConsumer biConsumer) {
        bq.j(this, biConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer g(Object obj, Integer num) {
        bq.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return g(obj, (Integer) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer h(Object obj, Integer num, BiFunction biFunction) {
        bq.m();
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer i(Object obj, Integer num) {
        return bj.b(this, obj, num);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer j(Object obj, Integer num) {
        bq.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer k(Object obj) {
        return bj.c(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        if (this.c == null) {
            Object obj = this.a;
            he heVar = hh.a;
            this.c = new hf(obj);
        }
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer l(Object obj, Integer num) {
        bq.p();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final boolean m(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        bq.d(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ void n(Object obj, Integer num, Integer num2) {
        bq.q();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final hd entrySet() {
        if (this.b == null) {
            d dVar = new d(this.a);
            he heVar = hh.a;
            this.b = new hf(dVar);
        }
        return this.b;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return i(obj, (Integer) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        bq.f(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return k(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        bq.o();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        bq.h(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    public final String toString() {
        return "{" + this.a.toString() + "=>0}";
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        if (this.d == null) {
            com.google.android.libraries.navigation.internal.agg.fa faVar = com.google.android.libraries.navigation.internal.agg.fd.a;
            this.d = new com.google.android.libraries.navigation.internal.agg.fb(0);
        }
        return this.d;
    }
}

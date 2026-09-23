package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bt extends bl implements Serializable, Cloneable, bs {
    private static final long serialVersionUID = -7046029254386353129L;

    protected bt() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agi.bk
    public final /* synthetic */ Integer c(Object obj) {
        return bj.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bl
    public final Object clone() {
        return bv.a;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ hd e() {
        return bq.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bl, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    @Deprecated
    public final Integer g(Object obj, Integer num) {
        return num;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.c, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Integer) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer h(Object obj, Integer num, BiFunction biFunction) {
        bq.m();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bl, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final /* synthetic */ Integer i(Object obj, Integer num) {
        return bj.b(this, obj, num);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
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
    public final /* synthetic */ Set keySet() {
        return hh.a;
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

    @Override // com.google.android.libraries.navigation.internal.agi.bs
    public final hd p() {
        return hh.a;
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

    @Override // com.google.android.libraries.navigation.internal.agi.bl
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agg.fd.a;
    }
}

package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ib extends hu implements Serializable, Cloneable, ia {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ib() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agi.ht
    public final /* synthetic */ Integer c(Object obj) {
        return hs.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hu
    public final Object clone() {
        return ic.a;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ hd e() {
        return hy.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hu, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer g(Object obj, Integer num, BiFunction biFunction) {
        hy.i();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.x, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Integer) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer h(Object obj, Integer num) {
        return hs.b(this, obj, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hu, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer i(Object obj, Integer num) {
        hy.j();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer j(Object obj) {
        return hs.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ Integer k(Object obj, Integer num) {
        hy.l();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return le.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final boolean l(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    @Deprecated
    public final Integer m() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        hy.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final /* synthetic */ void n(Object obj, Integer num, Integer num2) {
        hy.m();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ia
    public final hd p() {
        return hh.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return h(obj, (Integer) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        hy.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return j(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        hy.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        hy.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hu
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agg.fd.a;
    }
}

package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.hh;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends v implements Serializable, Cloneable, aa {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ab() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agg.u
    public final /* synthetic */ Integer c(Object obj) {
        return t.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.v
    public final Object clone() {
        return ac.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        z.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        z.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        z.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return t.d(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return g();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.v, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ hd g() {
        return z.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Integer) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer h(Integer num, BiFunction biFunction) {
        z.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.v, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer i(Integer num, Function function) {
        z.m();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer j(Integer num, BiFunction biFunction) {
        z.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer k(Integer num, Integer num2, BiFunction biFunction) {
        z.o();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return fd.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer l(Integer num, Integer num2) {
        return t.b(this, num, num2);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer m(Integer num, Integer num2) {
        z.p();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        z.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer n(Object obj) {
        return t.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ Integer o(Integer num, Integer num2) {
        z.r();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final boolean p(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return l((Integer) obj, (Integer) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        z.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    @Deprecated
    public final Integer q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final /* synthetic */ void r(Integer num, Integer num2, Integer num3) {
        z.s();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return n(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        z.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        z.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        r((Integer) obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.aa
    public final hd t() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.v
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return fd.a;
    }
}

package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends ay implements Serializable, Cloneable, be {
    private static final long serialVersionUID = -7046029254386353129L;

    protected bf() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agh.ax
    public final /* synthetic */ Integer c(Object obj) {
        return aw.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ay
    public final Object clone() {
        return bg.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        bc.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        bc.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        bc.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return aw.d(this, obj);
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

    @Override // com.google.android.libraries.navigation.internal.agh.ay, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd g() {
        return bc.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.d, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Integer) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer h(Long l, BiFunction biFunction) {
        bc.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ay, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer i(Long l, Function function) {
        bc.m();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer j(Long l, BiFunction biFunction) {
        bc.n();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer k(Long l, Integer num, BiFunction biFunction) {
        bc.o();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer l(Long l, Integer num) {
        return aw.b(this, l, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer m(Long l, Integer num) {
        bc.p();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        bc.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer n(Object obj) {
        return aw.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ Integer o(Long l, Integer num) {
        bc.r();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final boolean p(int i) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return l((Long) obj, (Integer) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        bc.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    @Deprecated
    public final Integer q() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final /* synthetic */ void r(Long l, Integer num, Integer num2) {
        bc.s();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return n(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        bc.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        bc.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        r((Long) obj, (Integer) obj2, (Integer) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.be
    public final com.google.android.libraries.navigation.internal.agi.hd t() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ay
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agg.fd.a;
    }
}

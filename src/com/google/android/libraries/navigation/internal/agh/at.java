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
public final class at extends am implements Serializable, Cloneable, as {
    private static final long serialVersionUID = -7046029254386353129L;

    protected at() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.am
    public final Object clone() {
        return au.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        aq.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        aq.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        aq.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return ak.d(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agh.al
    public final /* synthetic */ Double d(Object obj) {
        return ak.a(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return h();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.am, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    /* JADX INFO: renamed from: g */
    public final he keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Double) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd h() {
        return aq.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.am, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double i(Long l, BiFunction biFunction) {
        aq.l();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double j(Long l, Function function) {
        aq.m();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double k(Long l, BiFunction biFunction) {
        aq.n();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double l(Long l, Double d, BiFunction biFunction) {
        aq.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double m(Long l, Double d) {
        return ak.b(this, l, d);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        aq.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double n(Long l, Double d) {
        aq.p();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double o(Object obj) {
        return ak.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ Double p(Long l, Double d) {
        aq.r();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return m((Long) obj, (Double) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        aq.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final boolean q(double d) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    @Deprecated
    public final Double r() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return o(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        aq.q();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        aq.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        s((Long) obj, (Double) obj2, (Double) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final /* synthetic */ void s(Long l, Double d, Double d2) {
        aq.s();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.am
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.age.x.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.as
    public final com.google.android.libraries.navigation.internal.agi.hd x() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
    }
}

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
public final class cf extends by implements Serializable, Cloneable, ce {
    private static final long serialVersionUID = -7046029254386353129L;

    protected cf() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.by
    public final Object clone() {
        return ch.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        cd.b(this, obj, biFunction);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        cd.c(this, obj, function);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        cd.d(this, obj, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return bw.d(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agh.bx
    public final /* synthetic */ Long d(Object obj) {
        return bw.a(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return h();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.by, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: f */
    public final gf values() {
        throw null;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    /* JADX INFO: renamed from: g */
    public final he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Long) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd h() {
        return cd.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.by, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long i(Long l, BiFunction biFunction) {
        cd.n();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long j(Long l, Function function) {
        cd.o();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long k(Long l, BiFunction biFunction) {
        cd.p();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    @Deprecated
    public final Long l(Object obj, Long l) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long m(Long l, Long l2, BiFunction biFunction) {
        cd.r();
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        cd.f(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long n(Long l, Long l2) {
        return bw.b(this, l, l2);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long o(Long l, Long l2) {
        cd.s();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long p(Object obj) {
        return bw.c(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return n((Long) obj, (Long) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        cd.h(this, obj, obj2);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ Long q(Long l, Long l2) {
        cd.u();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final boolean r(long j) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return p(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        cd.t();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        cd.j(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        s((Long) obj, (Long) obj2, (Long) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final /* synthetic */ boolean s(Long l, Long l2, Long l3) {
        cd.v();
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.by
    public final String toString() {
        return "{}";
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ce
    public final com.google.android.libraries.navigation.internal.agi.hd u() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return hh.a;
    }
}

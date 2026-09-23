package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class df extends cx implements Serializable, Cloneable, de {
    private static final long serialVersionUID = -7046029254386353129L;

    protected df() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cx
    public final Object clone() {
        return dg.a;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agi.cw
    public final /* synthetic */ Long d(Object obj) {
        return cv.a(this, obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cx, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ hd f() {
        return db.a(this);
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return d(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Long) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long h(Object obj, Long l, BiFunction biFunction) {
        db.i();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cx, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long i(Object obj, Long l) {
        return cv.b(this, obj, l);
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long j(Object obj, Long l) {
        db.j();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long k(Object obj) {
        return cv.c(this, obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ Long l(Object obj, Long l) {
        db.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final boolean m(long j) {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        db.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    @Deprecated
    public final Long n() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final /* synthetic */ void o(Object obj, Long l, Long l2) {
        db.m();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return i(obj, (Long) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        db.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return k(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        db.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        db.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        o(obj, (Long) obj2, (Long) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.de
    public final hd t() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cx
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agh.hh.a;
    }
}

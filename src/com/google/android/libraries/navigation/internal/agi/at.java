package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at extends an implements Serializable, Cloneable, as {
    private static final long serialVersionUID = -7046029254386353129L;

    protected at() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agi.am
    public final /* synthetic */ Float c(Object obj) {
        return al.a(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.an
    public final Object clone() {
        return au.a;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ hd e() {
        return ar.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.an, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float g(Object obj, Float f, BiFunction biFunction) {
        ar.i();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.a, com.google.android.libraries.navigation.internal.agc.d
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return c(obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return (Float) obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float h(Object obj, Float f) {
        return al.b(this, obj, f);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.an, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float i(Object obj, Float f) {
        ar.j();
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float j(Object obj) {
        return al.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ Float k(Object obj, Float f) {
        ar.l();
        return null;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final boolean l(float f) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    @Deprecated
    public final Float m() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        ar.c(this, obj, obj2, biFunction);
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final /* synthetic */ void n(Object obj, Float f, Float f2) {
        ar.m();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.as
    public final hd p() {
        return hh.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return h(obj, (Float) obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        ar.e(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        return j(obj);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        ar.k();
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        ar.g(this, obj, obj2);
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        n(obj, (Float) obj2, (Float) obj3);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.an
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agf.al.a;
    }
}

package com.google.android.libraries.navigation.internal.agi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ez extends ei implements Serializable, Cloneable, ey {
    private static final long serialVersionUID = -7046029254386353129L;

    protected ez() {
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey
    public final /* synthetic */ hd b() {
        return ev.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ei
    public final Object clone() {
        return fa.a;
    }

    @Override // java.util.Map
    public final /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ev.b(this, obj, biFunction);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ev.c(this, obj, biFunction);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey
    /* JADX INFO: renamed from: d */
    public final hd i() {
        return hh.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return b();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ei, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ei, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return hh.a;
    }

    @Override // java.util.Map
    public final /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ev.d(this, obj, obj2, biFunction);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final /* synthetic */ Object put(Object obj, Object obj2) {
        return eg.a();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return ev.e(this, obj, obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ey, java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return eg.b();
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean remove(Object obj, Object obj2) {
        return ev.h(this, obj, obj2);
    }

    @Override // java.util.Map
    public final /* synthetic */ Object replace(Object obj, Object obj2) {
        return ev.f(this, obj, obj2);
    }

    @Override // java.util.Map
    public final /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return ev.i(this, obj, obj2, obj3);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ei
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return hh.a;
    }
}

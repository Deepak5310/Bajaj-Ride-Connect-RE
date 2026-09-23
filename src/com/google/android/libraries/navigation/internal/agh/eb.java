package com.google.android.libraries.navigation.internal.agh;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eb extends dj implements Serializable, Cloneable, ea {
    private static final long serialVersionUID = -7046029254386353129L;

    protected eb() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dj
    public final Object clone() {
        return ec.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return dh.d(this, obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: d */
    public final he keySet() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: e */
    public final com.google.android.libraries.navigation.internal.agi.gf values() {
        throw null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return f();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dj, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd f() {
        return dw.a(this);
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    public final /* synthetic */ Object g(Long l, Object obj) {
        return dh.b(this, l, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.h, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return dh.a(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final Object getOrDefault(Object obj, Object obj2) {
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dj, java.util.Map
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

    @Override // com.google.android.libraries.navigation.internal.agh.ea
    /* JADX INFO: renamed from: l */
    public final com.google.android.libraries.navigation.internal.agi.hd t() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return g((Long) obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return dh.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.dj
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
    }
}

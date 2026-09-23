package com.google.android.libraries.navigation.internal.agh;

import com.google.android.libraries.navigation.internal.agi.kx;
import com.google.android.libraries.navigation.internal.agi.le;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fa extends ev implements Serializable, Cloneable, ez {
    private static final long serialVersionUID = -7046029254386353129L;

    protected fa() {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ev
    public final Object clone() {
        return fb.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return et.d(this, obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    public final /* synthetic */ com.google.android.libraries.navigation.internal.agi.hd e() {
        return ey.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ev, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    /* JADX INFO: renamed from: f */
    public final kx values() {
        throw null;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    public final /* synthetic */ Object g(Long l, Object obj) {
        return et.b(this, l, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.l, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return et.a(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final Object getOrDefault(Object obj, Object obj2) {
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ev, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ez
    public final com.google.android.libraries.navigation.internal.agi.hd i() {
        return com.google.android.libraries.navigation.internal.agi.hh.a;
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
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return g((Long) obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return et.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ev
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return le.a;
    }
}

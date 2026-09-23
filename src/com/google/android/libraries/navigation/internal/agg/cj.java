package com.google.android.libraries.navigation.internal.agg;

import com.google.android.libraries.navigation.internal.agi.hd;
import com.google.android.libraries.navigation.internal.agi.hh;
import com.google.android.libraries.navigation.internal.agi.le;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cj extends ce implements Serializable, Cloneable, ci {
    private static final long serialVersionUID = -7046029254386353129L;

    protected cj() {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ce
    public final Object clone() {
        return ck.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ boolean containsKey(Object obj) {
        return cc.d(this, obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final /* synthetic */ hd e() {
        return ch.a(this);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return e();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ce, java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // java.util.Map
    public final void forEach(BiConsumer biConsumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final /* synthetic */ Object g(Integer num, Object obj) {
        return cc.b(this, num, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.f, com.google.android.libraries.navigation.internal.agc.d
    public final /* synthetic */ Object get(Object obj) {
        return cc.a(this, obj);
    }

    @Override // java.util.Map
    @Deprecated
    public final Object getOrDefault(Object obj, Object obj2) {
        return obj2;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ce, java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ci
    public final hd i() {
        return hh.a;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* synthetic */ Set keySet() {
        return fd.a;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return g((Integer) obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final /* synthetic */ Object remove(Object obj) {
        return cc.c(this, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ce
    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* synthetic */ Collection values() {
        return le.a;
    }
}

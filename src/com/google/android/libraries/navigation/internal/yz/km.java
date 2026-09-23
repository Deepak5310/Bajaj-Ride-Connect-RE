package com.google.android.libraries.navigation.internal.yz;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class km extends kb {
    public final kd a;

    public km(kd kdVar) {
        this.a = kdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb
    public final Set b() {
        return new kl(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.a.q();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.a.s(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (containsKey(obj)) {
            return this.a.c(obj);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.a.A();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb, java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.a.x();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (containsKey(obj)) {
            return this.a.d(obj);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.a.x().size();
    }
}

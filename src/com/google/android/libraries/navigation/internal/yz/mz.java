package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mz extends kb {
    final /* synthetic */ nb a;

    public mz(nb nbVar) {
        this.a = nbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.kb
    public final Set b() {
        return new my(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.a.k(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (this.a.k(obj)) {
            return this.a.i(Objects.requireNonNull(obj));
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Map) this.a.a.remove(obj);
    }
}

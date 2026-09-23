package com.google.android.libraries.navigation.internal.yz;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lw extends ev {
    final /* synthetic */ lx a;

    public lw(lx lxVar) {
        this.a = lxVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.a.c);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.a.a[i2]), Objects.requireNonNull(this.a.a[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

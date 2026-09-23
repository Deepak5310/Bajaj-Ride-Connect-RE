package com.google.android.libraries.navigation.internal.yz;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lz extends ev {
    private final transient Object[] a;
    private final transient int b;
    private final transient int c;

    public lz(Object[] objArr, int i, int i2) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.c);
        return Objects.requireNonNull(this.a[i + i + this.b]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

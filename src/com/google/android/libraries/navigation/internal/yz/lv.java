package com.google.android.libraries.navigation.internal.yz;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lv extends ev {
    public static final ev a = new lv(new Object[0], 0);
    final transient Object[] b;
    public final transient int c;

    public lv(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, i, this.c);
        return i + this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int c() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final Object[] g() {
        return this.b;
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.c);
        return Objects.requireNonNull(this.b[i]);
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

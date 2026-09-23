package com.google.android.libraries.navigation.internal.yz;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eu extends ev {
    final transient int a;
    final transient int b;
    final /* synthetic */ ev c;

    public eu(ev evVar, int i, int i2) {
        this.c = evVar;
        this.a = i;
        this.b = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int b() {
        return this.c.c() + this.a + this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int c() {
        return this.c.c() + this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final Object[] g() {
        return this.c.g();
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, this.b);
        return this.c.get(i + this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev
    /* JADX INFO: renamed from: i */
    public final ev subList(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.j(i, i2, this.b);
        int i3 = this.a;
        return this.c.subList(i + i3, i2 + i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

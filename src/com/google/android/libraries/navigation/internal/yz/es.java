package com.google.android.libraries.navigation.internal.yz;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class es extends ev {
    private final transient ev a;

    public es(ev evVar) {
        this.a = evVar;
    }

    private final int A(int i) {
        return size() - i;
    }

    private final int z(int i) {
        return (size() - 1) - i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return this.a.f();
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.google.android.libraries.navigation.internal.yx.ar.p(i, size());
        return this.a.get(z(i));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev
    public final ev h() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev
    /* JADX INFO: renamed from: i */
    public final ev subList(int i, int i2) {
        com.google.android.libraries.navigation.internal.yx.ar.j(i, i2, size());
        return this.a.subList(A(i2), A(i)).h();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.a.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return z(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ev, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.a.indexOf(obj);
        if (iIndexOf >= 0) {
            return z(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
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

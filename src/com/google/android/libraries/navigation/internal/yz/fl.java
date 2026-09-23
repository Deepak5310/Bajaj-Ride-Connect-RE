package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fl extends ek {
    public final fd a;

    public fl(fd fdVar) {
        this.a = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return obj != null && hb.g(new fi(this), obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final ev d() {
        return new fj(this.a.entrySet().d());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return new fi(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* synthetic */ Iterator listIterator() {
        return new fi(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new fk(this.a);
    }
}

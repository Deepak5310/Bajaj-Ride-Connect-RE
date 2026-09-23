package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fh extends gn {
    private final fd a;

    public fh(fd fdVar) {
        this.a = fdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gn, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return this.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gn
    public final Object h(int i) {
        return ((Map.Entry) this.a.entrySet().d().get(i)).getKey();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gn, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator listIterator() {
        return listIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.gn, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new fg(this.a);
    }
}

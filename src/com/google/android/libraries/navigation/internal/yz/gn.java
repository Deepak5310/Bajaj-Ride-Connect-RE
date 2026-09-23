package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class gn extends fy {
    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        return d().a(objArr, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public nn listIterator() {
        throw null;
    }

    public abstract Object h(int i);

    @Override // com.google.android.libraries.navigation.internal.yz.fy
    public final ev k() {
        return new gm(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

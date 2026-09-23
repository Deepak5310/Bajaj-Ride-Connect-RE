package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fr extends ek {
    private static final long serialVersionUID = 0;
    private final transient fs a;

    public fr(fs fsVar) {
        this.a = fsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final int a(Object[] objArr, int i) {
        nn nnVarListIterator = this.a.map.values().listIterator();
        while (nnVarListIterator.hasNext()) {
            i = ((ek) nnVarListIterator.next()).a(objArr, i);
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.z(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return new fn(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public final boolean f() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.a.size;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}

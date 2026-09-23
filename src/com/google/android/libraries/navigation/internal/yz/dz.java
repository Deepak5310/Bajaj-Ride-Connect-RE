package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dz extends ec {
    final /* synthetic */ ed a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz(ed edVar) {
        super(edVar);
        this.a = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ec
    public final Object a(int i) {
        return this.a.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        ed edVar = this.a;
        int iB = eh.b(obj);
        int iC = edVar.c(obj, iB);
        if (iC == -1) {
            return false;
        }
        this.a.j(iC, iB);
        return true;
    }
}

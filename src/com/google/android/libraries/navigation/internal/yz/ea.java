package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ea extends ec {
    final /* synthetic */ ed a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea(ed edVar) {
        super(edVar);
        this.a = edVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ec
    public final Object a(int i) {
        return this.a.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        ed edVar = this.a;
        int iB = eh.b(obj);
        int iF = edVar.f(obj, iB);
        if (iF == -1) {
            return false;
        }
        this.a.k(iF, iB);
        return true;
    }
}

package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class kx extends mm {
    public abstract ku a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        a().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof kt) {
            kt ktVar = (kt) obj;
            if (ktVar.a() > 0 && a().b(ktVar.b()) == ktVar.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!(obj instanceof kt)) {
            return false;
        }
        kt ktVar = (kt) obj;
        Object objB = ktVar.b();
        int iA = ktVar.a();
        if (iA != 0) {
            return a().i(objB, iA);
        }
        return false;
    }
}

package com.google.android.libraries.navigation.internal.afr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements k {
    private static final Object a = new Object();
    private volatile k b;
    private volatile Object c = a;

    private q(k kVar) {
        this.b = kVar;
    }

    public static k b(k kVar) {
        return ((kVar instanceof q) || (kVar instanceof e)) ? kVar : new q(kVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final Object a() {
        Object obj = this.c;
        if (obj != a) {
            return obj;
        }
        k kVar = this.b;
        if (kVar == null) {
            return this.c;
        }
        Object objA = kVar.a();
        this.c = objA;
        this.b = null;
        return objA;
    }
}

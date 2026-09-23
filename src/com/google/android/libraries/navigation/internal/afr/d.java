package com.google.android.libraries.navigation.internal.afr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements f {
    private k a;

    public static void b(d dVar, k kVar) {
        j.b(kVar);
        if (dVar.a != null) {
            throw new IllegalStateException();
        }
        dVar.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final Object a() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.a();
        }
        throw new IllegalStateException();
    }
}

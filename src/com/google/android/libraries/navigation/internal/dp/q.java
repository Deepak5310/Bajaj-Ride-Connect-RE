package com.google.android.libraries.navigation.internal.dp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ v a;

    public q(v vVar) {
        this.a = vVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        String str;
        com.google.android.libraries.navigation.internal.tj.j jVarA = com.google.android.libraries.navigation.internal.rw.t.a(bVar);
        if (jVarA != null) {
            str = jVarA.b;
        } else {
            com.google.android.libraries.navigation.internal.tj.h hVar = ((com.google.android.libraries.navigation.internal.rw.i) bVar).e;
            str = hVar != null ? hVar.b : null;
        }
        k kVar = this.a.f407n;
        kVar.w = str;
        if (kVar.o != null) {
            if (kVar.q != com.google.android.libraries.navigation.internal.dt.c.NAVIGATION || str == null) {
                kVar.o.d = null;
            } else {
                kVar.o.d = str;
            }
        }
    }
}

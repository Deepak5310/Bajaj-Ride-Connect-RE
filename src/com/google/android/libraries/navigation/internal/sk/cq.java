package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cq implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ ct a;

    public cq(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.vn.d dVar;
        if (this.a.d() && (dVar = (com.google.android.libraries.navigation.internal.vn.d) mVar.c()) != null) {
            com.google.android.libraries.navigation.internal.bp.bw bwVar = dVar.d;
            com.google.android.libraries.navigation.internal.vn.a aVar = dVar.f;
            if (bwVar == null || aVar == null) {
                return;
            }
            com.google.android.libraries.navigation.internal.bp.bq bqVarA = bwVar.a();
            int i = bqVarA.m;
            String strC = dVar.c();
            ((com.google.android.libraries.navigation.internal.sl.d) this.a.a.a()).i(dVar, com.google.android.libraries.navigation.internal.sl.h.a, new cp(this, bqVarA, i, aVar.d, strC));
            this.a.c.a(new com.google.android.libraries.navigation.internal.sm.d(bqVarA, strC));
            com.google.android.libraries.navigation.internal.ia.b bVar = (com.google.android.libraries.navigation.internal.ia.b) this.a.e.a();
            String str = aVar.a;
            double d = aVar.c;
            com.google.android.libraries.navigation.internal.bp.bz bzVar = aVar.b;
            bVar.c(new com.google.android.libraries.navigation.internal.sm.b(str, bzVar.b(), bzVar.a(), i, d, bzVar.e()));
        }
    }
}

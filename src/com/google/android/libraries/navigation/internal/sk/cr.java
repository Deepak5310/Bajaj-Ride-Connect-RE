package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cr implements com.google.android.libraries.navigation.internal.rw.m, com.google.android.libraries.navigation.internal.rw.r, com.google.android.libraries.navigation.internal.rw.aa {
    final /* synthetic */ ct a;

    public cr(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.m
    public final void a(com.google.android.libraries.navigation.internal.tj.o oVar) {
        if (this.a.f.y(com.google.android.libraries.navigation.internal.iv.ab.aM, true)) {
            ((com.google.android.libraries.navigation.internal.sl.d) this.a.a.a()).i(new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.vn.c.PREROLL_SOUND_ONLY, null, "", null, null, com.google.android.libraries.navigation.internal.vn.d.a(com.google.android.libraries.navigation.internal.vn.b.TAH_LAH_LAH)), com.google.android.libraries.navigation.internal.sl.h.f, null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.aa
    public final void av(com.google.android.libraries.navigation.internal.tj.o oVar, int i, boolean z) {
        if (z) {
            com.google.android.libraries.navigation.internal.bp.bg bgVarA = oVar.a();
            ct ctVar = this.a;
            ((com.google.android.libraries.navigation.internal.sn.h) ctVar.b.a()).b = bgVarA.O;
            ctVar.d.b = true;
            ((com.google.android.libraries.navigation.internal.sl.d) ctVar.a.a()).u();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rw.r
    public final void j(com.google.android.libraries.navigation.internal.tj.o oVar, com.google.android.libraries.navigation.internal.db.r rVar) {
        this.a.h = oVar.c().o;
    }
}

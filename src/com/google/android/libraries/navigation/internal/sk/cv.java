package com.google.android.libraries.navigation.internal.sk;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cv extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public cv(int i, Class cls, ct ctVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, ctVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.vn.d dVarD;
        int i = this.f;
        if (i == 0) {
            ct ctVar = (ct) this.c;
            com.google.android.libraries.navigation.internal.sd.a aVar2 = (com.google.android.libraries.navigation.internal.sd.a) aVar;
            if (ctVar.d()) {
                return;
            }
            ((com.google.android.libraries.navigation.internal.sl.d) ctVar.a.a()).t(ctVar.c().e(aVar2.a, aVar2.c, aVar2.d, aVar2.b));
            return;
        }
        if (i != 1) {
            ct ctVar2 = (ct) this.c;
            com.google.android.libraries.navigation.internal.cw.d dVar = (com.google.android.libraries.navigation.internal.cw.d) aVar;
            if (ctVar2.g && !dVar.c) {
                ((com.google.android.libraries.navigation.internal.sl.d) ctVar2.a.a()).i(new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.vn.c.ERROR, null, ctVar2.c().a.getString(com.google.android.libraries.navigation.internal.dw.h.D), new com.google.android.libraries.navigation.internal.bp.ab(12), null, -1), com.google.android.libraries.navigation.internal.sl.h.e, null);
            }
            ctVar2.g = dVar.c;
            return;
        }
        ct ctVar3 = (ct) this.c;
        com.google.android.libraries.navigation.internal.sd.b bVar = (com.google.android.libraries.navigation.internal.sd.b) aVar;
        if (ctVar3.d() || (dVarD = ctVar3.c().d(bVar.a, bVar.e, bVar.b, bVar.d, bVar.c)) == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.bp.bw bwVar = dVarD.d;
        com.google.android.libraries.navigation.internal.vn.a aVar3 = dVarD.f;
        if (bwVar == null || aVar3 == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.bp.bq bqVarA = bwVar.a();
        int i2 = bqVarA.m;
        String strC = dVarD.c();
        ((com.google.android.libraries.navigation.internal.sl.d) ctVar3.a.a()).i(dVarD, com.google.android.libraries.navigation.internal.sl.h.a, new co(ctVar3, bqVarA, i2, aVar3.d, strC));
        ctVar3.c.a(new com.google.android.libraries.navigation.internal.sm.d(bqVarA, strC));
        com.google.android.libraries.navigation.internal.ia.b bVar2 = (com.google.android.libraries.navigation.internal.ia.b) ctVar3.e.a();
        String str = aVar3.a;
        double d = aVar3.c;
        com.google.android.libraries.navigation.internal.bp.bz bzVar = aVar3.b;
        bVar2.c(new com.google.android.libraries.navigation.internal.sm.b(str, bzVar.b(), bzVar.a(), i2, d, bzVar.e()));
    }
}

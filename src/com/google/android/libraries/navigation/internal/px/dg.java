package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dg {
    public final com.google.android.libraries.navigation.internal.yy.b a;
    public final fy b;
    public final fy c;
    private final com.google.android.libraries.navigation.internal.yy.b d;

    public dg(fy fyVar, fy fyVar2) {
        this.b = fyVar;
        this.c = fyVar2;
        com.google.android.libraries.navigation.internal.yy.h hVar = new com.google.android.libraries.navigation.internal.yy.h();
        hVar.f(5000L);
        hVar.b().c(new dd(this));
        com.google.android.libraries.navigation.internal.yy.h hVar2 = new com.google.android.libraries.navigation.internal.yy.h();
        hVar2.f(5000L);
        hVar2.b().c(new de(this));
        com.google.android.libraries.navigation.internal.yy.h hVar3 = new com.google.android.libraries.navigation.internal.yy.h();
        hVar3.f(250L);
        this.d = hVar3.b().a();
        com.google.android.libraries.navigation.internal.yy.h hVar4 = new com.google.android.libraries.navigation.internal.yy.h();
        hVar4.f(250L);
        this.a = hVar4.b().a();
    }

    public final df a(final com.google.android.libraries.navigation.internal.adg.ef efVar) throws ExecutionException {
        com.google.android.libraries.navigation.internal.adg.dt dtVar = efVar.c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        final com.google.android.libraries.navigation.internal.yx.an anVarA = di.a(dtVar.c, this.c);
        if (!anVarA.g()) {
            com.google.android.libraries.navigation.internal.adg.dt dtVar2 = efVar.d;
            if (dtVar2 == null) {
                dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            anVarA = di.a(dtVar2.c, this.c);
        }
        String str = (String) this.d.b(efVar, new Callable() { // from class: com.google.android.libraries.navigation.internal.px.dc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return di.c(efVar, anVarA);
            }
        });
        if (di.d(com.google.android.libraries.navigation.internal.rb.a.a(efVar), this.c)) {
            return new df();
        }
        if (anVarA.g()) {
            return df.a(anVarA, str);
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.ac);
        efVar.h(bhVarS);
        Object objK = efVar.w.k(bhVarS.d);
        for (com.google.android.libraries.navigation.internal.adg.ao aoVar : ((com.google.android.libraries.navigation.internal.adg.u) (objK == null ? bhVarS.b : bhVarS.c(objK))).b) {
            if (this.b.contains(Integer.valueOf(aoVar.c))) {
                int i = aoVar.c;
                return new df();
            }
        }
        return null;
    }
}

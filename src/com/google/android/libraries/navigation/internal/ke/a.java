package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends g {
    private static final fd a;
    private final com.google.android.libraries.navigation.internal.zr.i d;

    static {
        ez ezVar = new ez();
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.APP_STARTED_COLD, com.google.android.libraries.navigation.internal.zp.n.v);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.APP_STARTED_HOT, com.google.android.libraries.navigation.internal.zp.n.t);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.APP_BACKGROUNDED, com.google.android.libraries.navigation.internal.zp.n.o);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.APP_CRASHED, com.google.android.libraries.navigation.internal.zp.n.p);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.APP_LOADED_WITH_NO_LABELS_ON_MAP, com.google.android.libraries.navigation.internal.zp.n.s);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.EXTERNAL_INVOCATION_STARTED, com.google.android.libraries.navigation.internal.zp.n.r);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.EXTERNAL_INVOCATION_COMPLETED, com.google.android.libraries.navigation.internal.zp.n.q);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.PROJECTED_APP_STARTED_COLD, com.google.android.libraries.navigation.internal.zp.n.CN);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.PROJECTED_APP_STARTED_HOT, com.google.android.libraries.navigation.internal.zp.n.CO);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.PROJECTED_APP_BACKGROUNDED, com.google.android.libraries.navigation.internal.zp.n.CM);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.WIDGET_STARTED, com.google.android.libraries.navigation.internal.zp.n.CU);
        ezVar.f(com.google.android.libraries.navigation.internal.afl.l.RUNNING, com.google.android.libraries.navigation.internal.zp.n.u);
        a = ezVar.d();
    }

    public a(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.zr.i iVar) {
        super(aVar.a());
        this.d = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        com.google.android.libraries.navigation.internal.zr.i iVar = this.d;
        if ((iVar.b & 1) != 0) {
            fd fdVar = a;
            com.google.android.libraries.navigation.internal.afl.l lVarB = com.google.android.libraries.navigation.internal.afl.l.b(iVar.c);
            if (lVarB == null) {
                lVarB = com.google.android.libraries.navigation.internal.afl.l.APP_STARTED_COLD;
            }
            com.google.android.libraries.navigation.internal.zp.n nVar = (com.google.android.libraries.navigation.internal.zp.n) fdVar.get(lVarB);
            if (nVar != null) {
                ak akVarC = c();
                if (!akVarC.b.H()) {
                    akVarC.v();
                }
                al alVar = (al) akVarC.b;
                al alVar2 = al.a;
                alVar.b |= 64;
                alVar.e = nVar.a;
                if (!pdVar.b.H()) {
                    pdVar.v();
                }
                pe peVar = (pe) pdVar.b;
                al alVar3 = (al) akVarC.t();
                pe peVar2 = pe.a;
                alVar3.getClass();
                peVar.f = alVar3;
                peVar.b |= 4;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.i iVar = this.d;
        bi biVar = (bi) bhVar.b;
        bi biVar2 = bi.a;
        iVar.getClass();
        biVar.o = iVar;
        biVar.b |= 65536;
    }
}

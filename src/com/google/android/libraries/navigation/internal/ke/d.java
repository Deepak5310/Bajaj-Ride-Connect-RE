package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zr.ab;
import com.google.android.libraries.navigation.internal.zr.ac;
import com.google.android.libraries.navigation.internal.zr.be;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;
import com.google.android.libraries.navigation.internal.zr.dg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends g {
    private final com.google.android.libraries.navigation.internal.afl.l a;
    private final com.google.android.libraries.navigation.internal.zr.s d;
    private final dg e;
    private final be f;

    public d(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.afl.l lVar, com.google.android.libraries.navigation.internal.zr.s sVar, dg dgVar, be beVar) {
        super(aVar.a());
        this.a = lVar;
        this.d = sVar;
        this.e = dgVar;
        this.f = beVar;
    }

    private final synchronized void w(ab abVar) {
        com.google.android.libraries.navigation.internal.afl.l lVar = this.a;
        if (lVar != null) {
            ar.q(lVar);
            if (!abVar.b.H()) {
                abVar.v();
            }
            ac acVar = (ac) abVar.b;
            ac acVar2 = ac.a;
            acVar.c = lVar.M;
            acVar.b |= 1;
        }
        com.google.android.libraries.navigation.internal.zr.s sVar = this.d;
        if (sVar != null) {
            ar.q(sVar);
            if (!abVar.b.H()) {
                abVar.v();
            }
            ac acVar3 = (ac) abVar.b;
            ac acVar4 = ac.a;
            acVar3.d = sVar;
            acVar3.b |= 2;
        }
        dg dgVar = this.e;
        if (dgVar != null) {
            ar.q(dgVar);
            if (!abVar.b.H()) {
                abVar.v();
            }
            ac acVar5 = (ac) abVar.b;
            ac acVar6 = ac.a;
            acVar5.e = dgVar;
            acVar5.b |= 4;
        }
        be beVar = this.f;
        if (beVar != null) {
            ar.q(beVar);
            if (!abVar.b.H()) {
                abVar.v();
            }
            ac acVar7 = (ac) abVar.b;
            ac acVar8 = ac.a;
            acVar7.f = beVar;
            acVar7.b |= 64;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        ak akVarC = c();
        int i = com.google.android.libraries.navigation.internal.zp.n.CP.a;
        if (!akVarC.b.H()) {
            akVarC.v();
        }
        al alVar = (al) akVarC.b;
        al alVar2 = al.a;
        alVar.b |= 64;
        alVar.e = i;
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

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        ac acVar = ((bi) bhVar.b).f;
        if (acVar == null) {
            acVar = ac.a;
        }
        bb bbVar = (bb) acVar.aH(5, null);
        bbVar.x(acVar);
        ab abVar = (ab) bbVar;
        w(abVar);
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        ac acVar2 = (ac) abVar.t();
        acVar2.getClass();
        biVar.f = acVar2;
        biVar.b |= 64;
    }
}

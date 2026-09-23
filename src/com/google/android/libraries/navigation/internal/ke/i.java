package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;
import com.google.android.libraries.navigation.internal.zr.bn;
import com.google.android.libraries.navigation.internal.zr.bo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends g {
    private static final h a = new h();
    private final fy d;

    public i(fy fyVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar.a());
        this.d = fyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        ak akVarC = c();
        int i = com.google.android.libraries.navigation.internal.zp.n.C.a;
        if (!akVarC.b.H()) {
            akVarC.v();
        }
        al alVar = (al) akVarC.b;
        al alVar2 = al.a;
        alVar.b |= 64;
        alVar.e = i;
        al alVar3 = (al) akVarC.t();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        pe peVar2 = pe.a;
        alVar3.getClass();
        peVar.f = alVar3;
        peVar.b |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        bo boVar = ((bi) bhVar.b).s;
        if (boVar == null) {
            boVar = bo.a;
        }
        bb bbVar = (bb) boVar.aH(5, null);
        bbVar.x(boVar);
        bn bnVar = (bn) bbVar;
        nn nnVarListIterator = this.d.listIterator();
        while (nnVarListIterator.hasNext()) {
            com.google.android.libraries.navigation.internal.aea.b bVarB = h.b((com.google.android.libraries.navigation.internal.cv.a) nnVarListIterator.next());
            if (!bnVar.b.H()) {
                bnVar.v();
            }
            bo boVar2 = (bo) bnVar.b;
            bVarB.getClass();
            bq bqVar = boVar2.b;
            if (!bqVar.c()) {
                boVar2.b = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
            }
            boVar2.b.i(bVarB.l);
        }
        bo boVar3 = (bo) bnVar.t();
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        bi biVar = (bi) bhVar.b;
        boVar3.getClass();
        biVar.s = boVar3;
        biVar.c |= 1;
    }
}

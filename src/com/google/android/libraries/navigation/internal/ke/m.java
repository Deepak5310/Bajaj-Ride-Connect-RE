package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.jy.w;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zp.cb;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.dh;
import com.google.android.libraries.navigation.internal.zr.di;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends g {
    private final w a;

    public m(w wVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar.a());
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        ak akVarC = c();
        int i = com.google.android.libraries.navigation.internal.zp.n.D.a;
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
        com.google.android.libraries.navigation.internal.afd.a aVarA;
        super.y(bhVar);
        dh dhVar = (dh) di.a.q();
        synchronized (this.a) {
            Integer num = ((com.google.android.libraries.navigation.internal.kd.a) this.a).c;
            ar.q(num);
            int iIntValue = num.intValue();
            if (!dhVar.b.H()) {
                dhVar.v();
            }
            di diVar = (di) dhVar.b;
            diVar.b |= 1;
            diVar.d = iIntValue;
            aVarA = this.a.a();
        }
        if (aVarA != null) {
            cb cbVarB = com.google.android.libraries.navigation.internal.jw.i.b(aVarA);
            if (!dhVar.b.H()) {
                dhVar.v();
            }
            di diVar2 = (di) dhVar.b;
            cbVarB.getClass();
            bz bzVar = diVar2.c;
            if (!bzVar.c()) {
                diVar2.c = bi.A(bzVar);
            }
            diVar2.c.add(cbVarB);
        }
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.bi biVar = (com.google.android.libraries.navigation.internal.zr.bi) bhVar.b;
        di diVar3 = (di) dhVar.t();
        com.google.android.libraries.navigation.internal.zr.bi biVar2 = com.google.android.libraries.navigation.internal.zr.bi.a;
        diVar3.getClass();
        biVar.p = diVar3;
        biVar.b |= 131072;
    }
}

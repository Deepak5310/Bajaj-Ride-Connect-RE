package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bj;
import com.google.android.libraries.navigation.internal.afl.go;
import com.google.android.libraries.navigation.internal.afl.gp;
import com.google.android.libraries.navigation.internal.afl.gq;
import com.google.android.libraries.navigation.internal.afl.gr;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zp.by;
import com.google.android.libraries.navigation.internal.zp.cb;
import com.google.android.libraries.navigation.internal.zp.ce;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends c {
    private final com.google.android.libraries.navigation.internal.kd.i a;

    /* JADX WARN: Illegal instructions before constructor call */
    public k(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kd.i iVar) {
        long jA = aVar.a();
        super(jA, jA);
        this.a = iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final synchronized ev a() {
        eq eqVar;
        eqVar = new eq();
        int i = 0;
        while (true) {
            ev evVar = ((com.google.android.libraries.navigation.internal.kd.c) this.a).a;
            if (i < ((lv) evVar).c) {
                com.google.android.libraries.navigation.internal.jy.i iVar = (com.google.android.libraries.navigation.internal.jy.i) evVar.get(i);
                by byVar = (by) cb.a.q();
                int i2 = iVar.a().a;
                if (!byVar.b.H()) {
                    byVar.v();
                }
                cb cbVar = (cb) byVar.b;
                cbVar.b |= 1;
                cbVar.c = i2;
                iVar.d();
                if (iVar.b() != null) {
                    byVar.C(com.google.android.libraries.navigation.internal.zp.r.b, iVar.b());
                }
                iVar.c();
                eqVar.h((cb) byVar.t());
                i++;
            }
        }
        return eqVar.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        gq gqVar = (gq) gr.a.q();
        ev evVarA = a();
        int i = ((lv) evVarA).c;
        for (int i2 = 0; i2 < i; i2++) {
            by byVar = (by) cb.a.r((cb) evVarA.get(i2));
            if (!byVar.b.H()) {
                byVar.v();
            }
            ((cb) byVar.b).e = bj.a;
            gqVar.c(byVar);
        }
        by byVar2 = (by) cb.a.q();
        int i3 = com.google.android.libraries.navigation.internal.zp.k.d.a;
        if (!byVar2.b.H()) {
            byVar2.v();
        }
        cb cbVar = (cb) byVar2.b;
        cbVar.b |= 1;
        cbVar.c = i3;
        for (int i4 = 0; i4 < ((lv) evVarA).c; i4++) {
            byVar2.a(i4);
        }
        gqVar.c(byVar2);
        ak akVarC = c();
        com.google.android.libraries.navigation.internal.kd.i iVar = this.a;
        if (!akVarC.b.H()) {
            akVarC.v();
        }
        ce ceVar = ((com.google.android.libraries.navigation.internal.kd.c) iVar).b;
        al alVar = (al) akVarC.b;
        al alVar2 = al.a;
        alVar.b |= 64;
        alVar.e = ((com.google.android.libraries.navigation.internal.zp.n) ceVar).a;
        go goVar = (go) gp.a.q();
        if (!goVar.b.H()) {
            goVar.v();
        }
        gp gpVar = (gp) goVar.b;
        gr grVar = (gr) gqVar.t();
        grVar.getClass();
        gpVar.d = grVar;
        gpVar.c = 4;
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        gp gpVar2 = (gp) goVar.t();
        pe peVar2 = pe.a;
        gpVar2.getClass();
        peVar.m = gpVar2;
        peVar.b |= 8192;
        al alVar3 = (al) akVarC.t();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar3 = (pe) pdVar.b;
        alVar3.getClass();
        peVar3.f = alVar3;
        peVar3.b = 4 | peVar3.b;
    }
}

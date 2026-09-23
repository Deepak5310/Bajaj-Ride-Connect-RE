package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.go;
import com.google.android.libraries.navigation.internal.afl.gp;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l extends c {
    private final ev a;

    /* JADX WARN: Illegal instructions before constructor call */
    public l(com.google.android.libraries.navigation.internal.mj.a aVar) {
        long jA = aVar.a();
        super(jA, jA);
        int i = ev.d;
        this.a = lv.a;
    }

    public abstract gp a();

    @Override // com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        go goVar = (go) gp.a.q();
        if (!goVar.b.H()) {
            goVar.v();
        }
        gp gpVar = (gp) goVar.b;
        bz bzVar = gpVar.f;
        if (!bzVar.c()) {
            gpVar.f = bi.A(bzVar);
        }
        com.google.android.libraries.navigation.internal.ael.b.m(this.a, gpVar.f);
        gp gpVar2 = (gp) goVar.t();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        pe peVar2 = pe.a;
        gpVar2.getClass();
        peVar.m = gpVar2;
        peVar.b |= 8192;
        gp gpVarA = a();
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar3 = (pe) pdVar.b;
        gpVarA.getClass();
        gp gpVar3 = peVar3.m;
        if (gpVar3 != null && gpVar3 != gp.a) {
            go goVar2 = (go) gp.a.r(peVar3.m);
            goVar2.x(gpVarA);
            gpVarA = (gp) goVar2.u();
        }
        peVar3.m = gpVarA;
        peVar3.b |= 8192;
    }
}

package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.adq.ak;
import com.google.android.libraries.navigation.internal.adq.al;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zr.an;
import com.google.android.libraries.navigation.internal.zr.ao;
import com.google.android.libraries.navigation.internal.zr.ds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    public final long b;
    public final long c;
    private al k;
    private String l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Integer f460n;
    private boolean o = false;

    public c(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    public synchronized void b(pd pdVar) {
        this.o = true;
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        long j = this.b;
        pe peVar = (pe) pdVar.b;
        pe peVar2 = pe.a;
        peVar.b |= 1;
        peVar.d = j;
        al alVar = this.k;
        if (alVar != null) {
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar3 = (pe) pdVar.b;
            peVar3.f = alVar;
            peVar3.b |= 4;
        }
        String str = this.l;
        if (str != null) {
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar4 = (pe) pdVar.b;
            peVar4.b |= 2;
            peVar4.e = str;
        }
        if (this.m) {
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar5 = (pe) pdVar.b;
            peVar5.b |= 32;
            peVar5.h = true;
        }
        Integer num = this.f460n;
        if (num != null) {
            an anVar = (an) ao.a.q();
            int iIntValue = num.intValue();
            if (!anVar.b.H()) {
                anVar.v();
            }
            ao aoVar = (ao) anVar.b;
            aoVar.b = 1 | aoVar.b;
            aoVar.c = iIntValue;
            ao aoVar2 = (ao) anVar.t();
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar6 = (pe) pdVar.b;
            aoVar2.getClass();
            peVar6.j = aoVar2;
            peVar6.b |= 64;
        }
    }

    protected final synchronized ak c() {
        al alVar = this.k;
        if (alVar == null) {
            return (ak) al.a.q();
        }
        bb bbVar = (bb) alVar.aH(5, null);
        bbVar.x(alVar);
        return (ak) bbVar;
    }

    public final synchronized al d() {
        return this.k;
    }

    public final synchronized pe e() {
        pd pdVar;
        pdVar = (pd) pe.a.q();
        b(pdVar);
        ar.k(this.o);
        this.o = false;
        return (pe) pdVar.t();
    }

    public final synchronized String f() {
        return this.l;
    }

    public final synchronized void g() {
        this.m = true;
    }

    public final synchronized void h(String str) {
        this.l = str;
    }

    @Deprecated
    public final synchronized void i(al alVar) {
        this.k = alVar;
    }

    public final synchronized void j(ds dsVar) {
        if (dsVar != null) {
            ak akVarC = c();
            if (!akVarC.b.H()) {
                akVarC.v();
            }
            al alVar = (al) akVarC.b;
            al alVar2 = al.a;
            alVar.i = dsVar;
            alVar.b |= 4194304;
            this.k = (al) akVarC.t();
        }
    }

    public boolean k() {
        return false;
    }

    public final synchronized void l(int i) {
        this.f460n = Integer.valueOf(i);
    }

    public final synchronized void m(int i) {
        if (this.f460n == null) {
            l(i);
        }
    }
}

package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.bi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends c {
    private final pe a;

    public o(pe peVar, long j, long j2) {
        super(j, j2);
        this.a = peVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        if (pdVar.a.H()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        pdVar.b = pdVar.s();
        pdVar.x(this.a);
        if ((this.a.b & 128) != 0) {
            long j = this.b;
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar = (pe) pdVar.b;
            peVar.b |= 1;
            peVar.d = j;
            bi biVar = this.a.k;
            if (biVar == null) {
                biVar = bi.a;
            }
            bh bhVar = (bh) bi.a.r(biVar);
            long j2 = this.b;
            long j3 = this.c;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            long j4 = j2 - j3;
            bi biVar2 = (bi) bhVar.b;
            biVar2.b |= 128;
            biVar2.g = j4;
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar2 = (pe) pdVar.b;
            bi biVar3 = (bi) bhVar.t();
            biVar3.getClass();
            peVar2.k = biVar3;
            peVar2.b |= 128;
        }
    }
}

package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.zr.bh;
import com.google.android.libraries.navigation.internal.zr.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class j extends g {
    public j(com.google.android.libraries.navigation.internal.mj.a aVar) {
        super(aVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.ke.g, com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        com.google.android.libraries.navigation.internal.aes.h hVarX = x();
        if (hVarX != null) {
            if (!pdVar.b.H()) {
                pdVar.v();
            }
            pe peVar = (pe) pdVar.b;
            pe peVar2 = pe.a;
            bz bzVar = peVar.c;
            if (!bzVar.c()) {
                peVar.c = bi.A(bzVar);
            }
            peVar.c.add(hVarX);
        }
    }

    protected abstract de w();

    protected abstract com.google.android.libraries.navigation.internal.aes.h x();

    @Override // com.google.android.libraries.navigation.internal.ke.g
    public final synchronized void y(bh bhVar) {
        super.y(bhVar);
        de deVarW = w();
        if (!bhVar.b.H()) {
            bhVar.v();
        }
        com.google.android.libraries.navigation.internal.zr.bi biVar = (com.google.android.libraries.navigation.internal.zr.bi) bhVar.b;
        com.google.android.libraries.navigation.internal.zr.bi biVar2 = com.google.android.libraries.navigation.internal.zr.bi.a;
        deVarW.getClass();
        biVar.f668n = deVarW;
        biVar.b |= 32768;
    }
}

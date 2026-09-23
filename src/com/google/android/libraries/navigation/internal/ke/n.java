package com.google.android.libraries.navigation.internal.ke;

import com.google.android.libraries.navigation.internal.afl.ht;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.afl.hw;
import com.google.android.libraries.navigation.internal.afl.pd;
import com.google.android.libraries.navigation.internal.afl.pe;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends c {
    private final hv a;
    private final String d;

    /* JADX WARN: Illegal instructions before constructor call */
    public n(hv hvVar, String str, com.google.android.libraries.navigation.internal.mj.a aVar) {
        long jA = aVar.a();
        super(jA, jA);
        ar.q(hvVar);
        this.a = hvVar;
        this.d = str;
    }

    @Override // com.google.android.libraries.navigation.internal.ke.c
    public final synchronized void b(pd pdVar) {
        super.b(pdVar);
        ht htVar = (ht) hw.a.q();
        if (!htVar.b.H()) {
            htVar.v();
        }
        hv hvVar = this.a;
        hw hwVar = (hw) htVar.b;
        hwVar.c = hvVar.j;
        hwVar.b |= 1;
        String str = this.d;
        if (!htVar.b.H()) {
            htVar.v();
        }
        hw hwVar2 = (hw) htVar.b;
        hwVar2.b |= 2;
        hwVar2.d = str;
        if (!pdVar.b.H()) {
            pdVar.v();
        }
        pe peVar = (pe) pdVar.b;
        hw hwVar3 = (hw) htVar.t();
        pe peVar2 = pe.a;
        hwVar3.getClass();
        peVar.l = hwVar3;
        peVar.b |= 256;
    }
}

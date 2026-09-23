package com.google.android.libraries.navigation.internal.br;

import com.google.android.libraries.navigation.internal.adr.ai;
import com.google.android.libraries.navigation.internal.adr.aj;
import com.google.android.libraries.navigation.internal.adr.gk;
import com.google.android.libraries.navigation.internal.adr.gm;
import com.google.android.libraries.navigation.internal.adr.gn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r {
    public final gk a;
    public final ai b;

    public r() {
        gk gkVar = (gk) gn.a.q();
        this.a = gkVar;
        int i = gm.c;
        if (!gkVar.b.H()) {
            gkVar.v();
        }
        gn gnVar = (gn) gkVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        gnVar.c = i2;
        gnVar.b |= 1;
        this.b = (ai) aj.a.q();
    }
}

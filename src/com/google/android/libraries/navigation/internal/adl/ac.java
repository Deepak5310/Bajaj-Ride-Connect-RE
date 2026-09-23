package com.google.android.libraries.navigation.internal.adl;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends bb implements cz {
    public ac() {
        super(ad.a);
    }

    public final void c(y yVar) {
        if (!this.b.H()) {
            v();
        }
        ad adVar = (ad) this.b;
        z zVar = (z) yVar.t();
        ad adVar2 = ad.a;
        zVar.getClass();
        bz bzVar = adVar.b;
        if (!bzVar.c()) {
            adVar.b = bi.A(bzVar);
        }
        adVar.b.add(zVar);
    }
}

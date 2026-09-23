package com.google.android.libraries.navigation.internal.adq;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public ae() {
        super(ah.a);
    }

    public final void c(c cVar) {
        if (!this.b.H()) {
            v();
        }
        ah ahVar = (ah) this.b;
        d dVar = (d) cVar.t();
        ah ahVar2 = ah.a;
        dVar.getClass();
        ahVar.c();
        ahVar.f.add(dVar);
    }

    public final void d(d dVar) {
        if (!this.b.H()) {
            v();
        }
        ah ahVar = (ah) this.b;
        ah ahVar2 = ah.a;
        dVar.getClass();
        ahVar.c();
        ahVar.f.add(dVar);
    }

    public final void e(int i) {
        if (!this.b.H()) {
            v();
        }
        ah ahVar = (ah) this.b;
        ah ahVar2 = ah.a;
        if (i == 0) {
            throw null;
        }
        bq bqVar = ahVar.c;
        if (!bqVar.c()) {
            ahVar.c = bi.w(bqVar);
        }
        bq bqVar2 = ahVar.c;
        if (i == 0) {
            throw null;
        }
        bqVar2.i(i);
    }
}

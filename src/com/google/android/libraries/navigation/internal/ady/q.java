package com.google.android.libraries.navigation.internal.ady;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bq;
import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends bb implements cz {
    public q() {
        super(v.a);
    }

    public final void c(s sVar) {
        if (!this.b.H()) {
            v();
        }
        v vVar = (v) this.b;
        v vVar2 = v.a;
        sVar.getClass();
        bq bqVar = vVar.c;
        if (!bqVar.c()) {
            vVar.c = bi.w(bqVar);
        }
        vVar.c.i(sVar.d);
    }

    public final void d(int i) {
        if (!this.b.H()) {
            v();
        }
        v vVar = (v) this.b;
        v vVar2 = v.a;
        if (i == 0) {
            throw null;
        }
        bq bqVar = vVar.b;
        if (!bqVar.c()) {
            vVar.b = bi.w(bqVar);
        }
        bq bqVar2 = vVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        bqVar2.i(i2);
    }
}

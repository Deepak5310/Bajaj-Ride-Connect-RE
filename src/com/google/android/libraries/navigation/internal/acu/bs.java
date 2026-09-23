package com.google.android.libraries.navigation.internal.acu;

import com.google.android.libraries.navigation.internal.ael.cz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs extends com.google.android.libraries.navigation.internal.ael.bb implements cz {
    public bs() {
        super(bt.a);
    }

    public final void c(int i) {
        if (!this.b.H()) {
            v();
        }
        bt btVar = (bt) this.b;
        bt btVar2 = bt.a;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = btVar.e;
        if (!bqVar.c()) {
            btVar.e = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        btVar.e.i(i);
    }

    public final void d(com.google.android.libraries.navigation.internal.aci.a aVar) {
        if (!this.b.H()) {
            v();
        }
        bt btVar = (bt) this.b;
        com.google.android.libraries.navigation.internal.aci.b bVar = (com.google.android.libraries.navigation.internal.aci.b) aVar.t();
        bt btVar2 = bt.a;
        bVar.getClass();
        btVar.c();
        btVar.f.add(bVar);
    }

    public final void e(com.google.android.libraries.navigation.internal.aci.b bVar) {
        if (!this.b.H()) {
            v();
        }
        bt btVar = (bt) this.b;
        bt btVar2 = bt.a;
        bVar.getClass();
        btVar.c();
        btVar.f.add(bVar);
    }

    public final void f(int i) {
        if (!this.b.H()) {
            v();
        }
        bt btVar = (bt) this.b;
        bt btVar2 = bt.a;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = btVar.d;
        if (!bqVar.c()) {
            btVar.d = com.google.android.libraries.navigation.internal.ael.bi.w(bqVar);
        }
        btVar.d.i(i);
    }
}

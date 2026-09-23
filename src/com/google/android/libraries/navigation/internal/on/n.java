package com.google.android.libraries.navigation.internal.on;

import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.ol.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends p {
    final /* synthetic */ q a;
    private final com.google.android.libraries.navigation.internal.adg.b c;

    /* JADX WARN: Illegal instructions before constructor call */
    public n(q qVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        this.a = qVar;
        ax axVar = qVar.a;
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        ej ejVar = (ej) eo.a.q();
        if (!ejVar.b.H()) {
            ejVar.v();
        }
        eo eoVar = (eo) ejVar.b;
        eoVar.j = bVar.j;
        eoVar.b |= 128;
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        eo eoVar2 = (eo) ejVar.t();
        eoVar2.getClass();
        dbVar2.e = eoVar2;
        dbVar2.b |= 4;
        fxVar.c(daVar);
        super(qVar, axVar.a((ga) fxVar.t()));
        this.c = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.on.p
    protected final void c() {
        synchronized (this.a) {
            this.a.c.remove(this.c);
        }
    }
}

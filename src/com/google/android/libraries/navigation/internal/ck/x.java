package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class x implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afo.a a;

    public x(com.google.android.libraries.navigation.internal.afo.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        com.google.android.libraries.navigation.internal.ol.ax axVar = (com.google.android.libraries.navigation.internal.ol.ax) this.a.a();
        fx fxVar = (fx) ga.a.q();
        da daVar = (da) db.a.q();
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar = (db) daVar.b;
        dbVar.b |= 1;
        dbVar.c = 0;
        com.google.android.libraries.navigation.internal.adg.at atVar = (com.google.android.libraries.navigation.internal.adg.at) com.google.android.libraries.navigation.internal.adg.ba.a.q();
        if (!atVar.b.H()) {
            atVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ba baVar = (com.google.android.libraries.navigation.internal.adg.ba) atVar.b;
        baVar.b |= 4;
        baVar.g = 0;
        if (!atVar.b.H()) {
            atVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ba baVar2 = (com.google.android.libraries.navigation.internal.adg.ba) atVar.b;
        baVar2.b |= 32;
        baVar2.j = "";
        if (!daVar.b.H()) {
            daVar.v();
        }
        db dbVar2 = (db) daVar.b;
        com.google.android.libraries.navigation.internal.adg.ba baVar3 = (com.google.android.libraries.navigation.internal.adg.ba) atVar.t();
        baVar3.getClass();
        dbVar2.d = baVar3;
        dbVar2.b |= 2;
        fxVar.c(daVar);
        return axVar.a((ga) fxVar.t());
    }
}

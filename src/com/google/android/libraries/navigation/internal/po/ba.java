package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.adg.Cdo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba implements com.google.android.libraries.navigation.internal.pp.g {
    public final int a;
    public final com.google.android.libraries.navigation.internal.adg.es b;
    private final hg c;

    public ba(int i, hg hgVar) {
        this.a = i;
        this.c = hgVar;
        com.google.android.libraries.navigation.internal.adg.er erVar = (com.google.android.libraries.navigation.internal.adg.er) com.google.android.libraries.navigation.internal.adg.es.a.q();
        if (!erVar.b.H()) {
            erVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.es esVar = (com.google.android.libraries.navigation.internal.adg.es) erVar.b;
        esVar.b |= 1;
        esVar.c = i;
        this.b = (com.google.android.libraries.navigation.internal.adg.es) erVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final int a() {
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final Cdo b() {
        Cdo cdo = (Cdo) com.google.android.libraries.navigation.internal.adg.dp.a.q();
        cdo.C(com.google.android.libraries.navigation.internal.adg.et.e, this.b);
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.dq c() {
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        dqVar.C(com.google.android.libraries.navigation.internal.adg.et.d, this.b);
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.dy d() {
        com.google.android.libraries.navigation.internal.adg.dy dyVar = (com.google.android.libraries.navigation.internal.adg.dy) com.google.android.libraries.navigation.internal.adg.ef.a.q();
        dyVar.C(com.google.android.libraries.navigation.internal.adg.et.c, this.b);
        return dyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.es e() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.aq
    public final void f(Runnable runnable) {
        this.c.a.b(runnable);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.g
    public final boolean o(com.google.android.libraries.navigation.internal.ol.aq aqVar, boolean z) {
        return aqVar instanceof ba;
    }
}

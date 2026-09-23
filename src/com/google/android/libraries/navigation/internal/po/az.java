package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.adg.Cdo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class az extends dq implements com.google.android.libraries.navigation.internal.ol.s {
    public final hi a;
    boolean b;
    private final com.google.android.libraries.navigation.internal.adg.ga g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(hi hiVar, gx gxVar, com.google.android.libraries.navigation.internal.adg.ga gaVar, int i) {
        super(gxVar, com.google.android.libraries.geo.mapcore.internal.model.bv.j(gaVar, new com.google.android.libraries.geo.mapcore.internal.model.bu(false)), i);
        com.google.android.libraries.geo.mapcore.internal.model.bt btVar = com.google.android.libraries.geo.mapcore.internal.model.bv.c;
        this.b = false;
        this.a = hiVar;
        this.g = gaVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq, com.google.android.libraries.navigation.internal.ol.aq
    public final int a() {
        synchronized (this) {
            if (this.b) {
                return -1;
            }
            return this.e;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq, com.google.android.libraries.navigation.internal.ol.aq
    public final Cdo b() {
        Cdo cdo = (Cdo) com.google.android.libraries.navigation.internal.adg.dp.a.q();
        int iA = a();
        if (!cdo.b.H()) {
            cdo.v();
        }
        com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) cdo.b;
        dpVar.b |= 2;
        dpVar.d = iA;
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq, com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.dq c() {
        com.google.android.libraries.navigation.internal.adg.dq dqVar = (com.google.android.libraries.navigation.internal.adg.dq) com.google.android.libraries.navigation.internal.adg.dt.a.q();
        int iA = a();
        if (!dqVar.b.H()) {
            dqVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar = (com.google.android.libraries.navigation.internal.adg.dt) dqVar.b;
        dtVar.b |= 1;
        dtVar.d = iA;
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq, com.google.android.libraries.navigation.internal.ol.aq
    public final com.google.android.libraries.navigation.internal.adg.dy d() {
        com.google.android.libraries.navigation.internal.adg.dy dyVar = (com.google.android.libraries.navigation.internal.adg.dy) com.google.android.libraries.navigation.internal.adg.ef.a.q();
        int iA = a();
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar = (com.google.android.libraries.navigation.internal.adg.ef) dyVar.b;
        efVar.b |= 4096;
        efVar.l = iA;
        return dyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq
    public final com.google.android.libraries.geo.mapcore.internal.model.bt g() {
        synchronized (this) {
            if (!this.b) {
                return super.g();
            }
            return com.google.android.libraries.geo.mapcore.internal.model.bt.a;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.dq
    public final void h() {
        synchronized (this) {
            this.b = true;
        }
    }
}

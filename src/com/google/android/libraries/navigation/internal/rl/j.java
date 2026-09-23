package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements c {
    private final int a;

    public j(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final Cdo a() {
        Cdo cdo = (Cdo) dp.a.q();
        if (!cdo.b.H()) {
            cdo.v();
        }
        int i = this.a;
        dp dpVar = (dp) cdo.b;
        dpVar.b |= 2;
        dpVar.d = i;
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final dq b() {
        dq dqVar = (dq) dt.a.q();
        if (!dqVar.b.H()) {
            dqVar.v();
        }
        int i = this.a;
        dt dtVar = (dt) dqVar.b;
        dtVar.b |= 1;
        dtVar.d = i;
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final dy c() {
        dy dyVar = (dy) ef.a.q();
        if (!dyVar.b.H()) {
            dyVar.v();
        }
        int i = this.a;
        ef efVar = (ef) dyVar.b;
        efVar.b |= 4096;
        efVar.l = i;
        return dyVar;
    }
}

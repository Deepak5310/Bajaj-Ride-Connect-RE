package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.er;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements c {
    private final es a;

    public t(int i) {
        er erVar = (er) es.a.q();
        if (!erVar.b.H()) {
            erVar.v();
        }
        es esVar = (es) erVar.b;
        esVar.b |= 1;
        esVar.c = i;
        this.a = (es) erVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final Cdo a() {
        Cdo cdo = (Cdo) dp.a.q();
        cdo.C(et.e, this.a);
        return cdo;
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final dq b() {
        dq dqVar = (dq) dt.a.q();
        dqVar.C(et.d, this.a);
        return dqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rl.c
    public final dy c() {
        dy dyVar = (dy) ef.a.q();
        dyVar.C(et.c, this.a);
        return dyVar;
    }
}

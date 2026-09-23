package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.os.Process;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class co implements cn {
    public static final co a = new co();

    private co() {
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final bv c(af afVar, ac acVar, bq bqVar, fe feVar) {
        return new bv(afVar, acVar, bqVar, feVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final Cdo d(Context context, id idVar) {
        int i = dq.c;
        com.google.android.libraries.navigation.internal.abf.s.k(context, "clientApplicationContext");
        com.google.android.libraries.navigation.internal.abf.s.k(idVar, "versionManager");
        if (context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0) {
            dq.a.c(100);
        } else {
            dq.a.c(102);
        }
        return new dq(new com.google.android.libraries.navigation.internal.lv.x(context), idVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.cn
    public final fe f(be beVar, ac acVar, fc fcVar, fg fgVar, com.google.android.libraries.navigation.internal.ly.o oVar, ht htVar, com.google.android.libraries.navigation.internal.yx.br brVar, bq bqVar) {
        return new ff(beVar, acVar, fcVar, fgVar, oVar, htVar, brVar, bqVar);
    }
}

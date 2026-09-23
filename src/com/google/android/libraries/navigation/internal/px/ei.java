package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.agg.ey;
import com.google.android.libraries.navigation.internal.agg.ez;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ei {
    public static ez a(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        ey eyVar = new ey();
        for (int i = 0; i < efVar.p.size(); i++) {
            eyVar.c(efVar.p.d(i));
        }
        return eyVar;
    }

    public static boolean b(ek ekVar, ek ekVar2) {
        if (c(ekVar) && c(ekVar2)) {
            return (Objects.equals(ekVar.n(), ekVar2.n()) || (ekVar.e() != 0 && ekVar.e() == ekVar2.e())) && !Objects.equals(ekVar.i(), ekVar2.i());
        }
        return false;
    }

    public static boolean c(ek ekVar) {
        return (ekVar.i() == null || ekVar.n() == null) ? false : true;
    }
}

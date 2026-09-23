package com.google.android.libraries.navigation.internal.bw;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.oe.ag;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    static boolean a(bg bgVar, bg bgVar2, x xVar) {
        ag agVarX = bgVar.x(xVar, xVar.e() * 100.0d);
        int i = agVarX != null ? agVarX.c : -1;
        bq[] bqVarArr = bgVar.l;
        for (int length = bqVarArr.length - 2; length >= 0; length--) {
            int i2 = (bqVarArr[length].k + bqVarArr[length + 1].k) / 2;
            if (i2 < i) {
                return true;
            }
            x xVar2 = (x) bgVar.N().get(i2);
            if (bgVar2.x(xVar2, xVar2.e() * 10.0d) == null) {
                return false;
            }
        }
        return true;
    }

    public static final boolean b(bg bgVar, bg bgVar2, x xVar) {
        return a(bgVar, bgVar2, xVar) && a(bgVar2, bgVar, xVar);
    }
}

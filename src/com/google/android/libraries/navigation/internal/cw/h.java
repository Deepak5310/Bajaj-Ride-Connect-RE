package com.google.android.libraries.navigation.internal.cw;

import com.google.android.libraries.navigation.internal.acd.ls;
import com.google.android.libraries.navigation.internal.acd.lt;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afm.z;
import com.google.android.libraries.navigation.internal.iv.w;
import com.google.android.libraries.navigation.internal.oe.x;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class h {
    public static h a;
    public x c;
    public x d;
    public int e;
    public int f;
    public final com.google.android.libraries.navigation.internal.iv.f h;
    public final Executor i;
    public final com.google.android.libraries.navigation.internal.gq.p j;
    private static final com.google.android.libraries.navigation.internal.zb.j l = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.cw.h");
    static final w b = new w("savedLocationShiftCoefficients", w.c);
    public int k = ls.b;
    public final long[] g = new long[6];

    public h(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.gq.p pVar, Executor executor) {
        this.h = fVar;
        this.j = pVar;
        this.i = executor;
        c(fVar);
    }

    public static synchronized void b(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.gq.p pVar, Executor executor) {
        a = new h(fVar, pVar, executor);
    }

    private final synchronized void c(com.google.android.libraries.navigation.internal.iv.f fVar) {
        lt ltVar = (lt) fVar.f(b, (dg) lt.a.aH(7, null), null);
        if (ltVar != null) {
            a(ltVar);
            return;
        }
        long[] jArr = this.g;
        jArr[0] = 0;
        jArr[1] = 1000000;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 1000000;
        this.e = 0;
        this.f = 0;
        this.k = ls.b;
    }

    public final void a(lt ltVar) {
        int iA = ls.a(ltVar.c);
        if (iA == 0) {
            iA = ls.a;
        }
        this.k = iA;
        for (int i = 0; i < 6; i++) {
            this.g[i] = ltVar.d.a(i);
        }
        this.f = ltVar.f;
        this.e = ltVar.g;
        z zVar = ltVar.e;
        if (zVar == null) {
            zVar = z.a;
        }
        int i2 = zVar.c;
        z zVar2 = ltVar.e;
        if (zVar2 == null) {
            zVar2 = z.a;
        }
        this.c = x.w(i2, zVar2.d);
    }
}

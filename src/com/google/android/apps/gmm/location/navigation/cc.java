package com.google.android.apps.gmm.location.navigation;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.android.libraries.navigation.internal.acd.lo;
import com.google.android.libraries.navigation.internal.acd.lp;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class cc {
    private final Context a;
    private final com.google.android.libraries.navigation.internal.iv.f b;
    private final Executor c;
    private final com.google.android.libraries.navigation.internal.gq.p d;

    public cc(Context context, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.gq.p pVar, Executor executor) {
        this.a = context.getApplicationContext();
        this.b = fVar;
        this.d = pVar;
        this.c = executor;
    }

    public final void a(com.google.android.libraries.navigation.internal.db.q qVar) {
        String networkOperator;
        com.google.android.libraries.navigation.internal.oe.x xVarF = qVar.f();
        int iO = xVarF.o();
        Context context = this.a;
        if (iO < 3000000 || xVarF.o() > 54000000 || xVarF.q() < 72000000 || xVarF.q() > 136000000) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager != null && (networkOperator = telephonyManager.getNetworkOperator()) != null && networkOperator.length() > 3 && Integer.parseInt(networkOperator.substring(0, 3)) != 460) {
                return;
            }
        } catch (NumberFormatException unused) {
        }
        com.google.android.libraries.navigation.internal.iv.f fVar = this.b;
        com.google.android.libraries.navigation.internal.gq.p pVar = this.d;
        Executor executor = this.c;
        if (com.google.android.libraries.navigation.internal.cw.h.a == null) {
            com.google.android.libraries.navigation.internal.cw.h.b(fVar, pVar, executor);
        }
        com.google.android.libraries.navigation.internal.cw.h hVar = com.google.android.libraries.navigation.internal.cw.h.a;
        long[] jArr = hVar.g;
        long jO = jArr[0] + (jArr[1] * ((long) xVarF.o()));
        long jQ = jArr[2] * ((long) xVarF.q());
        long jO2 = jArr[3] + (jArr[4] * ((long) xVarF.o()));
        long jQ2 = jArr[5] * ((long) xVarF.q());
        int i = hVar.e / 2;
        com.google.android.libraries.navigation.internal.oe.x xVar = hVar.c;
        if (xVar != null && Math.abs(xVarF.o() - xVar.o()) < i) {
            int iQ = xVarF.q() - hVar.c.q();
            while (iQ < 0) {
                iQ += 360000000;
            }
            if (Math.min(iQ, (int) (360000000 - ((long) iQ))) >= i) {
            }
            com.google.android.libraries.navigation.internal.oe.x xVarW = com.google.android.libraries.navigation.internal.oe.x.w((int) ((jO + jQ) / 1000000), (int) ((jO2 + jQ2) / 1000000));
            qVar.s(xVarW.b(), xVarW.d());
        }
        if (!xVarF.equals(hVar.c) && !xVarF.equals(hVar.d)) {
            hVar.d = xVarF;
            com.google.android.libraries.navigation.internal.gq.p pVar2 = hVar.j;
            lo loVar = (lo) lp.a.q();
            com.google.android.libraries.navigation.internal.afm.y yVar = (com.google.android.libraries.navigation.internal.afm.y) com.google.android.libraries.navigation.internal.afm.z.a.q();
            int iO2 = hVar.d.o();
            if (!yVar.b.H()) {
                yVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.z zVar = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
            zVar.b |= 1;
            zVar.c = iO2;
            int iQ2 = hVar.d.q();
            if (!yVar.b.H()) {
                yVar.v();
            }
            com.google.android.libraries.navigation.internal.afm.z zVar2 = (com.google.android.libraries.navigation.internal.afm.z) yVar.b;
            zVar2.b |= 2;
            zVar2.d = iQ2;
            if (!loVar.b.H()) {
                loVar.v();
            }
            lp lpVar = (lp) loVar.b;
            com.google.android.libraries.navigation.internal.afm.z zVar3 = (com.google.android.libraries.navigation.internal.afm.z) yVar.t();
            zVar3.getClass();
            lpVar.c = zVar3;
            lpVar.b |= 1;
            lp lpVar2 = (lp) loVar.t();
            com.google.android.libraries.navigation.internal.oe.x xVar2 = hVar.c;
            pVar2.a(lpVar2, new com.google.android.libraries.navigation.internal.cw.g(hVar), hVar.i);
        }
        com.google.android.libraries.navigation.internal.oe.x xVarW2 = com.google.android.libraries.navigation.internal.oe.x.w((int) ((jO + jQ) / 1000000), (int) ((jO2 + jQ2) / 1000000));
        qVar.s(xVarW2.b(), xVarW2.d());
    }
}

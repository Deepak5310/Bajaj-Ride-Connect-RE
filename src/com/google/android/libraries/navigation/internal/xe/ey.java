package com.google.android.libraries.navigation.internal.xe;

import android.app.Application;
import android.content.Context;
import com.google.android.libraries.navigation.NavigationTransactionRecorder;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ey implements ei {
    @Override // com.google.android.libraries.navigation.internal.xe.ei
    public final Navigator a(final com.google.android.libraries.navigation.environment.am amVar, fl flVar) {
        try {
            amVar.W().execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.ew
                @Override // java.lang.Runnable
                public final void run() {
                    amVar.bD().a();
                }
            });
            com.google.android.libraries.navigation.internal.vw.j jVar = (com.google.android.libraries.navigation.internal.vw.j) amVar.aQ();
            com.google.android.libraries.navigation.internal.xf.k kVarBy = amVar.by();
            com.google.android.libraries.navigation.environment.v vVarBD = amVar.bD();
            com.google.android.libraries.navigation.internal.vp.g gVarAR = amVar.aR();
            Context contextT = amVar.t();
            com.google.android.libraries.navigation.internal.xd.a aVarBw = amVar.bw();
            com.google.android.libraries.navigation.internal.uu.q qVarBu = amVar.bu();
            com.google.android.libraries.navigation.internal.wd.g gVarBv = amVar.bv();
            Context contextT2 = amVar.t();
            Objects.requireNonNull(amVar);
            fi fiVar = new fi(jVar, kVarBy, vVarBD, gVarAR, contextT, aVarBw, qVarBu, gVarBv, new gf(new com.google.android.libraries.navigation.internal.tn.m((Application) contextT2, new com.google.android.libraries.navigation.internal.afo.a() { // from class: com.google.android.libraries.navigation.internal.xe.ex
                @Override // com.google.android.libraries.navigation.internal.afo.a
                public final Object a() {
                    return amVar.f();
                }
            }, amVar.aN(), amVar.H()), amVar.t(), com.google.android.libraries.navigation.internal.ul.a.c(amVar.t(), amVar.cc(), amVar.cb())), flVar, new ga(), amVar.bz(), amVar.bC(), amVar.ar(), amVar.bF(), amVar.bb());
            try {
                if (fi.l()) {
                    int i = com.google.android.libraries.navigation.internal.yz.ev.d;
                    fiVar.j(lv.a);
                }
            } catch (NavigationTransactionRecorder.TransactionException unused) {
            }
            return fiVar;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}

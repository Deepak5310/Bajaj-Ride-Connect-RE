package com.google.android.apps.gmm.location.navigation;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bh {
    public static void a(com.google.android.libraries.navigation.internal.db.q qVar, boolean z, com.google.android.libraries.navigation.internal.ady.al alVar, com.google.android.libraries.navigation.internal.acu.ax axVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LocationPipeline.addObservations()");
        try {
            long jA = com.google.android.libraries.navigation.internal.ja.a.a(qVar.g());
            if (z && qVar.m() && qVar.i()) {
                double d = qVar.n() ? qVar.j : (((double) qVar.d) * 0.125d) + 1.9d;
                double dMin = qVar.j() ? qVar.h : Math.min(Math.abs(Math.toDegrees(d / ((double) qVar.i))), 2000.0d);
                com.google.android.libraries.navigation.internal.acu.av avVar = (com.google.android.libraries.navigation.internal.acu.av) com.google.android.libraries.navigation.internal.acu.aw.a.q();
                if (!avVar.b.H()) {
                    avVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.aw awVar = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
                awVar.b |= 1;
                awVar.e = jA;
                com.google.android.libraries.navigation.internal.acu.ca caVar = (com.google.android.libraries.navigation.internal.acu.ca) com.google.android.libraries.navigation.internal.acu.cb.a.q();
                double d2 = qVar.i;
                if (!caVar.b.H()) {
                    caVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.cb cbVar = (com.google.android.libraries.navigation.internal.acu.cb) caVar.b;
                cbVar.b |= 1;
                cbVar.c = d2;
                if (!caVar.b.H()) {
                    caVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.cb cbVar2 = (com.google.android.libraries.navigation.internal.acu.cb) caVar.b;
                cbVar2.b |= 2;
                cbVar2.d = d;
                double d3 = qVar.g;
                if (!caVar.b.H()) {
                    caVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.cb cbVar3 = (com.google.android.libraries.navigation.internal.acu.cb) caVar.b;
                cbVar3.b |= 4;
                cbVar3.e = d3;
                if (!caVar.b.H()) {
                    caVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.cb cbVar4 = (com.google.android.libraries.navigation.internal.acu.cb) caVar.b;
                cbVar4.b |= 8;
                cbVar4.f = dMin;
                if (!avVar.b.H()) {
                    avVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.aw awVar2 = (com.google.android.libraries.navigation.internal.acu.aw) avVar.b;
                com.google.android.libraries.navigation.internal.acu.cb cbVar5 = (com.google.android.libraries.navigation.internal.acu.cb) caVar.t();
                cbVar5.getClass();
                awVar2.d = cbVar5;
                awVar2.c = 3;
                axVar.c(avVar);
            }
            com.google.android.libraries.navigation.internal.pt.d dVar = qVar.s;
            if (dVar != null && com.google.android.libraries.navigation.internal.pt.e.a(alVar)) {
                com.google.android.libraries.navigation.internal.acu.av avVar2 = (com.google.android.libraries.navigation.internal.acu.av) com.google.android.libraries.navigation.internal.acu.aw.a.q();
                if (!avVar2.b.H()) {
                    avVar2.v();
                }
                com.google.android.libraries.navigation.internal.acu.aw awVar3 = (com.google.android.libraries.navigation.internal.acu.aw) avVar2.b;
                awVar3.b |= 1;
                awVar3.e = jA;
                com.google.android.libraries.navigation.internal.acu.aa aaVar = (com.google.android.libraries.navigation.internal.acu.aa) com.google.android.libraries.navigation.internal.acu.ab.a.q();
                long j = dVar.b.c;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.ab abVar = (com.google.android.libraries.navigation.internal.acu.ab) aaVar.b;
                abVar.b |= 1;
                abVar.c = j;
                double d4 = true != com.google.android.libraries.navigation.internal.yx.am.a(qVar.a, "geoa") ? 0.9900000095367432d : 0.9998999834060669d;
                if (!aaVar.b.H()) {
                    aaVar.v();
                }
                com.google.android.libraries.navigation.internal.acu.ab abVar2 = (com.google.android.libraries.navigation.internal.acu.ab) aaVar.b;
                abVar2.b |= 2;
                abVar2.d = d4;
                if (!avVar2.b.H()) {
                    avVar2.v();
                }
                com.google.android.libraries.navigation.internal.acu.aw awVar4 = (com.google.android.libraries.navigation.internal.acu.aw) avVar2.b;
                com.google.android.libraries.navigation.internal.acu.ab abVar3 = (com.google.android.libraries.navigation.internal.acu.ab) aaVar.t();
                abVar3.getClass();
                awVar4.d = abVar3;
                awVar4.c = 11;
                axVar.c(avVar2);
            }
            com.google.android.libraries.navigation.internal.acu.av avVar3 = (com.google.android.libraries.navigation.internal.acu.av) com.google.android.libraries.navigation.internal.acu.aw.a.q();
            if (!avVar3.b.H()) {
                avVar3.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar5 = (com.google.android.libraries.navigation.internal.acu.aw) avVar3.b;
            awVar5.b |= 1;
            awVar5.e = jA;
            com.google.android.libraries.navigation.internal.acu.bh bhVar = (com.google.android.libraries.navigation.internal.acu.bh) com.google.android.libraries.navigation.internal.acu.bi.a.q();
            double d5 = qVar.b;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bi biVar = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.b;
            biVar.b = 1 | biVar.b;
            biVar.c = d5;
            double d6 = qVar.c;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bi biVar2 = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.b;
            biVar2.b |= 2;
            biVar2.d = d6;
            double d7 = qVar.d;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bi biVar3 = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.b;
            biVar3.b |= 4;
            biVar3.e = d7;
            double d8 = z ? com.google.android.libraries.navigation.internal.dc.a.e : com.google.android.libraries.navigation.internal.dc.a.f;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bi biVar4 = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.b;
            biVar4.b |= 8;
            biVar4.f = d8;
            boolean z2 = qVar.c().d;
            if (!bhVar.b.H()) {
                bhVar.v();
            }
            com.google.android.libraries.navigation.internal.acu.bi biVar5 = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.b;
            biVar5.b |= 16;
            biVar5.g = z2;
            if (!avVar3.b.H()) {
                avVar3.v();
            }
            com.google.android.libraries.navigation.internal.acu.aw awVar6 = (com.google.android.libraries.navigation.internal.acu.aw) avVar3.b;
            com.google.android.libraries.navigation.internal.acu.bi biVar6 = (com.google.android.libraries.navigation.internal.acu.bi) bhVar.t();
            biVar6.getClass();
            awVar6.d = biVar6;
            awVar6.c = 2;
            axVar.c(avVar3);
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB == null) {
                throw th;
            }
            try {
                Trace.endSection();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }
}

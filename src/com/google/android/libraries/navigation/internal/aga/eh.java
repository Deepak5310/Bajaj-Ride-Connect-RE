package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eh extends com.google.android.libraries.navigation.internal.afx.bu {
    final /* synthetic */ ei a;
    private final com.google.android.libraries.navigation.internal.afx.bu b;

    public eh(ei eiVar, com.google.android.libraries.navigation.internal.afx.bu buVar) {
        this.a = eiVar;
        this.b = buVar;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.bu
    public final com.google.android.libraries.navigation.internal.afx.cl a(com.google.android.libraries.navigation.internal.afx.bw bwVar) {
        com.google.android.libraries.navigation.internal.afx.cl clVarA = this.b.a(bwVar);
        if (clVarA.c()) {
            this.a.b.a();
        } else {
            ei eiVar = this.a;
            eg egVar = new eg(eiVar);
            j jVar = (j) eiVar.b;
            jVar.c.d();
            if (jVar.e == null) {
                jVar.e = new ap();
            }
            com.google.android.libraries.navigation.internal.afx.cp cpVar = jVar.d;
            if (cpVar == null || !cpVar.b()) {
                long jA = jVar.e.a();
                jVar.d = jVar.c.a(egVar, jA, TimeUnit.NANOSECONDS, jVar.b);
                j.a.logp(Level.FINE, "io.grpc.internal.BackoffPolicyRetryScheduler", "schedule", "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jA));
            }
        }
        return clVarA;
    }
}

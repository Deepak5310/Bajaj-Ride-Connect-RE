package com.google.android.libraries.navigation.internal.sv;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sv.k");
    public final com.google.android.libraries.navigation.internal.kl.b b;
    public final com.google.android.libraries.navigation.internal.bw.b c;
    public final com.google.android.libraries.navigation.internal.hn.p d;
    public final List e = new ArrayList();
    public com.google.android.libraries.navigation.internal.sc.f f;

    public k(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.bw.b bVar2, com.google.android.libraries.navigation.internal.hn.p pVar) {
        this.b = bVar;
        this.c = bVar2;
        this.d = pVar;
    }

    public final com.google.android.libraries.navigation.internal.sc.d a(com.google.android.libraries.navigation.internal.db.r rVar) {
        com.google.android.libraries.navigation.internal.sc.d dVarK = null;
        for (com.google.android.libraries.navigation.internal.sc.f fVar : this.e) {
            if (fVar == this.f) {
                dVarK = fVar.k(rVar);
            } else {
                fVar.k(rVar);
            }
        }
        if (dVarK != null) {
            return dVarK;
        }
        throw new IllegalStateException("No OnLocationChangedResponse from the active guider.");
    }

    public final com.google.android.libraries.navigation.internal.sc.f b() {
        double d = 0.0d;
        com.google.android.libraries.navigation.internal.sc.f fVar = null;
        for (com.google.android.libraries.navigation.internal.sc.f fVar2 : this.e) {
            if (fVar2 != this.f) {
                double d2 = fVar2.d();
                if (fVar == null || d2 < d) {
                    fVar = fVar2;
                    d = d2;
                }
            }
        }
        return fVar;
    }

    public final com.google.android.libraries.navigation.internal.sc.f c() {
        double d = 0.0d;
        com.google.android.libraries.navigation.internal.sc.f fVar = null;
        for (com.google.android.libraries.navigation.internal.sc.f fVar2 : this.e) {
            if (fVar2 != this.f) {
                double dB = fVar2.b();
                if (fVar == null || dB < d) {
                    fVar = fVar2;
                    d = dB;
                }
            }
        }
        return fVar;
    }
}

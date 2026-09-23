package com.google.android.libraries.navigation.internal.px;

import android.content.res.Resources;
import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ca {
    public final Resources a;
    public final com.google.android.libraries.navigation.internal.qe.b b;
    public final com.google.android.libraries.navigation.internal.pz.a c;
    public final com.google.android.libraries.navigation.internal.qc.g d;
    public com.google.android.libraries.navigation.internal.qz.g e = null;
    public final av f;
    public final as g;
    private final com.google.android.libraries.navigation.internal.pz.a h;
    private final af i;

    public ca(com.google.android.libraries.navigation.internal.fq.f fVar, Resources resources, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.pz.a aVar2, ad adVar, com.google.android.libraries.navigation.internal.qc.g gVar) {
        this.a = resources;
        this.b = bVar;
        this.c = aVar;
        this.h = aVar2;
        this.d = gVar;
        this.f = new av(fVar, adVar);
        this.i = new af(fVar);
        this.g = new as(fVar);
    }

    public final ah a(ek ekVar, com.google.android.libraries.navigation.internal.adg.ee eeVar, int i, float f, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.ol.n nVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("LabelFactory.createCalloutLabel");
        try {
            ah ahVarA = this.i.a(ekVar, eeVar, i, f, this.h, this.d, this.b, this.e, this.a, bVar, dVar, nVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            return ahVarA;
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

package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.adr.im;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq implements bo {
    public final cn a;
    private final com.google.android.libraries.navigation.internal.ol.ax b;

    public cq(com.google.android.libraries.navigation.internal.ol.ax axVar, cn cnVar) {
        this.b = axVar;
        this.a = cnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bo
    public final com.google.android.libraries.navigation.internal.ol.aq a(bn bnVar) {
        f fVar = (f) bnVar;
        im imVar = (im) fVar.a.f();
        com.google.android.libraries.navigation.internal.yx.ar.q(imVar);
        ex exVar = fVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(exVar);
        return exVar != ex.LEGEND_STYLE_UNDEFINED ? this.b.f(ex.LEGEND_STYLE_PRIMARY_ROUTE_CONSUMED_JAMCIDENT) : this.a.c(imVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.bo
    public final com.google.android.libraries.navigation.internal.ol.aq b(bn bnVar, boolean z, boolean z2) {
        f fVar = (f) bnVar;
        im imVar = (im) fVar.a.f();
        com.google.android.libraries.navigation.internal.yx.ar.q(imVar);
        ex exVar = fVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(exVar);
        if (exVar != ex.LEGEND_STYLE_UNDEFINED) {
            return this.b.f(exVar);
        }
        if (z2) {
            return z ? this.a.d(imVar) : this.a.e(imVar);
        }
        return this.a.f(imVar);
    }
}

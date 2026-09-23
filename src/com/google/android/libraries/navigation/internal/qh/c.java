package com.google.android.libraries.navigation.internal.qh;

import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.ba;
import com.google.android.libraries.geo.mapcore.internal.model.bd;
import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.internal.model.bv;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public bv a;
    public bv b;
    public bd c;
    public aq d;

    public final ai a(ba baVar, int i) {
        return b(baVar, i, fd.a);
    }

    public final ai b(ba baVar, int i, ez ezVar) {
        if (baVar.f()) {
            return ai.c;
        }
        if (!baVar.e()) {
            bt btVarC = baVar.c(this.a);
            aq aqVar = this.d;
            bt btVarK = aqVar != null ? btVarC.k(aqVar.E) : null;
            return btVarK != null ? btVarK.g(i) : btVarC.g(i);
        }
        bv bvVar = this.b;
        bd bdVar = this.c;
        if (bvVar == null) {
            return ai.c;
        }
        int i2 = baVar.e;
        if (i2 != 0) {
            return bvVar.b(i2).f(i);
        }
        long j = baVar.c;
        if (j != -1) {
            return bvVar.c(ba.a(j, bdVar, ezVar)).g(i);
        }
        int i3 = baVar.d;
        return i3 != -1 ? bvVar.c(i3).g(i) : ai.c;
    }

    public final bt c(ba baVar) {
        return d(baVar, fd.a);
    }

    public final bt d(ba baVar, ez ezVar) {
        if (baVar.f()) {
            return bt.a;
        }
        if (baVar.e()) {
            return baVar.d(this.b, this.c, ezVar);
        }
        bt btVarC = baVar.c(this.a);
        aq aqVar = this.d;
        bt btVarK = aqVar != null ? btVarC.k(aqVar.E) : null;
        return btVarK != null ? btVarK : btVarC;
    }

    public final ai e(br brVar) {
        return b(brVar.l(), brVar.k(), fd.a);
    }

    public final ai f(br brVar, ez ezVar) {
        return b(brVar.l(), brVar.k(), ezVar);
    }
}

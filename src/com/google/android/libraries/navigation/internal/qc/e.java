package com.google.android.libraries.navigation.internal.qc;

import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.renderer.er;
import com.google.android.libraries.geo.mapcore.renderer.et;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.p;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends i {
    public final ev a;
    public final dp b;
    public final ai c;
    public final com.google.android.libraries.navigation.internal.pz.a d;
    public final com.google.android.libraries.navigation.internal.qz.g e;
    public final com.google.android.libraries.navigation.internal.pz.d f;
    public final boolean g;

    public e(float f, float f2, com.google.android.libraries.navigation.internal.pz.a aVar, ev evVar, dp dpVar, ai aiVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.qz.g gVar, boolean z) {
        super(f, f2);
        this.a = evVar;
        this.b = dpVar;
        this.c = aiVar;
        this.d = aVar;
        this.f = dVar;
        this.e = gVar;
        this.g = z;
    }

    @Override // com.google.android.libraries.navigation.internal.qc.i
    public final et j() {
        boolean z = this.g;
        com.google.android.libraries.navigation.internal.pz.a aVar = this.d;
        dp dpVar = this.b;
        ev evVar = this.a;
        ai aiVar = this.c;
        com.google.android.libraries.navigation.internal.pz.d dVar = this.f;
        com.google.android.libraries.navigation.internal.qz.g gVar = this.e;
        if (z) {
            return aVar.f(dpVar, evVar, aiVar, dVar, gVar);
        }
        er erVarC = aVar.c(dpVar, evVar, aiVar, dVar, gVar);
        if (erVarC != null) {
            return new et(ev.q(erVarC));
        }
        return null;
    }

    public static e b(com.google.android.libraries.navigation.internal.pz.a aVar, ev evVar, dp dpVar, ai aiVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.qz.g gVar, boolean z) {
        p pVar;
        if (z && aiVar != null && (pVar = aiVar.A) != null && (pVar.b & 1) != 0) {
            et etVarF = aVar.f(dpVar, evVar, aiVar, dVar, gVar);
            if (etVarF == null || etVarF.a() <= 0) {
                return null;
            }
            e eVar = new e(etVarF.a, etVarF.b, aVar, evVar, dpVar, aiVar, dVar, gVar, true);
            etVarF.c();
            return eVar;
        }
        er erVarC = aVar.c(dpVar, evVar, aiVar, dVar, gVar);
        if (erVarC == null) {
            return null;
        }
        float f = erVarC.e;
        float f2 = erVarC.h;
        e eVar2 = new e(erVarC.d * f2, f * f2, aVar, evVar, dpVar, aiVar, dVar, gVar, false);
        erVarC.c();
        return eVar2;
    }
}

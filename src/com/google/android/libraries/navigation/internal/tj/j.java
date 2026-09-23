package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class j extends f {
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final o j;

    public j(i iVar) {
        super(iVar);
        this.e = iVar.e;
        this.f = iVar.f;
        this.g = iVar.g;
        this.h = iVar.h;
        this.i = iVar.i;
        o oVar = iVar.j;
        ar.q(oVar);
        this.j = oVar;
    }

    public final bh b() {
        return this.j.a;
    }

    public final com.google.android.libraries.navigation.internal.se.b c() {
        return this.j.c();
    }

    public final boolean d() {
        return this.j.a().m() > 2;
    }

    public final boolean e() {
        return c().f > 4900;
    }

    public final boolean f() {
        return (!c().m || c().c == null) && this.f;
    }

    public final com.google.android.libraries.navigation.internal.se.b[] g() {
        return this.j.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.f
    public final String toString() {
        ak akVarE = a().e("offlineRoutingFailed", this.e).e("rerouting", this.f).e("newRouteRequested", this.g).e("nextDestinationReached", this.h).e("hideDestinationPins", this.i);
        akVarE.g("navigationInternalState", this.j);
        akVarE.g("currentNavGuidanceState", c());
        return akVarE.toString();
    }
}

package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.location.Location;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bu implements bt, com.google.android.libraries.navigation.internal.dp.l {
    public Location a;
    public final com.google.android.libraries.navigation.internal.pb.i b;
    public final com.google.android.libraries.navigation.internal.dp.m c;
    public final com.google.android.libraries.navigation.internal.p002do.l d;
    public final com.google.android.libraries.navigation.internal.dt.f e = new com.google.android.libraries.navigation.internal.dt.f();
    public final ac f;
    private final com.google.android.libraries.navigation.internal.ni.a g;
    private final com.google.android.libraries.navigation.internal.pb.t h;
    private int i;

    public bu(Context context, ac acVar, float f, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.d = new com.google.android.libraries.navigation.internal.p002do.p(aVar, false, null);
        this.b = new com.google.android.libraries.navigation.internal.pb.i(new com.google.android.libraries.navigation.internal.pb.m(context.getResources().getDisplayMetrics(), f));
        this.c = new com.google.android.libraries.navigation.internal.dp.m(aVar, tVar, eVar, this, Optional.empty());
        this.g = aVar;
        this.h = tVar;
        this.f = acVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final float a() {
        if (this.a == null) {
            return 0.0f;
        }
        this.d.b(this.e);
        return this.e.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bt
    public final com.google.android.libraries.navigation.internal.pd.d b(long j, com.google.android.libraries.navigation.internal.pd.a aVar) {
        if (this.a == null) {
            return aVar.a();
        }
        com.google.android.libraries.navigation.internal.p002do.l lVar = this.d;
        com.google.android.libraries.navigation.internal.pb.t tVar = this.h;
        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
        float f = dVarW.k;
        com.google.android.libraries.navigation.internal.p002do.p pVar = (com.google.android.libraries.navigation.internal.p002do.p) lVar;
        com.google.android.libraries.navigation.internal.p002do.o oVar = pVar.b;
        oVar.b = f;
        oVar.c = dVarW.l;
        pVar.a.c = tVar.w().k;
        this.d.k(this.g.a());
        this.i = this.b.a(j, aVar);
        return aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void c(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void d() {
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final void e() {
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final boolean f(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.d.b(this.e);
        com.google.android.libraries.navigation.internal.oe.x xVar2 = this.e.a;
        if (xVar2 == null) {
            return false;
        }
        xVar.W(xVar2);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final int g() {
        return 3;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.bt
    public final int i() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.dp.l
    public final com.google.android.libraries.navigation.internal.ql.a j() {
        return com.google.android.libraries.navigation.internal.ql.a.TRACKING;
    }
}

package com.google.android.libraries.navigation.internal.qg;

import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.v;
import com.google.android.libraries.geo.mapcore.renderer.u;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yz.ci;
import com.google.android.libraries.navigation.internal.yz.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements Runnable, Comparable {
    final /* synthetic */ j a;
    private final ap b;
    private final cd c;
    private final com.google.android.libraries.navigation.internal.qi.f d;
    private final v e;
    private final cc f;
    private final boolean g;
    private final float h;

    public i(j jVar, u uVar, ap apVar, cd cdVar, com.google.android.libraries.navigation.internal.qi.f fVar, v vVar, cc ccVar, boolean z) {
        this.a = jVar;
        this.b = apVar;
        this.c = cdVar;
        this.d = fVar;
        this.e = vVar;
        this.f = ccVar;
        this.g = z;
        if (uVar == null) {
            this.h = 0.0f;
            return;
        }
        x xVarB = cdVar.b();
        int iP = xVarB.a - uVar.p();
        float fQ = xVarB.b - uVar.q();
        float f = iP;
        this.h = (f * f) + (fQ * fQ);
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        ck ckVar = ck.b;
        return ci.h(Boolean.compare(j.v(iVar.b), j.v(this.b))).e(this.b, iVar.b).b(this.h, iVar.h).a();
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.a.r(this.c, this.d, this.e, this.f, this.g);
    }
}

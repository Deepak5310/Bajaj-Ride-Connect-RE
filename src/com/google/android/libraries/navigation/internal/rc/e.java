package com.google.android.libraries.navigation.internal.rc;

import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.ge;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.jy.o;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.jy.v;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.px.ci;
import com.google.android.libraries.navigation.internal.px.dj;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.mp;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zr.bj;
import com.google.android.libraries.navigation.internal.zr.bl;
import com.google.android.libraries.navigation.internal.zr.bm;
import com.google.android.libraries.navigation.internal.zt.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements c {
    private final af a;
    private final o b;
    private volatile int c;

    public e(af afVar) {
        mp.i();
        this.b = o.a;
        ar.q(afVar);
        this.a = afVar;
        j jVar = aa.a;
        x xVar = new x();
        xVar.i = com.google.android.libraries.navigation.internal.afe.o.r;
        bj bjVar = (bj) bm.a.q();
        int i = bl.b;
        if (!bjVar.b.H()) {
            bjVar.v();
        }
        bm bmVar = (bm) bjVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        bmVar.c = i2;
        bmVar.b |= 1;
        xVar.h((bm) bjVar.t());
        xVar.b();
        x xVar2 = new x();
        xVar2.i = com.google.android.libraries.navigation.internal.afe.o.r;
        bj bjVar2 = (bj) bm.a.q();
        int i3 = bl.c;
        if (!bjVar2.b.H()) {
            bjVar2.v();
        }
        bm bmVar2 = (bm) bjVar2.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        bmVar2.c = i4;
        bmVar2.b |= 1;
        xVar2.h((bm) bjVar2.t());
        xVar2.b();
    }

    @Override // com.google.android.libraries.navigation.internal.ol.am
    public final void a(ci ciVar) {
        this.c = ciVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rc.c
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.os.a b(ef efVar, fs fsVar, com.google.android.libraries.navigation.internal.oe.j jVar, boolean z, dj djVar) {
        fs fsVar2 = efVar.u;
        if (fsVar2 == null) {
            fsVar2 = fs.a;
        }
        bh bhVarS = bi.s(fu.u);
        fsVar2.h(bhVarS);
        Object objK = fsVar2.w.k(bhVarS.d);
        if (((ge) (objK == null ? bhVarS.b : bhVarS.c(objK))).b) {
            return null;
        }
        dt dtVar = efVar.d;
        if (dtVar == null) {
            dtVar = dt.a;
        }
        return new a(efVar, fsVar, z, dtVar.c.size() > 0, djVar, jVar);
    }

    @Override // com.google.android.libraries.navigation.internal.rc.c
    public final p c() throws b {
        ar.a(true);
        throw new b();
    }

    @Override // com.google.android.libraries.navigation.internal.rc.c
    public final void d() {
        this.a.d(this.b, new v(as.LONG_PRESS), aa.k(com.google.android.libraries.navigation.internal.afe.o.r));
    }
}

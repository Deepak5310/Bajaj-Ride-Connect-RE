package com.google.android.libraries.navigation.internal.cw;

import com.google.android.libraries.navigation.internal.acd.lq;
import com.google.android.libraries.navigation.internal.acd.ls;
import com.google.android.libraries.navigation.internal.acd.lt;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bt;
import com.google.android.libraries.navigation.internal.afm.y;
import com.google.android.libraries.navigation.internal.afm.z;
import com.google.android.libraries.navigation.internal.iv.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(com.google.android.libraries.navigation.internal.gg.i iVar, com.google.android.libraries.navigation.internal.gg.o oVar) {
        this.a.k = ls.b;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(com.google.android.libraries.navigation.internal.gg.i iVar, Object obj) {
        lt ltVar = (lt) obj;
        int iA = ls.a(ltVar.c);
        if (iA == 0) {
            iA = ls.a;
        }
        if (iA != ls.a) {
            this.a.k = ls.b;
            return;
        }
        this.a.a(ltVar);
        h hVar = this.a;
        w wVar = h.b;
        lq lqVar = (lq) lt.a.q();
        int i = hVar.k;
        if (!lqVar.b.H()) {
            lqVar.v();
        }
        lt ltVar2 = (lt) lqVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        ltVar2.c = i2;
        ltVar2.b |= 1;
        for (int i3 = 0; i3 < 6; i3++) {
            long j = hVar.g[i3];
            if (!lqVar.b.H()) {
                lqVar.v();
            }
            lt ltVar3 = (lt) lqVar.b;
            bt btVar = ltVar3.d;
            if (!btVar.c()) {
                ltVar3.d = bi.x(btVar);
            }
            ltVar3.d.f(j);
        }
        if (hVar.c != null) {
            y yVar = (y) z.a.q();
            int iO = hVar.c.o();
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar = (z) yVar.b;
            zVar.b |= 1;
            zVar.c = iO;
            int iQ = hVar.c.q();
            if (!yVar.b.H()) {
                yVar.v();
            }
            z zVar2 = (z) yVar.b;
            zVar2.b |= 2;
            zVar2.d = iQ;
            if (!lqVar.b.H()) {
                lqVar.v();
            }
            lt ltVar4 = (lt) lqVar.b;
            z zVar3 = (z) yVar.t();
            zVar3.getClass();
            ltVar4.e = zVar3;
            ltVar4.b |= 2;
        }
        int i4 = hVar.f;
        if (!lqVar.b.H()) {
            lqVar.v();
        }
        lt ltVar5 = (lt) lqVar.b;
        ltVar5.b |= 4;
        ltVar5.f = i4;
        int i5 = hVar.e;
        if (!lqVar.b.H()) {
            lqVar.v();
        }
        com.google.android.libraries.navigation.internal.iv.f fVar = hVar.h;
        lt ltVar6 = (lt) lqVar.b;
        ltVar6.b |= 8;
        ltVar6.g = i5;
        fVar.s(wVar, (lt) lqVar.t());
    }
}

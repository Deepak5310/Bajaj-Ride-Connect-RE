package com.google.android.libraries.navigation.internal.bo;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import j$.time.Duration;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class z {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bo.z");
    public fd b;
    public final com.google.android.libraries.navigation.internal.cl.t c;
    public volatile ev d;
    public com.google.android.libraries.navigation.internal.ot.k e;
    public final com.google.android.libraries.navigation.internal.oo.b f;
    public final com.google.android.libraries.navigation.internal.qk.w g;
    public final com.google.android.libraries.navigation.internal.ol.ak h;
    public final ax i;
    public final com.google.android.libraries.navigation.internal.ol.ai j;
    public final com.google.android.libraries.navigation.internal.qk.i k;
    public ev l;
    public final List m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.on.h f350n;
    public final com.google.android.libraries.navigation.internal.fz.d o;
    public final Executor p;
    public final boolean q;
    public final com.google.android.libraries.navigation.internal.cr.f r;
    public final com.google.android.libraries.navigation.internal.bm.ai s;
    private final boolean t;

    public z(List list, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.qk.w wVar, com.google.android.libraries.navigation.internal.cr.f fVar, com.google.android.libraries.navigation.internal.ol.ak akVar, ax axVar, com.google.android.libraries.navigation.internal.ol.ai aiVar, com.google.android.libraries.navigation.internal.qk.i iVar, com.google.android.libraries.navigation.internal.on.h hVar, Context context, Executor executor, boolean z, boolean z2, com.google.android.libraries.navigation.internal.bm.ai aiVar2, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.dx.i iVar2, boolean z3) {
        int i = ev.d;
        this.d = lv.a;
        this.m = ev.o(fy.o(list));
        this.f = bVar;
        this.g = wVar;
        this.r = fVar;
        this.h = akVar;
        this.i = axVar;
        this.j = aiVar;
        this.k = iVar;
        this.f350n = hVar;
        this.p = executor;
        this.e = null;
        this.t = z2;
        this.s = aiVar2;
        this.c = new com.google.android.libraries.navigation.internal.cl.t(context, axVar, bVar.g(), z2, z, null, dVar, null, iVar2);
        this.l = lv.a;
        this.b = ma.b;
        this.o = dVar;
        this.q = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        ev evVar = this.d;
        int i = ((lv) evVar).c;
        for (int i2 = 0; i2 < i; i2++) {
            ((com.google.android.libraries.navigation.internal.qk.ak) evVar.get(i2)).c();
        }
        this.d = lv.a;
    }

    public final boolean b(com.google.android.libraries.navigation.internal.oj.c cVar, el elVar) {
        boolean zL;
        fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
        if (fgVar == null) {
            fgVar = fg.a;
        }
        com.google.android.libraries.navigation.internal.bq.e eVarB = com.google.android.libraries.navigation.internal.bq.e.b(fgVar, this.i);
        if (!eVarB.b) {
            return false;
        }
        gn gnVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).l;
        if (gnVar == null) {
            gnVar = gn.a;
        }
        if (gnVar.d == null) {
            com.google.android.libraries.navigation.internal.adr.aj ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
        }
        String strD = com.google.android.libraries.navigation.internal.br.l.d(elVar, this.t);
        com.google.android.libraries.navigation.internal.aap.d dVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).d;
        if (dVar == null) {
            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        int i = dVar.c;
        com.google.android.libraries.navigation.internal.aap.d dVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).d;
        if (dVar2 == null) {
            dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
        }
        long j = dVar2.c;
        boolean z = this.q;
        Duration durationOfSeconds = Duration.ofSeconds(j);
        if (z) {
            com.google.android.libraries.navigation.internal.cl.t tVar = this.c;
            if (!eVarB.c) {
                durationOfSeconds = com.google.android.libraries.navigation.internal.cl.t.a;
            }
            zL = tVar.g(cVar, durationOfSeconds, strD, elVar);
        } else {
            zL = this.c.l(cVar, true == eVarB.c ? i : 0, strD, elVar);
        }
        if (this.q && zL) {
            fs fsVar = ((ef) cVar.c().b).u;
            if (fsVar == null) {
                fsVar = fs.a;
            }
            bh bhVarS = bi.s(fu.w);
            fsVar.h(bhVarS);
            if (!fsVar.w.n(bhVarS.d)) {
                dy dyVarC = cVar.c();
                bb bbVar = (bb) fsVar.aH(5, null);
                bbVar.x(fsVar);
                fr frVar = (fr) bbVar;
                frVar.C(fu.w, cx.a);
                if (!dyVarC.b.H()) {
                    dyVarC.v();
                }
                ef efVar = (ef) dyVarC.b;
                fs fsVar2 = (fs) frVar.t();
                fsVar2.getClass();
                efVar.u = fsVar2;
                efVar.b |= 65536;
                return true;
            }
        }
        return zL;
    }

    public final boolean c(el elVar) {
        fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
        if (fgVar == null) {
            fgVar = fg.a;
        }
        return com.google.android.libraries.navigation.internal.bq.e.b(fgVar, this.i).b;
    }
}

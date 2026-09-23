package com.google.android.libraries.navigation.internal.vw;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adr.dx;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.ix;
import com.google.android.libraries.navigation.internal.adr.ja;
import com.google.android.libraries.navigation.internal.adr.jb;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.br.s;
import com.google.android.libraries.navigation.internal.oe.r;
import com.google.android.libraries.navigation.internal.tj.ag;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements com.google.android.libraries.navigation.internal.vp.i {
    public final Context a;
    private final com.google.android.libraries.navigation.internal.vp.d b;
    private final com.google.android.libraries.navigation.internal.vp.g c;
    private final com.google.android.libraries.navigation.internal.fj.a d;
    private boolean e;
    private final com.google.android.libraries.navigation.internal.sj.a f;

    public q(com.google.android.libraries.navigation.internal.vp.d dVar, com.google.android.libraries.navigation.internal.vp.g gVar, Context context, com.google.android.libraries.navigation.internal.fj.a aVar, com.google.android.libraries.navigation.internal.sj.a aVar2) {
        this.b = dVar;
        this.c = gVar;
        this.a = context;
        ar.q(aVar);
        this.d = aVar;
        this.f = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void a() {
        if (this.e) {
            this.f.a();
            this.e = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void b() {
        this.d.a();
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void c() {
        this.d.b();
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void d(r rVar) {
        this.d.c(new r(rVar.a, rVar.b));
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void e() {
        bg bgVar = this.b.a().e;
        if (bgVar != null) {
            ix ixVar = (ix) jg.a.q();
            dx dxVar = (dx) el.a.q();
            fp fpVar = fp.INCIDENT;
            if (!dxVar.b.H()) {
                dxVar.v();
            }
            el elVar = (el) dxVar.b;
            elVar.g = fpVar.L;
            elVar.b |= 8;
            dxVar.c(s.a("Test prompt title"));
            dxVar.d(s.a("Test subtitle"));
            if (!ixVar.b.H()) {
                ixVar.v();
            }
            jg jgVar = (jg) ixVar.b;
            el elVarT = dxVar.t();
            elVarT.getClass();
            jgVar.i = elVarT;
            jgVar.b |= 32;
            x xVarV = x.v("\b\u0001");
            if (!ixVar.b.H()) {
                ixVar.v();
            }
            jg jgVar2 = (jg) ixVar.b;
            jgVar2.b |= 8;
            jgVar2.g = xVarV;
            com.google.android.libraries.navigation.internal.adr.k kVar = (com.google.android.libraries.navigation.internal.adr.k) com.google.android.libraries.navigation.internal.adr.n.a.q();
            if (!kVar.b.H()) {
                kVar.v();
            }
            com.google.android.libraries.navigation.internal.adr.n.c((com.google.android.libraries.navigation.internal.adr.n) kVar.b);
            ixVar.c(kVar);
            ja jaVar = (ja) jb.a.q();
            if (!jaVar.b.H()) {
                jaVar.v();
            }
            jb jbVar = (jb) jaVar.b;
            jbVar.b |= 1;
            jbVar.c = 3;
            if (!ixVar.b.H()) {
                ixVar.v();
            }
            jg jgVar3 = (jg) ixVar.b;
            jb jbVar2 = (jb) jaVar.t();
            jbVar2.getClass();
            jgVar3.k = jbVar2;
            jgVar3.b |= 128;
            this.f.b(new ag((jg) ixVar.t(), bh.g(bgVar), System.currentTimeMillis()));
            this.e = true;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void f(com.google.android.libraries.navigation.internal.vp.h hVar) {
        com.google.android.libraries.navigation.internal.vv.a aVarA = this.b.a();
        if (aVarA.d()) {
            i(aVarA, hVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized void g() {
        this.d.g();
        this.d.c(null);
    }

    @Override // com.google.android.libraries.navigation.internal.vp.i
    public final synchronized com.google.android.libraries.navigation.internal.vq.b h(List list, lr lrVar, long j, com.google.android.libraries.navigation.internal.vp.h hVar) {
        com.google.android.libraries.navigation.internal.vq.b bVarA;
        ar.r(list, "Tried to set a null destination list.");
        ar.b(!list.isEmpty(), "Tried to set an empty destination list.");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ar.r((ck) it2.next(), "Tried to set a null destination.");
        }
        ar.r(lrVar, "Tried to set null options. Use TactileOptionsUtils.createDefaultOptions() instead.");
        ev evVarO = ev.o(list);
        bVarA = com.google.android.libraries.navigation.internal.vq.b.a();
        p pVar = new p(this, hVar, bVarA);
        ArrayList arrayList = new ArrayList(evVarO.size());
        arrayList.addAll(evVarO);
        this.c.c(arrayList, lv.a, lrVar, j, pVar, null, null);
        return bVarA;
    }

    public final synchronized void i(com.google.android.libraries.navigation.internal.vv.a aVar, com.google.android.libraries.navigation.internal.vp.h hVar) {
        bg bgVar = aVar.e;
        ar.q(bgVar);
        this.d.d(bgVar, hVar.a, 0.0d);
    }
}

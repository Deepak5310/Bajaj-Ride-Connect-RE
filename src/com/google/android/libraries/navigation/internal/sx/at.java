package com.google.android.libraries.navigation.internal.sx;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.afl.gv;
import com.google.android.libraries.navigation.internal.afl.ku;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mi;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at {
    public static final mj a;
    public static final mj b;
    private static final mj g;
    public final com.google.android.libraries.navigation.internal.kl.b c;
    public final ac d;
    public final com.google.android.libraries.navigation.internal.bu.c e;
    public final boolean f;
    private final com.google.android.libraries.navigation.internal.afo.a h;
    private final com.google.android.libraries.navigation.internal.afo.a i;
    private final com.google.android.libraries.navigation.internal.fu.a j;
    private final com.google.android.libraries.navigation.internal.tq.e k;
    private final com.google.android.libraries.navigation.internal.bi.q l;
    private final com.google.android.libraries.navigation.internal.wr.a m;

    static {
        mi miVar = (mi) mj.a.q();
        int i = com.google.android.libraries.navigation.internal.adq.be.c;
        if (!miVar.b.H()) {
            miVar.v();
        }
        mj mjVar = (mj) miVar.b;
        if (i == 0) {
            throw null;
        }
        mjVar.c = i;
        mjVar.b |= 1;
        g = (mj) miVar.t();
        mi miVar2 = (mi) mj.a.q();
        int i2 = com.google.android.libraries.navigation.internal.adq.be.g;
        if (!miVar2.b.H()) {
            miVar2.v();
        }
        mj mjVar2 = (mj) miVar2.b;
        if (i2 == 0) {
            throw null;
        }
        mjVar2.c = i2;
        mjVar2.b |= 1;
        a = (mj) miVar2.t();
        mi miVar3 = (mi) mj.a.q();
        int i3 = com.google.android.libraries.navigation.internal.adq.be.h;
        if (!miVar3.b.H()) {
            miVar3.v();
        }
        mj mjVar3 = (mj) miVar3.b;
        if (i3 == 0) {
            throw null;
        }
        mjVar3.c = i3;
        mjVar3.b |= 1;
        b = (mj) miVar3.t();
    }

    public at(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.tq.e eVar, ac acVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fu.a aVar3, com.google.android.libraries.navigation.internal.bu.c cVar, com.google.android.libraries.navigation.internal.bi.q qVar, com.google.android.libraries.navigation.internal.wr.a aVar4) {
        this.c = bVar;
        this.i = aVar;
        this.h = aVar2;
        this.k = eVar;
        this.d = acVar;
        this.j = aVar3;
        this.e = cVar;
        this.f = fVar.y(com.google.android.libraries.navigation.internal.iv.ab.ck, false);
        this.l = qVar;
        this.m = aVar4;
    }

    public static boolean e(com.google.android.libraries.navigation.internal.db.r rVar) {
        if (rVar == null) {
            return true;
        }
        if (rVar.k().b) {
            return false;
        }
        return !rVar.r() || rVar.d > 50.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.libraries.navigation.internal.bs.a a(com.google.android.libraries.navigation.internal.db.r rVar, bg bgVar, lr lrVar, com.google.android.libraries.navigation.internal.adu.s sVar, boolean z, bm.a aVar, boolean z2) {
        ck ckVarN = ck.N(null, rVar.m());
        com.google.android.libraries.navigation.internal.bs.a aVar2 = new com.google.android.libraries.navigation.internal.bs.a();
        aVar2.d = com.google.android.libraries.navigation.internal.ts.a.a(rVar);
        aVar2.e = rVar.o();
        aVar2.g = z;
        aVar2.f = aVar;
        ka kaVar = lrVar.f;
        if (kaVar == null) {
            kaVar = ka.a;
        }
        com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(kaVar.c);
        if (alVarB == null) {
            alVarB = com.google.android.libraries.navigation.internal.ady.al.MIXED;
        }
        aVar2.a = this.e.a(lrVar, alVarB).a();
        aVar2.i = null;
        aVar2.b(ckVarN);
        com.google.android.libraries.navigation.internal.ady.c cVar = (com.google.android.libraries.navigation.internal.ady.c) com.google.android.libraries.navigation.internal.ady.h.a.q();
        int i = com.google.android.libraries.navigation.internal.ady.e.e;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar = (com.google.android.libraries.navigation.internal.ady.h) cVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.ady.g.e;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar2 = (com.google.android.libraries.navigation.internal.ady.h) cVar.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        hVar2.d = i4;
        hVar2.b |= 2;
        aVar2.c = (com.google.android.libraries.navigation.internal.ady.h) cVar.t();
        aVar2.h = z2;
        ev evVarB = bgVar.B();
        for (int i5 = 1; i5 < evVarB.size(); i5++) {
            aVar2.b((ck) evVarB.get(i5));
        }
        return aVar2;
    }

    public final bj b(com.google.android.libraries.navigation.internal.db.r rVar, bg bgVar, gv gvVar, Context context, com.google.android.libraries.navigation.internal.ael.x xVar, com.google.android.libraries.navigation.internal.ael.x xVar2) {
        lz lzVarF = f(rVar, bgVar, xVar, xVar2, false, null, null);
        ev evVarR = ev.r((com.google.android.libraries.navigation.internal.es.a) this.i.a(), (com.google.android.libraries.navigation.internal.es.a) this.h.a());
        com.google.android.libraries.navigation.internal.aco.b bVarA = com.google.android.libraries.navigation.internal.er.s.a(this.j, rVar, null);
        ck[] ckVarArr = (ck[]) as.a(lzVarF, context).toArray(new ck[0]);
        com.google.android.libraries.navigation.internal.tq.e eVar = this.k;
        com.google.android.libraries.navigation.internal.mj.a aVar = eVar.b;
        return eVar.a(evVarR, gvVar, bVarA, lzVarF, bgVar.d, bgVar.f, ckVarArr, e(rVar), aVar.f().toEpochMilli());
    }

    public final bm.a c() {
        return com.google.android.libraries.navigation.internal.hf.c.e(this.m);
    }

    public final lz d(com.google.android.libraries.navigation.internal.bs.b bVar, mj mjVar, lt ltVar) {
        ev evVarQ = ev.q(ku.SVG_INCIDENT_LIGHT);
        ev evVar = lv.a;
        return this.l.a(bVar, mjVar, evVarQ, ltVar, false, false);
    }

    public final lz f(com.google.android.libraries.navigation.internal.db.r rVar, bg bgVar, com.google.android.libraries.navigation.internal.ael.x xVar, com.google.android.libraries.navigation.internal.ael.x xVar2, boolean z, EnumMap enumMap, lt ltVar) {
        com.google.android.libraries.navigation.internal.bu.b bVarA = this.e.a(bgVar.P, bgVar.j);
        bVarA.b(xVar);
        bVarA.a = xVar2;
        bVarA.c = enumMap;
        com.google.android.libraries.navigation.internal.bs.a aVarA = a(rVar, bgVar, bVarA.a(), null, z, c(), this.f);
        bgVar.q.size();
        return d(aVarA.a(), g, ltVar);
    }
}

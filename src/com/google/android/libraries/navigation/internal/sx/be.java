package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.afl.ku;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mi;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.cg;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    public static final mj a;
    public final com.google.android.libraries.navigation.internal.bu.c b;
    public final com.google.android.libraries.navigation.internal.bi.q c;
    private final com.google.android.libraries.navigation.internal.iv.f d;
    private final boolean e;
    private final com.google.android.libraries.navigation.internal.he.d f;
    private final com.google.android.libraries.navigation.internal.afo.a g;
    private final com.google.android.libraries.navigation.internal.wr.a h;

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
        a = (mj) miVar.t();
    }

    public be(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.bu.c cVar, com.google.android.libraries.navigation.internal.bi.q qVar, com.google.android.libraries.navigation.internal.he.d dVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.wr.a aVar2) {
        this.d = fVar;
        this.b = cVar;
        this.c = qVar;
        this.f = dVar;
        this.g = aVar;
        this.h = aVar2;
        this.e = fVar.y(com.google.android.libraries.navigation.internal.iv.ab.ck, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ev c(ev evVar) {
        int i = ev.d;
        eq eqVar = new eq();
        if (evVar != null) {
            int size = evVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.libraries.navigation.internal.vr.a aVar = (com.google.android.libraries.navigation.internal.vr.a) evVar.get(i2);
                eqVar.h(cg.d(aVar.b(), aVar.a()));
            }
        }
        return eqVar.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.google.android.libraries.navigation.internal.bs.b a(com.google.android.libraries.navigation.internal.db.r rVar, lr lrVar, boolean z, ev evVar, boolean z2, ev evVar2, com.google.android.libraries.navigation.internal.adu.s sVar, Integer num, boolean z3) {
        com.google.android.libraries.navigation.internal.bs.a aVar = new com.google.android.libraries.navigation.internal.bs.a();
        aVar.e = rVar == null ? null : rVar.o();
        aVar.g = z;
        aVar.f = com.google.android.libraries.navigation.internal.hf.c.e(this.h);
        com.google.android.libraries.navigation.internal.bu.c cVar = this.b;
        ka kaVar = lrVar.f;
        if (kaVar == null) {
            kaVar = ka.a;
        }
        com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(kaVar.c);
        if (alVarB == null) {
            alVarB = com.google.android.libraries.navigation.internal.ady.al.MIXED;
        }
        aVar.a = cVar.a(lrVar, alVarB).a();
        aVar.i = null;
        com.google.android.libraries.navigation.internal.ady.c cVar2 = (com.google.android.libraries.navigation.internal.ady.c) com.google.android.libraries.navigation.internal.ady.h.a.q();
        int i = com.google.android.libraries.navigation.internal.ady.e.e;
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar = (com.google.android.libraries.navigation.internal.ady.h) cVar2.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.ady.g.e;
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.ady.h hVar2 = (com.google.android.libraries.navigation.internal.ady.h) cVar2.b;
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        hVar2.d = i4;
        hVar2.b |= 2;
        aVar.c = (com.google.android.libraries.navigation.internal.ady.h) cVar2.t();
        aVar.h = this.e;
        if (z3) {
            aVar.d = com.google.android.libraries.navigation.internal.ts.a.a(rVar);
        }
        aVar.b(ck.N(null, rVar == null ? null : rVar.m()));
        for (int i5 = (!z2 || evVar.size() <= 0) ? 0 : 1; i5 < evVar.size(); i5++) {
            aVar.b((ck) evVar.get(i5));
        }
        if (num != null) {
            if (num.intValue() >= -1) {
                evVar2.size();
            }
        } else if (!evVar2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = evVar2.size();
            for (int i6 = 0; i6 < size; i6++) {
                cg cgVar = (cg) evVar2.get(i6);
                arrayList.add(cg.d(cgVar.c(), cgVar.a()));
            }
            aVar.b.clear();
            aVar.b.addAll(arrayList);
        }
        return aVar.a();
    }

    public final com.google.android.libraries.navigation.internal.bs.b b(ap apVar) {
        com.google.android.libraries.navigation.internal.db.r rVarB = apVar.b();
        lr lrVar = (lr) Objects.requireNonNull(apVar.j());
        boolean zR = apVar.r();
        ev evVar = (ev) Objects.requireNonNull(apVar.d());
        ev evVarC = c(apVar.c());
        apVar.e();
        return a(rVarB, lrVar, zR, evVar, false, evVarC, null, null, false);
    }

    public final lz d(com.google.android.libraries.navigation.internal.bs.b bVar) {
        fy fyVar = com.google.android.libraries.navigation.internal.br.g.a;
        ev evVarS = ev.s(ku.SVG_LIGHT, ku.SVG_DARK, ku.SVG_INCIDENT_LIGHT);
        this.f.b();
        ev evVar = lv.a;
        return this.c.a(bVar, null, evVarS, null, ((eo) this.g.a()).e(), true);
    }
}

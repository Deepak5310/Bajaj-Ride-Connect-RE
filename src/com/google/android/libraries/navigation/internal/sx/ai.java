package com.google.android.libraries.navigation.internal.sx;

import android.app.Application;
import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.adr.ka;
import com.google.android.libraries.navigation.internal.afl.ku;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.afl.lz;
import com.google.android.libraries.navigation.internal.afl.mj;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.EnumMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai {
    public final Context a;
    public as b;
    public am c;
    public an d;
    public final bk e = new bk(new Callable() { // from class: com.google.android.libraries.navigation.internal.sx.af
        @Override // java.util.concurrent.Callable
        public final Object call() throws am, an {
            ai aiVar = this.a;
            an anVar = aiVar.d;
            if (anVar != null) {
                throw anVar;
            }
            am amVar = aiVar.c;
            if (amVar == null) {
                return (as) Objects.requireNonNull(aiVar.b);
            }
            throw amVar;
        }
    });
    public com.google.android.libraries.navigation.internal.bi.j f;
    public final i g;
    private final com.google.android.libraries.navigation.internal.mj.a h;
    private final com.google.android.libraries.navigation.internal.fr.d i;
    private final com.google.android.libraries.navigation.internal.bi.o j;
    private final Executor k;
    private final com.google.android.libraries.navigation.internal.bi.m l;
    private final be m;

    public ai(Application application, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fr.d dVar, com.google.android.libraries.navigation.internal.bi.o oVar, Executor executor, com.google.android.libraries.navigation.internal.bi.m mVar, be beVar, i iVar) {
        this.a = application;
        this.h = aVar;
        this.i = dVar;
        this.j = oVar;
        this.k = executor;
        this.l = mVar;
        this.m = beVar;
        this.g = iVar;
    }

    final bj a(ap apVar) {
        lz lzVarA;
        if (apVar.i() != null) {
            return com.google.android.libraries.navigation.internal.aac.az.f();
        }
        com.google.android.libraries.navigation.internal.db.r rVarB = apVar.b();
        boolean z = rVarB == null || (!rVarB.k().b && (!rVarB.r() || rVarB.d > 50.0f));
        long epochMilli = this.h.f().toEpochMilli();
        be beVar = this.m;
        if (apVar.d() == null || apVar.j() == null) {
            bg bgVar = (bg) Objects.requireNonNull(apVar.a());
            com.google.android.libraries.navigation.internal.ael.x xVarG = apVar.g();
            Double dM = apVar.m();
            com.google.android.libraries.navigation.internal.ady.n nVarF = apVar.f();
            com.google.android.libraries.navigation.internal.db.r rVar = (com.google.android.libraries.navigation.internal.db.r) Objects.requireNonNull(apVar.b());
            boolean zR = apVar.r();
            lt ltVarK = apVar.k();
            mj mjVar = (mj) Objects.requireNonNull(apVar.l());
            apVar.e();
            com.google.android.libraries.navigation.internal.ael.x xVarH = apVar.h();
            apVar.s();
            EnumMap enumMapP = apVar.p();
            Integer numN = apVar.n();
            com.google.android.libraries.navigation.internal.bu.b bVarA = beVar.b.a(bgVar.P, bgVar.j);
            bVarA.a = xVarG;
            bVarA.b = nVarF;
            bVarA.c = enumMapP;
            if (xVarH != null) {
                bVarA.b(xVarH);
            }
            if (dM != null) {
                bVarA.c(bgVar.U, dM.doubleValue());
            }
            com.google.android.libraries.navigation.internal.bs.b bVarA2 = beVar.a(rVar, bVarA.a(), zR, bgVar.B(), true, bgVar.q, null, numN, true);
            ev evVarQ = ev.q(ku.SVG_INCIDENT_LIGHT);
            com.google.android.libraries.navigation.internal.bi.q qVar = beVar.c;
            ev evVar = lv.a;
            lzVarA = qVar.a(bVarA2, mjVar, evVarQ, ltVarK, false, false);
        } else if (apVar.c() != null) {
            lzVarA = beVar.d(beVar.b(apVar));
        } else {
            com.google.android.libraries.navigation.internal.db.r rVarB2 = apVar.b();
            lr lrVar = (lr) Objects.requireNonNull(apVar.j());
            com.google.android.libraries.navigation.internal.ael.x xVarG2 = apVar.g();
            boolean zR2 = apVar.r();
            lt ltVarK2 = apVar.k();
            ev evVar2 = (ev) Objects.requireNonNull(apVar.d());
            ev evVarC = apVar.c();
            com.google.android.libraries.navigation.internal.bu.c cVar = beVar.b;
            ka kaVar = lrVar.f;
            if (kaVar == null) {
                kaVar = ka.a;
            }
            com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(kaVar.c);
            if (alVarB == null) {
                alVarB = com.google.android.libraries.navigation.internal.ady.al.MIXED;
            }
            com.google.android.libraries.navigation.internal.bu.b bVarA3 = cVar.a(lrVar, alVarB);
            bVarA3.a = xVarG2;
            com.google.android.libraries.navigation.internal.bs.b bVarA4 = beVar.a(rVarB2, bVarA3.a(), zR2, evVar2, false, be.c(evVarC), null, null, true);
            ev evVarQ2 = ev.q(ku.SVG_INCIDENT_LIGHT);
            com.google.android.libraries.navigation.internal.bi.q qVar2 = beVar.c;
            ev evVar3 = lv.a;
            lzVarA = qVar2.a(bVarA4, null, evVarQ2, ltVarK2, false, false);
        }
        i iVar = this.g;
        n nVar = (n) u.a.q();
        int i = q.b;
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar = (u) nVar.b;
        uVar.c = q.a(i);
        uVar.b |= 1;
        if (!nVar.b.H()) {
            nVar.v();
        }
        u uVar2 = (u) nVar.b;
        lzVarA.getClass();
        uVar2.d = lzVarA;
        uVar2.b |= 2;
        iVar.a((u) nVar.t());
        this.f = this.l.a(lzVarA, z, epochMilli, new ag(this, z, epochMilli), false);
        if (!com.google.android.libraries.navigation.internal.bi.m.b(lzVarA)) {
            this.g.a(e.a(q.f, s.HTTP_BAD_REQUEST));
            return com.google.android.libraries.navigation.internal.aac.az.g(new am((com.google.android.libraries.navigation.internal.bi.j) Objects.requireNonNull(this.f), this.a, com.google.android.libraries.navigation.internal.fw.g.SINGLE_REQUEST_FATAL_ERROR));
        }
        if (this.i.d()) {
            com.google.android.libraries.navigation.internal.aac.az.o(this.e, new ah(this, this.j.a((com.google.android.libraries.navigation.internal.bi.j) Objects.requireNonNull(this.f))), this.k);
            return this.e;
        }
        this.g.a(e.a(q.f, s.NO_CONNECTIVITY));
        return com.google.android.libraries.navigation.internal.aac.az.g(new an(com.google.android.libraries.navigation.internal.fw.g.SINGLE_REQUEST_FATAL_ERROR));
    }
}

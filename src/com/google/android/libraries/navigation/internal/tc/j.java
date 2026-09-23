package com.google.android.libraries.navigation.internal.tc;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.acd.ma;
import com.google.android.libraries.navigation.internal.acd.mb;
import com.google.android.libraries.navigation.internal.acd.mc;
import com.google.android.libraries.navigation.internal.acd.md;
import com.google.android.libraries.navigation.internal.acd.me;
import com.google.android.libraries.navigation.internal.acd.mf;
import com.google.android.libraries.navigation.internal.acd.mg;
import com.google.android.libraries.navigation.internal.acd.mh;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.afl.ls;
import com.google.android.libraries.navigation.internal.afl.lt;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.km.ag;
import com.google.android.libraries.navigation.internal.ti.ac;
import com.google.android.libraries.navigation.internal.ti.ad;
import com.google.android.libraries.navigation.internal.ti.af;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.zs.fa;
import com.google.android.libraries.navigation.internal.zs.fb;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    private final com.google.android.libraries.navigation.internal.fu.a A;
    private final Optional B;
    private final com.google.android.libraries.navigation.internal.sj.a C;
    private final com.google.android.libraries.navigation.internal.aaa.c D;
    public final Context a;
    public final com.google.android.libraries.navigation.internal.fz.d b;
    public final bn c;
    public com.google.android.libraries.navigation.internal.ti.p d;
    public h e;
    public g f;
    public int g;
    public final com.google.android.libraries.navigation.internal.au.c h;
    public final com.google.android.libraries.navigation.internal.te.a i;
    public final com.google.android.libraries.navigation.internal.td.b j;
    private final com.google.android.libraries.navigation.internal.fr.l k;
    private final com.google.android.libraries.navigation.internal.sl.l l;
    private final com.google.android.libraries.navigation.internal.iv.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.mj.a f588n;
    private final com.google.android.libraries.navigation.internal.ia.e o;
    private final com.google.android.libraries.navigation.internal.di.b p;
    private final String q;
    private final com.google.android.libraries.navigation.internal.rw.q r;
    private final bn s;
    private final com.google.android.libraries.navigation.internal.kl.b t;
    private final com.google.android.libraries.navigation.internal.gq.ab u;
    private final com.google.android.libraries.navigation.internal.cw.a v;
    private final com.google.android.libraries.navigation.internal.aq.m w;
    private final Optional x;
    private final Optional y;
    private final boolean z;

    public j(Context context, com.google.android.libraries.navigation.internal.fr.l lVar, com.google.android.libraries.navigation.internal.sl.l lVar2, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.fz.d dVar, String str, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.sj.a aVar, bn bnVar, bn bnVar2, com.google.android.libraries.navigation.internal.di.b bVar, com.google.android.libraries.navigation.internal.kl.b bVar2, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.gq.ab abVar, com.google.android.libraries.navigation.internal.cw.a aVar3, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.au.c cVar, Optional optional, Optional optional2, com.google.android.libraries.navigation.internal.te.a aVar4, com.google.android.libraries.navigation.internal.td.b bVar3, com.google.android.libraries.navigation.internal.aaa.c cVar2, com.google.android.libraries.navigation.internal.fu.a aVar5, Optional optional3) {
        this.a = context;
        this.k = lVar;
        this.l = lVar2;
        this.m = fVar;
        this.f588n = aVar2;
        this.o = eVar;
        this.b = dVar;
        this.q = str;
        this.r = qVar;
        this.C = aVar;
        this.c = bnVar;
        this.s = bnVar2;
        this.p = bVar;
        this.t = bVar2;
        this.u = abVar;
        this.h = cVar;
        this.x = optional;
        this.y = optional2;
        this.v = aVar3;
        ar.r(mVar, "projectedModeController");
        this.w = mVar;
        this.i = aVar4;
        this.j = bVar3;
        this.D = cVar2;
        this.B = optional3;
        this.z = true;
        this.A = aVar5;
        this.g = -1;
    }

    public final bj a(final i iVar) {
        ap.NAVIGATION_INTERNAL.f();
        return com.google.android.libraries.navigation.internal.aac.j.i(this.i.d(), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.tc.e
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                Boolean bool = (Boolean) obj;
                ap.NAVIGATION_INTERNAL.f();
                int i = iVar.a;
                j jVar = this.a;
                if (i != jVar.g || jVar.d == null) {
                    jVar.hashCode();
                    return be.a;
                }
                if (!bool.booleanValue() || jVar.d.f()) {
                    return be.a;
                }
                com.google.android.libraries.navigation.internal.ti.p pVar = jVar.d;
                pVar.z.set(true);
                AtomicReference atomicReference = pVar.A;
                com.google.android.libraries.navigation.internal.aaa.c cVar = pVar.I;
                atomicReference.set(com.google.android.libraries.navigation.internal.aaa.c.a());
                int iA = fa.a(pVar.g.a.z);
                if (iA == 0) {
                    iA = fa.a;
                }
                if (iA == fa.b) {
                    com.google.android.libraries.navigation.internal.ti.c.a.d(pVar.g.a());
                }
                com.google.android.libraries.navigation.internal.ia.e eVar = pVar.e;
                fd fdVarK = fd.k(ap.NAVIGATION_INTERNAL, pVar.d);
                fz fzVar = new fz();
                fzVar.b(com.google.android.libraries.navigation.internal.tf.d.class, new com.google.android.libraries.navigation.internal.ti.q(0, com.google.android.libraries.navigation.internal.tf.d.class, pVar, ap.NAVIGATION_INTERNAL, com.google.android.libraries.navigation.internal.ti.q.b(ap.NAVIGATION_INTERNAL, fdVarK)));
                ap apVar = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sr.a.class, new com.google.android.libraries.navigation.internal.ti.q(1, com.google.android.libraries.navigation.internal.sr.a.class, pVar, apVar, com.google.android.libraries.navigation.internal.ti.q.b(apVar, fdVarK)));
                ap apVar2 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.tf.c.class, new com.google.android.libraries.navigation.internal.ti.q(2, com.google.android.libraries.navigation.internal.tf.c.class, pVar, apVar2, com.google.android.libraries.navigation.internal.ti.q.b(apVar2, fdVarK)));
                ap apVar3 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new com.google.android.libraries.navigation.internal.ti.q(3, com.google.android.libraries.navigation.internal.db.s.class, pVar, apVar3, com.google.android.libraries.navigation.internal.ti.q.b(apVar3, fdVarK)));
                ap apVar4 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sr.h.class, new com.google.android.libraries.navigation.internal.ti.q(4, com.google.android.libraries.navigation.internal.sr.h.class, pVar, apVar4, com.google.android.libraries.navigation.internal.ti.q.b(apVar4, fdVarK)));
                ap apVar5 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sw.c.class, new com.google.android.libraries.navigation.internal.ti.q(5, com.google.android.libraries.navigation.internal.sw.c.class, pVar, apVar5, com.google.android.libraries.navigation.internal.ti.q.b(apVar5, fdVarK)));
                ap apVar6 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sw.b.class, new com.google.android.libraries.navigation.internal.ti.q(6, com.google.android.libraries.navigation.internal.sw.b.class, pVar, apVar6, com.google.android.libraries.navigation.internal.ti.q.b(apVar6, fdVarK)));
                ap apVar7 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.tf.b.class, new com.google.android.libraries.navigation.internal.ti.q(7, com.google.android.libraries.navigation.internal.tf.b.class, pVar, apVar7, com.google.android.libraries.navigation.internal.ti.q.b(apVar7, fdVarK)));
                ap apVar8 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sm.e.class, new com.google.android.libraries.navigation.internal.ti.q(8, com.google.android.libraries.navigation.internal.sm.e.class, pVar, apVar8, com.google.android.libraries.navigation.internal.ti.q.b(apVar8, fdVarK)));
                ap apVar9 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sm.c.class, new com.google.android.libraries.navigation.internal.ti.q(9, com.google.android.libraries.navigation.internal.sm.c.class, pVar, apVar9, com.google.android.libraries.navigation.internal.ti.q.b(apVar9, fdVarK)));
                ap apVar10 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sw.i.class, new com.google.android.libraries.navigation.internal.ti.q(10, com.google.android.libraries.navigation.internal.sw.i.class, pVar, apVar10, com.google.android.libraries.navigation.internal.ti.q.b(apVar10, fdVarK)));
                ap apVar11 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new com.google.android.libraries.navigation.internal.ti.q(11, com.google.android.libraries.navigation.internal.cw.d.class, pVar, apVar11, com.google.android.libraries.navigation.internal.ti.q.b(apVar11, fdVarK)));
                ap apVar12 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.tl.b.class, new com.google.android.libraries.navigation.internal.ti.q(12, com.google.android.libraries.navigation.internal.tl.b.class, pVar, apVar12, com.google.android.libraries.navigation.internal.ti.q.b(apVar12, fdVarK)));
                ap apVar13 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.cw.f.class, new com.google.android.libraries.navigation.internal.ti.q(13, com.google.android.libraries.navigation.internal.cw.f.class, pVar, apVar13, com.google.android.libraries.navigation.internal.ti.q.b(apVar13, fdVarK)));
                ap apVar14 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sr.b.class, new com.google.android.libraries.navigation.internal.ti.q(14, com.google.android.libraries.navigation.internal.sr.b.class, pVar, apVar14, com.google.android.libraries.navigation.internal.ti.q.b(apVar14, fdVarK)));
                ap apVar15 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.cw.j.class, new com.google.android.libraries.navigation.internal.ti.q(15, com.google.android.libraries.navigation.internal.cw.j.class, pVar, apVar15, com.google.android.libraries.navigation.internal.ti.q.b(apVar15, fdVarK)));
                ap apVar16 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.tf.g.class, new com.google.android.libraries.navigation.internal.ti.q(16, com.google.android.libraries.navigation.internal.tf.g.class, pVar, apVar16, com.google.android.libraries.navigation.internal.ti.q.b(apVar16, fdVarK)));
                ap apVar17 = ap.NAVIGATION_INTERNAL;
                fzVar.b(com.google.android.libraries.navigation.internal.sg.b.class, new com.google.android.libraries.navigation.internal.ti.q(17, com.google.android.libraries.navigation.internal.sg.b.class, pVar, apVar17, com.google.android.libraries.navigation.internal.ti.q.b(apVar17, fdVarK)));
                eVar.c(pVar, fzVar.a());
                pVar.c.a(pVar.F, pVar.d);
                pVar.H.c(pVar.G, pVar.d);
                pVar.e.a(new com.google.android.libraries.navigation.internal.sr.d());
                if (pVar.t.compareAndSet(false, true)) {
                    pVar.s.isPresent();
                }
                return be.a;
            }
        }, this.c);
    }

    public final lt b(boolean z) {
        ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.ti.p pVar = this.d;
        if (pVar == null || !pVar.f()) {
            return null;
        }
        ap.NAVIGATION_INTERNAL.f();
        long jA = pVar.f.a();
        int iMax = 0;
        int i = 0;
        while (i < pVar.y.size()) {
            com.google.android.libraries.navigation.internal.ti.n nVar = (com.google.android.libraries.navigation.internal.ti.n) pVar.y.get(i);
            if (jA >= nVar.f) {
                int i2 = nVar.a;
                pVar.y.remove(i);
                i--;
            }
            i++;
        }
        int iA = fa.a(pVar.g.a.z);
        if (iA == 0) {
            iA = fa.a;
        }
        ar.k(iA == fa.b);
        if (pVar.g("getReportingParams")) {
            fb fbVar = pVar.g.a;
            boolean z2 = fbVar.e;
            boolean z3 = fbVar.d && fbVar.l > 0 && !pVar.i.d();
            if (z2 || z3) {
                AtomicInteger atomicInteger = pVar.x;
                com.google.android.libraries.navigation.internal.ti.e eVar = pVar.i;
                int andIncrement = atomicInteger.getAndIncrement();
                int iA2 = eVar.c() ? pVar.i.a() : -1;
                boolean z4 = z || pVar.v;
                af afVarB = z2 ? pVar.k.b(z4) : pVar.k.clone();
                af afVarB2 = z3 ? pVar.j.b(z4) : pVar.j.clone();
                pVar.y.add(new com.google.android.libraries.navigation.internal.ti.n(andIncrement, afVarB, afVarB2, (!z2 || z4) ? afVarB.clone() : afVarB.b(true), iA2, jA + com.google.android.libraries.navigation.internal.ti.p.a));
                mf mfVar = (mf) mg.a.q();
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar = (mg) mfVar.b;
                mgVar.b |= 1;
                mgVar.e = z2;
                ad adVar = pVar.g;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                boolean z5 = adVar.f;
                mg mgVar2 = (mg) mfVar.b;
                mgVar2.b |= 4;
                mgVar2.f = true;
                al alVarB = al.b(pVar.g.a.A);
                if (alVarB == null) {
                    alVarB = al.DRIVE;
                }
                boolean z6 = alVarB == al.TRANSIT;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar3 = (mg) mfVar.b;
                mgVar3.c = 12;
                mgVar3.d = Boolean.valueOf(z6);
                int i3 = afVarB.a;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar4 = (mg) mfVar.b;
                mgVar4.b |= 128;
                mgVar4.k = i3;
                int i4 = afVarB.b;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar5 = (mg) mfVar.b;
                mgVar5.b |= 256;
                mgVar5.l = i4;
                ac acVar = pVar.h;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                long j = acVar.c;
                mg mgVar6 = (mg) mfVar.b;
                mgVar6.b |= 8;
                mgVar6.g = j;
                int i5 = pVar.g.a.o;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar7 = (mg) mfVar.b;
                mgVar7.b |= 16;
                mgVar7.h = i5;
                int i6 = pVar.g.a.y;
                if (!mfVar.b.H()) {
                    mfVar.v();
                }
                mg mgVar8 = (mg) mfVar.b;
                mgVar8.b |= 1024;
                mgVar8.m = i6;
                mg mgVar9 = (mg) mfVar.t();
                mb mbVar = (mb) me.a.q();
                if (!mbVar.b.H()) {
                    mbVar.v();
                }
                me meVar = (me) mbVar.b;
                meVar.b |= 1;
                meVar.c = z3;
                int i7 = afVarB2.a;
                if (!mbVar.b.H()) {
                    mbVar.v();
                }
                me meVar2 = (me) mbVar.b;
                meVar2.b |= 4;
                meVar2.e = i7;
                int i8 = afVarB2.b;
                if (!mbVar.b.H()) {
                    mbVar.v();
                }
                me meVar3 = (me) mbVar.b;
                meVar3.b |= 8;
                meVar3.f = i8;
                mc mcVar = (mc) md.a.q();
                int i9 = pVar.g.a.l;
                if (!mcVar.b.H()) {
                    mcVar.v();
                }
                md mdVar = (md) mcVar.b;
                mdVar.b |= 1;
                mdVar.c = i9;
                int i10 = pVar.g.a.m;
                if (!mcVar.b.H()) {
                    mcVar.v();
                }
                md mdVar2 = (md) mcVar.b;
                mdVar2.b |= 2;
                mdVar2.d = i10;
                int i11 = pVar.g.a.f677n;
                if (!mcVar.b.H()) {
                    mcVar.v();
                }
                md mdVar3 = (md) mcVar.b;
                mdVar3.b |= 4;
                mdVar3.e = i11;
                if (!mbVar.b.H()) {
                    mbVar.v();
                }
                me meVar4 = (me) mbVar.b;
                md mdVar4 = (md) mcVar.t();
                mdVar4.getClass();
                meVar4.g = mdVar4;
                meVar4.b |= 16;
                me meVar5 = (me) mbVar.t();
                ls lsVar = (ls) lt.a.q();
                long jA2 = pVar.g.a();
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                lt ltVar = (lt) lsVar.b;
                ltVar.b |= 2;
                ltVar.d = jA2;
                ad adVar2 = pVar.g;
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                long j2 = adVar2.b;
                lt ltVar2 = (lt) lsVar.b;
                ltVar2.b |= 4;
                ltVar2.e = j2;
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                lt ltVar3 = (lt) lsVar.b;
                ltVar3.b |= 128;
                ltVar3.i = andIncrement;
                ma maVar = (ma) mh.a.q();
                if (!maVar.b.H()) {
                    maVar.v();
                }
                mh mhVar = (mh) maVar.b;
                mgVar9.getClass();
                mhVar.c = mgVar9;
                mhVar.b |= 1;
                if (!maVar.b.H()) {
                    maVar.v();
                }
                mh mhVar2 = (mh) maVar.b;
                meVar5.getClass();
                mhVar2.d = meVar5;
                mhVar2.b |= 2;
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                lt ltVar4 = (lt) lsVar.b;
                mh mhVar3 = (mh) maVar.t();
                mhVar3.getClass();
                ltVar4.c = mhVar3;
                ltVar4.b |= 1;
                com.google.android.libraries.navigation.internal.ti.e eVar2 = pVar.i;
                if (!eVar2.c()) {
                    iMax = eVar2.a.d;
                } else if (!eVar2.j) {
                    iMax = z ? eVar2.a.d : Math.max(eVar2.a.d - eVar2.i, 0);
                }
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                lt ltVar5 = (lt) lsVar.b;
                ltVar5.b |= 32;
                ltVar5.g = iMax;
                ad adVar3 = pVar.g;
                if (!lsVar.b.H()) {
                    lsVar.v();
                }
                int i12 = adVar3.e;
                lt ltVar6 = (lt) lsVar.b;
                ltVar6.b |= 64;
                ltVar6.h = i12;
                ad adVar4 = pVar.g;
                String str = adVar4.i ? adVar4.c : null;
                if (str != null) {
                    if (!lsVar.b.H()) {
                        lsVar.v();
                    }
                    lt ltVar7 = (lt) lsVar.b;
                    ltVar7.b |= 8;
                    ltVar7.f = str;
                }
                return (lt) lsVar.t();
            }
        }
        return null;
    }

    public final void d(boolean z) {
        ap.NAVIGATION_INTERNAL.f();
        this.g++;
        hashCode();
        ap.NAVIGATION_INTERNAL.f();
        if (this.e != null) {
            com.google.android.libraries.navigation.internal.nt.m mVarC = this.i.c();
            h hVar = this.e;
            ar.q(hVar);
            mVarC.h(hVar);
            this.e = null;
        }
        if (this.f != null) {
            com.google.android.libraries.navigation.internal.nt.a aVarA = this.j.a();
            g gVar = this.f;
            ar.q(gVar);
            aVarA.c(gVar);
            this.f = null;
        }
        g(z);
        e();
    }

    public final void e() {
        ap.NAVIGATION_INTERNAL.f();
        this.d = null;
    }

    public final void f(i iVar) {
        ap.NAVIGATION_INTERNAL.f();
        int iA = fa.a(iVar.b.z);
        if (iA == 0) {
            iA = fa.a;
        }
        com.google.android.libraries.navigation.internal.kk.k kVar = (com.google.android.libraries.navigation.internal.kk.k) this.t.a(ag.a);
        al alVarB = al.b(iVar.b.A);
        if (alVarB == null) {
            alVarB = al.DRIVE;
        }
        kVar.a(alVarB.k);
        ((com.google.android.libraries.navigation.internal.kk.j) this.t.a(ag.c)).a();
        ((com.google.android.libraries.navigation.internal.kk.j) this.t.a(iA == fa.b ? ag.d : ag.e)).a();
        hashCode();
        ar.k(this.d == null);
        Context context = this.a;
        com.google.android.libraries.navigation.internal.fr.l lVar = this.k;
        com.google.android.libraries.navigation.internal.sl.l lVar2 = this.l;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.m;
        com.google.android.libraries.navigation.internal.gq.ab abVar = this.u;
        com.google.android.libraries.navigation.internal.rw.q qVar = this.r;
        com.google.android.libraries.navigation.internal.sj.a aVar = this.C;
        bn bnVar = this.c;
        com.google.android.libraries.navigation.internal.ia.e eVar = this.o;
        com.google.android.libraries.navigation.internal.mj.a aVar2 = this.f588n;
        bn bnVar2 = this.s;
        com.google.android.libraries.navigation.internal.kl.b bVar = this.t;
        com.google.android.libraries.navigation.internal.di.b bVar2 = this.p;
        bVar2.c();
        bVar2.a();
        com.google.android.libraries.navigation.internal.cw.a aVar3 = this.v;
        com.google.android.libraries.navigation.internal.aq.m mVar = this.w;
        com.google.android.libraries.navigation.internal.au.c cVar = this.h;
        com.google.android.libraries.navigation.internal.fz.d dVar = this.b;
        com.google.android.libraries.navigation.internal.hn.p pVarB = dVar.b();
        dVar.y();
        boolean zY = this.m.y(com.google.android.libraries.navigation.internal.iv.ab.S, false);
        fb fbVar = iVar.b;
        String str = (String) com.google.android.libraries.navigation.internal.jb.b.a.i(com.google.android.libraries.navigation.internal.je.a.b(this.a)).get(0);
        String str2 = this.q;
        String str3 = iVar.c;
        String str4 = iVar.d;
        Long l = iVar.e;
        com.google.android.libraries.navigation.internal.mj.a aVar4 = this.f588n;
        String strB = com.google.android.libraries.navigation.internal.jb.b.b();
        long epochMilli = aVar4.f().toEpochMilli();
        com.google.android.libraries.navigation.internal.mj.a aVar5 = this.f588n;
        Context context2 = this.a;
        com.google.android.libraries.navigation.internal.fu.a aVar6 = this.A;
        long jA = aVar5.a();
        int iB = com.google.android.libraries.navigation.internal.fr.n.b(context2);
        int iA2 = aVar6.a();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        long jLongValue = l != null ? l.longValue() : secureRandom.nextLong();
        int i = fbVar.k;
        int i2 = fbVar.j;
        int i3 = (i - i2) + 1;
        this.d = new com.google.android.libraries.navigation.internal.ti.p(context, lVar, lVar2, fVar, abVar, qVar, aVar, bnVar, eVar, aVar2, bnVar2, bVar, aVar3, mVar, cVar, pVarB, new ad(fbVar, jNextLong, jLongValue, str4, i2 + secureRandom.nextInt(i3), fbVar.j + secureRandom.nextInt(i3), str, strB, str2, str3, true, epochMilli, jA, zY, iB, iA2), this.b, this.x, this.y, this.D, this.B);
    }

    public final void g(boolean z) {
        ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.ti.p pVar = this.d;
        if (pVar == null) {
            return;
        }
        if (pVar.f()) {
            this.d.d(z, new Runnable() { // from class: com.google.android.libraries.navigation.internal.tc.f
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
        this.d.g.i = false;
    }

    public static String c(String str) {
        return "";
    }
}

package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.ac;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.agh.gs;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.bp.ae;
import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.sk.eo;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.zr.am;
import com.google.android.libraries.navigation.internal.zr.bw;
import com.google.android.libraries.navigation.internal.zr.cj;
import com.google.android.libraries.navigation.internal.zr.co;
import com.google.android.libraries.navigation.internal.zr.cp;
import com.google.android.libraries.navigation.internal.zr.cr;
import com.google.android.libraries.navigation.internal.zr.cs;
import com.google.android.libraries.navigation.internal.zr.cu;
import com.google.android.libraries.navigation.internal.zr.cv;
import com.google.android.libraries.navigation.internal.zr.cw;
import com.google.android.libraries.navigation.internal.zr.cx;
import com.google.android.libraries.navigation.internal.zr.dd;
import com.google.android.libraries.navigation.internal.zr.de;
import com.google.android.libraries.navigation.internal.zr.dp;
import com.google.android.libraries.navigation.internal.zr.dq;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.google.android.libraries.navigation.internal.sp.b {
    public static final long a = TimeUnit.SECONDS.toMillis(30);
    private long A;
    private Long B;
    private final eo F;
    public u b;
    public aa c;
    public d d;
    public r e;
    public String f;
    public double g;
    public double h;
    public long i;
    public double j;
    public boolean k;
    public com.google.android.libraries.navigation.internal.db.r l;
    public int p;
    private final com.google.android.libraries.navigation.internal.ia.e q;
    private final com.google.android.libraries.navigation.internal.rw.q r;
    private final com.google.android.libraries.navigation.internal.rw.f s;
    private final Executor t;
    private final com.google.android.libraries.navigation.internal.mj.a u;
    private final af v;
    private final com.google.android.libraries.navigation.internal.iv.f w;
    private final com.google.android.libraries.navigation.internal.th.a x;
    private final Set y;
    private final com.google.android.libraries.navigation.internal.th.c z;
    private final List C = new ArrayList();
    public boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f590n = false;
    public volatile boolean o = false;
    private final m D = new m(this);
    private final l E = new l(this);

    public n(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.th.c cVar, af afVar, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.th.a aVar2, Set set, eo eoVar) {
        this.q = eVar;
        this.r = qVar;
        this.s = fVar;
        this.t = executor;
        this.u = aVar;
        this.v = afVar;
        this.w = fVar2;
        this.z = cVar;
        this.x = aVar2;
        this.y = set;
        this.F = eoVar;
    }

    private final int f() {
        return (int) ((this.u.a() - this.A) / 1000);
    }

    private final int g() {
        return com.google.android.libraries.navigation.internal.zw.b.b(Math.max(0.0d, this.j), RoundingMode.HALF_UP);
    }

    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void a(com.google.android.libraries.navigation.internal.sp.c cVar) {
        this.p = 0;
        this.b = new u();
        this.c = new aa();
        this.d = new d();
        this.z.p();
        this.e = new r();
        this.f = null;
        this.A = this.u.a();
        this.x.a();
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = this.u.a();
        this.j = 0.0d;
        this.k = this.w.y(com.google.android.libraries.navigation.internal.iv.ab.ab, false);
        this.B = null;
        this.C.clear();
        this.m = false;
        this.f590n = false;
        this.o = false;
        Iterator it2 = this.y.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.sp.d) it2.next()).c();
        }
        if (this.F.e()) {
            this.z.r(this.F.a());
        } else {
            this.z.r(null);
        }
        com.google.android.libraries.navigation.internal.ia.e eVar = this.q;
        fd fdVarK = fd.k(ap.UI_THREAD, this.t);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.uf.a.class, new p(0, com.google.android.libraries.navigation.internal.uf.a.class, this, ap.UI_THREAD, p.b(ap.UI_THREAD, fdVarK)));
        ap apVar = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.tf.f.class, new p(1, com.google.android.libraries.navigation.internal.tf.f.class, this, apVar, p.b(apVar, fdVarK)));
        ap apVar2 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.sq.a.class, new p(2, com.google.android.libraries.navigation.internal.sq.a.class, this, apVar2, p.b(apVar2, fdVarK)));
        ap apVar3 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.dh.a.class, new p(3, com.google.android.libraries.navigation.internal.dh.a.class, this, apVar3, p.b(apVar3, fdVarK)));
        ap apVar4 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new p(4, com.google.android.libraries.navigation.internal.db.s.class, this, apVar4, p.b(apVar4, fdVarK)));
        ap apVar5 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.tf.b.class, new p(5, com.google.android.libraries.navigation.internal.tf.b.class, this, apVar5, p.b(apVar5, fdVarK)));
        ap apVar6 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.tf.a.class, new p(6, com.google.android.libraries.navigation.internal.tf.a.class, this, apVar6, p.b(apVar6, fdVarK)));
        ap apVar7 = ap.UI_THREAD;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.g.class, new p(7, com.google.android.libraries.navigation.internal.sr.g.class, this, apVar7, p.b(apVar7, fdVarK)));
        ap apVar8 = ap.CURRENT;
        fzVar.b(com.google.android.libraries.navigation.internal.sm.f.class, new p(8, com.google.android.libraries.navigation.internal.sm.f.class, this, apVar8, p.b(apVar8, fdVarK)));
        eVar.c(this, fzVar.a());
        this.r.a(this.D, this.t);
        this.s.c(this.E, this.t);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01cc  */
    @Override // com.google.android.libraries.navigation.internal.sp.b
    public final void b(boolean z) {
        int i;
        this.r.b(this.D);
        this.s.d(this.E);
        this.q.e(this);
        cj cjVar = (cj) de.a.q();
        int i2 = this.p;
        if (i2 != 0 && i2 != cr.a) {
            int i3 = this.p;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar = (de) cjVar.b;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            deVar.e = i4;
            deVar.b |= 1;
        }
        int iF = f();
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar2 = (de) cjVar.b;
        deVar2.b |= 2048;
        deVar2.o = iF;
        int iG = g();
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar3 = (de) cjVar.b;
        deVar3.b |= 4096;
        deVar3.p = iG;
        int iC = c();
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar4 = (de) cjVar.b;
        deVar4.b |= 8192;
        deVar4.q = iC;
        boolean z2 = this.f590n;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar5 = (de) cjVar.b;
        deVar5.b |= 1073741824;
        deVar5.A = z2;
        boolean z3 = this.m;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar6 = (de) cjVar.b;
        deVar6.b |= 524288;
        deVar6.u = z3;
        boolean z4 = this.k;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar7 = (de) cjVar.b;
        deVar7.b |= 16777216;
        deVar7.x = z4;
        int i5 = com.google.android.libraries.navigation.internal.ue.a.a(this.w).d;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar8 = (de) cjVar.b;
        int i6 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        deVar8.y = i6;
        deVar8.b |= 33554432;
        boolean zY = this.w.y(com.google.android.libraries.navigation.internal.iv.ab.aL, true);
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar9 = (de) cjVar.b;
        deVar9.c |= 2;
        deVar9.B = zY;
        boolean z5 = this.o;
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar10 = (de) cjVar.b;
        deVar10.d |= 32768;
        deVar10.aj = z5;
        if (!this.C.isEmpty()) {
            List list = this.C;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar11 = (de) cjVar.b;
            bz bzVar = deVar11.ai;
            if (!bzVar.c()) {
                deVar11.ai = bi.A(bzVar);
            }
            com.google.android.libraries.navigation.internal.ael.b.m(list, deVar11.ai);
        }
        String strI = this.w.i(com.google.android.libraries.navigation.internal.iv.ab.aH, "");
        if (!strI.isEmpty()) {
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar12 = (de) cjVar.b;
            strI.getClass();
            deVar12.d |= 512;
            deVar12.ag = strI;
        }
        if (this.w.y(com.google.android.libraries.navigation.internal.iv.ab.U, false)) {
            i = bw.a;
        } else {
            com.google.android.libraries.navigation.internal.sl.m mVarA = com.google.android.libraries.navigation.internal.sl.m.a(this.w.a(com.google.android.libraries.navigation.internal.iv.ab.V, com.google.android.libraries.navigation.internal.sl.m.UNMUTED.d));
            if (mVarA == null) {
                i = 0;
            } else {
                int iOrdinal = mVarA.ordinal();
                if (iOrdinal == 0) {
                    i = bw.c;
                } else if (iOrdinal == 1) {
                    i = bw.b;
                } else if (iOrdinal != 2) {
                    i = 0;
                } else {
                    i = bw.a;
                }
            }
        }
        if (i != 0) {
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar13 = (de) cjVar.b;
            deVar13.z = i - 1;
            deVar13.b |= 134217728;
        }
        boolean zY2 = this.w.y(com.google.android.libraries.navigation.internal.iv.ab.cb, false);
        if (!cjVar.b.H()) {
            cjVar.v();
        }
        de deVar14 = (de) cjVar.b;
        deVar14.d |= 16384;
        deVar14.ah = zY2;
        u uVar = this.b;
        if (uVar != null && !uVar.c.isEmpty()) {
            s sVarB = uVar.b();
            t tVar = uVar.b;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            cw cwVar = tVar.a;
            de deVar15 = (de) cjVar.b;
            cx cxVar = (cx) cwVar.t();
            cxVar.getClass();
            deVar15.af = cxVar;
            deVar15.d |= 16;
            al alVar = sVarB.b;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar16 = (de) cjVar.b;
            deVar16.f = alVar.k;
            deVar16.b |= 2;
            int i7 = sVarB.g;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar17 = (de) cjVar.b;
            deVar17.b |= 256;
            deVar17.m = i7;
            int i8 = sVarB.i;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar18 = (de) cjVar.b;
            deVar18.b |= 4;
            deVar18.g = i8;
            if (sVarB.f) {
                int i9 = sVarB.h;
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar19 = (de) cjVar.b;
                deVar19.b |= 8;
                deVar19.h = i9;
            }
            int i10 = sVarB.j;
            if (i10 > 0) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar20 = (de) cjVar.b;
                deVar20.b |= 16;
                deVar20.i = i10;
            }
            int i11 = sVarB.k;
            if (i11 > 0) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar21 = (de) cjVar.b;
                deVar21.b |= 32;
                deVar21.j = i11;
            }
            int i12 = sVarB.l;
            if (i12 > 0) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar22 = (de) cjVar.b;
                deVar22.b |= 64;
                deVar22.k = i12;
            }
            for (cu cuVar : uVar.d) {
                cs csVar = (cs) cv.a.q();
                if (!csVar.b.H()) {
                    csVar.v();
                }
                cv cvVar = (cv) csVar.b;
                cvVar.c = cuVar.d;
                cvVar.b |= 1;
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar23 = (de) cjVar.b;
                cv cvVar2 = (cv) csVar.t();
                cvVar2.getClass();
                bz bzVar2 = deVar23.s;
                if (!bzVar2.c()) {
                    deVar23.s = bi.A(bzVar2);
                }
                deVar23.s.add(cvVar2);
            }
            com.google.android.libraries.navigation.internal.oe.x xVar = sVarB.d;
            if (uVar.e != null && uVar.f != null) {
                int iA = uVar.a(sVarB);
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar24 = (de) cjVar.b;
                deVar24.b |= 1048576;
                deVar24.v = iA;
            }
            ck[] ckVarArr = sVarB.c;
            if (ckVarArr != null) {
                int length = ckVarArr.length - 1;
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar25 = (de) cjVar.b;
                deVar25.b |= 512;
                deVar25.f670n = length;
            }
            dq dqVar = sVarB.m;
            if (dqVar != null) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar26 = (de) cjVar.b;
                deVar26.l = dqVar;
                deVar26.b |= 128;
            }
        }
        aa aaVar = this.c;
        if (aaVar != null) {
            for (dd ddVar : aaVar.f) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar27 = (de) cjVar.b;
                ddVar.getClass();
                bz bzVar3 = deVar27.w;
                if (!bzVar3.c()) {
                    deVar27.w = bi.A(bzVar3);
                }
                deVar27.w.add(ddVar);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            int iB = dVar.b();
            if (iB != 0) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar28 = (de) cjVar.b;
                deVar28.C = iB - 1;
                deVar28.c |= 4;
            }
            am amVarA = dVar.b.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar29 = (de) cjVar.b;
            amVarA.getClass();
            deVar29.D = amVarA;
            deVar29.c |= 8;
            am amVarA2 = dVar.c.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar30 = (de) cjVar.b;
            amVarA2.getClass();
            deVar30.E = amVarA2;
            deVar30.c |= 16;
            am amVarA3 = dVar.d.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar31 = (de) cjVar.b;
            amVarA3.getClass();
            deVar31.F = amVarA3;
            deVar31.c |= 32;
            int i13 = (int) dVar.e;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar32 = (de) cjVar.b;
            deVar32.b |= 262144;
            deVar32.t = i13;
        }
        this.z.a(cjVar);
        r rVar = this.e;
        if (rVar != null) {
            com.google.android.libraries.navigation.internal.zr.d dVar2 = rVar.d;
            q qVar = rVar.b;
            am amVarA4 = qVar.a.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar33 = (de) cjVar.b;
            amVarA4.getClass();
            deVar33.G = amVarA4;
            deVar33.c |= 64;
            am amVarA5 = qVar.b.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar34 = (de) cjVar.b;
            amVarA5.getClass();
            deVar34.H = amVarA5;
            deVar34.c |= 128;
            am amVarA6 = qVar.c.a();
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar35 = (de) cjVar.b;
            amVarA6.getClass();
            deVar35.I = amVarA6;
            deVar35.c |= 256;
            int i14 = qVar.d;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar36 = (de) cjVar.b;
            deVar36.c |= 512;
            deVar36.J = i14;
            int i15 = qVar.e;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar37 = (de) cjVar.b;
            deVar37.c |= 1024;
            deVar37.K = i15;
            int i16 = qVar.f;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar38 = (de) cjVar.b;
            deVar38.c |= 16384;
            deVar38.O = i16;
            int i17 = qVar.h;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar39 = (de) cjVar.b;
            deVar39.c |= 2048;
            deVar39.L = i17;
            int i18 = qVar.i;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar40 = (de) cjVar.b;
            deVar40.c |= 8192;
            deVar40.N = i18;
            int i19 = qVar.g;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar41 = (de) cjVar.b;
            deVar41.c |= 4096;
            deVar41.M = i19;
            int i20 = qVar.j;
            if (!cjVar.b.H()) {
                cjVar.v();
            }
            de deVar42 = (de) cjVar.b;
            deVar42.b |= 16384;
            deVar42.r = i20;
            if (dVar2 != null) {
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar43 = (de) cjVar.b;
                deVar43.P = dVar2;
                deVar43.c |= 32768;
            }
            gs gsVarListIterator = rVar.a.keySet().listIterator();
            while (gsVarListIterator.hasNext()) {
                long jLongValue = gsVarListIterator.next().longValue();
                q qVar2 = (q) rVar.a.aO(jLongValue);
                co coVar = (co) cp.a.q();
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar = (cp) coVar.b;
                cpVar.b |= 1;
                cpVar.c = jLongValue;
                am amVarA7 = qVar2.a.a();
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar2 = (cp) coVar.b;
                amVarA7.getClass();
                cpVar2.g = amVarA7;
                cpVar2.b |= 16;
                am amVarA8 = qVar2.b.a();
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar3 = (cp) coVar.b;
                amVarA8.getClass();
                cpVar3.k = amVarA8;
                cpVar3.b |= 256;
                am amVarA9 = qVar2.c.a();
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar4 = (cp) coVar.b;
                amVarA9.getClass();
                cpVar4.h = amVarA9;
                cpVar4.b |= 32;
                int i21 = qVar2.d;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar5 = (cp) coVar.b;
                cpVar5.b |= 64;
                cpVar5.i = i21;
                int i22 = qVar2.e;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar6 = (cp) coVar.b;
                cpVar6.b |= 128;
                cpVar6.j = i22;
                int i23 = qVar2.f;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar7 = (cp) coVar.b;
                cpVar7.b |= 1024;
                cpVar7.m = i23;
                int i24 = qVar2.h;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar8 = (cp) coVar.b;
                cpVar8.b |= 512;
                cpVar8.l = i24;
                int i25 = qVar2.i;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar9 = (cp) coVar.b;
                cpVar9.b |= 8;
                cpVar9.f = i25;
                int i26 = qVar2.g;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar10 = (cp) coVar.b;
                cpVar10.b |= 4;
                cpVar10.e = i26;
                int i27 = qVar2.j;
                if (!coVar.b.H()) {
                    coVar.v();
                }
                cp cpVar11 = (cp) coVar.b;
                cpVar11.b |= 2;
                cpVar11.d = i27;
                cp cpVar12 = (cp) coVar.t();
                if (!cjVar.b.H()) {
                    cjVar.v();
                }
                de deVar44 = (de) cjVar.b;
                cpVar12.getClass();
                bz bzVar4 = deVar44.Q;
                if (!bzVar4.c()) {
                    deVar44.Q = bi.A(bzVar4);
                }
                deVar44.Q.add(cpVar12);
            }
        }
        Iterator it2 = this.y.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.sp.d) it2.next()).b();
        }
        de deVar45 = (de) cjVar.t();
        com.google.android.libraries.navigation.internal.db.r rVar2 = this.l;
        this.v.e(new com.google.android.libraries.navigation.internal.tf.e(deVar45, rVar2 != null ? rVar2.o() : null, this.u));
        Iterator it3 = this.y.iterator();
        while (it3.hasNext()) {
            ((com.google.android.libraries.navigation.internal.sp.d) it3.next()).a();
        }
    }

    public final int c() {
        return com.google.android.libraries.navigation.internal.hf.u.g(com.google.android.libraries.navigation.internal.zw.b.b(-this.h, RoundingMode.HALF_UP), false) == 1 ? com.google.android.libraries.navigation.internal.zw.b.b(this.g + this.h, RoundingMode.HALF_UP) : com.google.android.libraries.navigation.internal.zw.b.b(this.g, RoundingMode.HALF_UP);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x021e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0220  */
    /* JADX WARN: Code duplicated, block: B:57:0x0224  */
    /* JADX WARN: Code duplicated, block: B:59:0x022e  */
    /* JADX WARN: Code duplicated, block: B:61:0x023f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0249  */
    /* JADX WARN: Code duplicated, block: B:65:0x025b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0265  */
    public final void d(bg bgVar, com.google.android.libraries.navigation.internal.se.b bVar, com.google.android.libraries.navigation.internal.se.b bVar2) {
        t tVar;
        int iOrdinal;
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        u uVar = this.b;
        if (uVar != null) {
            long epochMilli = this.u.f().toEpochMilli();
            boolean z = epochMilli != 0;
            ar.k(z);
            if (uVar.c.isEmpty() || !u.c(hx.d(((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).c), bVar.b.B())) {
                if (uVar.c.isEmpty()) {
                    uVar.e = bVar.b.r(0).c;
                } else if (bVar2 != null) {
                    s sVar = (s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c);
                    boolean z2 = sVar.f;
                    ae aeVar = bVar2.l;
                    sVar.f = z2 && aeVar.d();
                    sVar.g -= bVar2.k;
                    sVar.h = (int) (((long) sVar.h) - aeVar.c().toSeconds());
                    sVar.i = (int) (((long) sVar.i) - ((com.google.android.libraries.navigation.internal.bp.k) aeVar).a.toSeconds());
                }
                bq bqVarQ = bVar.b.q();
                if (bqVarQ != null) {
                    bg bgVar2 = bVar.b;
                    uVar.c.add(new s(epochMilli, bgVar2.j, (ck[]) bgVar2.B().toArray(new ck[0]), bqVarQ.c));
                }
            } else {
                bg bgVar3 = bVar.b;
                ar.k(z);
                long j = epochMilli - ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).a;
                if (((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).e == bf.ONLINE || bgVar3.Q != bf.ONLINE || j >= u.a) {
                    bg bgVar4 = bVar.b;
                    if (uVar.c.size() == 1 && epochMilli - ((s) uVar.c.get(0)).a < u.a && u.c(hx.d(((s) uVar.c.get(0)).c), bgVar4.B())) {
                    }
                }
                tVar = uVar.b;
                iOrdinal = bVar.b.Q.ordinal();
                if (iOrdinal != 0) {
                    cwVar = tVar.a;
                    if (!cwVar.b.H()) {
                        cwVar.v();
                    }
                    cx cxVar = (cx) cwVar.b;
                    cx cxVar2 = cx.a;
                    cxVar.b |= 1;
                    cxVar.c = true;
                } else if (iOrdinal != 1) {
                    cwVar2 = tVar.a;
                    if (!cwVar2.b.H()) {
                        cwVar2.v();
                    }
                    cx cxVar3 = (cx) cwVar2.b;
                    cx cxVar4 = cx.a;
                    cxVar3.b |= 4;
                    cxVar3.e = true;
                } else if (iOrdinal == 2) {
                    cwVar3 = tVar.a;
                    if (!cwVar3.b.H()) {
                        cwVar3.v();
                    }
                    cx cxVar5 = (cx) cwVar3.b;
                    cx cxVar6 = cx.a;
                    cxVar5.b |= 2;
                    cxVar5.d = true;
                }
            }
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).e = bVar.b.Q;
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).g = bVar.k;
            ae aeVar2 = bVar.l;
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).f = aeVar2.d();
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).h = (int) aeVar2.c().toSeconds();
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).i = (int) ((com.google.android.libraries.navigation.internal.bp.k) aeVar2).a.toSeconds();
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).j = (int) bVar.b.K.toSeconds();
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).k = (int) bVar.b.L.toSeconds();
            ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).l = (int) bVar.b.N.toSeconds();
            com.google.android.libraries.navigation.internal.ael.x xVar = bVar.b.X;
            if (xVar != null) {
                dp dpVar = (dp) dq.a.q();
                ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).m = null;
                try {
                    try {
                        ac acVarK = xVar.k();
                        com.google.android.libraries.navigation.internal.ael.ar arVar = com.google.android.libraries.navigation.internal.ael.ar.a;
                        di diVar = di.a;
                        dpVar.o(acVarK, com.google.android.libraries.navigation.internal.ael.ar.a);
                        acVarK.z(0);
                        ((s) com.google.android.libraries.navigation.internal.yz.gs.d(uVar.c)).m = (dq) dpVar.t();
                    } catch (cc e) {
                        throw e;
                    } catch (IOException e2) {
                        throw new RuntimeException("Reading " + dpVar.getClass().getName() + " from a ByteString threw an IOException (should never happen).", e2);
                    }
                } catch (IOException unused) {
                    ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1720)).p("Could not convert a serializedRoadTrafficExperimentalData bytes into RoadTrafficLoggedExperimentalData");
                }
            }
            tVar = uVar.b;
            iOrdinal = bVar.b.Q.ordinal();
            if (iOrdinal != 0) {
                cwVar = tVar.a;
                if (!cwVar.b.H()) {
                    cwVar.v();
                }
                cx cxVar7 = (cx) cwVar.b;
                cx cxVar8 = cx.a;
                cxVar7.b |= 1;
                cxVar7.c = true;
            } else if (iOrdinal != 1) {
                cwVar2 = tVar.a;
                if (!cwVar2.b.H()) {
                    cwVar2.v();
                }
                cx cxVar9 = (cx) cwVar2.b;
                cx cxVar10 = cx.a;
                cxVar9.b |= 4;
                cxVar9.e = true;
            } else if (iOrdinal == 2) {
                cwVar3 = tVar.a;
                if (!cwVar3.b.H()) {
                    cwVar3.v();
                }
                cx cxVar11 = (cx) cwVar3.b;
                cx cxVar12 = cx.a;
                cxVar11.b |= 2;
                cxVar11.d = true;
            }
        }
        r rVar = this.e;
        if (rVar != null) {
            rVar.b.b(bgVar);
            gi giVarListIterator = rVar.a.values().listIterator();
            while (giVarListIterator.hasNext()) {
                ((q) giVarListIterator.next()).b(bgVar);
            }
        }
    }

    public final void e() {
    }

    public final String toString() {
        ak akVarE = com.google.android.libraries.navigation.internal.yx.al.b(this).c("DURATION_SECONDS", f()).c("SAVED_TIME", c()).c("WASTED_TIME", g()).e("REACHED_DESTINATION", this.m).e("HAS_BLUETOOTH_AUDIO_CONNECTION", this.f590n);
        akVarE.g("routeStats", this.b);
        akVarE.g("stepCompletionStats", this.c);
        akVarE.g("locationStats", this.d);
        akVarE.g("textToSpeechStats", this.z);
        akVarE.g("routeSnappingStats", this.e);
        return akVarE.toString();
    }
}

package com.google.android.libraries.navigation.internal.t;

import com.google.android.libraries.navigation.internal.aap.ag;
import com.google.android.libraries.navigation.internal.aap.x;
import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.ace.ca;
import com.google.android.libraries.navigation.internal.ace.cb;
import com.google.android.libraries.navigation.internal.ace.ff;
import com.google.android.libraries.navigation.internal.ace.fh;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.ace.fl;
import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.ael.bs;
import com.google.android.libraries.navigation.internal.afl.ea;
import com.google.android.libraries.navigation.internal.afl.ec;
import com.google.android.libraries.navigation.internal.afl.ey;
import com.google.android.libraries.navigation.internal.afl.fa;
import com.google.android.libraries.navigation.internal.afl.ig;
import com.google.android.libraries.navigation.internal.afl.jm;
import com.google.android.libraries.navigation.internal.afl.jw;
import com.google.android.libraries.navigation.internal.afl.no;
import com.google.android.libraries.navigation.internal.afl.og;
import com.google.android.libraries.navigation.internal.afl.pw;
import com.google.android.libraries.navigation.internal.afl.qa;
import com.google.android.libraries.navigation.internal.afl.qc;
import com.google.android.libraries.navigation.internal.afl.qj;
import com.google.android.libraries.navigation.internal.agg.fc;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.om.t;
import com.google.android.libraries.navigation.internal.om.v;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.cs;
import com.google.android.libraries.navigation.internal.yz.cu;
import com.google.android.libraries.navigation.internal.yz.lr;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements com.google.android.libraries.navigation.internal.om.p {
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a c;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a d;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a e;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a f;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a g;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a h;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a i;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a j;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a k;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a l;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a f587n;
    final /* synthetic */ com.google.android.libraries.navigation.internal.agl.a o;

    public r(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6, com.google.android.libraries.navigation.internal.agl.a aVar7, com.google.android.libraries.navigation.internal.agl.a aVar8, com.google.android.libraries.navigation.internal.agl.a aVar9, com.google.android.libraries.navigation.internal.agl.a aVar10, com.google.android.libraries.navigation.internal.agl.a aVar11, com.google.android.libraries.navigation.internal.agl.a aVar12, com.google.android.libraries.navigation.internal.agl.a aVar13, com.google.android.libraries.navigation.internal.agl.a aVar14, com.google.android.libraries.navigation.internal.agl.a aVar15) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
        this.j = aVar10;
        this.k = aVar11;
        this.l = aVar12;
        this.m = aVar13;
        this.f587n = aVar14;
        this.o = aVar15;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.j a() {
        boolean z;
        com.google.android.libraries.navigation.internal.hn.p pVar = (com.google.android.libraries.navigation.internal.hn.p) this.i.a();
        com.google.android.libraries.navigation.internal.om.a aVar = new com.google.android.libraries.navigation.internal.om.a();
        aVar.b(pVar.m());
        Iterator it2 = pVar.a.L.iterator();
        float fMax = 65.0f;
        while (it2.hasNext()) {
            fa faVar = ((ey) it2.next()).d;
            if (faVar == null) {
                faVar = fa.a;
            }
            fMax = Math.max(fMax, faVar.c);
        }
        jw jwVar = pVar.a.aV;
        if (jwVar == null) {
            jwVar = jw.a;
        }
        if (jwVar.c) {
            z = true;
        } else {
            jw jwVar2 = pVar.a.aV;
            if (jwVar2 == null) {
                jwVar2 = jw.a;
            }
            if (jwVar2.d) {
                z = true;
            } else {
                z = false;
            }
        }
        jw jwVar3 = pVar.a.aV;
        if (jwVar3 == null) {
            jwVar3 = jw.a;
        }
        for (ag agVar : jwVar3.b) {
            boolean zContains = new bs(agVar.e, ag.a).contains(com.google.android.libraries.navigation.internal.aap.b.LEGACY_CAMERA_SURFACE);
            boolean z2 = z && new bs(agVar.e, ag.a).contains(com.google.android.libraries.navigation.internal.aap.b.SHARED_CAMERA_SURFACE);
            if (zContains || z2) {
                x xVar = agVar.d;
                if (xVar == null) {
                    xVar = x.a;
                }
                fMax = Math.max(fMax, xVar.b);
            }
        }
        aVar.c(fMax);
        return aVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.l b() {
        an anVarJ;
        bk bkVar = (bk) this.a.a();
        ea eaVar = (ea) this.b.a();
        ec ecVar = (ec) this.c.a();
        fh fhVar = (fh) this.d.a();
        kx kxVar = (kx) this.e.a();
        qj qjVar = (qj) this.f.a();
        fj fjVar = (fj) this.g.a();
        fl flVar = (fl) this.h.a();
        com.google.android.libraries.navigation.internal.om.c cVar = new com.google.android.libraries.navigation.internal.om.c();
        if (qjVar.K) {
            Float fValueOf = Float.valueOf(qjVar.L);
            Float fValueOf2 = Float.valueOf(qjVar.M);
            lr lrVar = lr.a;
            anVarJ = an.j(new lr(new cu(fValueOf), new cs(fValueOf2)));
        } else {
            anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
        }
        cVar.e(anVarJ);
        cVar.i(fhVar.c);
        cVar.f(fhVar.q);
        cVar.k(ecVar.d);
        cVar.s(fhVar.f163n);
        cVar.m(fhVar.b);
        cVar.v(fhVar.k);
        cVar.n(fhVar.h);
        cVar.w(ecVar.e);
        cVar.G(qjVar.w);
        cVar.H(fhVar.d);
        cVar.D(fhVar.e);
        cVar.l(fhVar.f);
        ff ffVarB = ff.b(fhVar.i);
        if (ffVarB == null) {
            ffVarB = ff.UNKNOWN_BASEMAP_PHOTOS_ROUTE_OVERVIEW_STATUS;
        }
        cVar.d(ffVarB);
        cVar.J(ecVar.f);
        pw pwVar = qjVar.l;
        if (pwVar == null) {
            pwVar = pw.a;
        }
        cVar.Q(pwVar.c);
        cVar.R(bkVar.k);
        qc qcVar = qjVar.t;
        if (qcVar == null) {
            qcVar = qc.a;
        }
        cVar.L(qcVar.c);
        cVar.N(fjVar.h);
        cVar.M(qjVar.u);
        cVar.O(eaVar.q);
        cVar.u(qjVar.C);
        cVar.o(qjVar.D);
        cVar.r(qjVar.F);
        cVar.g(qjVar.H);
        cVar.P(kxVar.o);
        cVar.b(qjVar.I);
        boolean z = true;
        cVar.h(true);
        cVar.S();
        cVar.F();
        cVar.t(false);
        if (!fhVar.m && !fhVar.o) {
            z = false;
        }
        cVar.C(z);
        cVar.j(kxVar.q);
        cVar.T(kxVar.s);
        cVar.I(kxVar.r);
        cVar.c(eaVar.w);
        cVar.K(kxVar.w);
        cVar.A(fjVar.f);
        cVar.x(fjVar.d);
        cVar.y(fjVar.j);
        cVar.z(fjVar.i);
        cVar.p(fhVar.r);
        cVar.B(fjVar.e);
        cVar.q(kxVar.y);
        cVar.E(flVar.d);
        cVar.U(flVar.b);
        return cVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.n c() {
        ec ecVar = (ec) this.c.a();
        qj qjVar = (qj) this.f.a();
        cb cbVar = (cb) this.m.a();
        ea eaVar = (ea) this.b.a();
        fh fhVar = (fh) this.d.a();
        ig igVar = (ig) this.f587n.a();
        fj fjVar = (fj) this.g.a();
        fl flVar = (fl) this.h.a();
        com.google.android.libraries.navigation.internal.om.e eVar = new com.google.android.libraries.navigation.internal.om.e();
        eVar.l(igVar.b);
        eVar.d(ecVar.c);
        com.google.android.libraries.navigation.internal.agg.ey eyVar = new com.google.android.libraries.navigation.internal.agg.ey(ecVar.b);
        com.google.android.libraries.navigation.internal.agg.fa faVar = fd.a;
        eVar.c(new fc(eyVar));
        int iA = qa.a(qjVar.f);
        if (iA == 0) {
            iA = qa.a;
        }
        boolean z = iA == qa.a;
        if (iA == 0) {
            throw null;
        }
        eVar.r(z);
        eVar.q(qjVar.k);
        eVar.f(qjVar.g);
        eVar.k(qjVar.h);
        eVar.b(qjVar.r);
        eVar.v(qjVar.s);
        eVar.u(qjVar.v);
        ca caVar = cbVar.b;
        if (caVar == null) {
            caVar = ca.a;
        }
        eVar.n(caVar.b);
        eVar.m(qjVar.x);
        eVar.s(qjVar.y);
        eVar.j(eaVar.q);
        eVar.o(eaVar.r);
        eVar.t(qjVar.B);
        eVar.h(fhVar.g);
        eVar.p(qjVar.E);
        eVar.g(qjVar.G);
        eVar.i(fjVar.b);
        eVar.e(flVar.c);
        return eVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final v d() {
        return new v(new t());
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final com.google.android.libraries.navigation.internal.om.x e() {
        jm jmVar = (jm) this.j.a();
        no noVar = (no) this.k.a();
        og ogVar = (og) this.l.a();
        qj qjVar = (qj) this.f.a();
        kx kxVar = (kx) this.e.a();
        fl flVar = (fl) this.h.a();
        com.google.android.libraries.navigation.internal.om.g gVar = new com.google.android.libraries.navigation.internal.om.g();
        gVar.g(jmVar.b);
        gVar.i(jmVar.c);
        gVar.o(ogVar.b);
        gVar.j(qjVar.e);
        gVar.c(qjVar.m);
        gVar.n(noVar);
        gVar.k(qjVar.b);
        gVar.m(qjVar.c);
        gVar.p(qjVar.A);
        qc qcVar = qjVar.t;
        if (qcVar == null) {
            qcVar = qc.a;
        }
        gVar.d(qcVar.b);
        qc qcVar2 = qjVar.t;
        if (qcVar2 == null) {
            qcVar2 = qc.a;
        }
        gVar.b(qcVar2.d);
        gVar.e(((fh) this.d.a()).p);
        gVar.f(kxVar.u);
        gVar.h(kxVar.z);
        gVar.l(flVar.e);
        return gVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.om.p
    public final af f() {
        return (af) this.o.a();
    }
}

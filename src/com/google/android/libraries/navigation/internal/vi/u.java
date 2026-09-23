package com.google.android.libraries.navigation.internal.vi;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adu.w;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.sv.bk;
import com.google.android.libraries.navigation.internal.tj.ab;
import com.google.android.libraries.navigation.internal.tj.ae;
import com.google.android.libraries.navigation.internal.us.aa;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class u extends aa<ab> implements com.google.android.libraries.navigation.internal.vj.d {
    protected static final int C = w.f;
    protected static final int D = w.d;
    private static final long E = 5000;
    public long A;
    public final com.google.android.libraries.navigation.internal.so.a B;
    private final com.google.android.libraries.navigation.internal.iv.f F;
    private boolean G;
    private String H;
    private y I;
    private com.google.android.libraries.navigation.internal.vj.c J;
    private com.google.android.libraries.navigation.internal.vj.c K;
    private final com.google.android.libraries.navigation.internal.afo.a L;
    private final com.google.android.libraries.navigation.internal.qy.h M;
    private final com.google.android.libraries.navigation.internal.rw.q N;
    private final com.google.android.libraries.navigation.internal.rw.f O;
    private final com.google.android.libraries.navigation.internal.dx.i P;
    private final com.google.android.libraries.navigation.internal.dx.o Q;
    private final bk R;
    private final ae S;
    private final t T;
    private boolean U;
    protected final at y;
    public int z;

    protected u(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.sl.d dVar, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar, af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, at atVar, com.google.android.libraries.navigation.internal.so.a aVar2, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ch.b bVar, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.qy.h hVar2, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar2, com.google.android.libraries.navigation.internal.dx.i iVar, com.google.android.libraries.navigation.internal.dx.o oVar, bk bkVar, ae aeVar, Context context, ab abVar) {
        super(abVar, context, eVar, dVar2, dVar, hVar, context.getResources(), aVar, afVar, tVar, bnVar, executor, mVar, bVar);
        this.z = 0;
        this.A = 0L;
        this.I = y.UNKNOWN_INCIDENT_TYPE;
        this.T = new t(this);
        this.U = false;
        this.y = atVar;
        this.B = aVar2;
        this.F = fVar;
        this.L = aVar3;
        this.M = hVar2;
        this.N = qVar;
        this.O = fVar2;
        this.P = iVar;
        this.Q = oVar;
        this.R = bkVar;
        this.S = aeVar;
    }

    private final com.google.android.libraries.navigation.internal.jy.aa ah(com.google.android.libraries.navigation.internal.afd.a aVar, com.google.android.libraries.navigation.internal.tt.d dVar) {
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        x xVar = new x();
        xVar.i = aVar;
        com.google.android.libraries.navigation.internal.zq.i iVar = (com.google.android.libraries.navigation.internal.zq.i) com.google.android.libraries.navigation.internal.zq.l.a.q();
        int i = com.google.android.libraries.navigation.internal.zq.k.c;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.zq.l lVar = (com.google.android.libraries.navigation.internal.zq.l) iVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        lVar.c = i2;
        lVar.b |= 1;
        xVar.f((com.google.android.libraries.navigation.internal.zq.l) iVar.t());
        x xVarA = xVar.a(dVar.B());
        com.google.android.libraries.navigation.internal.zp.q qVar = (com.google.android.libraries.navigation.internal.zp.q) com.google.android.libraries.navigation.internal.zp.r.a.q();
        com.google.android.libraries.navigation.internal.zp.s sVar = (com.google.android.libraries.navigation.internal.zp.s) com.google.android.libraries.navigation.internal.zp.t.a.q();
        y yVar = this.I;
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.t tVar = (com.google.android.libraries.navigation.internal.zp.t) sVar.b;
        tVar.c = yVar.x;
        tVar.b |= 1;
        if (!qVar.b.H()) {
            qVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.r rVar = (com.google.android.libraries.navigation.internal.zp.r) qVar.b;
        com.google.android.libraries.navigation.internal.zp.t tVar2 = (com.google.android.libraries.navigation.internal.zp.t) sVar.t();
        tVar2.getClass();
        rVar.d = tVar2;
        rVar.c |= 8192;
        xVarA.g((com.google.android.libraries.navigation.internal.zp.r) qVar.t());
        return xVarA.b();
    }

    @Override // com.google.android.libraries.navigation.internal.vj.d
    public com.google.android.libraries.navigation.internal.vj.c Z() {
        return this.J;
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final com.google.android.libraries.navigation.internal.vn.d a() {
        ((ab) this.a).h();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.d
    public com.google.android.libraries.navigation.internal.vj.c aa() {
        return this.K;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.d
    public Boolean ab() {
        return Boolean.valueOf(this.G);
    }

    public Boolean ac() {
        return false;
    }

    public String ad() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ag(int i, long j, List list, boolean z) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        if (this.U) {
            return;
        }
        com.google.android.libraries.navigation.internal.afo.a aVar = this.L;
        Optional optionalEmpty = Optional.empty();
        com.google.android.libraries.navigation.internal.db.r rVarB = ((com.google.android.libraries.navigation.internal.cw.a) aVar.a()).b();
        if (rVarB != null) {
            optionalEmpty = Optional.of(Boolean.valueOf(rVarB.p));
        }
        Optional optional = optionalEmpty;
        if (this.B != null) {
            this.U = true;
            this.y.a(this);
            this.B.g(this.A, this.I, i, j, list, z, optional);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa, com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void b() {
        super.b();
        this.N.a(this.T, this.k);
        this.R.a(((ab) this.a).c).b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa, com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void c() {
        this.N.b(this.T);
        super.c();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    public void d() {
        ((ab) this.a).h();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.c f() {
        return com.google.android.libraries.navigation.internal.ut.d.c.VOTABLE_INCIDENT;
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa
    protected final void g() {
        com.google.android.libraries.navigation.internal.tt.d dVar = ((ab) this.a).c;
        Cdo cdoM = dVar.m();
        if (cdoM == null) {
            cdoM = Cdo.INCIDENT_OTHER;
        }
        y yVarA = com.google.android.libraries.navigation.internal.tt.e.a(cdoM);
        if (yVarA == null) {
            yVarA = y.UNKNOWN_INCIDENT_TYPE;
        }
        this.I = yVarA;
        ac().booleanValue();
        boolean z = dVar.n() != null;
        this.m = z ? dVar.q() : dVar.t();
        if (this.B != null) {
            long jB = dVar.b();
            this.A = jB;
            if (this.B.e(jB)) {
                this.f626n = null;
                R(this.P.l(this.g));
            } else {
                CharSequence charSequenceN = this.P.n(this.g, dVar);
                if (Objects.equals(dVar.m(), Cdo.INCIDENT_SPEED_LIMIT)) {
                    this.G = true;
                    this.f626n = dVar.t();
                    R(new CharSequence[0]);
                } else {
                    com.google.android.libraries.navigation.internal.dx.a aVar = this.P.c;
                    this.f626n = charSequenceN;
                    int iA = this.F.a(com.google.android.libraries.navigation.internal.iv.ab.bS, 0);
                    if (iA < 3) {
                        R(this.P.o(this.g));
                        this.F.q(com.google.android.libraries.navigation.internal.iv.ab.bS, iA + 1);
                    } else {
                        R(new CharSequence[0]);
                    }
                }
                final long jLongValue = ((Long) Optional.ofNullable(dVar.o()).orElse(0L)).longValue();
                final List listL = dVar.L();
                final boolean z2 = z;
                this.J = new o(this.y, this.b, ah(com.google.android.libraries.navigation.internal.afe.i.E, dVar), new p(this), com.google.android.libraries.navigation.internal.nc.j.c(this.P.k(this.g)), com.google.android.libraries.navigation.internal.dw.c.a, com.google.android.libraries.navigation.internal.dw.c.c, new com.google.android.libraries.navigation.internal.vj.c.a() { // from class: com.google.android.libraries.navigation.internal.vi.q
                    @Override // com.google.android.libraries.navigation.internal.vj.c.a
                    public final void a() {
                        this.a.ag(u.C, 1 + jLongValue, listL, z2);
                    }
                }, new r(this));
                this.K = new o(this.y, this.b, ah(com.google.android.libraries.navigation.internal.afe.i.F, dVar), new p(this), com.google.android.libraries.navigation.internal.nc.j.c(this.P.m(this.g)), com.google.android.libraries.navigation.internal.dw.c.b, com.google.android.libraries.navigation.internal.dw.c.d, new com.google.android.libraries.navigation.internal.vj.c.a() { // from class: com.google.android.libraries.navigation.internal.vi.s
                    @Override // com.google.android.libraries.navigation.internal.vj.c.a
                    public final void a() {
                        this.a.ag(u.D, jLongValue, listL, z2);
                    }
                }, new r(this));
            }
        }
        this.q = ah(com.google.android.libraries.navigation.internal.afe.i.H, dVar);
        com.google.android.libraries.navigation.internal.us.m mVarY = Y();
        mVarY.f = ah(com.google.android.libraries.navigation.internal.afe.i.G, dVar);
        K(mVarY.a());
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public CharSequence x() {
        com.google.android.libraries.navigation.internal.tt.d dVar = ((ab) this.a).c;
        String strAd = ad();
        if (strAd == null) {
            return super.x();
        }
        ac().booleanValue();
        return strAd;
    }
}

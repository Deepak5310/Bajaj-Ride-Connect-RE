package com.google.android.libraries.navigation.internal.vi;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ace.nv;
import com.google.android.libraries.navigation.internal.ace.nx;
import com.google.android.libraries.navigation.internal.ace.nz;
import com.google.android.libraries.navigation.internal.ace.oa;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.be;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.tj.x;
import com.google.android.libraries.navigation.internal.us.y;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l extends y<x> implements com.google.android.libraries.navigation.internal.vj.b {
    private static final long B = TimeUnit.SECONDS.toMillis(10);
    private static final long C = TimeUnit.SECONDS.toMillis(20);
    protected final int A;
    private final com.google.android.libraries.navigation.internal.iv.f D;
    private final com.google.android.libraries.navigation.internal.afo.a E;
    private final f.a F;
    private final com.google.android.libraries.navigation.internal.so.a G;
    private com.google.android.libraries.navigation.internal.us.f H;
    private com.google.android.libraries.navigation.internal.vj.a I;
    private final com.google.android.libraries.navigation.internal.dx.i J;
    private final com.google.android.libraries.navigation.internal.dx.o K;
    private boolean L;
    public final com.google.android.libraries.navigation.internal.dy.b x;
    public final at y;
    public final be z;

    public l(Context context, x xVar, com.google.android.libraries.navigation.internal.dy.b.a aVar, com.google.android.libraries.navigation.internal.afo.a<com.google.android.libraries.navigation.internal.vd.g> aVar2, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.sl.d dVar, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar3, af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, f.a aVar4, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.so.a aVar5, com.google.android.libraries.navigation.internal.ch.b bVar, com.google.android.libraries.navigation.internal.dx.o oVar, com.google.android.libraries.navigation.internal.dx.i iVar, at atVar, be beVar) {
        super(xVar, context, eVar, dVar2, dVar, hVar, context.getResources(), aVar3, afVar, tVar, bnVar, executor, xVar.a ? 3500L : B, bVar);
        this.L = false;
        this.D = fVar;
        this.E = aVar2;
        this.G = aVar5;
        this.F = aVar4;
        this.K = oVar;
        this.J = iVar;
        this.y = atVar;
        this.z = beVar;
        com.google.android.libraries.navigation.internal.dy.b bVarA = aVar.a(new k(this), false, iVar, context);
        this.x = bVarA;
        this.A = e(bVarA.d.size());
        this.m = bVarA.e;
        this.q = aa.k(com.google.android.libraries.navigation.internal.afe.i.h);
        int iA = fVar.a(ab.bT, 0);
        if (iA < 3) {
            this.f626n = this.g.getText(com.google.android.libraries.navigation.internal.dw.h.aY);
            fVar.q(ab.bT, iA + 1);
        }
        com.google.android.libraries.navigation.internal.us.m mVarY = Y();
        mVarY.f = aa.k(com.google.android.libraries.navigation.internal.afe.i.l);
        K(mVarY.a());
        if (xVar.a) {
            com.google.android.libraries.navigation.internal.us.f fVar2 = new com.google.android.libraries.navigation.internal.us.f(dVar2, com.google.android.libraries.navigation.internal.dw.h.Y, context.getString(com.google.android.libraries.navigation.internal.dw.h.Z), (ah) null, true, u().booleanValue());
            this.H = fVar2;
            fVar2.k(aa.k(com.google.android.libraries.navigation.internal.afe.i.r));
        }
    }

    public static /* synthetic */ boolean af(l lVar, View view, MotionEvent motionEvent) {
        lVar.U();
        lVar.T();
        return false;
    }

    protected static int e(int i) {
        return (int) Math.ceil(((double) i) / 2.0d);
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    public void L() {
        super.L();
        this.L = false;
        this.y.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public View.OnTouchListener Z() {
        return new View.OnTouchListener() { // from class: com.google.android.libraries.navigation.internal.vi.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                l.af(this.a, view, motionEvent);
                return false;
            }
        };
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public cs.a aa() {
        L();
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public com.google.android.libraries.navigation.internal.ut.b ab() {
        return this.H;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public com.google.android.libraries.navigation.internal.vj.a ac() {
        return this.I;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public List<com.google.android.libraries.navigation.internal.ut.c> ad() {
        return this.x.d;
    }

    public final void ae(oa oaVar) {
        Integer numValueOf;
        if (!this.d.x().h()) {
            if (!((com.google.android.libraries.navigation.internal.vd.g) this.E.a()).a()) {
                L();
                return;
            }
            com.google.android.libraries.navigation.internal.so.a aVar = this.G;
            com.google.android.libraries.navigation.internal.oe.x xVarH = ((x) this.a).h();
            nz nzVarB = nz.b(oaVar.c);
            if (nzVarB == null) {
                nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
            }
            com.google.android.libraries.navigation.internal.adu.y yVarJ = com.google.android.libraries.navigation.internal.dx.i.j(nzVarB);
            ar.q(yVarJ);
            aVar.d(xVarH, yVarJ, Float.valueOf(((x) this.a).g()), ((x) this.a).i(), ((x) this.a).k());
            com.google.android.libraries.navigation.internal.so.a aVar2 = this.G;
            com.google.android.libraries.navigation.internal.oe.x xVarH2 = ((x) this.a).h();
            nz nzVarB2 = nz.b(oaVar.c);
            if (nzVarB2 == null) {
                nzVarB2 = nz.UNKNOWN_USER_INCIDENT_TYPE;
            }
            com.google.android.libraries.navigation.internal.adu.y yVarJ2 = com.google.android.libraries.navigation.internal.dx.i.j(nzVarB2);
            ar.q(yVarJ2);
            aVar2.c(xVarH2, yVarJ2);
            L();
            return;
        }
        U();
        f.a aVar3 = this.F;
        nz nzVarB3 = nz.b(oaVar.c);
        if (nzVarB3 == null) {
            nzVarB3 = nz.UNKNOWN_USER_INCIDENT_TYPE;
        }
        com.google.android.libraries.navigation.internal.adu.y yVarJ3 = com.google.android.libraries.navigation.internal.dx.i.j(nzVarB3);
        ar.q(yVarJ3);
        com.google.android.libraries.navigation.internal.dx.i iVar = this.J;
        com.google.android.libraries.navigation.internal.vg.b bVarG = iVar.g(oaVar);
        nx nxVarB = nx.b(oaVar.g);
        if (nxVarB == null) {
            nxVarB = nx.UNKNOWN_SEVERITY;
        }
        com.google.android.libraries.navigation.internal.dx.c cVar = new com.google.android.libraries.navigation.internal.dx.c(iVar, bVarG, new com.google.android.libraries.navigation.internal.dx.l(nxVarB));
        com.google.android.libraries.navigation.internal.dx.i iVar2 = this.J;
        int iA = nv.a(oaVar.h);
        if (iA == 0) {
            iA = nv.a;
        }
        Integer numValueOf2 = null;
        if (iA == 0) {
            throw null;
        }
        switch (iA - 1) {
            case 1:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.az);
                break;
            case 2:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aC);
                break;
            case 3:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.bb);
                break;
            case 4:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aL);
                break;
            case 5:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aF);
                break;
            case 6:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aO);
                break;
            case 7:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aI);
                break;
            case 8:
                numValueOf = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aU);
                break;
            case 11:
            case 12:
                com.google.android.libraries.navigation.internal.dx.a aVar4 = iVar2.c;
            case 9:
            case 10:
            default:
                numValueOf = null;
                break;
        }
        ar.q(numValueOf);
        com.google.android.libraries.navigation.internal.nc.t tVarM = com.google.android.libraries.navigation.internal.nc.j.m(numValueOf.intValue());
        com.google.android.libraries.navigation.internal.dx.i iVar3 = this.J;
        int iA2 = nv.a(oaVar.h);
        if (iA2 == 0) {
            iA2 = nv.a;
        }
        int i = iA2 - 1;
        if (iA2 == 0) {
            throw null;
        }
        switch (i) {
            case 1:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.ay);
                break;
            case 2:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aB);
                break;
            case 3:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.ba);
                break;
            case 4:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aK);
                break;
            case 5:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aE);
                break;
            case 6:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aN);
                break;
            case 7:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aH);
                break;
            case 8:
                numValueOf2 = Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aT);
                break;
            case 11:
            case 12:
                com.google.android.libraries.navigation.internal.dx.a aVar5 = iVar3.c;
                break;
        }
        ar.q(numValueOf2);
        this.I = aVar3.a(this, yVarJ3, cVar, tVarM, com.google.android.libraries.navigation.internal.nc.j.m(numValueOf2.intValue()));
        this.L = false;
        this.y.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public boolean ag() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public boolean ah() {
        return this.L;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public boolean ai() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public void b() {
        super.b();
        com.google.android.libraries.navigation.internal.adu.y yVar = ((x) this.a).b;
        EnumSet enumSetJ = this.D.j(ab.bM, nz.class);
        ev evVarH = this.J.h();
        int size = evVarH.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            oa oaVar = (oa) evVarH.get(i);
            nz nzVarB = nz.b(oaVar.c);
            if (nzVarB == null) {
                nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
            }
            if (!enumSetJ.contains(nzVarB)) {
                nz nzVarB2 = nz.b(oaVar.c);
                if (nzVarB2 == null) {
                    nzVarB2 = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                enumSetJ.add(nzVarB2);
                z = true;
            }
        }
        if (z) {
            this.D.p(ab.bM, enumSetJ);
        }
        this.L = true;
        this.y.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public com.google.android.libraries.navigation.internal.ut.d.c f() {
        return com.google.android.libraries.navigation.internal.ut.d.c.REPORT_INCIDENT;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.b
    public int g() {
        return e(ad().size());
    }
}

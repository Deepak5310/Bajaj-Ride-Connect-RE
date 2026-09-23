package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.fs;
import com.google.android.libraries.navigation.internal.adr.ft;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.sv.bk;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ah extends aa<com.google.android.libraries.navigation.internal.tj.ab> {
    private static final long z = TimeUnit.SECONDS.toMillis(30);
    private final com.google.android.libraries.navigation.internal.qy.h A;
    private final com.google.android.libraries.navigation.internal.hf.c B;
    private final at C;
    private final com.google.android.libraries.navigation.internal.rw.q D;
    private final com.google.android.libraries.navigation.internal.dx.i E;
    private final bk F;
    private final com.google.android.libraries.navigation.internal.tj.ae G;
    private final ag H;
    public int y;

    public ah(Context context, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.sl.d dVar, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar, com.google.android.libraries.navigation.internal.qy.h hVar2, com.google.android.libraries.navigation.internal.hf.c cVar, at atVar, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.tj.ab abVar, com.google.android.libraries.navigation.internal.ch.b bVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.dx.i iVar, bk bkVar, com.google.android.libraries.navigation.internal.tj.ae aeVar) {
        super(abVar, context, eVar, dVar2, dVar, hVar, context.getResources(), aVar, afVar, tVar, bnVar, executor, mVar, z, bVar);
        this.H = new ag(this);
        this.A = hVar2;
        this.B = cVar;
        this.y = 0;
        this.C = atVar;
        this.D = qVar;
        this.E = iVar;
        this.F = bkVar;
        this.G = aeVar;
    }

    public static /* synthetic */ void Z(ah ahVar, com.google.android.libraries.navigation.internal.qz.k kVar) {
        ahVar.N(com.google.android.libraries.navigation.internal.jk.a.b(kVar));
        ahVar.aa();
    }

    private static com.google.android.libraries.navigation.internal.jy.aa ac(com.google.android.libraries.navigation.internal.afd.a aVar, com.google.android.libraries.navigation.internal.tt.d dVar) {
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
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
        return xVar.a(dVar.B()).b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final com.google.android.libraries.navigation.internal.vn.d a() {
        ((com.google.android.libraries.navigation.internal.tj.ab) this.a).h();
        return null;
    }

    public final void aa() {
        this.C.a(this);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    public final CharSequence[] ab(int i) {
        boolean z2;
        bm bmVar;
        int i2;
        ArrayList arrayList = new ArrayList();
        ((com.google.android.libraries.navigation.internal.tj.ab) this.a).c.x();
        com.google.android.libraries.navigation.internal.dx.a aVar = this.E.c;
        String strT = ((com.google.android.libraries.navigation.internal.tj.ab) this.a).c.t();
        bm bmVarK = ((com.google.android.libraries.navigation.internal.tj.ab) this.a).c.K();
        if (bmVarK != null) {
            if ((bmVarK.b & 1) == 0 || (i2 = bmVarK.c - i) <= 0) {
                bmVar = null;
            } else {
                com.google.android.libraries.navigation.internal.adr.bk bkVar = (com.google.android.libraries.navigation.internal.adr.bk) bm.a.q();
                bm.a aVarB = bm.a.b(bmVarK.d);
                if (aVarB == null) {
                    aVarB = bm.a.REGIONAL;
                }
                if (!bkVar.b.H()) {
                    bkVar.v();
                }
                bm bmVar2 = (bm) bkVar.b;
                bmVar2.d = aVarB.e;
                bmVar2.b |= 4;
                if (!bkVar.b.H()) {
                    bkVar.v();
                }
                bm bmVar3 = (bm) bkVar.b;
                bmVar3.b |= 1;
                bmVar3.c = i2;
                bmVar = (bm) bkVar.t();
            }
            if (bmVar != null) {
                String string = this.g.getString(com.google.android.libraries.navigation.internal.qr.e.b, this.B.h(bmVar));
                if (TextUtils.isEmpty(strT)) {
                    strT = string;
                } else {
                    strT = strT + "  •  " + string;
                }
            }
        }
        if (strT != null) {
            arrayList.add(strT);
        }
        ft ftVar = (ft) com.google.android.libraries.navigation.internal.hc.a.e(((com.google.android.libraries.navigation.internal.tj.ab) this.a).c.d(), (dg) ft.a.aH(7, null), ft.a);
        if (ftVar != null) {
            int iA = fs.a(ftVar.c);
            if (iA == 0) {
                iA = fs.a;
            }
            z2 = iA == fs.b;
        }
        Boolean.valueOf(z2).getClass();
        if (z2) {
            Resources resources = this.g;
            com.google.android.libraries.navigation.internal.hf.n nVar = new com.google.android.libraries.navigation.internal.hf.n(resources);
            Spannable spannableA = nVar.a(resources.getDrawable(com.google.android.libraries.navigation.internal.jl.a.d), 1.0f);
            com.google.android.libraries.navigation.internal.hf.l lVarE = nVar.e(com.google.android.libraries.navigation.internal.jl.b.b);
            com.google.android.libraries.navigation.internal.hf.m mVar = new com.google.android.libraries.navigation.internal.hf.m(spannableA);
            mVar.f(" ");
            mVar.e(lVarE);
            arrayList.add(mVar.b());
        }
        return (CharSequence[]) arrayList.toArray(new CharSequence[0]);
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa, com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void b() {
        super.b();
        this.D.a(this.H, this.k);
        this.F.a(((com.google.android.libraries.navigation.internal.tj.ab) this.a).c).b();
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa, com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public synchronized void c() {
        this.D.b(this.H);
        super.c();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    public void d() {
        ((com.google.android.libraries.navigation.internal.tj.ab) this.a).h();
    }

    @Override // com.google.android.libraries.navigation.internal.us.aa
    protected final void g() {
        com.google.android.libraries.navigation.internal.tj.ab abVar = (com.google.android.libraries.navigation.internal.tj.ab) this.a;
        if (abVar.d) {
            this.m = this.g.getText(com.google.android.libraries.navigation.internal.jl.b.f);
        } else {
            com.google.android.libraries.navigation.internal.tt.d dVar = abVar.c;
            String strV = dVar.v();
            if (strV != null) {
                N(com.google.android.libraries.navigation.internal.jk.a.c(com.google.android.libraries.navigation.internal.jk.a.d(strV), this.A, new com.google.android.libraries.navigation.internal.qz.g() { // from class: com.google.android.libraries.navigation.internal.us.af
                    @Override // com.google.android.libraries.navigation.internal.qz.g
                    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
                        ah.Z(this.a, kVar);
                    }
                }));
            }
            this.m = dVar.q();
            R(ab(this.y));
        }
        com.google.android.libraries.navigation.internal.tt.d dVar2 = abVar.c;
        this.q = ac(com.google.android.libraries.navigation.internal.afe.i.D, dVar2);
        m mVarY = Y();
        mVarY.f = ac(com.google.android.libraries.navigation.internal.afe.i.G, dVar2);
        K(mVarY.a());
    }
}

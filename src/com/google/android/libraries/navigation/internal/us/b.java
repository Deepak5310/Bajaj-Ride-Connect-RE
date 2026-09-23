package com.google.android.libraries.navigation.internal.us;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.adr.kp;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.cl.bd;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executor;
import kotlin.UByte$$ExternalSyntheticBackport0;
import okio.Utf8;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class b extends e<com.google.android.libraries.navigation.internal.tj.b> {
    private final boolean A;
    private final com.google.android.libraries.navigation.internal.ut.d.a x;
    private final Optional y;
    private final com.google.android.libraries.navigation.internal.aq.m z;

    public b(Context context, com.google.android.libraries.navigation.internal.tj.b bVar, com.google.android.libraries.navigation.internal.ut.d.a aVar, Optional<com.google.android.libraries.navigation.internal.uh.d> optional, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.sl.d dVar, com.google.android.libraries.navigation.internal.sn.h hVar, com.google.android.libraries.navigation.internal.mj.a aVar2, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.jy.af afVar, com.google.android.libraries.navigation.internal.jy.t tVar, com.google.android.libraries.navigation.internal.aq.m mVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.uq.m mVar2, com.google.android.libraries.navigation.internal.bn.d dVar3, com.google.android.libraries.navigation.internal.ch.b bVar2, com.google.android.libraries.navigation.internal.iv.f fVar) {
        super(bVar, context, eVar, dVar2, dVar, hVar, context.getResources(), aVar2, afVar, tVar, bnVar, executor, mVar2, bVar2);
        this.x = aVar;
        this.y = optional;
        this.z = mVar;
        boolean zY = fVar.y(com.google.android.libraries.navigation.internal.iv.ab.cj, false);
        this.A = zY;
        com.google.android.libraries.navigation.internal.ci.a aVarA = com.google.android.libraries.navigation.internal.cj.b.a(context);
        com.google.android.libraries.navigation.internal.br.o oVar = new com.google.android.libraries.navigation.internal.br.o();
        oVar.b = dVar3;
        oVar.g = aVarA;
        oVar.a = this.b;
        com.google.android.libraries.navigation.internal.br.p pVar = new com.google.android.libraries.navigation.internal.br.p(oVar);
        oVar.a();
        com.google.android.libraries.navigation.internal.br.p pVar2 = new com.google.android.libraries.navigation.internal.br.p(oVar);
        jg jgVar = ((com.google.android.libraries.navigation.internal.tj.b) this.a).b.e;
        jgVar = jgVar == null ? jg.a : jgVar;
        el elVar = jgVar.i;
        elVar = elVar == null ? el.a : elVar;
        this.m = pVar.a(elVar.f221n);
        CharSequence charSequenceA = pVar.a(elVar.p);
        R(charSequenceA);
        S(pVar2.a(elVar.p));
        TextUtils.isEmpty(pVar.a(elVar.q).toString());
        this.o = charSequenceA;
        ak.c(jgVar, dVar3, this);
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.b = jgVar.d;
        com.google.android.libraries.navigation.internal.jy.x xVarA = xVar.a(jgVar.c);
        xVarA.d = hv.DIRECTIONS;
        xVarA.i = com.google.android.libraries.navigation.internal.afe.i.N;
        this.q = xVarA.b();
        if (zY) {
            com.google.android.libraries.navigation.internal.ut.d.b bVarAa = aa(true);
            com.google.android.libraries.navigation.internal.ut.d.b bVarZ = Z(false, false);
            K(bVarAa);
            g(bVarZ);
            return;
        }
        int iA = kp.a(((com.google.android.libraries.navigation.internal.tj.b) this.a).b.d);
        iA = iA == 0 ? kp.a : iA;
        if (iA == 0) {
            throw null;
        }
        if (iA == 1) {
            com.google.android.libraries.navigation.internal.ut.d.b bVarAa2 = aa(true);
            com.google.android.libraries.navigation.internal.ut.d.b bVarZ2 = Z(false, false);
            K(bVarAa2);
            g(bVarZ2);
            return;
        }
        if (iA != 2) {
            if (iA != 3) {
                return;
            }
            g(Z(true, true));
        } else {
            com.google.android.libraries.navigation.internal.ut.d.b bVarAa3 = aa(false);
            com.google.android.libraries.navigation.internal.ut.d.b bVarZ3 = Z(true, false);
            K(bVarAa3);
            g(bVarZ3);
        }
    }

    private final com.google.android.libraries.navigation.internal.ut.d.b Z(boolean z, boolean z2) {
        m mVarM = m(z);
        mVarM.i = true;
        mVarM.c = com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.bh);
        mVarM.d = com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.bf);
        mVarM.e = com.google.android.libraries.navigation.internal.ut.d.b.a.ACCEPT;
        mVarM.l = new a(this, true);
        com.google.android.libraries.navigation.internal.jy.aa aaVarJ = j();
        if (z2) {
            com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
            com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
            xVar.b = aaVarJ.f;
            xVar.i = com.google.android.libraries.navigation.internal.afe.i.J;
            mVarM.f = xVar.b();
            com.google.android.libraries.navigation.internal.jy.x xVar2 = new com.google.android.libraries.navigation.internal.jy.x();
            xVar2.b = aaVarJ.f;
            xVar2.i = com.google.android.libraries.navigation.internal.afe.i.O;
            mVarM.g = xVar2.b();
        } else {
            com.google.android.libraries.navigation.internal.zb.j jVar2 = com.google.android.libraries.navigation.internal.jy.aa.a;
            com.google.android.libraries.navigation.internal.jy.x xVar3 = new com.google.android.libraries.navigation.internal.jy.x();
            xVar3.b = aaVarJ.f;
            xVar3.i = com.google.android.libraries.navigation.internal.afe.i.K;
            mVarM.f = xVar3.b();
            com.google.android.libraries.navigation.internal.jy.x xVar4 = new com.google.android.libraries.navigation.internal.jy.x();
            xVar4.b = aaVarJ.f;
            xVar4.i = com.google.android.libraries.navigation.internal.afe.i.P;
            mVarM.g = xVar4.b();
        }
        if (z) {
            mVarM.h = true;
        }
        return mVarM.a();
    }

    private final com.google.android.libraries.navigation.internal.ut.d.b aa(boolean z) {
        m mVarM = m(z);
        mVarM.c = com.google.android.libraries.navigation.internal.nc.j.m(com.google.android.libraries.navigation.internal.dw.h.bg);
        mVarM.e = com.google.android.libraries.navigation.internal.ut.d.b.a.DISMISS;
        mVarM.l = new a(this, false);
        com.google.android.libraries.navigation.internal.jy.aa aaVarJ = j();
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.b = aaVarJ.f;
        xVar.i = com.google.android.libraries.navigation.internal.afe.i.M;
        mVarM.f = xVar.b();
        com.google.android.libraries.navigation.internal.jy.x xVar2 = new com.google.android.libraries.navigation.internal.jy.x();
        xVar2.b = aaVarJ.f;
        xVar2.i = com.google.android.libraries.navigation.internal.afe.i.Q;
        mVarM.g = xVar2.b();
        return mVarM.a();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final com.google.android.libraries.navigation.internal.vn.d a() {
        String string;
        jg jgVar = ((com.google.android.libraries.navigation.internal.tj.b) this.a).b.e;
        if (jgVar == null) {
            jgVar = jg.a;
        }
        com.google.android.libraries.navigation.internal.ut.d.a aVar = this.x;
        com.google.android.libraries.navigation.internal.tj.u uVar = this.a;
        int iA = aVar.a();
        int iA2 = kp.a(((com.google.android.libraries.navigation.internal.tj.b) uVar).b.d);
        if (iA2 == 0) {
            iA2 = kp.a;
        }
        if (this.z.a().a()) {
            string = "";
        } else {
            if (iA2 == 0) {
                throw null;
            }
            if (iA2 != 1) {
                string = iA2 != 2 ? null : this.g.getString(com.google.android.libraries.navigation.internal.dw.h.bj, this.g.getString(com.google.android.libraries.navigation.internal.dw.h.bg));
            } else {
                string = this.g.getString(com.google.android.libraries.navigation.internal.dw.h.bi, this.g.getString(com.google.android.libraries.navigation.internal.dw.h.bh));
            }
        }
        return ak.b(jgVar, iA, string, this.f);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0081  */
    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public void b() {
        bd bdVar;
        bh bhVar;
        bd bdVar2;
        com.google.android.libraries.navigation.internal.bt.e eVar;
        super.b();
        if (UByte$$ExternalSyntheticBackport0.m(this.y)) {
            return;
        }
        com.google.android.libraries.navigation.internal.tj.b bVar = (com.google.android.libraries.navigation.internal.tj.b) this.a;
        bh bhVarI = bh.i(0, bVar.c, bVar.h());
        com.google.android.libraries.navigation.internal.ea.a aVar = new com.google.android.libraries.navigation.internal.ea.a();
        aVar.a(bd.SHOW_ALL);
        com.google.android.libraries.navigation.internal.bt.e eVar2 = com.google.android.libraries.navigation.internal.bt.e.FIRST_DESTINATION;
        Objects.requireNonNull(eVar2);
        aVar.c = eVar2;
        Optional optionalEmpty = Optional.empty();
        Objects.requireNonNull(optionalEmpty);
        aVar.d = optionalEmpty;
        Optional optionalEmpty2 = Optional.empty();
        Objects.requireNonNull(optionalEmpty2);
        aVar.g = optionalEmpty2;
        byte b = aVar.i;
        aVar.e = true;
        aVar.f = true;
        aVar.i = (byte) (b | Utf8.REPLACEMENT_BYTE);
        Optional optionalEmpty3 = Optional.empty();
        Objects.requireNonNull(optionalEmpty3);
        aVar.h = optionalEmpty3;
        Objects.requireNonNull(bhVarI);
        aVar.a = bhVarI;
        com.google.android.libraries.navigation.internal.ady.ad adVarB = com.google.android.libraries.navigation.internal.ady.ad.b(((com.google.android.libraries.navigation.internal.tj.b) this.a).b.c);
        if (adVarB == null) {
            adVarB = com.google.android.libraries.navigation.internal.ady.ad.REROUTE_TYPE_BETTER_ETA;
        }
        int iOrdinal = adVarB.ordinal();
        if (iOrdinal == 1) {
            bdVar = bd.SHOW_AS_NEW_CLOSED;
        } else if (iOrdinal == 2) {
            bdVar = bd.SHOW_AS_NEW_CURRENT;
        } else if (iOrdinal != 3) {
            bdVar = bd.SHOW_AS_CURRENT_FASTER;
        } else {
            bdVar = bd.SHOW_AS_NEW_CLOSED;
        }
        aVar.a(bdVar);
        if (aVar.i != 63 || (bhVar = aVar.a) == null || (bdVar2 = aVar.b) == null || (eVar = aVar.c) == null) {
            throw new IllegalStateException();
        }
        ((com.google.android.libraries.navigation.internal.uh.d) this.y.get()).d(new com.google.android.libraries.navigation.internal.ea.b(bhVar, bdVar2, eVar, aVar.d, aVar.e, aVar.f, aVar.g, aVar.h));
    }

    @Override // com.google.android.libraries.navigation.internal.us.y, com.google.android.libraries.navigation.internal.ut.d
    public void c() {
        if (!UByte$$ExternalSyntheticBackport0.m(this.y)) {
            ((com.google.android.libraries.navigation.internal.uh.d) this.y.get()).d(null);
        }
        super.c();
    }

    @Override // com.google.android.libraries.navigation.internal.us.y
    protected final void d() {
        com.google.android.libraries.navigation.internal.jy.r rVarD = this.j.d();
        com.google.android.libraries.navigation.internal.zb.j jVar = com.google.android.libraries.navigation.internal.jy.aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.b = j().f;
        xVar.d = hv.DIRECTIONS;
        xVar.i = com.google.android.libraries.navigation.internal.afe.i.b;
        rVarD.b(xVar.b());
    }
}

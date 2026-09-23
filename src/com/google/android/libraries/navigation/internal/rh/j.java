package com.google.android.libraries.navigation.internal.rh;

import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.eg;
import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements h {
    private final i a;
    private final com.google.android.libraries.navigation.internal.rl.p b;
    private final com.google.android.libraries.navigation.internal.rl.l c;

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void b() {
        com.google.android.libraries.navigation.internal.rl.p pVar = this.b;
        if (pVar != null) {
            pVar.close();
        }
        com.google.android.libraries.navigation.internal.rl.l lVar = this.c;
        if (lVar != null) {
            lVar.close();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void c() {
        this.a.a();
    }

    public j(o oVar, bg bgVar, com.google.android.libraries.navigation.internal.rl.s sVar) {
        ev evVar;
        byte[] bArr;
        this.b = sVar == null ? null : sVar.c();
        com.google.android.libraries.navigation.internal.rl.l lVarB = sVar == null ? null : sVar.b();
        this.c = lVarB;
        eh ehVar = bgVar.f;
        ehVar = ehVar == null ? eh.a : ehVar;
        jr jrVar = oVar.e;
        com.google.android.libraries.navigation.internal.pm.f fVar = (com.google.android.libraries.navigation.internal.pm.f) oVar.d.c();
        if (lVarB == null) {
            int i = ev.d;
            evVar = lv.a;
        } else {
            evVar = lVarB.a;
        }
        com.google.android.libraries.navigation.internal.or.c cVar = oVar.c;
        eg egVar = (eg) eh.a.q();
        for (ef efVar : ehVar.b) {
            bb bbVar = (bb) efVar.aH(5, null);
            bbVar.x(efVar);
            dy dyVar = (dy) bbVar;
            fs fsVar = efVar.u;
            fs fsVarF = o.f(fsVar == null ? fs.a : fsVar, cVar);
            if (!dyVar.b.H()) {
                dyVar.v();
            }
            ef efVar2 = (ef) dyVar.b;
            fsVarF.getClass();
            efVar2.u = fsVarF;
            efVar2.b |= 65536;
            egVar.d((ef) dyVar.t());
        }
        com.google.android.libraries.navigation.internal.px.n nVar = new com.google.android.libraries.navigation.internal.px.n();
        com.google.android.libraries.navigation.internal.adl.t tVar = (com.google.android.libraries.navigation.internal.adl.t) com.google.android.libraries.navigation.internal.adl.u.a.q();
        if (!tVar.b.H()) {
            tVar.v();
        }
        com.google.android.libraries.navigation.internal.adl.u uVar = (com.google.android.libraries.navigation.internal.adl.u) tVar.b;
        uVar.h = jrVar.f;
        uVar.b |= 64;
        tVar.c(evVar);
        com.google.android.libraries.navigation.internal.adl.u uVar2 = (com.google.android.libraries.navigation.internal.adl.u) tVar.t();
        Objects.requireNonNull(uVar2);
        nVar.a = uVar2;
        byte[] bArrM = ((eh) egVar.t()).m();
        Objects.requireNonNull(bArrM);
        nVar.b = bArrM;
        com.google.android.libraries.navigation.internal.adl.u uVar3 = nVar.a;
        if (uVar3 == null || (bArr = nVar.b) == null) {
            throw new IllegalStateException();
        }
        this.a = new i(new com.google.android.libraries.navigation.internal.px.o(uVar3, bArr, null), fVar);
    }
}

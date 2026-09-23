package com.google.android.libraries.navigation.internal.hq;

import com.google.android.libraries.navigation.internal.acd.mj;
import com.google.android.libraries.navigation.internal.acd.sn;
import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.ace.kx;
import com.google.android.libraries.navigation.internal.afl.ci;
import com.google.android.libraries.navigation.internal.afl.ea;
import com.google.android.libraries.navigation.internal.ho.ac;
import com.google.android.libraries.navigation.internal.ho.bg;
import com.google.android.libraries.navigation.internal.ho.ch;
import com.google.android.libraries.navigation.internal.ho.cq;
import com.google.android.libraries.navigation.internal.ho.v;
import com.google.android.libraries.navigation.internal.nk.r;
import com.google.android.libraries.navigation.internal.nk.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;

    public j(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        bk bkVarA = ((com.google.android.libraries.navigation.internal.ho.p) this.a).a();
        mj mjVarA = ((bg) this.b).a();
        ci ciVarA = ((v) this.c).a();
        ea eaVarA = ((ac) this.d).a();
        kx kxVarA = ((ch) this.e).a();
        sn snVarA = ((cq) this.f).a();
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("provideClientPlatformConfig");
        try {
            com.google.android.libraries.navigation.internal.nk.a aVar = (com.google.android.libraries.navigation.internal.nk.a) com.google.android.libraries.navigation.internal.nk.b.a.q();
            int i = i.a;
            com.google.android.libraries.navigation.internal.nk.d dVarA = i.a(bkVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            dVarA.getClass();
            bVar.h = dVarA;
            bVar.b |= 32;
            int i2 = o.a;
            r rVarA = o.a(mjVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar2 = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            rVarA.getClass();
            bVar2.c = rVarA;
            bVar2.b |= 1;
            int i3 = k.a;
            com.google.android.libraries.navigation.internal.nk.f fVarA = k.a(ciVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar3 = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            fVarA.getClass();
            bVar3.d = fVarA;
            bVar3.b |= 2;
            int i4 = l.c;
            com.google.android.libraries.navigation.internal.nk.p pVarA = l.a(eaVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar4 = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            pVarA.getClass();
            bVar4.e = pVarA;
            bVar4.b |= 4;
            int i5 = p.a;
            com.google.android.libraries.navigation.internal.nk.v vVarA = p.a(kxVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar5 = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            vVarA.getClass();
            bVar5.f = vVarA;
            bVar5.b |= 8;
            int i6 = q.a;
            x xVarA = q.a(snVarA);
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.nk.b bVar6 = (com.google.android.libraries.navigation.internal.nk.b) aVar.b;
            xVarA.getClass();
            bVar6.g = xVarA;
            bVar6.b |= 16;
            com.google.android.libraries.navigation.internal.nk.b bVar7 = (com.google.android.libraries.navigation.internal.nk.b) aVar.t();
            aVarA.close();
            com.google.android.libraries.navigation.internal.afr.j.d(bVar7);
            return bVar7;
        } catch (Throwable th) {
            try {
                aVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

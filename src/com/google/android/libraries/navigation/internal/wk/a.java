package com.google.android.libraries.navigation.internal.wk;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.add.av;
import com.google.android.libraries.navigation.internal.add.aw;
import com.google.android.libraries.navigation.internal.ade.p;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.kk.j;
import com.google.android.libraries.navigation.internal.kk.k;
import com.google.android.libraries.navigation.internal.kk.m;
import com.google.android.libraries.navigation.internal.kk.n;
import com.google.android.libraries.navigation.internal.km.ad;
import com.google.android.libraries.navigation.internal.km.ah;
import com.google.android.libraries.navigation.internal.km.ak;
import com.google.android.libraries.navigation.internal.km.x;
import com.google.android.libraries.navigation.internal.wl.d;
import com.google.android.libraries.navigation.internal.wn.e;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements c {
    private final com.google.android.libraries.navigation.internal.kl.b a;
    private final e b;
    private final com.google.android.libraries.navigation.internal.wm.a c;

    public a(com.google.android.libraries.navigation.internal.wm.a aVar, com.google.android.libraries.navigation.internal.kl.b bVar, e eVar) {
        this.c = aVar;
        this.a = bVar;
        this.b = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    @Override // com.google.android.libraries.navigation.internal.wk.c
    public final bj a(aw awVar) {
        com.google.android.libraries.navigation.internal.wl.b bVar;
        bj bjVarH;
        ez ezVar = new ez();
        if (this.c != null) {
            p pVar = awVar.c;
            if (pVar == null) {
                pVar = p.a;
            }
            com.google.android.libraries.navigation.internal.wm.a aVar = this.c;
            String str = pVar.b;
            com.google.android.libraries.navigation.internal.wl.c cVarA = aVar.a(str);
            if (cVarA == null) {
                bVar = null;
            } else {
                ezVar.f(str, cVarA);
                ArrayList arrayList = new ArrayList();
                for (p pVar2 : awVar.d) {
                    String str2 = pVar2.b;
                    com.google.android.libraries.navigation.internal.wl.c cVarA2 = this.c.a(str2);
                    if (cVarA2 != null) {
                        arrayList.add(pVar2);
                        ezVar.f(str2, cVarA2);
                    }
                }
                if (arrayList.size() != awVar.d.size()) {
                    av avVar = (av) aw.a.q();
                    if (!avVar.b.H()) {
                        avVar.v();
                    }
                    aw awVar2 = (aw) avVar.b;
                    pVar.getClass();
                    awVar2.c = pVar;
                    awVar2.b |= 1;
                    avVar.c(arrayList);
                    aw awVar3 = (aw) avVar.t();
                    fd fdVarD = ezVar.d();
                    d dVar = d.c;
                    bVar = new com.google.android.libraries.navigation.internal.wl.b(awVar3, fdVarD);
                } else {
                    fd fdVarD2 = ezVar.d();
                    d dVar2 = d.c;
                    bVar = new com.google.android.libraries.navigation.internal.wl.b(awVar, fdVarD2);
                }
            }
        } else {
            bVar = null;
        }
        if (bVar == null) {
            ((j) this.a.a(ak.q)).a();
            bjVarH = az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.NOT_FOUND, "No routes found for the provided RouteIdSet.", null)));
        } else {
            bjVarH = az.h(bVar);
        }
        final e eVar = this.b;
        final x xVar = ak.p;
        ad adVar = ak.r;
        final int andIncrement = eVar.a.getAndIncrement();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.beginAsyncSection("RoutesSdkImpl.getRoutesForGuidance", andIncrement);
        final m mVarA = ((n) eVar.b.a(adVar)).a();
        return com.google.android.libraries.navigation.internal.yu.a.b(bjVarH).c(new aa() { // from class: com.google.android.libraries.navigation.internal.wn.a
            public final /* synthetic */ String d = "RoutesSdkImpl.getRoutesForGuidance";

            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                mVarA.a();
                ((k) eVar.b.a(xVar)).a(ah.a(2));
                String[] strArr2 = com.google.android.libraries.navigation.internal.nw.e.a;
                Trace.endAsyncSection(this.d, andIncrement);
                return obj;
            }
        }, eVar.c).a(Exception.class, new t() { // from class: com.google.android.libraries.navigation.internal.wn.b
            public final /* synthetic */ String c = "RoutesSdkImpl.getRoutesForGuidance";

            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                ((k) eVar.b.a(xVar)).a(ah.a(1));
                String[] strArr2 = com.google.android.libraries.navigation.internal.nw.e.a;
                Trace.endAsyncSection(this.c, andIncrement);
                return az.g((Exception) obj);
            }
        }, eVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.wk.c
    public final void b(bh bhVar, com.google.android.libraries.navigation.internal.ade.n nVar) {
        Iterator it2 = bhVar.iterator();
        while (it2.hasNext()) {
            bg bgVar = (bg) it2.next();
            if (bgVar.R) {
                this.c.b(bgVar.Z, bgVar, nVar);
            }
        }
    }
}

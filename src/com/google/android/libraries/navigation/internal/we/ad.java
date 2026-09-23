package com.google.android.libraries.navigation.internal.we;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.adr.ki;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.lh;
import com.google.android.libraries.navigation.internal.afl.ll;
import com.google.android.libraries.navigation.internal.afl.mf;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements aa {
    public final com.google.android.libraries.navigation.internal.kl.b a;
    private final com.google.android.libraries.navigation.internal.wk.c b;
    private final com.google.android.libraries.navigation.internal.wn.e c;

    public ad(com.google.android.libraries.navigation.internal.wk.c cVar, com.google.android.libraries.navigation.internal.wn.e eVar, com.google.android.libraries.navigation.internal.kl.b bVar) {
        this.b = cVar;
        this.c = eVar;
        this.a = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.we.aa
    public final bj a(com.google.android.libraries.navigation.internal.add.aw awVar, Executor executor) {
        com.google.android.libraries.navigation.internal.ade.p pVar = awVar.c;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        if (pVar.b.isEmpty()) {
            com.google.android.libraries.navigation.internal.wq.b bVar = new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INVALID_ARGUMENT, "Selected route was not provided in the routeIdSet.", null));
            ((com.google.android.libraries.navigation.internal.kk.j) this.a.a(com.google.android.libraries.navigation.internal.km.ak.j)).a();
            return com.google.android.libraries.navigation.internal.aac.az.g(bVar);
        }
        final com.google.android.libraries.navigation.internal.wn.e eVar = this.c;
        bj bjVarA = this.b.a(awVar);
        com.google.android.libraries.navigation.internal.km.ad adVar = com.google.android.libraries.navigation.internal.km.ak.l;
        final int andIncrement = eVar.a.getAndIncrement();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.beginAsyncSection("GuidanceRouteExtractorImpl.getRoutesForGuidance", andIncrement);
        final com.google.android.libraries.navigation.internal.kk.m mVarA = ((com.google.android.libraries.navigation.internal.kk.n) eVar.b.a(adVar)).a();
        return com.google.android.libraries.navigation.internal.yu.a.b(com.google.android.libraries.navigation.internal.yu.a.b(bjVarA).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.wn.c
            public final /* synthetic */ String b = "GuidanceRouteExtractorImpl.getRoutesForGuidance";

            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                e.a(this.b, mVarA, andIncrement);
                return obj;
            }
        }, eVar.c).a(Exception.class, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.wn.d
            public final /* synthetic */ String b = "GuidanceRouteExtractorImpl.getRoutesForGuidance";

            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                e.a(this.b, mVarA, andIncrement);
                return az.g((Exception) obj);
            }
        }, eVar.c)).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.we.ab
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                com.google.android.libraries.navigation.internal.wl.d dVar = (com.google.android.libraries.navigation.internal.wl.d) obj;
                if (dVar == null || dVar.a().isEmpty()) {
                    throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, "RoutesSdk succeeded but returned an empty routeList", null));
                }
                com.google.android.libraries.navigation.internal.add.aw awVarB = dVar.b();
                if ((awVarB.b & 1) != 0) {
                    if (awVarB.d.size() != 0) {
                        fd fdVarA = dVar.a();
                        com.google.android.libraries.navigation.internal.ade.p pVar2 = awVarB.c;
                        if (pVar2 == null) {
                            pVar2 = com.google.android.libraries.navigation.internal.ade.p.a;
                        }
                        com.google.android.libraries.navigation.internal.wl.c cVar = (com.google.android.libraries.navigation.internal.wl.c) fdVarA.get(pVar2.b);
                        com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
                        com.google.android.libraries.navigation.internal.bp.bg bgVarA = cVar.a();
                        mf mfVar = bgVarA.d;
                        if (mfVar != null) {
                            ll llVar = mfVar.c;
                            if (llVar == null) {
                                llVar = ll.a;
                            }
                            lh lhVar = llVar.c;
                            if (lhVar == null) {
                                lhVar = lh.a;
                            }
                            bz bzVar = lhVar.d;
                            ArrayList arrayList = new ArrayList();
                            Iterator it2 = bzVar.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(((ki) it2.next()).A);
                            }
                            ArrayList arrayList2 = new ArrayList(Arrays.asList((String) arrayList.get(bgVarA.f)));
                            Iterator it3 = awVarB.d.iterator();
                            while (it3.hasNext()) {
                                com.google.android.libraries.navigation.internal.wl.c cVar2 = (com.google.android.libraries.navigation.internal.wl.c) dVar.a().get(((com.google.android.libraries.navigation.internal.ade.p) it3.next()).b);
                                com.google.android.libraries.navigation.internal.yx.ar.q(cVar2);
                                arrayList2.add(cVar2.a().g.h());
                            }
                            if (arrayList.size() == arrayList2.size()) {
                                Iterator it4 = arrayList2.iterator();
                                while (it4.hasNext()) {
                                    if (arrayList.contains((String) it4.next())) {
                                    }
                                }
                            }
                        }
                    }
                    return dVar;
                }
                throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, "RoutesForGuiance is invalid.", null));
            }
        }, executor).a(Exception.class, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.we.ac
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1959)).p("Failed to extract routes from RoutesSdkInternal.");
                ((com.google.android.libraries.navigation.internal.kk.j) this.a.a.a(com.google.android.libraries.navigation.internal.km.ak.k)).a();
                return com.google.android.libraries.navigation.internal.aac.az.g((Exception) obj);
            }
        }, executor);
    }
}

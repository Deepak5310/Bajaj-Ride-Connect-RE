package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements com.google.android.libraries.navigation.internal.ol.ad {
    final /* synthetic */ l a;

    public k(l lVar) {
        this.a = lVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0190 */
    @Override // com.google.android.libraries.navigation.internal.ol.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, aq aqVar) throws Throwable {
        boolean z;
        boolean z2;
        k kVar = this;
        com.google.android.libraries.navigation.internal.ra.c.e.f();
        synchronized (kVar.a.f.c) {
            try {
                kVar.a.d.clear();
                l lVar = kVar.a;
                lVar.d.addAll(lVar.f.d.entrySet());
            } catch (Throwable th) {
                th = th;
                while (true) {
                    throw th;
                }
            }
        }
        ez ezVarH = fd.h(kVar.a.d.size());
        Iterator it2 = kVar.a.d.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ol.n nVar = (com.google.android.libraries.navigation.internal.ol.n) ((Map.Entry) it2.next()).getKey();
            ezVarH.f(nVar.a(), nVar.b());
        }
        al alVar = new al(ezVarH.c());
        kVar.a.f.e.a();
        Collections.sort(kVar.a.d, n.a);
        com.google.android.libraries.navigation.internal.rf.g gVar = new com.google.android.libraries.navigation.internal.rf.g(com.google.android.libraries.navigation.internal.pd.d.b(tVar.w()), tVar.s(), tVar.r(), tVar.n());
        Iterator it3 = kVar.a.d.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            com.google.android.libraries.navigation.internal.ol.n nVar2 = (com.google.android.libraries.navigation.internal.ol.n) entry.getKey();
            m mVar = (m) entry.getValue();
            nVar2.c();
            l lVar2 = kVar.a;
            q qVar = lVar2.c;
            if (qVar == null) {
                t tVar2 = mVar.b;
                com.google.android.libraries.navigation.internal.oe.x xVar = mVar.e ? mVar.d : null;
                com.google.android.libraries.navigation.internal.adg.b bVar = mVar.f;
                n nVar3 = lVar2.f;
                z = true;
                lVar2.c = new q(tVar2, xVar, bVar, gVar, nVar3.e, alVar, mVar.g, nVar3.h);
                z2 = false;
            } else {
                z = true;
                qVar.a = mVar.b;
                com.google.android.libraries.navigation.internal.oe.x xVar2 = mVar.e ? mVar.d : null;
                if (xVar2 != null) {
                    qVar.b.W(xVar2);
                    qVar.c = true;
                    z2 = false;
                } else {
                    z2 = false;
                    qVar.c = false;
                }
                q qVar2 = lVar2.c;
                qVar2.d = mVar.f;
                qVar2.h = gVar;
                n nVar4 = lVar2.f;
                qVar2.e = nVar4.e;
                qVar2.i = alVar;
                qVar2.f = mVar.g;
                qVar2.g = nVar4.h;
            }
            r rVar = mVar.a;
            com.google.android.libraries.navigation.internal.op.g gVarA = nVar2.a();
            l lVar3 = this.a;
            if (rVar.a(gVarA, lVar3.c, lVar3.a)) {
                l lVar4 = this.a;
                lVar4.b.b(lVar4.a.a);
                l lVar5 = this.a;
                com.google.android.libraries.navigation.internal.ol.m mVar2 = lVar5.b;
                mVar2.b = lVar5.a.b;
                nVar2.e(mVar2, z2);
                if (!mVar.h) {
                    mVar.i;
                    mVar.i;
                    this.a.f.b.m(nVar2);
                    mVar.h = z;
                }
                mVar.d.W(this.a.a.a);
                mVar.e = z;
                mVar.f = this.a.a.b;
            } else if (mVar.h) {
                this.a.f.b.i(nVar2);
                mVar.h = z2;
            }
            it3 = it3;
            kVar = this;
        }
    }
}

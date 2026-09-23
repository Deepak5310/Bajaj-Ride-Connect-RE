package com.google.android.libraries.navigation.internal.po;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cu implements com.google.android.libraries.navigation.internal.ol.ad {
    final /* synthetic */ cv a;

    public cu(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.ad
    public final void a(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar) {
        boolean z = this.a.f.getAndSet(false) || aqVar != this.a.h.l;
        cv cvVar = this.a;
        cvVar.h.l = aqVar;
        synchronized (cvVar.a) {
            this.a.c.clear();
            cv cvVar2 = this.a;
            cvVar2.c.addAll(cvVar2.b);
            this.a.b.clear();
            cv cvVar3 = this.a;
            List list = cvVar3.d;
            cvVar3.d = cvVar3.e;
            cvVar3.e = list;
            cvVar3.d.clear();
        }
        Iterator it2 = this.a.c.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        int size = this.a.e.size();
        while (true) {
            size--;
            if (size < 0) {
                synchronized (this.a.a) {
                    cv cvVar4 = this.a;
                    cvVar4.e.addAll(cvVar4.d);
                    cv cvVar5 = this.a;
                    List list2 = cvVar5.d;
                    cvVar5.d = cvVar5.e;
                    cvVar5.e = list2;
                    cvVar5.e.clear();
                }
                return;
            }
            if (((aa) this.a.e.get(size)).B()) {
                this.a.e.remove(size);
            } else if (z) {
                aa aaVar = (aa) this.a.e.get(size);
                com.google.android.libraries.navigation.internal.px.ca caVar = this.a.h.f;
                com.google.android.libraries.navigation.internal.yx.ar.q(caVar);
                cv cvVar6 = this.a;
                dh dhVar = cvVar6.h;
                aaVar.C(caVar, dhVar.g, dhVar.k, cvVar6.h.l);
            }
        }
    }
}

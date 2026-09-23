package com.google.android.libraries.navigation.internal.rl;

import android.graphics.Bitmap;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.ab;
import com.google.android.libraries.geo.mapcore.internal.model.ah;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.navigation.internal.adg.cq;
import com.google.android.libraries.navigation.internal.adg.cr;
import com.google.android.libraries.navigation.internal.adg.da;
import com.google.android.libraries.navigation.internal.adg.db;
import com.google.android.libraries.navigation.internal.adg.ej;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.android.libraries.navigation.internal.adg.fx;
import com.google.android.libraries.navigation.internal.adg.ga;
import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.ol.av;
import com.google.android.libraries.navigation.internal.po.dq;
import com.google.android.libraries.navigation.internal.po.gx;
import com.google.android.libraries.navigation.internal.po.hi;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gi;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w {
    public final d a;
    private final u d;
    private final Map c = new HashMap();
    public boolean b = false;

    public w(u uVar) {
        this.d = uVar;
        this.a = uVar.b();
    }

    public final c a(com.google.android.libraries.navigation.internal.oo.f fVar) {
        c cVarA;
        c cVar = (c) this.c.get(fVar);
        if (cVar != null) {
            return cVar;
        }
        com.google.android.libraries.navigation.internal.rd.g gVar = (com.google.android.libraries.navigation.internal.rd.g) fVar;
        int iB = gVar.b() - 1;
        if (iB == 0) {
            cVarA = this.d.a(((com.google.android.libraries.navigation.internal.rd.e) gVar).a().c);
        } else if (iB != 1) {
            this.b = true;
            gi giVarA = ((com.google.android.libraries.navigation.internal.rd.d) gVar).a();
            eq eqVarJ = ev.j(giVarA.size());
            nn nnVarListIterator = giVarA.entrySet().listIterator();
            while (nnVarListIterator.hasNext()) {
                Map.Entry entry = (Map.Entry) nnVarListIterator.next();
                eqVarJ.h(new ao((Integer) entry.getKey(), (Bitmap) entry.getValue()));
            }
            d dVar = this.a;
            final ev evVarO = ev.o(eqVarJ.g());
            cVarA = ((r) dVar).a(new i() { // from class: com.google.android.libraries.navigation.internal.rl.g
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.libraries.navigation.internal.rl.i
                public final void a(av avVar) {
                    AtomicInteger atomicInteger = ((gx) avVar).b;
                    ev evVar = evVarO;
                    int andIncrement = atomicInteger.getAndIncrement();
                    ai[] aiVarArr = new ai[evVar.size()];
                    byte[] bArr = new byte[evVar.size()];
                    for (int i = 0; i < evVar.size(); i++) {
                        ao aoVar = (ao) evVar.get(i);
                        Integer num = (Integer) aoVar.a;
                        Bitmap bitmap = (Bitmap) aoVar.b;
                        if (num == null) {
                            aq aqVar = hi.b;
                            return;
                        }
                        if (bitmap == null) {
                            aq aqVar2 = hi.b;
                            return;
                        }
                        ai aiVar = ai.c;
                        ah ahVar = new ah();
                        ahVar.p = new ab(bitmap);
                        aiVarArr[i] = new ai(ahVar);
                        bArr[i] = num.byteValue();
                    }
                    com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("createMapStyleAndAddToNamespace-zooms");
                    try {
                        dq dqVar = new dq((gx) avVar, new bt(0L, aiVarArr, bArr, null, ((gx) avVar).e), andIncrement);
                        synchronized (((gx) avVar).a) {
                            try {
                                ((gx) avVar).a.a(dqVar.e, dqVar);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (dVarB != null) {
                            Trace.endSection();
                        }
                    } catch (Throwable th2) {
                        if (dVarB != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }, new k() { // from class: com.google.android.libraries.navigation.internal.rl.h
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.libraries.navigation.internal.rl.k
                public final ga a(q qVar) {
                    fx fxVar = (fx) ga.a.q();
                    ev evVar = evVarO;
                    int size = evVar.size();
                    for (int i = 0; i < size; i++) {
                        ao aoVar = (ao) evVar.get(i);
                        da daVar = (da) db.a.q();
                        int iIntValue = ((Integer) aoVar.a).intValue();
                        if (!daVar.b.H()) {
                            daVar.v();
                        }
                        db dbVar = (db) daVar.b;
                        dbVar.b |= 1;
                        dbVar.c = iIntValue;
                        ej ejVar = (ej) eo.a.q();
                        cq cqVar = (cq) cr.a.q();
                        String strA = qVar.b.a((Bitmap) aoVar.b);
                        qVar.a.add(strA);
                        if (!cqVar.b.H()) {
                            cqVar.v();
                        }
                        cr crVar = (cr) cqVar.b;
                        crVar.b |= 1;
                        crVar.c = strA;
                        ejVar.c(cqVar);
                        if (!daVar.b.H()) {
                            daVar.v();
                        }
                        db dbVar2 = (db) daVar.b;
                        eo eoVar = (eo) ejVar.t();
                        eoVar.getClass();
                        dbVar2.e = eoVar;
                        dbVar2.b |= 4;
                        fxVar.c(daVar);
                    }
                    return (ga) fxVar.t();
                }
            });
        } else {
            this.b = true;
            d dVar2 = this.a;
            final ga gaVarA = ((com.google.android.libraries.navigation.internal.rd.f) gVar).a();
            cVarA = ((r) dVar2).a(new i() { // from class: com.google.android.libraries.navigation.internal.rl.e
                @Override // com.google.android.libraries.navigation.internal.rl.i
                public final void a(av avVar) {
                    avVar.b(gaVarA);
                }
            }, new k() { // from class: com.google.android.libraries.navigation.internal.rl.f
                @Override // com.google.android.libraries.navigation.internal.rl.k
                public final ga a(q qVar) {
                    return gaVarA;
                }
            });
        }
        Map map = this.c;
        ar.q(cVarA);
        map.put(fVar, cVarA);
        return cVarA;
    }
}

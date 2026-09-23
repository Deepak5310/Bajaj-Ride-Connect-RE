package com.google.android.libraries.navigation.internal.rh;

import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.eh;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.ol.av;
import com.google.android.libraries.navigation.internal.po.ag;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Iterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements h {
    final /* synthetic */ o a;
    private final ev b;
    private final com.google.android.libraries.navigation.internal.rl.p c;

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void a() {
        this.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.a.b.q().i((com.google.android.libraries.navigation.internal.ol.o) obj);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void b() {
        this.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.m
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.a.b.q().g((com.google.android.libraries.navigation.internal.ol.o) obj);
            }
        });
        com.google.android.libraries.navigation.internal.rl.p pVar = this.c;
        if (pVar != null) {
            pVar.close();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.rh.h
    public final void c() {
        this.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.k
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.a.b.q().m((com.google.android.libraries.navigation.internal.ol.o) obj);
            }
        });
    }

    public n(o oVar, bg bgVar, com.google.android.libraries.navigation.internal.rl.s sVar) {
        this.a = oVar;
        com.google.android.libraries.navigation.internal.rl.p pVarC = sVar == null ? null : sVar.c();
        this.c = pVarC;
        eh ehVar = bgVar.f;
        ehVar = ehVar == null ? eh.a : ehVar;
        jr jrVar = oVar.e;
        com.google.android.libraries.navigation.internal.ob.g gVar = oVar.b;
        av avVarA = pVarC != null ? pVarC.a() : null;
        com.google.android.libraries.navigation.internal.or.c cVar = oVar.c;
        ai aiVarQ = gVar.q();
        bz bzVar = ehVar.b;
        int i = ev.d;
        eq eqVar = new eq();
        Iterator it2 = bzVar.iterator();
        while (it2.hasNext()) {
            ag agVarP = ((dh) aiVarQ).p((ef) it2.next(), cVar, jrVar, avVarA, com.google.android.libraries.navigation.internal.ox.b.FROM_MODERN);
            agVarP.l();
            eqVar.h(agVarP);
        }
        this.b = eqVar.g();
    }
}

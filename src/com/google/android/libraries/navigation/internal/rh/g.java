package com.google.android.libraries.navigation.internal.rh;

import com.google.android.libraries.navigation.internal.adg.aq;
import com.google.android.libraries.navigation.internal.adg.as;
import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.fi;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ol.ak;
import com.google.android.libraries.navigation.internal.ol.av;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final ev a;
    public final ev b;
    public final h c;
    final /* synthetic */ o d;
    public final com.google.android.libraries.navigation.internal.rl.p e;
    public final com.google.android.libraries.navigation.internal.rl.l f;

    final void a() {
        this.c.c();
        this.a.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.d.b.r().at((com.google.android.libraries.navigation.internal.ol.p) obj);
            }
        });
        this.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.d.b.p().e((com.google.android.libraries.navigation.internal.ol.g) obj);
            }
        });
    }

    public g(o oVar, bg bgVar, com.google.android.libraries.navigation.internal.rl.s sVar, h hVar) {
        this.d = oVar;
        com.google.android.libraries.navigation.internal.rl.p pVarC = sVar == null ? null : sVar.c();
        this.e = pVarC;
        this.f = sVar == null ? null : sVar.b();
        av avVarA = pVarC != null ? pVarC.a() : null;
        this.c = hVar;
        fi fiVar = bgVar.d;
        fiVar = fiVar == null ? fi.a : fiVar;
        jr jrVar = oVar.e;
        com.google.android.libraries.navigation.internal.ob.g gVar = oVar.b;
        com.google.android.libraries.navigation.internal.or.c cVar = oVar.c;
        ak akVarR = gVar.r();
        bz<fg> bzVar = fiVar.b;
        int i = ev.d;
        eq eqVar = new eq();
        for (fg fgVar : bzVar) {
            eqVar.h(avVarA == null ? akVarR.a(o.e(fgVar, cVar), jrVar) : akVarR.b(o.e(fgVar, cVar), jrVar, avVarA));
        }
        this.a = eqVar.g();
        as asVar = bgVar.e;
        asVar = asVar == null ? as.a : asVar;
        jr jrVar2 = oVar.e;
        com.google.android.libraries.navigation.internal.ob.g gVar2 = oVar.b;
        com.google.android.libraries.navigation.internal.or.c cVar2 = oVar.c;
        com.google.android.libraries.navigation.internal.ol.a aVarP = gVar2.p();
        bz<aq> bzVar2 = asVar.b;
        eq eqVar2 = new eq();
        for (aq aqVar : bzVar2) {
            eqVar2.h(avVarA == null ? aVarP.a(o.d(aqVar, cVar2), jrVar2) : aVarP.b(o.d(aqVar, cVar2), avVarA, jrVar2));
        }
        this.b = eqVar2.g();
    }
}

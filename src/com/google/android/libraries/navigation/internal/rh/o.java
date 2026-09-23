package com.google.android.libraries.navigation.internal.rh;

import com.google.android.libraries.navigation.internal.adg.ap;
import com.google.android.libraries.navigation.internal.adg.aq;
import com.google.android.libraries.navigation.internal.adg.bg;
import com.google.android.libraries.navigation.internal.adg.fd;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements r {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.rh.o");
    public final com.google.android.libraries.navigation.internal.ob.g b;
    public final com.google.android.libraries.navigation.internal.or.c c;
    public final an d;
    public final jr e;
    public final g f;
    private boolean g = false;
    private boolean h = false;

    public o(bg bgVar, com.google.android.libraries.navigation.internal.ob.g gVar, an anVar, com.google.android.libraries.navigation.internal.rl.s sVar, com.google.android.libraries.navigation.internal.or.c cVar) {
        this.b = gVar;
        this.c = cVar;
        this.d = anVar;
        jr jrVarB = jr.b(bgVar.c);
        this.e = jrVarB == null ? jr.WORLD_ENCODING_UNKNOWN : jrVarB;
        this.f = new g(this, bgVar, sVar, anVar.g() ? new j(this, bgVar, sVar) : new n(this, bgVar, sVar));
    }

    public static aq d(aq aqVar, com.google.android.libraries.navigation.internal.or.c cVar) {
        bb bbVar = (bb) aqVar.aH(5, null);
        bbVar.x(aqVar);
        ap apVar = (ap) bbVar;
        fs fsVar = aqVar.m;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        fs fsVarF = f(fsVar, cVar);
        if (!apVar.b.H()) {
            apVar.v();
        }
        aq aqVar2 = (aq) apVar.b;
        fsVarF.getClass();
        aqVar2.m = fsVarF;
        aqVar2.b |= 4096;
        return (aq) apVar.t();
    }

    public static fg e(fg fgVar, com.google.android.libraries.navigation.internal.or.c cVar) {
        bb bbVar = (bb) fgVar.aH(5, null);
        bbVar.x(fgVar);
        fd fdVar = (fd) bbVar;
        fs fsVar = fgVar.q;
        if (fsVar == null) {
            fsVar = fs.a;
        }
        fs fsVarF = f(fsVar, cVar);
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        fg fgVar2 = (fg) fdVar.b;
        fsVarF.getClass();
        fgVar2.q = fsVarF;
        fgVar2.b |= 8192;
        return (fg) fdVar.t();
    }

    public static fs f(fs fsVar, com.google.android.libraries.navigation.internal.or.c cVar) {
        bb bbVar = (bb) fsVar.aH(5, null);
        bbVar.x(fsVar);
        fr frVar = (fr) bbVar;
        bh bhVar = com.google.android.libraries.navigation.internal.adk.c.a;
        bh bhVarS = bi.s(com.google.android.libraries.navigation.internal.adk.c.a);
        fsVar.h(bhVarS);
        Object objK = fsVar.w.k(bhVarS.d);
        com.google.android.libraries.navigation.internal.adk.b bVar = (com.google.android.libraries.navigation.internal.adk.b) (objK == null ? bhVarS.b : bhVarS.c(objK));
        bb bbVar2 = (bb) bVar.aH(5, null);
        bbVar2.x(bVar);
        long j = ((com.google.android.libraries.navigation.internal.or.a) cVar).a;
        com.google.android.libraries.navigation.internal.adk.a aVar = (com.google.android.libraries.navigation.internal.adk.a) bbVar2;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.adk.b bVar2 = (com.google.android.libraries.navigation.internal.adk.b) aVar.b;
        com.google.android.libraries.navigation.internal.adk.b bVar3 = com.google.android.libraries.navigation.internal.adk.b.a;
        bVar2.b |= 1;
        bVar2.c = j;
        frVar.C(bhVar, (com.google.android.libraries.navigation.internal.adk.b) aVar.t());
        return (fs) frVar.t();
    }

    @Override // com.google.android.libraries.navigation.internal.or.b
    public final synchronized void a() {
        if (!this.h && this.g) {
            this.g = false;
            final g gVar = this.f;
            gVar.c.a();
            gVar.a.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    gVar.d.b.r().e((com.google.android.libraries.navigation.internal.ol.p) obj);
                }
            });
            gVar.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    gVar.d.b.p().d((com.google.android.libraries.navigation.internal.ol.g) obj);
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.or.b
    public final synchronized void b() {
        if (!this.h) {
            this.h = true;
            final g gVar = this.f;
            gVar.c.b();
            gVar.a.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    gVar.d.b.r().c((com.google.android.libraries.navigation.internal.ol.p) obj);
                }
            });
            gVar.b.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.rh.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    gVar.d.b.p().c((com.google.android.libraries.navigation.internal.ol.g) obj);
                }
            });
            com.google.android.libraries.navigation.internal.rl.p pVar = gVar.e;
            if (pVar != null) {
                pVar.close();
            }
            com.google.android.libraries.navigation.internal.rl.l lVar = gVar.f;
            if (lVar != null) {
                lVar.close();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.or.b
    public final synchronized void c() {
        if (!this.h && !this.g) {
            this.g = true;
            this.f.a();
        }
    }
}

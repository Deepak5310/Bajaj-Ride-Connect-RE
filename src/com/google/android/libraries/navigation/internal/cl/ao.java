package com.google.android.libraries.navigation.internal.cl;

import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao implements com.google.android.libraries.navigation.internal.oh.a {
    static final fd a;
    private final bq b;
    private final com.google.android.libraries.navigation.internal.oe.ad c;
    private final com.google.android.libraries.navigation.internal.oe.ay d = new com.google.android.libraries.navigation.internal.oe.ay();

    static {
        ez ezVar = new ez();
        ezVar.f(com.google.android.libraries.navigation.internal.adg.b.BOTTOM, new com.google.android.libraries.navigation.internal.oe.ay(0.0f, 1.0f));
        com.google.android.libraries.navigation.internal.adg.b bVar = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT;
        com.google.android.libraries.navigation.internal.oe.ay ayVar = new com.google.android.libraries.navigation.internal.oe.ay(-1.0f, 1.0f);
        com.google.android.libraries.navigation.internal.oe.ay.n(ayVar, ayVar);
        ezVar.f(bVar, ayVar);
        com.google.android.libraries.navigation.internal.adg.b bVar2 = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT;
        com.google.android.libraries.navigation.internal.oe.ay ayVar2 = new com.google.android.libraries.navigation.internal.oe.ay(1.0f, 1.0f);
        com.google.android.libraries.navigation.internal.oe.ay.n(ayVar2, ayVar2);
        ezVar.f(bVar2, ayVar2);
        ezVar.f(com.google.android.libraries.navigation.internal.adg.b.TOP, new com.google.android.libraries.navigation.internal.oe.ay(0.0f, -1.0f));
        com.google.android.libraries.navigation.internal.adg.b bVar3 = com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT;
        com.google.android.libraries.navigation.internal.oe.ay ayVar3 = new com.google.android.libraries.navigation.internal.oe.ay(-1.0f, -1.0f);
        com.google.android.libraries.navigation.internal.oe.ay.n(ayVar3, ayVar3);
        ezVar.f(bVar3, ayVar3);
        com.google.android.libraries.navigation.internal.adg.b bVar4 = com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT;
        com.google.android.libraries.navigation.internal.oe.ay ayVar4 = new com.google.android.libraries.navigation.internal.oe.ay(1.0f, -1.0f);
        com.google.android.libraries.navigation.internal.oe.ay.n(ayVar4, ayVar4);
        ezVar.f(bVar4, ayVar4);
        ezVar.f(com.google.android.libraries.navigation.internal.adg.b.LEFT, new com.google.android.libraries.navigation.internal.oe.ay(-1.0f, 0.0f));
        ezVar.f(com.google.android.libraries.navigation.internal.adg.b.RIGHT, new com.google.android.libraries.navigation.internal.oe.ay(1.0f, 0.0f));
        a = ezVar.d();
    }

    public ao(bq bqVar, com.google.android.libraries.navigation.internal.oe.ad adVar) {
        this.b = bqVar;
        this.c = adVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        com.google.android.libraries.navigation.internal.oe.ay ayVar;
        com.google.android.libraries.navigation.internal.oe.ay ayVarF;
        com.google.android.libraries.navigation.internal.oe.ay ayVarF2;
        com.google.android.libraries.navigation.internal.oe.ay ayVarF3;
        if (!xVar.equals(this.b.c)) {
            com.google.android.libraries.navigation.internal.oe.x xVar2 = this.b.c;
        }
        com.google.android.libraries.navigation.internal.oe.ad adVar = this.c;
        bq bqVar = this.b;
        List listQ = adVar.q();
        int i = bqVar.k;
        float fC = 0.0f;
        if (i > 0 && i < listQ.size() - 1) {
            if (bVar == com.google.android.libraries.navigation.internal.adg.b.CENTER || (ayVar = (com.google.android.libraries.navigation.internal.oe.ay) a.get(bVar)) == null || (ayVarF = qVar.h.f((com.google.android.libraries.navigation.internal.oe.x) listQ.get(i))) == null || (ayVarF2 = qVar.h.f((com.google.android.libraries.navigation.internal.oe.x) listQ.get(i - 1))) == null || (ayVarF3 = qVar.h.f((com.google.android.libraries.navigation.internal.oe.x) listQ.get(i + 1))) == null) {
                fC = 0.5f;
            } else {
                com.google.android.libraries.navigation.internal.oe.ay.s(ayVarF2, ayVarF, ayVarF2);
                com.google.android.libraries.navigation.internal.oe.ay.n(ayVarF2, ayVarF2);
                com.google.android.libraries.navigation.internal.oe.ay.s(ayVarF3, ayVarF, ayVarF3);
                com.google.android.libraries.navigation.internal.oe.ay.n(ayVarF3, ayVarF3);
                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = this.d;
                com.google.android.libraries.navigation.internal.oe.ay.j(ayVarF2, ayVarF3, ayVar2);
                com.google.android.libraries.navigation.internal.oe.ay.n(ayVar2, ayVar2);
                fC = (this.d.c(ayVar) + 1.0f) / 2.0f;
            }
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(fC, "InsideBendInPolyline:"));
        }
        return fC;
    }
}

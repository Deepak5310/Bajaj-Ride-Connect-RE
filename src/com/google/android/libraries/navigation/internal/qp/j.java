package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.ael.bh;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements y {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qp.j");
    private final cg b;

    public j(cg cgVar) {
        this.b = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        for (int i = 0; i < ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).d.size(); i++) {
            int iA = com.google.android.libraries.navigation.internal.adi.w.a(agVar.c(i).c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adi.w.a;
            }
            if (iA == com.google.android.libraries.navigation.internal.adi.w.g && agVar.c(i).d.equals("evcs")) {
                if (i == -1) {
                    break;
                }
                com.google.android.libraries.navigation.internal.aep.c cVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.b).r;
                if (cVar != null) {
                    com.google.android.libraries.navigation.internal.adf.a aVar = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                    bh bhVar = com.google.android.libraries.navigation.internal.aep.h.b;
                    com.google.android.libraries.navigation.internal.aep.a aVar2 = (com.google.android.libraries.navigation.internal.aep.a) com.google.android.libraries.navigation.internal.aep.h.a.q();
                    if (!aVar2.b.H()) {
                        aVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aep.h hVar = (com.google.android.libraries.navigation.internal.aep.h) aVar2.b;
                    hVar.h = cVar;
                    hVar.c |= 16;
                    aVar.C(bhVar, (com.google.android.libraries.navigation.internal.aep.h) aVar2.t());
                    agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar.t());
                    return;
                }
                return;
            }
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1106)).p("Paint request template does not have evcs Layer.");
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}

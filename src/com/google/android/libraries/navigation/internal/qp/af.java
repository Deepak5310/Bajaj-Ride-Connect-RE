package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af implements y {
    private final cg a;

    public af(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        com.google.android.libraries.navigation.internal.aai.f fVar;
        for (int i = 0; i < ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).d.size(); i++) {
            int iA = com.google.android.libraries.navigation.internal.adi.w.a(agVar.c(i).c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adi.w.a;
            }
            if (iA == com.google.android.libraries.navigation.internal.adi.w.g) {
                String str = agVar.c(i).d;
                if (str.equals("categorical-search") || str.equals("categorical-search-results-injection") || str.equals("hotel-categorical-search") || str.equals("hotel-categorical-search-injection") || str.equals("spotlit")) {
                    if (i == -1 || (fVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).a) == null) {
                        return;
                    }
                    com.google.android.libraries.navigation.internal.adf.a aVar = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
                    aVar.C(com.google.android.libraries.navigation.internal.aai.f.b, fVar);
                    agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar.t());
                    return;
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}

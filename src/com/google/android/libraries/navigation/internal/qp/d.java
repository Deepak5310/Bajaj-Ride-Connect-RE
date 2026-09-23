package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements y {
    private final cg a;

    public d(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        boolean zBooleanValue;
        com.google.android.libraries.navigation.internal.acz.a aVar = (com.google.android.libraries.navigation.internal.acz.a) com.google.android.libraries.navigation.internal.acz.b.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.acz.b bVar = (com.google.android.libraries.navigation.internal.acz.b) aVar.b;
        bVar.c |= 1;
        bVar.d = true;
        Boolean bool = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).f;
        if (bool != null) {
            ar.q(bool);
            zBooleanValue = bool.booleanValue();
        } else {
            zBooleanValue = false;
        }
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.acz.b bVar2 = (com.google.android.libraries.navigation.internal.acz.b) aVar.b;
        bVar2.c |= 2;
        bVar2.e = zBooleanValue;
        com.google.android.libraries.navigation.internal.acz.b bVar3 = (com.google.android.libraries.navigation.internal.acz.b) aVar.t();
        com.google.android.libraries.navigation.internal.adf.a aVar2 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
        aVar2.C(com.google.android.libraries.navigation.internal.acz.b.b, bVar3);
        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar2.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}

package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements y {
    private final cg a;

    public m(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        com.google.android.libraries.navigation.internal.adi.aj ajVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).k;
        if (ajVar == null) {
            return;
        }
        agVar.x(ajVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}

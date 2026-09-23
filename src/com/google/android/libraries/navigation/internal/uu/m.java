package com.google.android.libraries.navigation.internal.uu;

import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ax;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends com.google.android.libraries.navigation.internal.ia.k {
    public m(Class cls, l lVar, ap apVar) {
        super(cls, lVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        l lVar = (l) this.c;
        com.google.android.libraries.navigation.internal.db.r rVarD = ((com.google.android.libraries.navigation.internal.db.s) aVar).d();
        if (rVarD == null) {
            lVar.e();
            return;
        }
        if (!"gmfc".equals(rVarD.a)) {
            lVar.e();
            return;
        }
        if (!rVarD.x() || !rVarD.y()) {
            lVar.e();
            return;
        }
        final double dAbs = Math.abs(rVarD.f);
        double dH = rVarD.h();
        if (dH > 4.0d) {
            lVar.g.d(new c());
        } else if (dAbs - dH <= 0.0d) {
            lVar.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.e
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    ((k) obj).b(0.0f);
                }
            });
        } else {
            lVar.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.f
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    ((k) obj).b((float) dAbs);
                }
            });
        }
    }
}

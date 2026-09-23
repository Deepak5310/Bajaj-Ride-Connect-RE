package com.google.android.libraries.navigation.internal.cl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements p {
    private final bc b;
    private final com.google.android.libraries.navigation.internal.bp.ay c;

    public q(bc bcVar, com.google.android.libraries.navigation.internal.bp.ay ayVar) {
        this.b = bcVar;
        this.c = ayVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oh.a
    public final float a(com.google.android.libraries.navigation.internal.op.g gVar, com.google.android.libraries.navigation.internal.qk.q qVar, com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.qk.s sVar) {
        com.google.android.libraries.navigation.internal.oe.an anVarE;
        com.google.android.libraries.navigation.internal.bp.ay ayVar = this.c;
        float f = 0.0f;
        if (this.b.a.Y != ayVar.a().Y && (anVarE = ayVar.b().e()) != null) {
            if (this.b.c.equals(anVarE.c())) {
                f = 1.0f;
            }
        }
        if (sVar != null) {
            sVar.a(xVar, bVar, com.google.android.libraries.navigation.internal.b.b.h(f, "DuplicatesSelectedPathToNextDestination:"));
        }
        return f;
    }
}

package com.google.android.libraries.navigation.internal.dr;

import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa implements d {
    private final com.google.android.libraries.navigation.internal.ol.a a;
    private final br b;
    private boolean c = false;

    public aa(com.google.android.libraries.navigation.internal.ol.a aVar, br brVar) {
        this.a = aVar;
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void a() {
        this.a.d((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        this.a.c((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void b(boolean z) {
        if (z == this.c) {
            return;
        }
        this.c = z;
        if (z) {
            this.a.e((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        } else {
            this.a.d((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.oe.x xVar, float f) {
        com.google.android.libraries.navigation.internal.ol.i iVarC = ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).c();
        iVarC.b(xVar);
        iVarC.d(f, com.google.android.libraries.navigation.internal.ol.h.WORLD);
        ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).d(iVarC);
    }
}

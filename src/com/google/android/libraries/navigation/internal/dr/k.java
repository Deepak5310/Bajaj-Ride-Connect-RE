package com.google.android.libraries.navigation.internal.dr;

import com.google.android.libraries.geo.mapcore.renderer.ck;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k implements d {
    static final int a = ck.CLIENT_INJECTED_AREAS_ABOVE_LABELS_AND_CALLOUTS.a();
    public final br b;
    public int d;
    public String e;
    private final com.google.android.libraries.navigation.internal.ol.a f;
    public boolean c = false;
    private boolean g = false;

    public k(com.google.android.libraries.navigation.internal.ol.a aVar, String str, int i, br brVar) {
        this.f = aVar;
        this.e = str;
        this.d = i;
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void a() {
        if (this.c) {
            this.f.d((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
            this.f.c((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void b(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        this.c = true;
        if (z) {
            this.f.e((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        } else {
            this.f.d((com.google.android.libraries.navigation.internal.ol.g) this.b.a());
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.oe.x xVar, Float f, Float f2, Float f3) {
        this.c = true;
        com.google.android.libraries.navigation.internal.ol.i iVarC = ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).c();
        if (xVar != null) {
            iVarC.b(xVar);
            iVarC.c(iVarC.d, xVar);
        }
        if (f != null) {
            iVarC.d(f.floatValue(), com.google.android.libraries.navigation.internal.ol.h.PIXEL);
        }
        if (f2 != null) {
            iVarC.c(-f2.floatValue(), iVarC.a);
        }
        ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).d(iVarC);
        if (f3 != null) {
            ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).a(f3.floatValue());
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.pi.v vVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar) {
        this.c = true;
        ((com.google.android.libraries.navigation.internal.ol.j) this.b.a()).k(new j(this, vVar, eVar, sVar));
    }
}

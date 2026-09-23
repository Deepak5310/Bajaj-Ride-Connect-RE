package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public final com.google.android.libraries.navigation.internal.ia.e a;
    public final l b;
    public final e c;
    public final k d;
    public int e;
    public k f;
    public volatile boolean g = true;

    public f(com.google.android.libraries.navigation.internal.ia.e eVar, l lVar, com.google.android.libraries.navigation.internal.iv.f fVar, e eVar2) {
        this.a = eVar;
        this.b = lVar;
        this.c = eVar2;
        int iA = eVar2.a();
        this.e = iA;
        this.d = eVar2.a.a("Direction cone around the blue dot", iA);
        if (fVar == null || !fVar.y(com.google.android.libraries.navigation.internal.iv.ab.G, false)) {
            return;
        }
        this.f = eVar2.a.a("Direction arrow around the blue dot", com.google.android.libraries.navigation.internal.du.c.ag);
    }

    public final void a() {
        this.d.b(false);
        k kVar = this.f;
        if (kVar != null) {
            kVar.b(false);
        }
    }

    public final void b(k kVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, float f2) {
        kVar.b(this.g);
        kVar.c(xVar, Float.valueOf(f), Float.valueOf(f2), null);
    }
}

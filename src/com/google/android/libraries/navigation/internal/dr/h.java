package com.google.android.libraries.navigation.internal.dr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements d {
    public com.google.android.libraries.navigation.internal.op.f a;
    private com.google.android.libraries.navigation.internal.ol.l e;
    public boolean c = false;
    public boolean d = false;
    public com.google.android.libraries.navigation.internal.oe.x b = new com.google.android.libraries.navigation.internal.oe.x();

    public h(com.google.android.libraries.navigation.internal.op.f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void a() {
        com.google.android.libraries.navigation.internal.op.f fVar = this.a;
        if (fVar != null) {
            fVar.b();
            this.a.c();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dr.d
    public final void b(boolean z) {
        if (z != this.c) {
            this.c = z;
            com.google.android.libraries.navigation.internal.op.f fVar = this.a;
            if (fVar != null) {
                if (z) {
                    fVar.e(this.b.t(), com.google.android.libraries.navigation.internal.adg.b.BOTTOM);
                } else {
                    fVar.b();
                }
            }
            this.d = false;
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.op.f fVar) {
        com.google.android.libraries.navigation.internal.op.f fVar2 = this.a;
        if (fVar2 != null) {
            fVar2.b();
            fVar2.c();
        }
        if (fVar != null) {
            com.google.android.libraries.navigation.internal.ol.l lVar = this.e;
            if (lVar != null && (fVar instanceof com.google.android.libraries.navigation.internal.oj.d)) {
                ((com.google.android.libraries.navigation.internal.oj.d) fVar).d(lVar);
            }
            if (this.c) {
                fVar.e(this.b.t(), com.google.android.libraries.navigation.internal.adg.b.BOTTOM);
            }
        }
        this.a = fVar;
        this.d = false;
    }

    public final void d(com.google.android.libraries.navigation.internal.ol.l lVar) {
        com.google.android.libraries.navigation.internal.op.f fVar = this.a;
        if (fVar instanceof com.google.android.libraries.navigation.internal.oj.d) {
            ((com.google.android.libraries.navigation.internal.oj.d) fVar).d(lVar);
            this.e = lVar;
        }
    }
}

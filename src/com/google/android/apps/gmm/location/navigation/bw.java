package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bw extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public bw(int i, Class cls, bu buVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, buVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            bu buVar = (bu) this.c;
            com.google.android.libraries.navigation.internal.sq.a aVar2 = (com.google.android.libraries.navigation.internal.sq.a) aVar;
            SnappingTracerJni snappingTracerJni = buVar.i;
            if (snappingTracerJni != null) {
                snappingTracerJni.b(aVar2.a.a(), buVar.d.a());
                return;
            }
            return;
        }
        if (i == 1) {
            ((bu) this.c).g((com.google.android.libraries.navigation.internal.sm.d) aVar);
            return;
        }
        if (i == 2) {
            ((bu) this.c).h((com.google.android.libraries.navigation.internal.sm.e) aVar);
            return;
        }
        if (i == 3) {
            ((bu) this.c).f((com.google.android.libraries.navigation.internal.sm.c) aVar);
        } else if (i == 4) {
            ((bu) this.c).i((com.google.android.libraries.navigation.internal.tl.b) aVar);
        } else {
            ((bu) this.c).j();
        }
    }
}

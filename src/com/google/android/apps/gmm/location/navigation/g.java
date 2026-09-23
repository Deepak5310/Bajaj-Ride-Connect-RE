package com.google.android.apps.gmm.location.navigation;

import com.google.android.libraries.navigation.internal.yz.fy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends a {
    private static final fy g = fy.s("70.00.021", "70.00.100", "70.00.120", "70.00.200");
    public boolean c;
    public boolean d;
    public boolean e;
    bg f;
    private final int h;
    private long i;

    public g(com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.kl.a aVar2, l lVar) {
        super(aVar, aVar2, lVar);
        this.c = false;
        this.d = false;
        this.h = 0;
        this.e = false;
        this.i = -4611686018427387904L;
    }

    @Override // com.google.android.apps.gmm.location.navigation.a
    public final boolean c(com.google.android.libraries.navigation.internal.db.q qVar) {
        if (!b(qVar)) {
            return true;
        }
        com.google.android.libraries.navigation.internal.db.r rVarA = qVar.a();
        if (com.google.android.libraries.navigation.internal.ja.a.a(rVarA.g) - this.i < 900) {
            return true;
        }
        boolean zC = super.c(qVar);
        if (!zC) {
            this.i = com.google.android.libraries.navigation.internal.ja.a.a(rVarA.g);
        }
        return zC;
    }

    public final void e(bg bgVar) {
        com.google.android.libraries.navigation.internal.hx.ap.LOCATION_DISPATCHER.f();
        this.f = bgVar;
    }
}

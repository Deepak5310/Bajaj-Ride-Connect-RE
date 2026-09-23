package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public u(int i, Class cls, s sVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, sVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            ((s) this.c).e((com.google.android.libraries.navigation.internal.dh.ad) aVar);
            return;
        }
        if (i == 1) {
            ((s) this.c).c((com.google.android.libraries.navigation.internal.dh.p) aVar);
        } else if (i != 2) {
            ((s) this.c).d((com.google.android.libraries.navigation.internal.db.s) aVar);
        } else {
            ((s) this.c).i();
        }
    }
}

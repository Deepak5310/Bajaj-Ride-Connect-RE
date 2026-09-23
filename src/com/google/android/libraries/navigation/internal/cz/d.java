package com.google.android.libraries.navigation.internal.cz;

import com.google.android.apps.gmm.location.navigation.bt;
import com.google.android.libraries.navigation.internal.zr.dx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements bt {
    private final com.google.android.libraries.navigation.internal.mj.a a;
    private final com.google.android.libraries.navigation.internal.kc.a b;

    public d(com.google.android.libraries.navigation.internal.kc.a aVar, com.google.android.libraries.navigation.internal.mj.a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    @Override // com.google.android.apps.gmm.location.navigation.bt
    public final void a(dx dxVar) {
        this.b.a(new c(this.a, dxVar));
    }
}
